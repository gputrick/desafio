<%@ page import="com.bea.netuix.servlets.controls.layout.PlaceholderPresentationContext,
                 com.bea.netuix.servlets.controls.layout.BorderLayoutPresentationContext"
%>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %>

<%
    BorderLayoutPresentationContext layout = BorderLayoutPresentationContext.getBorderLayoutPresentationContext(request);
    PlaceholderPresentationContext north = layout.north();
    PlaceholderPresentationContext west = layout.west();
    PlaceholderPresentationContext center = layout.center();
    PlaceholderPresentationContext east = layout.east();
    PlaceholderPresentationContext south = layout.south();
    int columns = layout.columns();
%>

<render:beginRender>
    <table
        <render:writeAttribute name="id" value="<%= layout.getPresentationId() %>"/>
        <render:writeAttribute name="class" value="<%= layout.getPresentationClass() %>" defaultValue="bea-portal-layout-border"/>
        <render:writeAttribute name="style" value="<%= layout.getPresentationStyle() %>"/>
        cellspacing="0"
    >
    <%
        if (north != null)
        {
    %>
        <tr>
            <td class="bea-portal-layout-placeholder-container-north" colspan="<%= columns %>">
                <render:renderChild presentationContext="<%= north %>" />
            </td>
        </tr>
    <%
        }

        if (west != null || center != null || east != null)
        {
    %>
        <tr>
    <%
            if (west != null)
            {
    %>
            <td class="bea-portal-layout-placeholder-container-west">
                <render:renderChild presentationContext="<%= west %>" />
            </td>
    <%
            }

            if (center != null)
            {
    %>
            <td class="bea-portal-layout-placeholder-container-center">
                <render:renderChild presentationContext="<%= center %>" />
            </td>
    <%
            }

            if (east != null)
            {
    %>
            <td class="bea-portal-layout-placeholder-container-east">
                <render:renderChild presentationContext="<%= east %>" />
            </td>
        </tr>
    <%
            }
        }

        if (south != null)
        {
    %>
        <tr>
            <td class="bea-portal-layout-placeholder-container-south" colspan="<%= columns %>">
                <render:renderChild presentationContext="<%= south %>" />
            </td>
        </tr>
    <%
        }
    %>
    </table>
</render:beginRender>
<render:endRender>
</render:endRender>
