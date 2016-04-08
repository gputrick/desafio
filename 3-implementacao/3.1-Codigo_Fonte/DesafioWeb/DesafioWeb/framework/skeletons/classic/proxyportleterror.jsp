<%@ page session="false"%>
<%@ page import="com.bea.netuix.servlets.controls.portlet.PortletPresentationContext"%>

<%
    // The cause explains the cause of the error
    Throwable errorCause = (Throwable) request.getAttribute("portlet.error.cause");

    // Error message
    String errorMessage = (String) request.getAttribute("portlet.error.message");

    // Context
    PortletPresentationContext presentationContext = PortletPresentationContext.getPortletPresentationContext(request);

%>
<p>Error invoking portlet &quot;<%=presentationContext.getTitle()%>&quot;</p>
<br>
The source of this error is:
<pre><%
    if (errorCause != null) {
        errorCause.printStackTrace(response.getWriter());
    }

    Throwable rootCause = null;
    if (errorCause instanceof ServletException)
    {
        rootCause = ((ServletException) errorCause).getRootCause();
        if (rootCause == null)
        {
            rootCause = errorCause.getCause();
        }
    }

    if (rootCause != null)
    {
%></pre>
Caused by:
<pre><%
        rootCause.printStackTrace(response.getWriter());
    }
%></pre>
