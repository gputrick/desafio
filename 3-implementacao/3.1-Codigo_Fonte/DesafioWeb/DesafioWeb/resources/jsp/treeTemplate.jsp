<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="netui-tags-databinding.tld" prefix="netui-data"%>
<%@ taglib uri="netui-tags-html.tld" prefix="netui"%>
<%@ taglib uri="netui-tags-template.tld" prefix="netui-template"%>
<netui:html>
    <head>
        <title>
            Web Application Page
        </title>
    </head>
    <body>
        <p>
        <netui:tree tree="" dataSource="pageflow.myTree" action="treeState">
              <netui:node expanded="true" >
                  <netui:node>Root Folder</netui:node>
                  <netui:node expanded="false">
                      <netui:node>I</netui:node>
                      <netui:node expanded="false">
                          <netui:node>A</netui:node>
                          <netui:node>1</netui:node>
                          <netui:node>2</netui:node>
                      </netui:node>
                  </netui:node>
              </netui:node>
          </netui:tree>
        </p>
    </body>
</netui:html>
