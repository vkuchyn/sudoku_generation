package ua.com.kuchyn.sudoku.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ssl.SslSelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 9/10/13
 * Time: 11:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebLauncher
{

    private Server server;

    public static void main(String[] args)
    {
        WebLauncher launcher = new WebLauncher();
        launcher.deployApplication(8080);
    }

    public void deployApplication(Integer port) {
        try {

            server = new Server(port);

            WebAppContext context = new WebAppContext();
            context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
            context.setResourceBase("src/main/webapp");
            context.setContextPath("/sudoku-gen");
            context.setParentLoaderPriority(true);

            server.setHandler(context);

            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
