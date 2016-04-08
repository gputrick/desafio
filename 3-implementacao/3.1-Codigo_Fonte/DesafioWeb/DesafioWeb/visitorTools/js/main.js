var selectedType = "book";
var selectedId = "0";
var selectedParentId = "0";
var selectedParentType = "book";
var selectedName = "";
var moveBit = "0";
var selectedMoveParentBit = 0;
var selectedMoveType = "book";
var selectedMoveId = "0";
var selectedMoveName = "";
var oldInnerHTML = "";
var moveToPageOK = false;
var moveToBookOK = false;
var selectedBookDivNum = "";
var selectedTaxonomy = "";

document.vlinkColor = document.linkColor;
document.alinkColor = document.linkColor;

function translateValues(inputString)
{
    filteredVal = new String(inputString);
    filteredVal = filteredVal.replace(/\</gi, "&lt;");
    filteredVal = filteredVal.replace(/\>/gi, "&gt;");
    filteredVal = filteredVal.replace(/\(/gi, "&#40");
    filteredVal = filteredVal.replace(/\)/gi, "&#41");

    return filteredVal;
}

function cancelMove()
{
    moveBit = 0;
    selectedMoveId = "";
    selectedMoveName = "";

    disableItems("portlet",false);
    disableItems("book",false);
    disableItems("page",false);

    if (selectedMoveParentBit == 1)
    {
        tmpHTML = document.getElementById("finishMoveButtonOff").innerHTML;
        document.getElementById("finishMoveButtonOff").innerHTML = document.getElementById("finishMoveButtonOn").innerHTML;
        document.getElementById("finishMoveButtonOn").innerHTML = tmpHTML;
    }
    selectedMoveParentBit = 0;

    document.getElementById("moveDiv").innerHTML = document.getElementById("editItemDiv").innerHTML;
    document.getElementById("editItemDiv").innerHTML = oldInnerHTML;
    oldInnerHTML = "";
}

function moveResource(clickPage, clickBook)
{
    moveBit = 1;

    disableItems("portlet",true);

    if (selectedType == "portlet")
    {
        disableItems("book",true);
        document.getElementById("itemToMoveTo").innerHTML = clickPage;
    }
    else if (selectedType == "page")
    {
        disableItems("page",true);
        document.getElementById("itemToMoveTo").innerHTML = clickBook;
    } else if (selectedType == "book")
    {
        if (selectedParentType == "book")
        {
            disableItems("page",true);
            document.getElementById("itemToMoveTo").innerHTML = clickBook;
        }
        else if (selectedParentType == "page")
        {
            disableItems("book",true);
            document.getElementById("itemToMoveTo").innerHTML = clickPage;
        }
        // Turn off the book itself to prevent recursion
        //document.getElementById("book" + selectedBookDivNum + "On").style.display = "none";
        //document.getElementById("book" + selectedBookDivNum + "Off").style.display = "block";
    }

    disableChildItems();

    oldInnerHTML = document.getElementById("editItemDiv").innerHTML;
    document.getElementById("editItemDiv").innerHTML = document.getElementById("moveDiv").innerHTML;
    document.getElementById("moveDiv").innerHTML = "";
}

function disableChildItems()
{
    num = resourcesArray.length;

    for (i=0; i < num; i++)
    {
       if (resourcesArray[i][1].indexOf(selectedTaxonomy) != -1 && resourcesArray[i][1] != selectedTaxonomy)
       {
            //alert(resourcesArray[i][1]);
            var eltOn = document.getElementById(resourcesArray[i][0] + "On");
            var eltOff = document.getElementById(resourcesArray[i][0] + "Off");
            eltOn.style.display = "none";
            eltOff.style.display = "block";
       }
    }
}

function disableItems(type,bool)
{
    var keepGoing = true;
    var num = 0;
    while (keepGoing)
    {
        var eltOn = document.getElementById(type + num + (bool ? "On" : "Off"));
        var eltOff = document.getElementById(type + num + (bool ? "Off" : "On"));
        if (eltOn == null)
        {
            keepGoing = false;
        } else
        {
            eltOn.style.display = "none";
            eltOff.style.display = "block";
            num++;
        }
    }
}

