<%@ page import="com.bea.netuix.servlets.controls.layout.PlaceholderPresentationContext,
                 com.bea.netuix.servlets.controls.layout.FlowLayoutPresentationContext,
                 java.util.List,
                 com.bea.netuix.servlets.controls.PresentationContext"
%>
<%@ page session="false"%>
<%@ taglib uri="render.tld" prefix="render" %>

<%
    FlowLayoutPresentationContext layout = FlowLayoutPresentationContext.getFlowLayoutPresentationContext(request);
%>

<render:beginRender>
    <table
        <render:writeAttribute name="id" value="<%= layout.getPresentationId() %>"/>
        <render:writeAttribute name="class" value="<%= layout.getPresentationClass() %>" defaultValue="bea-portal-layout-flow"/>
        <render:writeAttribute name="style" value="<%= layout.getPresentationStyle() %>"/>
        cellspacing="0"
    >
        <tr>
    <%
        List children = layout.getChildren("layout:placeholder");
        int size = children.size();

        for (int i = 0; i < size; i++)
        {
    %>
            <td class="bea-portal-layout-placeholder-container"><render:renderChild presentationContext="<%= (PresentationContext) children.get(i) %>"/></td>
    <%
            if (layout.isVertical() && i != size - 1)
            {
    %>              </tr>
                    <tr>
    <%      }
        }
    %>
        </tr>
    </table>

</render:beginRender>

<render:endRender>
</render:endRender>
