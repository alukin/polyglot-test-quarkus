package ua.cn.al.tst;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

@Path("/hello-resteasy")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String out = "From JS:";
//Workarround: replace class loader. Uncomment to make it work

//        ClassLoader quarkusClassLoader = Thread.currentThread().getContextClassLoader();
//        Thread.currentThread().setContextClassLoader(ClassLoader.getSystemClassLoader());

        try (Context context = Context.create()) {
            Value function = context.eval("js", "x => x+1");
            assert function.canExecute();
            int x = function.execute(41).asInt();
            out = out + x;
        } finally {
            //we have to rtestore original class loader after JS execution
            //because Quarkus needs it. If we don't it can not load e.g. TransactionManager
//            Thread.currentThread().setContextClassLoader(quarkusClassLoader);
            
        }
        return out;
    }
}