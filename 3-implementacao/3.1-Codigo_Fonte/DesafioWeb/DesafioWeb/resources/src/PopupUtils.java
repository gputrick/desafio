package resources.src; 

import javax.servlet.http.HttpServletRequest;

public class PopupUtils { 
  
  public static final String OBJ_SELECT_KEY = "OBJ_SEL_POPUP";
    
  public static String generatePopupURL (HttpServletRequest request,String action) {
    return ActionUtils.generateActionURL(request,action);
    
  }
} 
