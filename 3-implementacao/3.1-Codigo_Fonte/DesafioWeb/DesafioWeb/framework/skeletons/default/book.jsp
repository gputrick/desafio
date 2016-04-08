<%@ page import="com.bea.netuix.servlets.controls.page.BookPresentationContext,
                 com.bea.netuix.servlets.controls.page.MenuPresentationContext"
%>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %>
<%!
    static final String BOOK_CLASS = "bea-portal-book";
    static final String DESKTOP_BOOK_CLASS = BOOK_CLASS + "-primary";
    static final String INVISIBLE_BOOK_CLASS = BOOK_CLASS + "-invisible";
    static final String BOOK_CONTENT_CLASS = BOOK_CLASS+ "-content";
    static final String DESKTOP_BOOK_CONTENT_CLASS = DESKTOP_BOOK_CLASS + "-content";
%>

<render:beginRender>
<%
    BookPresentationContext book = BookPresentationContext.getBookPresentationContext(request);
    MenuPresentationContext menu = (MenuPresentationContext) book.getFirstChild("page:menu");

    String useBookClass = BOOK_CLASS;
	String bookContentClass = BOOK_CONTENT_CLASS;
    if (book.isDesktopBook())
    {
        useBookClass = DESKTOP_BOOK_CLASS;
		bookContentClass = DESKTOP_BOOK_CONTENT_CLASS;
    }
    else if (book.isLikePage())
    {
        useBookClass = INVISIBLE_BOOK_CLASS;
    }
%>
    <%-- Begin Book --%>
    <div
        <render:writeAttribute name="id" value="<%= book.getPresentationId() %>"/>
        <render:writeAttribute name="class" value="<%= book.getPresentationClass()%>" defaultValue="<%= useBookClass %>"/>
        <render:writeAttribute name="style" value="<%= book.getPresentationStyle() %>"/>
    >
        <render:renderChild presentationContext="<%= menu %>"/>
        <%-- Begin Book Content --%>
        <div
            <render:writeAttribute name="class" value="<%= book.getContentPresentationClass()%>" defaultValue="<%= bookContentClass %>"/>
            <render:writeAttribute name="style" value="<%= book.getContentPresentationStyle() %>"/>
        >
</render:beginRender>
<render:endRender>
        </div>
        <%-- End Book Content --%>
    </div>
    <%-- End Book --%>
</render:endRender>
