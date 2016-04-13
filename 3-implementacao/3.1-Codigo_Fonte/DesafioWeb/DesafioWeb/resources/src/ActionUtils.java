package resources.src; 

import com.bea.wlw.netui.pageflow.scoping.ScopedServletUtils;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.Globals;
import org.apache.struts.config.ModuleConfig;

public class ActionUtils { 
  
  private static final String ACTION_EXTENSION = ".do";
  private static final String JPF_SCOPE_KEY = "jpfScopeID";    
  
  public static String generateActionURL (HttpServletRequest request,String action) {
    if (request != null &&  action != null) {
      ModuleConfig appConfig = ( ModuleConfig ) request.getAttribute( Globals.MODULE_KEY );
      if ( appConfig != null ) {
        StringBuffer sb = new StringBuffer();                
        
        sb.append(request.getProtocol().substring(0, 4))
        .append("://")
        .append(request.getServerName())        
        .append(":")
        .append(request.getServerPort())
        .append(request.getContextPath())
        .append(appConfig.getPrefix())
        .append("/")
        .append( action )
        .append(ACTION_EXTENSION);
        String jpfScopeID = null;
        if (ScopedServletUtils.unwrapRequest( request ) != null)
          jpfScopeID = (String) ScopedServletUtils.unwrapRequest( request ).getScopeKey();
        else
          jpfScopeID = (String) request.getParameter(JPF_SCOPE_KEY); 
        sb.append("?")
        .append(JPF_SCOPE_KEY)
        .append("=")
        .append(jpfScopeID);
        return sb.toString();
      }
    }    
    return null;
  }    
    
} 
