package citestpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CITest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement statement = null;
		try {
			
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/" + "jdbc/db");
			
			Connection connection = dataSource.getConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM fruit ORDER BY name");
			StringJoiner stringJoiner = new StringJoiner(",");
			while (resultSet.next()) {
				stringJoiner.add(resultSet.getString("name"));
	        }
			response.getWriter().append(stringJoiner.toString());
			
		} catch (SQLException | NamingException e) {			
			e.printStackTrace();
			response.getWriter().append("Database communication error. See Tomcat log for details. Exception: " + e.getMessage());
			
		} finally {  //TODO Fix this ugly finally.
			if (statement != null) { try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} }
		}
	}

}
