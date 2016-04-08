package com.bea.jsptools.portal.placement;



public class BookPlacement extends Placement implements PlaceablePlacement, NavigablePlacement
{
    int placeholder = -1;

    public BookPlacement(int id, int parentId, int containerId, int placeholder, int position)
    {
        super(id, parentId, containerId, position);
        this.placeholder = placeholder;
    }

    public BookPlacement(String id, String parentId, String containerId, String placeholder, String position)
    {
        super(id, parentId, containerId, position);
        this.placeholder = Integer.parseInt(placeholder);
    }

    public BookPlacement(int id, int parentId, int containerId, int position)
    {
        super(id, parentId, containerId, position);
    }

    public BookPlacement(String id, String parentId, String containerId, String position)
    {
        super(id, parentId, containerId, position);
    }

    public int getPlaceholder()
    {
        return this.placeholder;
    }
}