function showPageContents()
{
    if (document.getElementById("showPageContentsCheckbox").checked)
    {

        divElements = document.getElementsByTagName('DIV');
        for (i=0; i<divElements.length; i++)
        {
            if (divElements[i].className=="pagechild" || divElements[i].className=="bookchild" || divElements[i].className=="portletchild")
            {
                //divElements[i].style.visibility = "visible";
                divElements[i].style.display = "block";
            }
        }
    }
    else
    {
        divElements = document.getElementsByTagName('DIV');
        for (i=0; i<divElements.length; i++)
        {
            if (divElements[i].className=="pagechild" || divElements[i].className=="bookchild" || divElements[i].className=="portletchild")
            {
                //divElements[i].style.visibility = "hidden";
                divElements[i].style.display = "none";
            }
        }
    }
}

function editResource()
{
    checkVal = "0";
    showContents = document.getElementById("showPageContentsCheckbox");
    if (showContents.checked)
    {
        checkVal = "1";
    }

    if (selectedType == "page")
    {
        document.EditPageForm.showPageContentsVal.value = checkVal;
        document.EditPageForm.submit();
    }
    else
    {
        document.EditBookForm.showPageContentsVal.value = checkVal;
        document.EditBookForm.submit();
    }
}

function applyTheme()
{
    checkVal = "0";
    showContents = document.getElementById("showPageContentsCheckbox");
    if (showContents.checked)
    {
        checkVal = "1";
    }

    document.UpdateThemeForm.showPageContentsVal.value = checkVal;
    document.UpdateThemeForm.submit();
}

function applyLookAndFeel()
{
    checkVal = "0";
    showContents = document.getElementById("showPageContentsCheckbox");
    if (showContents.checked)
    {
        checkVal = "1";
    }

    document.UpdateLookAndFeelForm.showPageContentsVal.value = checkVal;
    document.UpdateLookAndFeelForm.submit();
}

function renameResource(inputString)
{
	toggleDialogBox("renameResourceDialog",125,250,inputString);
}

function renameResourceSubmit(newName,alertTxt)
{
    checkVal = "0";
    showContents = document.getElementById("showPageContentsCheckbox");
    if (showContents.checked)
    {
        checkVal = "1";
    }

    if(newName != null)
    {
        if (newName != "")
        {
            document.RenameResourceForm.showPageContentsVal.value = checkVal;
            document.RenameResourceForm.renameResource.value = newName;
            document.RenameResourceForm.submit();
        }
        else
        {
            alert(alertTxt);
        }
    }
}

function finishMoveResource()
{
    checkVal = "0";
    showContents = document.getElementById("showPageContentsCheckbox");
    if (showContents.checked)
    {
        checkVal = "1";
    }

    if (selectedType == "portlet")
    {
        document.MoveToPageForm.pageToMoveTo.value = selectedMoveId;
        document.MoveToPageForm.resourceToMove.value = selectedId;
        document.MoveToPageForm.resourceTypeToMove.value = selectedType;
        document.MoveToPageForm.resourceToMoveFrom.value = selectedParentId;
        document.MoveToPageForm.resourceTypeToMoveFrom.value = selectedParentType;
        document.MoveToPageForm.showPageContentsVal.value = checkVal;

        document.MoveToPageForm.submit();
    }
    else if (selectedType == "page")
    {
        document.MoveToBookForm.bookToMoveTo.value = selectedMoveId;
        document.MoveToBookForm.resourceToMove.value = selectedId;
        document.MoveToBookForm.resourceTypeToMove.value = selectedType;
        document.MoveToBookForm.resourceToMoveFrom.value = selectedParentId;
        document.MoveToBookForm.resourceTypeToMoveFrom.value = selectedParentType;
        document.MoveToBookForm.showPageContentsVal.value = checkVal;

        document.MoveToBookForm.submit();
    }
    else if (selectedType == "book")
    {
        if (selectedMoveType == "page")
        {
            document.MoveToPageForm.pageToMoveTo.value = selectedMoveId;
            document.MoveToPageForm.resourceToMove.value = selectedId;
            document.MoveToPageForm.resourceTypeToMove.value = selectedType;
            document.MoveToPageForm.resourceToMoveFrom.value = selectedParentId;
            document.MoveToPageForm.resourceTypeToMoveFrom.value = selectedParentType;
            document.MoveToPageForm.showPageContentsVal.value = checkVal;

            document.MoveToPageForm.submit();
        }
        else
        {
            document.MoveToBookForm.bookToMoveTo.value = selectedMoveId;
            document.MoveToBookForm.resourceToMove.value = selectedId;
            document.MoveToBookForm.resourceTypeToMove.value = selectedType;
            document.MoveToBookForm.resourceToMoveFrom.value = selectedParentId;
            document.MoveToBookForm.resourceTypeToMoveFrom.value = selectedParentType;
            document.MoveToBookForm.showPageContentsVal.value = checkVal;

            document.MoveToBookForm.submit();
        }
    }
}

