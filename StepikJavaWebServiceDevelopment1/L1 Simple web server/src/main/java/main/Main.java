package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;
import servlets.MirrorRequestsServlet;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {

    public static final Logger LOG = Logger.getGlobal(); // !!!

    public static void main(String[] args) throws Exception {
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
        MirrorRequestsServlet mirrorRequestsServlet = new MirrorRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");
        context.addServlet(new ServletHolder(mirrorRequestsServlet), "/mirror");

        Server server = new Server(8081);
        server.setHandler(context);

        server.start();
//        java.util.logging.Logger.getGlobal().info("Server started"); // !!!
        LOG.info("Server started"); // !!!
        server.join();
    }
}
