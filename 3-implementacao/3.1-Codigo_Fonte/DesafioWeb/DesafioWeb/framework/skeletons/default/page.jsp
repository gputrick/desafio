<%@ page import="com.bea.netuix.servlets.controls.page.PagePresentationContext,
                 com.bea.netuix.servlets.controls.page.BookPresentationContext"
%>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %>
<%!
    static final String PAGE_CLASS = "bea-portal-book-page";
    static final String DESKTOP_PAGE_CLASS = "bea-portal-book-primary-page";
%>

<render:beginRender>
<%
    PagePresentationContext pageCtx = PagePresentationContext.getPagePresentationContext(request);
    BookPresentationContext book = BookPresentationContext.getBookPresentationContext(request);

    String pageClass = PAGE_CLASS;
    if (book.isDesktopBook())
    {
        pageClass = DESKTOP_PAGE_CLASS;
    }

%>
    <%-- Begin Page --%>
    <div
        <render:writeAttribute name="id" value="<%= pageCtx.getPresentationId() %>"/>
        <render:writeAttribute name="class" value="<%= pageCtx.getPresentationClass() %>" defaultValue="<%= pageClass %>"/>
        <render:writeAttribute name="style" value="<%= pageCtx.getPresentationStyle() %>"/>
    >
</render:beginRender>
<render:endRender>
    </div>
    <%-- End Page --%>
</render:endRender>
