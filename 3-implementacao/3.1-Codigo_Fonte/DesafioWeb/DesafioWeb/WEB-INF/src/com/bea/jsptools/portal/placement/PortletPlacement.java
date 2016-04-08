package com.bea.jsptools.portal.placement;



public class PortletPlacement extends Placement implements PlaceablePlacement
{
    int placeholder = -1;

    public PortletPlacement(int id, int parentId, int containerId, int placeholder, int position)
    {
        super(id, parentId, containerId, position);
        this.placeholder = placeholder;
    }

    public PortletPlacement(String id, String parentId, String containerId, String placeholder, String position)
    {
        super(id, parentId, containerId, position);
        this.placeholder = Integer.parseInt(placeholder);
    }

    public int getPlaceholder()
    {
        return this.placeholder;
    }
}
