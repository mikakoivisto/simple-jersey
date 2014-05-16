
package com.sohlman.jersey;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {
	@Context ServletContext context;
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces("application/json")
    public String getIt() {
    	try {
    		String json = StringUtil.readFile(context.getRealPath("/WEB-INF/payload.json"));
    		return json.equals("")? "{}" : json;
    	}
    	catch(IOException ioe) {
    		return "{" + ioe.getMessage() + "}";
    	}
        
    }
}
