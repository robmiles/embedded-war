import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;
import java.security.ProtectionDomain;

/*
This class demonstrates how to embed Jetty so that it will work from an embedded WAR.
 */
public class WarJettyServer {

    public static void main(String args[]) throws Exception {
        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");

        // We need to use the ProtectionDomain to find where this class has been loaded from
        ProtectionDomain protectionDomain = WarJettyServer.class.getProtectionDomain();
        URL location = protectionDomain.getCodeSource().getLocation();
        context.setWar(location.toExternalForm());

        server.setHandler(context);
        server.start();
    }
}
