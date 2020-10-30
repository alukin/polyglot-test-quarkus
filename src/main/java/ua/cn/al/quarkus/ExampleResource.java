package ua.cn.al.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.graalvm.polyglot.*;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String out = "From JS:";
//Workarround: replace class loaded. Uncomment to make it work        
//        Thread.currentThread().setContextClassLoader(ClassLoader.getSystemClassLoader());

        try (Context context = Context.create()) {
            Value function = context.eval("js", "x => x+1");
            assert function.canExecute();
            int x = function.execute(41).asInt();
            out=out+x;
        }
        return out;
    }
}