function selectPortlet(portletId, parentId, parentType, themeId, portletName, taxonomy, selectPortletTxt)
{
    if (moveBit == 1)
    {
    }
    else
    {
        selectedType = "portlet";
        selectedId = portletId;
        selectedParentId = parentId;
        selectedParentType = parentType;
        selectedName = portletName;
        selectedTaxonomy = taxonomy;
        moveToPageOK = true;
        moveToBookOK = false;

        document.RenameResourceForm.resourceId.value = portletId;
        document.RenameResourceForm.resourceType.value = "portlet";
        document.UpdateThemeForm.resourceId.value = portletId;
        document.UpdateThemeForm.resourceType.value = "portlet";

        document.getElementById("selectedResourceDiv").innerHTML = selectPortletTxt + " &quot;" + translateValues(portletName) + "&quot;";

        var num = document.forms.UpdateThemeForm.themeId.options.length;
        for (var x=0; x < num; x++)
        {
            if (themeId == document.forms.UpdateThemeForm.themeId.options[x].value)
            {
                document.forms.UpdateThemeForm.themeId[x].selected = "1";
            }
        }

        activateEditMode();
    }
}

function selectBook(bookId, parentId, parentType, themeId, bookName, divNum, taxonomy, selectedText)
{
    if (moveBit == 1)
    {
        if (moveToBookOK)
        {
            selectedMoveType = "book";
            selectedMoveId = bookId;
            selectedMoveName = bookName;

            document.getElementById("itemToMoveTo").innerHTML = translateValues(bookName);
            if (selectedMoveParentBit == 0)
            {
                tmpHTML = document.getElementById("finishMoveButtonOff").innerHTML;
                document.getElementById("finishMoveButtonOff").innerHTML = document.getElementById("finishMoveButtonOn").innerHTML;
                document.getElementById("finishMoveButtonOn").innerHTML = tmpHTML;
            }
            selectedMoveParentBit = 1;
        }
    }
    else
    {
        selectedType = "book";
        selectedId = bookId;
        selectedParentId = parentId;
        selectedParentType = parentType;
        selectedName = bookName;
        moveToPageOK = true;
        moveToBookOK = true;
        selectedBookDivNum = divNum;
        selectedTaxonomy = taxonomy;

        document.RenameResourceForm.resourceId.value = bookId;
        document.RenameResourceForm.resourceType.value = "book";
        document.UpdateThemeForm.resourceId.value = bookId;
        document.UpdateThemeForm.resourceType.value = "book";
        document.EditBookForm.editBook.value = bookId;
        document.EditBookForm.editBookName.value = bookName;

        document.getElementById("selectedResourceDiv").innerHTML = selectedText + " &quot;" + translateValues(bookName) + "&quot;";


        var num = document.forms.UpdateThemeForm.themeId.options.length;
        for (var x=0; x < num; x++)
        {
            if (themeId == document.forms.UpdateThemeForm.themeId.options[x].value)
            {
                document.forms.UpdateThemeForm.themeId[x].selected = "1";
            }
        }

        activateEditMode();
    }
}

