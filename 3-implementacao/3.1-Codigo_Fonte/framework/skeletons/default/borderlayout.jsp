<%@ page import="com.bea.netuix.servlets.controls.layout.PlaceholderPresentationContext,
                 com.bea.netuix.servlets.controls.layout.BorderLayoutPresentationContext"
%>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %>
<render:beginRender>
<%
    BorderLayoutPresentationContext layout = BorderLayoutPresentationContext.getBorderLayoutPresentationContext(request);
    PlaceholderPresentationContext north = layout.north();
    PlaceholderPresentationContext west = layout.west();
    PlaceholderPresentationContext center = layout.center();
    PlaceholderPresentationContext east = layout.east();
    PlaceholderPresentationContext south = layout.south();
    int columns = layout.columns();
%>

    <%-- Begin Border Layout --%>
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
            <%-- Begin Border Layout Cell North --%>
            <td class="bea-portal-layout-placeholder-container-north" colspan="<%= columns %>"
                <render:writeAttribute name="width" value="<%= north.getWidth() %>"/>
            ><render:renderChild presentationContext="<%= north %>"/></td>
            <%-- End Border Layout Cell North --%>
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
            <%-- Begin Border Layout Cell West --%>
            <td class="bea-portal-layout-placeholder-container-west"
                <render:writeAttribute name="width" value="<%= west.getWidth() %>"/>
            ><render:renderChild presentationContext="<%= west %>"/></td>
            <%-- End Border Layout Cell West --%>
    <%
            }

            if (center != null)
            {
    %>
            <%-- Begin Border Layout Cell Center --%>
            <td class="bea-portal-layout-placeholder-container-center"
                <render:writeAttribute name="width" value="<%= center.getWidth() %>"/>
            ><render:renderChild presentationContext="<%= center %>"/></td>
            <%-- End Border Layout Cell Center --%>
    <%
            }

            if (east != null)
            {
    %>
            <%-- Begin Border Layout Cell East --%>
            <td class="bea-portal-layout-placeholder-container-east"
                <render:writeAttribute name="width" value="<%= east.getWidth() %>"/>
            ><render:renderChild presentationContext="<%= east %>"/></td>
            <%-- End Border Layout Cell East --%>
        </tr>
    <%
            }
        }

        if (south != null)
        {
    %>
        <tr>
            <%-- Begin Border Layout Cell South --%>
            <td class="bea-portal-layout-placeholder-container-south" colspan="<%= columns %>"
                <render:writeAttribute name="width" value="<%= south.getWidth() %>"/>
            ><render:renderChild presentationContext="<%= south %>"/></td>
            <%-- End Border Layout Cell South --%>
        </tr>
    <%
        }
    %>
    </table>
    <%-- End Border Layout --%>
</render:beginRender>
<render:endRender>
</render:endRender>
