/*
 * This JavaScript file is an integral part of the filtering mechanism
 * and the NetUI Grid tag set.  
 * 
 * This file should not be modified.
 */

/*
 * Open the filter window.
 * 
 * Request parameters attached to the query string of the filter window opened here
 * are guaranteed to have been encoded in Java before being passed to the ShowFilterWindow
 * JavaScript method.
 *
 * column -- the name of the current column
 * elem -- the grid's window
 * strfilter -- the current request's query
 * gridName -- the name of the current grid
 * strPath -- filter window path
 * jdbcColumnType -- the JDBC type index of the current column
 * filterAction -- the PageFlow Action that will be executed if this filter is selected
 * prefix -- the prefix to append to any filter parameter added to the URL for a grid
 */
function ShowFilterWindow(column,elem,strfilter,gridName,strPath,jdbcColumnType,filterAction,prefix)
{
  var ie4 = navigator.appName.indexOf("Microsoft") != -1 && parseInt(navigator.appVersion) >= 4;
  var posStr;
  if (ie4)
    {
      var offset = ScreenPosIE(elem);
      posStr = "top="+offset.top.toString() + ",left="+(offset.left-250).toString();
      posStr += ",width=300";
    }
  else
    {
      posStr = "screenY="+(window.screenY+100).toString() + ",screenX="+(window.screenX+200).toString();
      posStr += ",width=550,resizable=yes";
    }

  var search;
  if (strfilter == null)
    {
      search = window.location.search;
    }
  else
    {
      search = strfilter;
    }
  search = encodeURIComponent(search);

  search = "?" + 
    "&_column=" + column + 
    "&_search=" + search + 
    "&_jdbcColumnType=" + jdbcColumnType + 
    "&_filterAction=" + filterAction + 
    "&_prefix=" + prefix;

  if (gridName != null && gridName != '')
  {
      search = search + "&_grid=" + gridName;
  }

  var w = window.open(strPath + search, "filter", posStr+",height=200,scrollbars=no");

  if (null != w)
    w.focus();

  return false;
}

function ScreenPosIE(elem)
{
  var top = window.screenTop + elem.clientTop + elem.offsetHeight;
  var left = window.screenLeft + elem.clientLeft + elem.offsetWidth;
  var last = elem;
  while (elem != null)
    {
      top  += elem.offsetTop  - elem.scrollTop;
      left += elem.offsetLeft - elem.scrollLeft;
      last = elem;
      elem = elem.offsetParent;
    }
  var pos = new Object;
  pos.top = top - last.scrollTop;
  pos.left = left - last.scrollLeft;
  return pos;
}