function selectPage(pageId, parentId, parentType, themeId, pageName, taxonomy, selectedTxt)
{
    if (moveBit == 1)
    {
        if (moveToPageOK)
        {
            selectedMoveType = "page";
            selectedMoveId = pageId;
            selectedMoveName = pageName;
            document.getElementById("itemToMoveTo").innerHTML = translateValues(pageName);
            if (selectedMoveParentBit == 0)
            {
                tmpHTML = document.getElementById("finishMoveButtonOff").innerHTML;
                document.getElementById("finishMoveButtonOff").innerHTML = document.getElementById("finishMoveButtonOn").innerHTML;
                document.getElementById("finishMoveButtonOn").innerHTML = tmpHTML;
            }
            selectedMoveParentBit = 1;
        }
    }
    else
    {
        selectedType = "page";
        selectedId = pageId;
        selectedParentId = parentId;
        selectedParentType = parentType;
        selectedName = pageName;
        moveToPageOK = false;
        moveToBookOK = true;
        selectedTaxonomy = taxonomy;

        document.RenameResourceForm.resourceId.value = pageId;
        document.RenameResourceForm.resourceType.value = "page";
        document.UpdateThemeForm.resourceId.value = pageId;
        document.UpdateThemeForm.resourceType.value = "page";
        document.EditPageForm.editPage.value = pageId;
        document.EditPageForm.editPageName.value = pageName;

        document.getElementById("selectedResourceDiv").innerHTML = selectedTxt + " &quot;" + translateValues(pageName) + "&quot;";

        var num = document.forms.UpdateThemeForm.themeId.options.length;
        for (var x=0; x < num; x++)
        {
            if (themeId == document.forms.UpdateThemeForm.themeId.options[x].value)
            {
                document.forms.UpdateThemeForm.themeId[x].selected = "1";
            }
        }

        activateEditMode();
    }
}

function selectPortal(bookId, themeId, bookName, selectedPre, selectedPost)
{
    if (moveBit == 1)
    {
        if (moveToBookOK)
        {
            selectedMoveType = "book";
            selectedMoveId = bookId;
            selectedMoveName = bookName;
            document.getElementById("itemToMoveTo").innerHTML = selectedPost;
            if (selectedMoveParentBit == 0)
            {
                tmpHTML = document.getElementById("finishMoveButtonOff").innerHTML;
                document.getElementById("finishMoveButtonOff").innerHTML = document.getElementById("finishMoveButtonOn").innerHTML;
                document.getElementById("finishMoveButtonOn").innerHTML = tmpHTML;
            }
            selectedMoveParentBit = 1;
        }
    }
    else
    {
        selectedType = "portal";
        selectedId = bookId;
        selectedName = bookName;
        moveToPageOK = false;
        moveToBookOK = false;

        document.EditBookForm.editBook.value = bookId;
        document.EditBookForm.editBookName.value = bookName;
        document.UpdateThemeForm.resourceId.value = bookId;
        document.UpdateThemeForm.resourceType.value = "book";

        document.getElementById("selectedResourceDiv").innerHTML = selectedPre + " " + selectedPost;

        var num = document.forms.UpdateThemeForm.themeId.options.length;
        for (var x=0; x < num; x++)
        {
            if (themeId == document.forms.UpdateThemeForm.themeId.options[x].value)
            {
                document.forms.UpdateThemeForm.themeId[x].selected = "1";
            }
        }

        activateEditMode();
    }
}


function activateEditMode()
{
    if (selectedType == "portlet")
    {
        document.getElementById("editContentsButtonOn").style.display = "none"
        document.getElementById("editContentsButtonOff").style.display = "block"
    } else
    {
        document.getElementById("editContentsButtonOn").style.display = "block"
        document.getElementById("editContentsButtonOff").style.display = "none"
    }

    document.getElementById("chooseThemeButtonOff").style.display = "none";
    document.getElementById("chooseThemeButtonOn").style.display = "block";

    if (selectedType == "portal")
    {
        document.getElementById("renameButtonOn").style.display = "none"
        document.getElementById("renameButtonOff").style.display = "block"
        document.getElementById("moveButtonOn").style.display = "none"
        document.getElementById("moveButtonOff").style.display = "block"
    } else
    {
        document.getElementById("renameButtonOn").style.display = "block"
        document.getElementById("renameButtonOff").style.display = "none"
        document.getElementById("moveButtonOn").style.display = "block"
        document.getElementById("moveButtonOff").style.display = "none"
    }
}
