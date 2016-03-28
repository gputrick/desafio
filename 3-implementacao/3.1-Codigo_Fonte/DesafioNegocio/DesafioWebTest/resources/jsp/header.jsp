
  <!-- header.jsp -->

  <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <!-- Topmost table containing the primary header graphics and color -->
   <tr>
   <!--Primary header color defined here in the form of 'bgcolor="#ffffff"' -->
    <td width="100%" height="96" valign="top" bgcolor="#ffffff">
    <!-- Left justified graphic image with arrows -->
    <img src="<%=request.getContextPath ()%>/resources/images/weblogic-img-lt.jpg" border="0" align="left">
    <!-- Right justified graphic text 'Weblogic Workshop version 2.0' -->
    <img src="<%=request.getContextPath ()%>/resources/images/weblogic-img-rt.gif" border="0" align="right">
    </td>
   </tr>
  </table>
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <!-- Smaller, lower table containing the decorative 'bar' which could be used for navigation -->
   <tr>
    <!-- Styled, graphical look of 'bar' defined here using a repeatable image specified as 'background="bar-background.gif"' -->
    <td width="100%" height="21" background="<%=request.getContextPath ()%>/resources/images/bar-background.gif">&nbsp;</td>
  </tr>
  </table>
  <!-- end header.jsp -->
