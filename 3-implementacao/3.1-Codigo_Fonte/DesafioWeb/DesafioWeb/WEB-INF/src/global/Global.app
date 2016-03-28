package global;

import com.bea.wlw.netui.pageflow.*;

/**
 * The Global page flow is used to define actions which can be invoked by any other
 * page flow in a webapp. The "jpf:catch" annotation provides a global way to catch
 * unhandled exceptions by forwarding to an error page.
 *
 * @jpf:catch type="Exception" method="handleException"
 * @jpf:catch type="PageFlowException" method="handlePageFlowException"
 */
public class Global extends GlobalApp
{
   /**
    * Sample global action that will return to the default Controller.jpf in
    * the webapp root.
    * @jpf:action
    * @jpf:forward name="home" path="/Controller.jpf"
    */
    public Forward home()
    {
        return new Forward( "home" );
    }

    /**
     * @jpf:exception-handler
     * @jpf:forward name="errorPage" path="/error.jsp"
     */
    protected Forward handleException( Exception ex, String actionName,
                                       String message, FormData form )
    {
        System.err.print( "[" + getRequest().getContextPath() + "] " );
        System.err.println( "Unhandled exception caught in Global.app:" );
        ex.printStackTrace();
        return new Forward( "errorPage" );
    }

    /** 
     * Handler for native page flow exceptions (e.g., ActionNotFoundException,
     * which is thrown when an unknown page flow action is requested). This handler
     * allows PageFlowExceptions to write informative error pages to the response.
     * To use the standard exception-handler for these exceptions, simply remove
     * this method and the "jpf:catch" annotation for PageFlowException.
     *
     * @jpf:exception-handler
     */ 
    public Forward handlePageFlowException( PageFlowException ex, String actionName,
                                            String message, FormData form ) 
        throws java.io.IOException
    { 
        ex.sendError( getRequest(), getResponse() ); 
        return null; 
    } 
}
