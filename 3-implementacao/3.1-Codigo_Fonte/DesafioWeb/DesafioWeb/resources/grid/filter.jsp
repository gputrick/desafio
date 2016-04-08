<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.bea.wlw.netui.databinding.jsp.FilterWindowService"%>
<%@ page import="com.bea.wlw.netui.databinding.jsp.FilterWindowService.FilterWindowData"%>
<%@ page import="com.bea.wlw.netui.databinding.jsp.FilterWindowService.Filter"%>
<%@ page import="com.bea.wlw.netui.util.Bundle"%>
<%!
/**
 * Render the select box that describes the filter operations that can be performed
 * for a particular column type.
 */
private void renderOperatorSelect(PageContext pageContext, 
                                  int defaultSelection, 
                                  int currentSelection, 
                                  String selectName, 
                                  int selectIndex, 
                                  int tabIndex, 
                                  int columnType)
    throws IOException
{
    String[][] options = FilterWindowService.getOptions();
    
    StringBuffer buf = new StringBuffer();
    buf.append("<select size=\"1\" name=\"");
    buf.append(selectName);
    buf.append("\" tabindex=");
    buf.append(tabIndex);
    buf.append(" onChange=\"ChangeFilter(this, document.all.inpFilter");
    buf.append(selectIndex);
    buf.append(");\" onfocus=\"CheckFocus(true);\" onblur=\"CheckFocus(false);\">\n");
    
    // render the options; make sure to select either the defaultSelection (if currentSelection is null) or currentSelection
    for(int i = 0; i < options.length; i++)
    {
        // "is one of" is not supported for dates
        if(i == 7 && FilterWindowService.isDateType(columnType))
            continue;
        // the rest are just for strings
        else if(i >= 8 && !FilterWindowService.isStringType(columnType))
            break;

        if(currentSelection != -1 && currentSelection == i || currentSelection == -1 && defaultSelection != -1 && defaultSelection == i)
        {
            buf.append("<option selected value=\"");
            buf.append(options[i][1]);
            buf.append("\">");
            buf.append(options[i][0]);
            buf.append("</option>\n");
        }
        else
        { 
            buf.append("<option value=\"");
            buf.append(options[i][1]);
            buf.append("\">");
            buf.append(options[i][0]);
            buf.append("</option>\n");
        }
    }
    
    buf.append("</select>\n");

    pageContext.getOut().write(buf.toString());
}

/**
 * Render an input box that displays allows a user to enter a filter value in 
 * a text box; if a filter already exists for this column, display the current filter.
 */
private void renderInputBox(PageContext pageContext, String currentValue, String inputName, int tabIndex)
    throws IOException
{
    StringBuffer buf = new StringBuffer();
    buf.append("<input type=\"text\" name=\"");
    buf.append(inputName);
    buf.append("\" size=\"40\" tabindex=");
    buf.append(tabIndex);
    buf.append(" value=\"");
    buf.append((currentValue == null ? "" : currentValue));
    buf.append("\" onfocus=\"CheckFocus(true);\" onblur=\"CheckFocus(false);\" >");

    pageContext.getOut().write(buf.toString());
}
%>
<%

// initialize the data used in rendering the filter window
FilterWindowData fwd = FilterWindowService.getFilterWindowData(request, response);

Filter[] currFilters = fwd.getFilters();
int columnType = fwd.getJDBCColumnType();
int defaultSelection = fwd.getDefaultFilterOperation();
String currentColumn = fwd.getColumnName();
String clearAllFilters = fwd.getClearAllFiltersQueryString();
String clearColumnFilters = fwd.getClearColumnFiltersQueryString();
String filterAction = fwd.getFilterAction();
String gridName = fwd.getGridName();
String filterKey = fwd.getFilterKey();

// get internationalized strings
String dateWarning = Bundle.getString("FilterWindow_dateWarning");
String filterButtonTitle = Bundle.getString("FilterWindow_filterButtonTitle");
String clearButtonTitle = Bundle.getString("FilterWindow_clearButtonTitle");
String clearAllButtonTitle = Bundle.getString("FilterWindow_clearAllButtonTitle");
String cancelButtonTitle = Bundle.getString("FilterWindow_cancelButtonTitle");
String showRecordsWhere = Bundle.getString("FilterWindow_showRecordsWhere");
String booleanEither = Bundle.getString("FilterWindow_booleanEither");
String booleanFalse = Bundle.getString("FilterWindow_booleanFalse");
String booleanTrue = Bundle.getString("FilterWindow_booleanTrue");
String windowTitle = Bundle.getString("FilterWindow_windowTitle");

String clearAllURL = null;
String clearColumnURL = null;

