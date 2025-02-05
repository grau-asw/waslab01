package fib.asw.waslab01_ss;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class H2dbStarter implements ServletContextListener {


	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/fib/asw/waslab01", "sa", "");
			// The database contents will be stored in a file: $HOME/fib/asw/waslab01.mv.db

			DatabaseMetaData metaData = conn.getMetaData();
			ResultSet tables = metaData.getTables(null, null, "TWEETS", null);
			if (!tables.next()) {
				// The "tweets" table does not exist, so we initialize the database
				Statement stmt = conn.createStatement();
				stmt.execute("RUNSCRIPT FROM 'classpath:h2-config.sql'");
				stmt.close();
			}
			tables.close();

			servletContextEvent.getServletContext().setAttribute("connection", conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		Connection conn = (Connection) servletContextEvent.getServletContext().getAttribute("connection");
		try {
			Statement stat = conn.createStatement();
			stat.execute("SHUTDOWN");
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}