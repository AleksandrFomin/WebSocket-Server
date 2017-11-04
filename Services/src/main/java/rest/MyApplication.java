package rest; /**
 * Created by sasha on 30.10.17.
 */
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import rest.restservice;

//Defines the base URI for all resource URIs.
@ApplicationPath("/rest")
//The java class declares root resource and provider classes
public class MyApplication extends Application{
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add( restservice.class );
        return h;
    }
}
