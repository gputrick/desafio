    var currentHotPlaceholder = 0;
    var numAddedResources= 0;
    var layoutActuallyChanged = new Array(0);

    function saveNewBook()
    {
        var theId = "placeholderList" + currentHotPlaceholder;

        var idx = document.getElementById("allBooks").options.selectedIndex;
        var menuId = document.getElementById("newBookMenuId").value;
        var bookName = document.getElementById("newBookName").value;
        var bookValue = "newbook_new" + numAddedResources + "_" + menuId + ":" + bookName;
        numAddedResources++;

        var theLength = document.getElementById(theId).options.length;
        document.getElementById(theId).options[theLength] = new Option(bookName, bookValue);

        toggleDialogBox2('AddNewBookDialog');
        toggleDialogBox('AddContentDialog');
    }

    function removeItem(placeholderNum,alertTxt,alertTxt2) 
    {
        var theId = "placeholderList" + placeholderNum;
        var idx = document.getElementById(theId).options.selectedIndex;
        /* CR232222 - Get the label value */
        var selectedLabel = document.getElementById(theId).options[idx].label;
        if (idx < 0)
        {
            alert( alertTxt );
            return;
        }
        /* CR232222 - Check to see if te label value was set to notEntitled */
        else if (selectedLabel == "notEntitled")
        {
            alert(alertTxt2);
            return;
        }
               
        document.getElementById(theId).options[idx] = null;
    }

    /**
     *  Function to return current state of locked placeholders
    */
    function getLockedState(num)
    {
        var totalPlaceholders = parseInt(num);

        lockedArray = new Array(totalPlaceholders);

        for (i=0; i < totalPlaceholders; i++)
        {
            lockedId = "lockPlaceholder" + i;
            lockedElement = document.getElementById(lockedId);
            if (lockedElement.checked)
            {
                lockedArray[i] = 1;
            }
            else
            {
                lockedArray[i] = 0;
            }
        }

        return lockedArray;
    }

    function moveLeft(placeholderNum)
    {
        var numPlaceholders = getNumPlaceholders();
        var theId = "placeholderList" + placeholderNum;
        var idx = document.getElementById(theId).options.selectedIndex;
        if (idx < 0)
        {
            return;
        }

        var sum = parseInt(placeholderNum) - 1;
        lockCheck = 0;
        lockedState = getLockedState(numPlaceholders);
        while (!lockCheck)
        {
            if (sum < 0)
            {
                sum = numPlaceholders - 1;
            }

            if (lockedState[sum] == 1)
            {
                sum--;
            }
            else
            {
                lockCheck = 1;
            }
        }

        var theNextId = "placeholderList" + sum;

        var idxName = document.getElementById(theId).options[idx].text;
        var idxValue = document.getElementById(theId).options[idx].value;
        var idxLabel = document.getElementById(theId).options[idx].label;
        var idxClass = document.getElementById(theId).options[idx].className;    
        document.getElementById(theId).options[idx] = null;
        var nextLength = document.getElementById(theNextId).options.length;
        document.getElementById(theNextId).options[nextLength] = new Option(idxName, idxValue);
        document.getElementById(theNextId).options[nextLength].label = idxLabel;
        document.getElementById(theNextId).options[nextLength].className = idxClass;        
    }

    function moveRight(placeholderNum)
    {
        var numPlaceholders = getNumPlaceholders();
        var theId = "placeholderList" + placeholderNum;
        var idx = document.getElementById(theId).options.selectedIndex;
        if (idx < 0)
        {
            return;
        }

        var sum = parseInt(placeholderNum) + 1;
        lockCheck = 0;
        lockedState = getLockedState(numPlaceholders);
        while (!lockCheck)
        {
            if (sum == numPlaceholders)
            {
                sum = 0;
            }

            if (lockedState[sum] == 1)
            {
                sum++;
            }
            else
            {
                lockCheck = 1;
            }
        }

        var theNextId = "placeholderList" + sum;

        var idxName = document.getElementById(theId).options[idx].text;
        var idxValue = document.getElementById(theId).options[idx].value;
        var idxLabel = document.getElementById(theId).options[idx].label;
        var idxClass = document.getElementById(theId).options[idx].className;        
        document.getElementById(theId).options[idx] = null;
        var nextLength = document.getElementById(theNextId).options.length;
        document.getElementById(theNextId).options[nextLength] = new Option(idxName, idxValue);
        document.getElementById(theNextId).options[nextLength].label = idxLabel;
        document.getElementById(theNextId).options[nextLength].className = idxClass;
    }

    function moveUp(placeholderNum)
    {
        var theId = "placeholderList" + placeholderNum;
        var idx = document.getElementById(theId).options.selectedIndex;
        if (idx < 0)
        {
            return;
        }
        var newIdx = idx - 1;

        if (idx <= 0)
        {
            return;
        }
        var selectedName  = document.getElementById(theId).options[newIdx].text;
        var selectedValue = document.getElementById(theId).options[newIdx].value;
        var selectedLabel = document.getElementById(theId).options[newIdx].label;
        var selectedClass = document.getElementById(theId).options[newIdx].className;
        
        document.getElementById(theId).options[newIdx].text = document.getElementById(theId).options[idx].text;
        document.getElementById(theId).options[newIdx].value = document.getElementById(theId).options[idx].value;
        document.getElementById(theId).options[newIdx].label = document.getElementById(theId).options[idx].label;
        document.getElementById(theId).options[newIdx].className = document.getElementById(theId).options[idx].className;
        
        document.getElementById(theId).options[idx].text = selectedName;
        document.getElementById(theId).options[idx].value = selectedValue;
        document.getElementById(theId).options[idx].label = selectedLabel;
        document.getElementById(theId).options[idx].className = selectedClass;
        
        document.getElementById(theId).options[newIdx].selected = "1";
    }

    function moveDown(placeholderNum)
    {
        var theId = "placeholderList" + placeholderNum;
        var idx = document.getElementById(theId).options.selectedIndex;
        if (idx < 0)
        {
            return;
        }
        var num = document.getElementById(theId).options.length;
        var newIdx = idx + 1;

        if (idx == num - 1)
        {
            return;
        }
        var selectedName  = document.getElementById(theId).options[newIdx].text;
        var selectedValue = document.getElementById(theId).options[newIdx].value;
        var selectedLabel = document.getElementById(theId).options[newIdx].label;
        var selectedClass = document.getElementById(theId).options[newIdx].className;
          
        document.getElementById(theId).options[newIdx].text = document.getElementById(theId).options[idx].text;
        document.getElementById(theId).options[newIdx].value = document.getElementById(theId).options[idx].value;
        document.getElementById(theId).options[newIdx].label = document.getElementById(theId).options[idx].label;
        document.getElementById(theId).options[newIdx].className = document.getElementById(theId).options[idx].className;
                
        document.getElementById(theId).options[idx].text = selectedName;
        document.getElementById(theId).options[idx].value = selectedValue;
        document.getElementById(theId).options[idx].label = selectedLabel;
        document.getElementById(theId).options[idx].className = selectedClass;
        
        document.getElementById(theId).options[newIdx].selected = "1";
    }

    function cancelChanges()
    {
        document.CancelChangesForm.submit();
    }

    function addPortlet(alertTxt)
    {
        var theId = "placeholderList" + currentHotPlaceholder;

        var allPortlets= document.getElementById("allPortlets");
        var allPortletOptionsLen = allPortlets.options.length;
        var curPortletsOptionsLen = document.getElementById(theId).options.length;
        var idx = allPortlets.options.selectedIndex;
        if (idx > -1)
        {
            for( i = 0; i < allPortletOptionsLen; i++ )
            {
                if( allPortlets.options[i].selected )
                {
                    var portletName = allPortlets.options[i].text;
                    var portletValue = "portlet_new" + numAddedResources + "_" + allPortlets.options[i].value;
                    numAddedResources++;
                    document.getElementById(theId).options[curPortletsOptionsLen] = new Option(portletName, portletValue);
                    curPortletsOptionsLen++;
                }
            }
            toggleDialogBox('AddContentDialog');
        }
        else
        {
            alert (alertTxt);
        }

    }

    function addBook(alertTxt)
    {
        var theId = "placeholderList" + currentHotPlaceholder;

        var allBooks = document.getElementById("allBooks");
        var allBooksOptionsLen = allBooks.options.length;
        var curBookOptionsLen = document.getElementById(theId).options.length;
        var idx = allBooks.options.selectedIndex;
        if (idx > -1)
        {
            for( i = 0; i < allBooksOptionsLen; i++ )
            {
                if( allBooks.options[i].selected )
                {
                    var bookName = allBooks.options[i].text;
                    var bookValue = "book_new" + numAddedResources + "_" + allBooks.options[i].value;
                    numAddedResources++;
                    document.getElementById(theId).options[curBookOptionsLen] = new Option(bookName, bookValue);
                    curBookOptionsLen++;
                }
            }
            toggleDialogBox('AddContentDialog');
        }
        else
        {
            alert (alertTxt);
        }

    }

    function addNewBook(txt)
    {
        toggleDialogBox2("AddNewBookDialog", 230,300,txt);
    }

    function addContent(placeholderNum,txt)
    {
        currentHotPlaceholder = placeholderNum;
        toggleDialogBox("AddContentDialog",370,430,txt);
    }

    /**
     *   Function to find placeholders that have changed placeables...
     */
    function findChangedPlaceholders(originalState, newState)
    {
        layoutActuallyChanged = new Array(newState.length);

        for (i=0; i<originalState.length; i++)
        {
            for (j=0; j<originalState[i].length; j++)
            {
                for (k=0; k<newState.length; k++)
                {
                    for (l=0; l<newState[k].length; l++)
                    {
                        if (originalState[i][j] == newState[k][l])
                        {
                            if (i != k || j != l)
                            {
                                layoutActuallyChanged[k] = 1;
                            }
                            k = newState.length;
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     *   Function to find all placeables that have changed position and need to be updated
     */
    function findMovedPlaceables(originalState, newState)
    {
        movedPlaceables = new Array(0);
        findChangedPlaceholders(originalState, newState);

        for (i=0; i<originalState.length; i++)
        {
            for (j=0; j<originalState[i].length; j++)
            {
                for (k=0; k<newState.length; k++)
                {
                    for (l=0; l<newState[k].length; l++)
                    {
                        if (originalState[i][j] == newState[k][l])
                        {
                            //if (i != k || j != l)
                            //{
                            if (layoutActuallyChanged[k] == 1)
                            {
                                movedPlaceables.push(new Array(newState[k][l], k, l));
                            }
                            //}
                            k = newState.length;
                            break;
                        }
                    }
                }
            }
        }

        return movedPlaceables;
    }

    /**
     *   Function to find all placeables that have been added
     */
    function findAddedPlaceables(originalState, newState)
    {
        addedPlaceables = new Array(0);

        for (i=0; i<newState.length; i++)
        {
            for (j=0; j<newState[i].length; j++)
            {
                found = 0;
                for (k=0; k<originalState.length; k++)
                {
                    for (l=0; l<originalState[k].length; l++)
                    {
                        if (newState[i][j] == originalState[k][l])
                        {
                            found = 1;
                            k = newState.length;
                            break;
                        }
                    }
                }
                if (!found)
                {
                    addedPlaceables.push(new Array(newState[i][j], i, j));
                }
            }
        }

        return addedPlaceables;
    }

    /**
     *   Function to find all placeables that have been deleted
     */
    function findDeletedPlaceables(originalState, newState)
    {
        deletedPlaceables = new Array(0);

        for (i=0; i<originalState.length; i++)
        {
            for (j=0; j<originalState[i].length; j++)
            {
                found = 0;
                for (k=0; k<newState.length; k++)
                {
                    for (l=0; l<newState[k].length; l++)
                    {
                        if (originalState[i][j] == newState[k][l])
                        {
                            found = 1;
                            k = newState.length;
                            break;
                        }
                    }
                }
                if (!found)
                {
                    deletedPlaceables.push(originalState[i][j]);
                }
            }
        }

        return deletedPlaceables;
    }

    /**
     *   Function to find all placeables that have changed position and need to be updated
     */
    function findChangedPlaceables(originalState, newState)
    {
        changedPlaceables = new Array(0);

        for (i=0; i<newState.length; i++)
        {
            for (j=0; j<newState[i].length; j++)
            {
                if (newState[i][j] != originalState[i][j])
                {
                    changedPlaceables.push(new Array(newState[i][j], i, j));
                }
            }
        }

        return changedPlaceables;
    }

    function stateHasChanged()
    {
        for (x=0; x<layoutActuallyChanged.length; x++)
        {
            if (layoutActuallyChanged[x] == 1)
            {
                return true;
            }
        }
        return false;
    }

    function saveChanges(alertTxt)
    {
        var newState = getPlaceableState();
        allMovedPlaceables = findMovedPlaceables(originalPlaceableState, newState);
        allDeletedPlaceables = findDeletedPlaceables(originalPlaceableState, newState);
        allAddedPlaceables = findAddedPlaceables(originalPlaceableState, newState);
        movedPlaceableIds = "";
        movedPlaceablePlaceholders = "";
        movedPlaceablePositions = "";
        deletedPlaceableIds = "";
        addedPlaceableIds = "";
        addedPlaceablePlaceholders = "";
        addedPlaceablePositions = "";

        for (i=0; i<allMovedPlaceables.length; i++)
        {
            movedPlaceableIds = movedPlaceableIds + allMovedPlaceables[i][0] + ",";
            movedPlaceablePlaceholders = movedPlaceablePlaceholders + allMovedPlaceables[i][1] + ",";
            movedPlaceablePositions = movedPlaceablePositions + allMovedPlaceables[i][2] + ",";
        }

        for (j=0; j<allDeletedPlaceables.length; j++)
        {
            deletedPlaceableIds = deletedPlaceableIds + allDeletedPlaceables[j] + ",";
        }

        for (k=0; k<allAddedPlaceables.length; k++)
        {
            addedPlaceableIds = addedPlaceableIds + allAddedPlaceables[k][0] + ",";
            addedPlaceablePlaceholders = addedPlaceablePlaceholders + allAddedPlaceables[k][1] + ",";
            addedPlaceablePositions = addedPlaceablePositions + allAddedPlaceables[k][2] + ",";
        }

        if (!stateHasChanged() && allDeletedPlaceables.length < 1 && allAddedPlaceables.length < 1)
        {
            alert(alertTxt);
        }
        else
        { 
            document.SavePlaceholdersForm.movePlaceableIds.value = movedPlaceableIds;
            document.SavePlaceholdersForm.movePlaceablePlaceholders.value = movedPlaceablePlaceholders;
            document.SavePlaceholdersForm.movePlaceablePositions.value = movedPlaceablePositions;
            document.SavePlaceholdersForm.deletePlaceableIds.value = deletedPlaceableIds;
            document.SavePlaceholdersForm.addPlaceableIds.value = addedPlaceableIds;
            document.SavePlaceholdersForm.addPlaceablePlaceholders.value = addedPlaceablePlaceholders;
            document.SavePlaceholdersForm.addPlaceablePositions.value = addedPlaceablePositions;
            document.SavePlaceholdersForm.submit();

        }
    }

    /**
    *   Function to return current state of placeables
    */
    function getPlaceableState()
    {

        plength = getNumPlaceholders();
        placeableArray = new Array(plength);

        for (i=0; i < plength; i++)
        {
            var theId = "placeholderList" + i;
            var theLength = document.getElementById(theId).options.length;
            placeableArray[i] = new Array(theLength);

            for (j=0; j<theLength; j++)
            {
                placeableArray[i][j] = document.getElementById(theId).options[j].value;
            }
        }

        return placeableArray;
    }


    function getNumPlaceholders()
    {
        plength = 0;
        while( true )
        {
            var theId = "placeholderList" + plength;
            if( document.getElementById(theId) == null || document.getElementById(theId).id == null )
            {
                break;
            }
            plength++;
        }
 
        return plength;
    }

    var originalPlaceableState = getPlaceableState();
