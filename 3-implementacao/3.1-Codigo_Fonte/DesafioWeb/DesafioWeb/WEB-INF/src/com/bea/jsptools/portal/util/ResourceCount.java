/**
 * B E A   S Y S T E M S
 *
 * Copyright (c) 2002-2004  BEA Systems, Inc.
 *
 * All Rights Reserved. Unpublished rights reserved under the copyright laws
 * of the United States. The software contained on this media is proprietary
 * to and embodies the confidential technology of BEA Systems, Inc. The
 * possession or receipt of this information does not convey any right to
 * disclose its contents, reproduce it, or use,  or license the use, for
 * manufacture or sale, the information or anything described therein. Any
 * use, disclosure, or reproduction without BEA System's prior written
 * permission is strictly prohibited.
 *
 */
package com.bea.jsptools.portal.util;

public class ResourceCount
{
    int resourceCount;
    int pageCount;
    int bookCount;
    int portletCount;

    public ResourceCount( int resourceCount, int pageCount, int bookCount, int portletCount )
    {
        this.resourceCount = resourceCount;
        this.bookCount = bookCount;
        this.pageCount = pageCount;
        this.portletCount = portletCount;
    }

    public void setResourceCount( int resourceCount )
    {
        this.resourceCount = resourceCount;
    }

    public int getResourceCount()
    {
        return this.resourceCount;
    }

    public void setPageCount( int pageCount )
    {
        this.pageCount = pageCount;
    }

    public int getPageCount()
    {
        return this.pageCount;
    }

    public void setBookCount( int bookCount )
    {
        this.bookCount = bookCount;
    }

    public int getBookCount()
    {
        return this.bookCount;
    }

    public void setPortletCount( int portletCount )
    {
        this.portletCount = portletCount;
    }

    public int getPortletCount()
    {
        return this.portletCount;
    }
}