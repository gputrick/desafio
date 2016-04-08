/*
 * This JavaScript file is an integral part of the filtering mechanism
 * and the NetUI Grid tag set.  
 * 
 * This file should not be modified.
 */

var nTimeout = 0;

function CheckFocus(focus)
{
  if (!focus)
    {
      if (nTimeout == 0)
	nTimeout = window.setTimeout("window.close()", 300);
    }
  else if (nTimeout)
    {
      window.clearTimeout(nTimeout);
      nTimeout = 0;
    }
}

function ChangeFilter(sel, inp)
{
  if (null == sel || null == inp)
    return;
  var f = selValue(sel);
  if (f == "~isempty" || f == "~isnotempty")
    inp.disabled = true;
  else
    inp.disabled = false;
}

/*
opener -- the window that opened the filter window
search -- the opener's previous search string
column -- the current column's name
filter -- an array of the current filters [op1, val1, op2, val2]
gridName -- the current grid's name
filterAction -- the PageFlow Action to perform if this is a valid filter
*/
function ApplyFilter(opener,search,column,filter,gridName,filterAction)
{
  if (null == opener)
    return false;

  numOPs = 0;
  for (i=0 ; i<filter.length ; i+=2)
    {
      if (filter[i] != null && filter[i] != "" && filter[i] != "*") {
	numOPs++;
      }
    }

  numNOPs = 0;
  for (i=0 ; i<filter.length ; i+=2)
    {
      if ((filter[i] == null || filter[i] == "" || filter[i] == "*") && filter[i] != savedFilter[i])
	{
	  numNOPs++;
	  filter[i] = "";
	  if (numOPs != 0 || numNOPs > 1)
	    continue;
	  else
	    filter[i+1] = "*";
	}
      else if (filter[i] == "~isempty" || filter[i] == "~isnotempty")
	filter[i+1] = "1";
      
      var colPrefix = (gridName != null ? gridName + "~" + column : column);
      search = AppendSearch(search, colPrefix + filter[i], filter[i+1]);
    }

  if(search == '?') 
    search = "";
  else if(filterAction.indexOf('?') > -1)
    search = search.charAt(0) == '?' ? search.substring(1) : search;
  else if(search.charAt(0) != '?')
    search = '?' + search;
  
  if(filterAction.indexOf('http') == 0)
    opener.location.href = filterAction + search;
  else 
    opener.location.href = opener.location.protocol + '//' + opener.location.host + filterAction + search;
  
  window.close();
  return false;
}

function SizeToFit()
{
  var Nav4 = ((navigator.appName == "Netscape") && (parseInt(navigator.appVersion) >= 4));
  if (Nav4)
    {
      window.innerWidth = document.width;
      window.innerHeight = document.height;
    }
  else
    {
      window.resizeBy(document.body.scrollWidth-document.body.clientWidth, document.body.scrollHeight-document.body.clientHeight);
    }
}
function selValue(sel)
{
  var index = sel.selectedIndex;
  var value = sel.options[index].value;
  return value;
}

function PlaceCursor() 
{
  var frm = document.forms[0];
  if (null == frm) return;
  
  var n = 2;
  while ( --n >= 0 )
    {
      var e = frm.elements[n];
      if (null == e || e.disabled || e.type == "hidden")
	continue;
      e.focus();
      if ( e.type == "text" )
	e.select();
      return;
    }
}

