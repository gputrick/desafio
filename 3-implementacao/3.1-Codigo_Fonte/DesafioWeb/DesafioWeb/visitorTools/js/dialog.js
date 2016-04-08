    var isDialogDisplayed = false;
    var dialogHeight = 0;
    var dialogWidth = 0;
    var theDialogDiv;
    var oldDialogInnerHTML;

    var theDialog2Div;
    var oldDialog2InnerHTML;
    var isDialog2Displayed = false;
    var dialog2Height = 0;
    var dialog2Width = 0;

    function toggleDialogBox2(theId,height,width,title)
    {
        theDialog2Div = document.getElementById(theId);
        dialog2Height = height;
        dialog2Width = width;

        if (isDialog2Displayed)
        {
            theDialog2Div.innerHTML = oldDialog2InnerHTML;
            theDialog2Div.style.visibility = "hidden";
            theDialogDiv.style.zIndex = 5001;
            document.getElementById("portletSelectList").style.visibility = "visible";
            document.getElementById("bookSelectList").style.visibility = "visible";
        }
        else
        {
            addDialog2Title(title);
            setDialog2SizeAndPos();
            theDialog2Div.style.visibility = "visible";
            theDialogDiv.style.zIndex = 0;
            document.getElementById("portletSelectList").style.visibility = "hidden";
            document.getElementById("bookSelectList").style.visibility = "hidden";
        }
        isDialog2Displayed = !isDialog2Displayed;
    }

    function toggleDialogBox(theId,height,width,title)
    {
        theDialogDiv = document.getElementById(theId);
        dialogHeight = height;
        dialogWidth = width;
        isDialogDisplayed = !isDialogDisplayed;
        dialogBkgdDiv = document.getElementById("dialogBackgroundDiv");

        if (isDialogDisplayed)
        {
            addDialogTitle(title);
            setDialogSizeAndPos();
        } else
        {
            theDialogDiv.innerHTML = oldDialogInnerHTML;
        }
        toggleDialogBkgd();
        var viz = isDialogDisplayed ? "visible" : "hidden";
        theDialogDiv.style.visibility = viz;

        if (isDialogDisplayed)
        {
            var keepGoing = true;
            var divElements = theDialogDiv.getElementsByTagName('INPUT');
            for (i=0; i<divElements.length && keepGoing; i++)
            {
                if (divElements[i].type=="text")
                {
                    divElements[i].focus();
                    divElements[i].select();
                    keepGoing = false;
                }
            }

            // if there is no text type, let us select the select type....
            if(keepGoing == true)
            {
                divElements = theDialogDiv.getElementsByTagName('SELECT');
                for (i=0; i<divElements.length; i++)
                {
                    divElements[i].focus();
                    break;
                }
            }
        }
    }

    function addDialog2Title(title)
    {
        oldDialog2InnerHTML = theDialog2Div.innerHTML;
        title = title ? title : "&nbsp;";
        var titleDiv = "<div class='bea-portal-window-titlebar' align='left'>\n";
        titleDiv += title + "\n";
        titleDiv += "</div>\n";
        theDialog2Div.innerHTML = titleDiv + oldDialog2InnerHTML + "\n";
    }

    function addDialogTitle(title)
    {
        oldDialogInnerHTML = theDialogDiv.innerHTML;
        title = title ? title : "&nbsp;";
        var titleDiv = "<div class='bea-portal-window-titlebar' align='left'>\n";
        titleDiv += title + "\n";
        titleDiv += "</div>\n";
        theDialogDiv.innerHTML = titleDiv + oldDialogInnerHTML + "\n";
    }

    function toggleDialogBkgd()
    {
        var keepGoing = true;
        var dbdViz = isDialogDisplayed ? "visible" : "hidden";
        var hfdViz = isDialogDisplayed ? "none" : "block";

        var divElements = document.getElementsByTagName('SELECT');
        for (i=0; i<divElements.length; i++)
        {
            if (divElements[i].name != "newBookMenuId")
            {
                divElements[i].style.display = hfdViz;
            }
        }

        if (isDialogDisplayed)
        {
            divElements = theDialogDiv.getElementsByTagName('SELECT');
            for (i=0; i<divElements.length; i++)
            {
                divElements[i].style.display = "block";
            }
        }

        dialogBkgdDiv.style.visibility = dbdViz;
    }

    function setDialogSizeAndPos()
    {

        if (isDialogDisplayed)
        {
            if (document.documentElement && document.documentElement.clientHeight && document.all)
            {
                // Appears to be IE6 with doctype
                var ch = document.documentElement.clientHeight;
                var sh = document.documentElement.scrollHeight;
                var cw = document.documentElement.clientWidth;
                var sw = document.documentElement.scrollWidth;
                var theTop;
                var theLeft;

                if ( (ch - dialogHeight) < 0 )
                {
                    theTop = document.documentElement.scrollTop;
                } else {
                    theTop = parseInt((ch - dialogHeight)/2) + document.documentElement.scrollTop;
                }

                if ( (cw - dialogWidth) < 0 )
                {
                    theLeft = document.documentElement.scrollLeft;
                } else {
                    theLeft = parseInt((cw - dialogWidth)/2) + document.documentElement.scrollLeft;
                }

                dialogBkgdDiv.style.height = (ch > sh)? ch : sh;
                dialogBkgdDiv.style.width = (cw > sw)? cw : sw;
                theDialogDiv.style.top = theTop;
                theDialogDiv.style.left = theLeft;
                theDialogDiv.style.height = dialogHeight;
                theDialogDiv.style.width = dialogWidth;
            } else
            {
                var ch = document.body.clientHeight;
                var sh = document.body.scrollHeight;
                var cw = document.body.clientWidth;
                var sw = document.body.scrollWidth;
                var theTop;
                var theLeft;

                if ( (ch - dialogHeight) < 0 )
                {
                    theTop = document.body.scrollTop;
                } else {
                    theTop = parseInt((ch - dialogHeight)/2) + document.body.scrollTop;
                }

                if ( (cw - dialogWidth) < 0 )
                {
                    theLeft = document.body.scrollLeft;
                } else {
                    theLeft = parseInt((cw - dialogWidth)/2) + document.body.scrollLeft;
                }

                if (document.getElementById&&!document.all)
                {
                    // Appears to be Mozilla
                    dialogBkgdDiv.style.height = ((ch > sh)? ch : sh) + "px";
                    dialogBkgdDiv.style.width = ((cw > sw)? cw : sw) + "px";
                    theDialogDiv.style.top = theTop + "px";
                    theDialogDiv.style.left = theLeft + "px";
                    theDialogDiv.style.height = dialogHeight + "px";
                    theDialogDiv.style.width = dialogWidth + "px";
                } else
                {
                    dialogBkgdDiv.style.height = (ch > sh)? ch : sh;
                    dialogBkgdDiv.style.width = (cw > sw)? cw : sw;
                    theDialogDiv.style.top = theTop;
                    theDialogDiv.style.left = theLeft;
                    theDialogDiv.style.height = dialogHeight;
                    theDialogDiv.style.width = dialogWidth;
                }
            }
        }
    }

    function setDialog2SizeAndPos()
    {
        if (!isDialog2Displayed)
        {
            if (document.documentElement && document.documentElement.clientHeight && document.all)
            {
                // Appears to be IE6 with doctype
                var ch = document.documentElement.clientHeight;
                var sh = document.documentElement.scrollHeight;
                var cw = document.documentElement.clientWidth;
                var sw = document.documentElement.scrollWidth;
                var theTop;
                var theLeft;

                if ( (ch - dialogHeight) < 0 )
                {
                    theTop = document.documentElement.scrollTop;
                } else {
                    theTop = parseInt((ch - dialog2Height)/2) + document.documentElement.scrollTop;
                }

                if ( (cw - dialog2Width) < 0 )
                {
                    theLeft = document.documentElement.scrollLeft;
                } else {
                    theLeft = parseInt((cw - dialog2Width)/2) + document.documentElement.scrollLeft;
                }

                dialogBkgdDiv.style.height = (ch > sh)? ch : sh;
                dialogBkgdDiv.style.width = (cw > sw)? cw : sw;
                theDialog2Div.style.top = theTop;
                theDialog2Div.style.left = theLeft;
                theDialog2Div.style.height = dialog2Height;
                theDialog2Div.style.width = dialog2Width;
            } else
            {
                var ch = document.body.clientHeight;
                var sh = document.body.scrollHeight;
                var cw = document.body.clientWidth;
                var sw = document.body.scrollWidth;
                var theTop;
                var theLeft;

                if ( (ch - dialogHeight) < 0 )
                {
                    theTop = document.body.scrollTop;
                } else {
                    theTop = parseInt((ch - dialog2Height)/2) + document.body.scrollTop;
                }

                if ( (cw - dialog2Width) < 0 )
                {
                    theLeft = document.body.scrollLeft;
                } else {
                    theLeft = parseInt((cw - dialog2Width)/2) + document.body.scrollLeft;
                }

                if (document.getElementById&&!document.all)
                {
                    // Appears to be Mozilla
                    dialogBkgdDiv.style.height = ((ch > sh)? ch : sh) + "px";
                    dialogBkgdDiv.style.width = ((cw > sw)? cw : sw) + "px";
                    theDialog2Div.style.top = theTop + "px";
                    theDialog2Div.style.left = theLeft + "px";
                    theDialog2Div.style.height = dialog2Height + "px";
                    theDialog2Div.style.width = dialog2Width + "px";
                } else
                {
                    dialogBkgdDiv.style.height = (ch > sh)? ch : sh;
                    dialogBkgdDiv.style.width = (cw > sw)? cw : sw;
                    theDialog2Div.style.top = theTop;
                    theDialog2Div.style.left = theLeft;
                    theDialog2Div.style.height = dialog2Height;
                    theDialog2Div.style.width = dialog2Width;
                }
            }
        }
    }

    onresize=setDialogSizeAndPos;
    onscroll=setDialogSizeAndPos;

