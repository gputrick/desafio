package com.bea.jsptools.portal.placement;

public class Placement implements Comparable
{
    private int id;
    private int parentId;
    private int containerId;
    private int position; 
    
    public Placement(int id, int parentId, int containerId, int position)
    {
        this.id = id;
        this.parentId = parentId;
        this.containerId = containerId;
        this.position = position;
    }

    public Placement(String id, String parentId, String containerId, String position)
    {
        this.id = Integer.parseInt(id);
        this.parentId = Integer.parseInt(parentId);
        this.containerId = Integer.parseInt(containerId);
        this.position = Integer.parseInt(position);
    }

    public int getId()
    {
        return this.id;
    }

    public int getParentId()
    {
        return this.parentId;
    }

    public int getContainerId()
    {
        return this.containerId;
    }
    
    public int getPosition()
    {
        return this.position;
    }

    public int compareTo(Object o)
    {
        Placement pp = (Placement) o;
        if (this.getPosition() < pp.getPosition())
        {
            return -1;
        }
        else if (this.getPosition() == pp.getPosition())
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    public String toString()
    {
        return "[ID: " + this.getId() + "  Position: " + this.getPosition();
    }
}
