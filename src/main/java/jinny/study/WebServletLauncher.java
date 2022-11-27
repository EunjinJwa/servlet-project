package jinny.study;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class WebServletLauncher {
    public static void main(String[] args) throws Exception {
        String webappDirLocation = "webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Connector connector = tomcat.getConnector();
        connector.setURIEncoding("UTF-8");

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}