if(filterAction.indexOf("?") > 0)
{
    clearAllURL = filterAction + "&" + (clearAllFilters.startsWith("?") ? clearAllFilters.substring(1) : clearAllFilters);
    clearColumnURL = filterAction + "&" + (clearColumnFilters.startsWith("?") ? clearColumnFilters.substring(1) : clearColumnFilters);
}
else
{
    clearAllURL = filterAction + (clearAllFilters.startsWith("?") ? clearAllFilters : "?" + clearAllFilters);
    clearColumnURL = filterAction + (clearColumnFilters.startsWith("?") ? clearColumnFilters : "?" + clearColumnFilters);
}
%>
<html>
<head>
    <title><%= windowTitle %></title>
    <!-- This JavaScript file is required for the filter window -->
    <script language="javascript" TYPE="text/javascript" src="_filter.js"></script>
    <script language="javascript" TYPE="text/javascript">
<!--
var savedFilter;

<%
if(FilterWindowService.isBooleanType(columnType))
{
%>
function doFilter()
{
var w = window.opener != null ? window.opener : window
var frm = document.forms[0];
var filter = frm.radioFilter[1].checked ? ["~eq", "true"] : frm.radioFilter[2].checked ? ["~eq", "false"] : ["", ""];
return ApplyFilter(w, '<%= "?" + clearColumnFilters %>', '<%= currentColumn %>', filter, '<%= gridName %>', '<%= filterAction%>');
}

function initFilter()
{
var frm = document.forms[0];
var f = frm.radioFilter[1].checked ? "true" : frm.radioFilter[2].checked ? "false" : "";
savedFilter = ["~eq", f];	    
}	      
<%
} // close Boolean filter
else if(FilterWindowService.isDateType(columnType))
{
%>
function two(i) {return (i < 10) ? "0" + i.toString() : i.toString();}
function three(i) {return (i < 10) ? "00" + i.toString() : (i < 100) ? "0" + i.toString() : i.toString();}
function hasTime(d, s)
{
    return d.getHours() || d.getMinutes() || d.getSeconds() || d.getMilliseconds() || (s.indexOf(":") >= 0);
}
function today()
{
    var d = new Date();
    return "" + d.getFullYear() + "-" + two(d.getMonth()+1) + "-" + two(d.getDate());
}
function parseDate(s)
{
    s = s.replace("-", "/");
    var ms = Date.parse(s);
    if(ms != ms) return null;
    var d = new Date(ms);
    var sReturn = "" + d.getFullYear() + "-" + two(d.getMonth()+1) + "-" + two(d.getDate());
    if(hasTime(d, s))
    {
        sReturn += " " + two(d.getHours()) + ":" + two(d.getMinutes());
        if(d.getSeconds() || d.getMilliseconds())
            sReturn += ":" + two(d.getSeconds());
        if(d.getMilliseconds())
            sReturn += "." + three(d.getMilliseconds());
    }
    return sReturn;
}
function doFilter()
{
    var w = window.opener != null ? window.opener : window;
    var frm = document.forms[0];

    var op1 = selValue(frm.selOperator1);
    var d1 = parseDate(frm.inpFilter1.value);
    if(op1 != "*" && frm.inpFilter1.value && !d1)
    {
        alert("'" + frm.inpFilter1.value + "' <%= dateWarning %>");
        return false;
    }

    if(d1 && d1.length == 10 && op1 != "*")
        op1 = op1.replace("~", "~date-");

    var op2 = selValue(frm.selOperator2);
    var d2 = parseDate(frm.inpFilter2.value);
    if(d2 && d2.length == 10 && op2 != "*")
        op2 = op2.replace("~", "~date-");
    if(op2 != "*" && frm.inpFilter2.value && !d2)
    {
        alert("'" + frm.inpFilter2.value + "' <%= dateWarning %>");
        return false;
    }

    var filter = [op1, frm.inpFilter1.value, op2, frm.inpFilter2.value];
    return ApplyFilter(w, '<%= "?" + clearColumnFilters %>', '<%= currentColumn %>', filter, '<%= gridName %>', '<%= filterAction%>');
}
function initFilter()
{
    var frm = document.forms[0];
    savedFilter = [selValue(frm.selOperator1), frm.inpFilter1.value, selValue(frm.selOperator2), frm.inpFilter2.value];
}
<%
}
else
{
%>
function doFilter()
{
var w = window.opener != null ? window.opener : window;
var frm = document.forms[0];
var filter = [selValue(frm.selOperator1), frm.inpFilter1.value, selValue(frm.selOperator2), frm.inpFilter2.value];

return ApplyFilter(w, '<%= "?" + clearColumnFilters %>', '<%= currentColumn %>', filter, '<%= gridName %>', '<%= filterAction%>');
}

function initFilter()
{
var frm = document.forms[0];
savedFilter = [selValue(frm.selOperator1), frm.inpFilter1.value, selValue(frm.selOperator2), frm.inpFilter2.value];
}

<%
} // close default filter
%>

