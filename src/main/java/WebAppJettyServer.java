import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/*
This class demonstrates how to embed Jetty to point at a webapp.
You should be able to run it from within IntelliJ or Eclipse.
 */
public class WebAppJettyServer {

    public static void main(String args[]) throws Exception {
        Server server = new Server(8080);
        WebAppContext context = new WebAppContext();
        context.setWar("src/main/webapp");
        context.setContextPath("/");
        server.setHandler(context);
        server.start();
    }
}
