package com.bea.jsptools.portal.placement;

public interface PlaceablePlacement
{
    public int getId();
    
    public int getParentId();

    public int getContainerId();
    
    public int getPlaceholder();
    
    public int getPosition();
}