function doClear(fAll)
{
var w = window.opener != null ? window.opener : window;


<%
    if(filterAction.startsWith("http"))
    {
%>
if(fAll)
    w.location.href='<%= clearAllURL %>';
else 
    w.location.href='<%= clearColumnURL %>';
<%
        }
    else
    {
%>
if(fAll)
    w.location.href=w.location.protocol + '//' + w.location.host + '<%= clearAllURL %>'; 
else 
    w.location.href=w.location.protocol + '//' + w.location.host + '<%= clearColumnURL %>';
<%
        }
%>

if(w != window)
  window.close();

return false;
}

function doCancel()
{
  window.close();
  return false;
}

function doLoad()
{
  initFilter();
  PlaceCursor();
  SizeToFit();
}

function AppendSearch(s,k,v)
{
  if (k == null || k == "" || v == null || v == "")
    return s;

  // Do not change the key for the filter here.  This key is expected by the NetUI server.
  var append = "<%= filterKey %>=" + encodeURIComponent(k+"~"+v);
  
  if (s == null || s == "")
    s = "?";
  if (s == "?")
    s = s + append;
  else
    s = s + "&" + append;
  return s;
}
-->
    </script>
  </head>
<body onload="doLoad();">
<form id="frmFilter" onSubmit="return doFilter();">
<table>
<tr><td><%= showRecordsWhere %></td></tr>
<tr><td><%= currentColumn %></td></tr>
<%
if(FilterWindowService.isBooleanType(columnType))
{ // render radio group
%>
<tr>
<td onfocus="CheckFocus(true);" onblur="CheckFocus(false);">
<input type="radio" name="radioFilter" value="*" tabindex=1 
	    <%= (currFilters[0] == null || currFilters[0].getValue() == null ? "checked" : "") %>
	    onfocus="CheckFocus(true);" onblur="CheckFocus(false);"><%= booleanEither %>
<input type="radio" name="radioFilter" value="true" tabindex=2 
	    <%= (currFilters[0] != null && currFilters[0].getValue().equals("true") ? "checked" : "") %>
       onfocus="CheckFocus(true);" onblur="CheckFocus(false);"><%= booleanTrue %>
<input type="radio" name="radioFilter" value="false" tabindex=3 
	    <%= (currFilters[0] != null && currFilters[0].getValue().equals("false") ? "checked" : "") %>
       onfocus="CheckFocus(true);" onblur="CheckFocus(false);"><%= booleanFalse %>
</td>
</tr>
<%
}
else
{ // render text boxes
%>
<tr>
<td onfocus="CheckFocus(true);" onblur="CheckFocus(false);">
    <% renderOperatorSelect(pageContext, defaultSelection, (currFilters[0] != null ? currFilters[0].getOperation() : -1), "selOperator1", 1, 1, columnType); %>
</td>
</tr>
<tr>
<td onfocus="CheckFocus(true);" onblur="CheckFocus(false);">
    <% renderInputBox(pageContext, (currFilters[0] != null ? currFilters[0].getValue() : null), "inpFilter1", 2); %></td></tr>
<tr>
<td onfocus="CheckFocus(true);" onblur="CheckFocus(false);">
and <%= currentColumn %>
</td>
</tr>
<tr>
<td onfocus="CheckFocus(true);" onblur="CheckFocus(false);">
<% renderOperatorSelect(pageContext, defaultSelection, (currFilters[1] != null ? currFilters[1].getOperation() : -1), "selOperator2", 2, 3, columnType); %>
</td>
</tr>
<tr>
<td onfocus="CheckFocus(true);" onblur="CheckFocus(false);">
<% renderInputBox(pageContext, (currFilters[1] != null ? currFilters[1].getValue() : null), "inpFilter2", 4); %>
</td>
</tr>
<%
    }
%>
<tr>
<td>
<input type="submit" name="btnFilter" value="<%= filterButtonTitle %>" onfocus="CheckFocus(true);" onblur="CheckFocus(false);"/>
<input type="submit" name="btnClear" value="<%= clearButtonTitle %>" onclick="return doClear();" onfocus="CheckFocus(true);" onblur="CheckFocus(false);"/>
<input type="submit" name="cmdClearAll" value="<%= clearAllButtonTitle %>" onclick="return doClear(true);" onfocus="CheckFocus(true);" onblur="CheckFocus(false);"/>
<input type="submit" name="cmdCancel" value="<%= cancelButtonTitle %>" onclick="return doCancel();" onfocus="CheckFocus(true);" onblur="CheckFocus(false);"/>
</td>
</tr>
</table>
</form>
</body>
</html>
