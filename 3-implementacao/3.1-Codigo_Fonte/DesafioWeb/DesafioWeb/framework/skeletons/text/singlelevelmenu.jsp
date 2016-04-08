<%@ page import="com.bea.netuix.servlets.controls.window.WindowPresentationContext,
                 com.bea.netuix.servlets.controls.window.TitlebarPresentationContext,
                 java.util.Iterator,
                 com.bea.netuix.servlets.controls.page.PagePresentationContext,
                 com.bea.netuix.servlets.controls.page.BookPresentationContext,
                 com.bea.netuix.servlets.controls.page.MenuPresentationContext,
                 com.bea.netuix.servlets.controls.PresentationContext,
                 com.bea.netuix.servlets.controls.window.WindowCapabilities" %>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %>
<%!
    static final String BOOK_CLASS =            "bea-portal-book";
    static final String MENU_CLASS =            BOOK_CLASS + "-menu-single";
    static final String MENU_CONTAINER_CLASS =  MENU_CLASS + "-container";
    static final String MENU_ITEM_CLASS =       MENU_CLASS + "-item";
    static final String MENU_ITEM_ACTIVE_CLASS= MENU_ITEM_CLASS + "-active";
    static final String MENU_CHILDREN_CLASS =    MENU_CLASS + "-children";

    static final String DESKTOP_BOOK_CLASS =            "bea-portal-book-primary";
    static final String DESKTOP_MENU_CLASS =            DESKTOP_BOOK_CLASS + "-menu-single";
    static final String DESKTOP_MENU_CONTAINER_CLASS =  DESKTOP_MENU_CLASS + "-container";
    static final String DESKTOP_MENU_ITEM_CLASS =       DESKTOP_MENU_CLASS + "-item";
    static final String DESKTOP_MENU_ITEM_ACTIVE_CLASS= DESKTOP_MENU_ITEM_CLASS + "-active";
    static final String DESKTOP_MENU_CHILDREN_CLASS =   DESKTOP_MENU_CLASS + "-children";

    static final String CONTAINED_BOOK_CLASS =            "bea-portal-book-contained";
    static final String CONTAINED_MENU_CLASS =            CONTAINED_BOOK_CLASS + "-menu-single";
    static final String CONTAINED_MENU_CONTAINER_CLASS =  CONTAINED_MENU_CLASS + "-container";
    static final String CONTAINED_MENU_ITEM_CLASS =       CONTAINED_MENU_CLASS + "-item";
    static final String CONTAINED_MENU_ITEM_ACTIVE_CLASS= CONTAINED_MENU_ITEM_CLASS + "-active";
    static final String CONTAINED_MENU_CHILDREN_CLASS =   CONTAINED_MENU_CLASS + "-children";
%>

<%
    BookPresentationContext book = BookPresentationContext.getBookPresentationContext(request);
    MenuPresentationContext menu = MenuPresentationContext.getMenuPresentationContext(request);

    String menuContainerClass = MENU_CONTAINER_CLASS;
	String menuClass = MENU_CLASS;
    String menuItemClass = MENU_ITEM_CLASS;
    String menuItemActiveClass = MENU_ITEM_ACTIVE_CLASS;
    String menuChildrenClass = MENU_CHILDREN_CLASS;

    if (book.isDesktopBook())
    {
		menuClass =             DESKTOP_MENU_CLASS;
        menuContainerClass =    DESKTOP_MENU_CONTAINER_CLASS;
        menuItemClass =         DESKTOP_MENU_ITEM_CLASS;
        menuItemActiveClass =   DESKTOP_MENU_ITEM_ACTIVE_CLASS;
        menuChildrenClass =     DESKTOP_MENU_CHILDREN_CLASS;
    }
    else if (book.isContained())
    {
		menuClass =             CONTAINED_MENU_CLASS;
        menuContainerClass =    CONTAINED_MENU_CONTAINER_CLASS;
        menuItemClass =         CONTAINED_MENU_ITEM_CLASS;
        menuItemActiveClass =   CONTAINED_MENU_ITEM_ACTIVE_CLASS;
        menuChildrenClass =     CONTAINED_MENU_CHILDREN_CLASS;
    }

%>

<render:beginRender>
    <%-- Begin Single Level Menu --%>
    <div class="bea-portal-ie-table-buffer-div">
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <tr>
            <td class="<%= menuContainerClass %>" nowrap="nowrap">
    <ul
        <render:writeAttribute name="id" value="<%= menu.getPresentationId() %>"/>
        <render:writeAttribute name="class" value="<%= menu.getPresentationClass() %>" defaultValue="<%= menuClass %>"/>
        <render:writeAttribute name="style" value="<%= menu.getPresentationStyle() %>"/>
    ><%
    // Only render tabs when in view mode
    if (book.getWindowMode().equals(WindowCapabilities.VIEW))
    {

        Iterator pages = book.getPagePresentationContexts().iterator();

        while (pages.hasNext())
        {
            PagePresentationContext pageCtx = (PagePresentationContext) pages.next();

            if (!pageCtx.isHidden() && pageCtx.isVisible())
            {
                if (pageCtx.isActive())
                {
    %><li class="<%= menuItemActiveClass %>" ><span><%= pageCtx.getTitle() %></span></li><%
                }
                else
                {
    %><li class="<%= menuItemClass %>" ><a href="<render:pageUrl pageLabel="<%=pageCtx.getDefinitionLabel()%>"/>"><%= pageCtx.getTitle() %></a></li><%
                }
            }
        }
    }
%></ul>
            </td>
            <td class="<%= menuChildrenClass %>">
</render:beginRender>
<render:endRender>
            </td>
        </tr>
    </table>
    </div>
    <%-- End Single Level Menu --%>
</render:endRender>
