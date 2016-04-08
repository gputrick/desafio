    var numAddedResources = 0;
    var movedCheck = 0;
    var originalNavigableState = getNavigableState();

    /**
     *   Function to find all navigables that have changed position and need to be updated
     */
    function findMovedNavigables(originalState, newState)
    {
        movedNavigables = new Array(0);

        for (i=0; i<originalState.length; i++)
        {
            for (j=0; j<newState.length; j++)
            {
                if (originalState[i] == newState[j])
                {
                    if (i != j)
                    {
                        movedCheck = 1;
                    }
                    movedNavigables.push(new Array(newState[j], j));
                    break;
                }
            }
        }

        return movedNavigables;
    }

    /**
     *   Function to find all navigables that have been deleted
     */
    function findDeletedNavigables(originalState, newState)
    {
        deletedNavigables = new Array(0);

        for (i=0; i<originalState.length; i++)
        {
            found = 0;
            for (j=0; j<newState.length; j++)
            {
                if (originalState[i] == newState[j])
                {
                    found = 1;
                    break;
                }
            }
            if (!found)
            {
                deletedNavigables.push(originalState[i]);
            }
        }

        return deletedNavigables;
    }

    /**
     *   Function to find all navigables that have been added
     */
    function findAddedNavigables(originalState, newState)
    {
        addedNavigables = new Array(0);

        for (i=0; i<newState.length; i++)
        {
            found = 0;
            for (j=0; j<originalState.length; j++)
            {
                if (newState[i] == originalState[j])
                {
                    found = 1;
                    break;
                }
            }
            if (!found)
            {
                addedNavigables.push(new Array(newState[i], i));
            }
        }

        return addedNavigables;
    }

    function saveNavChanges(bookId,fixedBookName,alertTxt)
    {
        var newState = getNavigableState();
        allMovedNavigables = findMovedNavigables(originalNavigableState, newState);
        allDeletedNavigables = findDeletedNavigables(originalNavigableState, newState);
        allAddedNavigables = findAddedNavigables(originalNavigableState, newState);
        movedNavigableIds = "";
        movedNavigablePositions = "";
        deletedNavigableIds = "";
        addedNavigableIds = "";
        addedNavigablePositions = "";

        for (i=0; i<allMovedNavigables.length; i++)
        {
            movedNavigableIds = movedNavigableIds + allMovedNavigables[i][0] + ",";
            movedNavigablePositions = movedNavigablePositions + allMovedNavigables[i][1] + ",";
        }

        for (j=0; j<allDeletedNavigables.length; j++)
        {
            deletedNavigableIds = deletedNavigableIds + allDeletedNavigables[j] + ",";
        }

        for (k=0; k<allAddedNavigables.length; k++)
        {
            addedNavigableIds = addedNavigableIds + allAddedNavigables[k][0] + ",";
            addedNavigablePositions = addedNavigablePositions + allAddedNavigables[k][1] + ",";
        }

        if (movedCheck == 0 && allDeletedNavigables.length < 1 && allAddedNavigables.length < 1)
        {
            alert(alertTxt);
        }
        else
        {
            document.SaveNavigablesForm.editBook.value = bookId;
            document.SaveNavigablesForm.editBookName.value = fixedBookName;
            document.SaveNavigablesForm.moveNavigableIds.value = movedNavigableIds;
            document.SaveNavigablesForm.moveNavigablePositions.value = movedNavigablePositions;
            document.SaveNavigablesForm.deletePlaceableIds.value = deletedNavigableIds;
            document.SaveNavigablesForm.addPlaceableIds.value = addedNavigableIds;
            document.SaveNavigablesForm.addPlaceablePositions.value = addedNavigablePositions;
            document.SaveNavigablesForm.submit();
        }
    }

    function cancelNavChanges()
    {
        document.CancelNavChangesForm.submit();
    }

    function RTrim(inputString)
    {
       // Trims trailing spaces from a String
       if (typeof inputString != "string")
       {
          return inputString;
       }
       var retValue = inputString;
       if (retValue != "")
       {
          ch = retValue.substring(retValue.length-1, retValue.length);
          while (ch == " ")
          {
             // Check for spaces at the end of the string
             retValue = retValue.substring(0, retValue.length-1);
             ch = retValue.substring(retValue.length-1, retValue.length);
          }
       }
       return retValue;
    }

    function saveNewPageInBook(alertTxt)
    {
        var layoutId = document.getElementById("newPageLayoutId").value;
        var pageName = document.getElementById("newPageName").value;

		if (pageName == "" || RTrim(pageName) == "")
	    {
            alert( alertTxt );
            return;
	    }

        var pageValue = "newpage_new" + numAddedResources + "_" + layoutId + ":" + pageName;
	    numAddedResources++;

	    var theLength = document.getElementById("allNavs").options.length;
	    document.getElementById("allNavs").options[theLength] = new Option(pageName, pageValue);

        toggleDialogBox('AddNewPageToBookDialog');
    }


    function saveNewBookInBook(alertTxt)
    {
        var menuId = document.getElementById("newBookMenuId").value;
        var bookName = document.getElementById("newBookName").value;
        if (bookName == "" || RTrim(bookName) == "")
        {
            alert( alertTxt );
            return;
        }
        var bookValue = "newbook_new" + numAddedResources + "_" + menuId + ":" + bookName;
        numAddedResources++;

        var theLength = document.getElementById("allNavs").options.length;
        document.getElementById("allNavs").options[theLength] = new Option(bookName, bookValue);

        toggleDialogBox('AddNewBookToBookDialog');
    }


    function moveNavUp()
    {
        var idx = document.getElementById("allNavs").options.selectedIndex;
        if (idx < 0)
        {
            return;
        }
        var newIdx = idx - 1;

        if (idx <= 0)
        {
            return;
        }
        var selectedName = document.getElementById("allNavs").options[newIdx].text;
        var selectedValue = document.getElementById("allNavs").options[newIdx].value;
        document.getElementById("allNavs").options[newIdx].text = document.getElementById("allNavs").options[idx].text;
        document.getElementById("allNavs").options[newIdx].value = document.getElementById("allNavs").options[idx].value;
        document.getElementById("allNavs").options[idx].text = selectedName;
        document.getElementById("allNavs").options[idx].value = selectedValue;
        document.getElementById("allNavs").options[newIdx].selected = "1";

    }

    function moveNavDown()
    {
        var idx = document.getElementById("allNavs").options.selectedIndex;
        if (idx < 0)
        {
            return;
        }
        var num = document.getElementById("allNavs").options.length;
        var newIdx = idx + 1;

        if (idx == num - 1)
        {
            return;
        }
        var selectedName = document.getElementById("allNavs").options[newIdx].text;
        var selectedValue = document.getElementById("allNavs").options[newIdx].value;
        document.getElementById("allNavs").options[newIdx].text = document.getElementById("allNavs").options[idx].text;
        document.getElementById("allNavs").options[newIdx].value = document.getElementById("allNavs").options[idx].value;
        document.getElementById("allNavs").options[idx].text = selectedName;
        document.getElementById("allNavs").options[idx].value = selectedValue;
        document.getElementById("allNavs").options[newIdx].selected = "1";
    }

    function removeNav(alertTxt)
    {
        var idx = document.getElementById("allNavs").options.selectedIndex;
        if (idx < 0)
        {
            alert( alertTxt );
            return;
        }
        document.getElementById("allNavs").options[idx] = null;
    }

    function addPageToBook(alertTxt)
    {
        var allPages = document.getElementById("allPages");
        var idx = allPages.options.selectedIndex;
        if( idx < 0 )
        {
            alert( alertTxt );
            return;
        }

        var possiblePages = allPages.options.length;
        for( i = 0; i < possiblePages; i ++ )
        {
            if( allPages.options[i].selected )
            {
                var pageName = allPages.options[i].text;
                var pageValue = "page_new" + numAddedResources + "_" + allPages.options[i].value;
                numAddedResources++;

                var theLength = document.getElementById("allNavs").options.length;
                document.getElementById("allNavs").options[theLength] = new Option(pageName, pageValue);
            }
        }

        toggleDialogBox('AddContentToBookDialog');
    }

    function addBookToBook(alertTxt)
    {
        var allBooks = document.getElementById( "allBookBooks" );

        var idx = allBooks.options.selectedIndex;
        if( idx < 0 )
        {
            alert( alertTxt );
            return;
        }

        var possibleBooks = allBooks.options.length;
        for( i = 0; i < possibleBooks; i++ )
        {
            if( allBooks.options[i].selected )
            {
                var bookName = allBooks.options[i].text;
                var bookValue = "book_new" + numAddedResources + "_" + allBooks.options[i].value;
                numAddedResources++;

                var theLength = document.getElementById("allNavs").options.length;
                document.getElementById("allNavs").options[theLength] = new Option(bookName, bookValue);
            }
        }
        toggleDialogBox('AddContentToBookDialog');
    }

    function addContentToBook(txt)
    {
        toggleDialogBox("AddContentToBookDialog",370,400,txt);
    }

    function addNewPageToBook(txt)
    {
        toggleDialogBox("AddNewPageToBookDialog",240,300,txt);
    }

    function addNewBookToBook(txt)
    {
        toggleDialogBox("AddNewBookToBookDialog",240,300,txt);
    }

    /**
    *   Function to return current state of navigables
    */
    function getNavigableState()
    {
        var theLength = document.getElementById("allNavs").options.length;

        navigableArray = new Array(theLength);

        for (i=0; i<theLength; i++)
        {
            navigableArray[i] = document.getElementById("allNavs").options[i].value;
        }

        return navigableArray;
    }

