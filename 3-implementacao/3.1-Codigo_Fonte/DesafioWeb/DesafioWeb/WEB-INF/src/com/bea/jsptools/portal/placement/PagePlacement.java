package com.bea.jsptools.portal.placement;



public class PagePlacement extends Placement implements NavigablePlacement
{
    public PagePlacement(int id, int parentId, int containerId, int position)
    {
        super(id, parentId, containerId, position);
    }

    public PagePlacement(String id, String parentId, String containerId, String position)
    {
        super(id, parentId, containerId, position);
    }

}
