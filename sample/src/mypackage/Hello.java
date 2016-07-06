package mypackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;



import mypackage.Table1;

public final class Hello extends HttpServlet
{	
	

 public Hello()
 {
 }

 public void doGet(HttpServletRequest request, HttpServletResponse response)
     throws IOException, ServletException
     
 {
	 
	 //CacheFactory.ensureCluster();
     //NamedCache cache = CacheFactory.getCache("Table1");

     //cache.put(123, "asdasd");
     //System.out.println((String)cache.get(123));

     //CacheFactory.shutdown();
	 
	 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "testEclipselink2" );
     EntityManager entitymanager = emfactory.createEntityManager( );
     entitymanager.getTransaction( ).begin( );

     Table1 employee = new Table1( ); 
          
     employee = entitymanager.find( Table1.class, 123 );
     System.out.println(employee.toString());
	 
     response.setContentType("text/html");
     PrintWriter writer = response.getWriter();
     writer.println("<html>");
     writer.println("<head>");
     writer.println("<title>Sample Application Servlet Page</title>");
     writer.println("</head>");
     writer.println("<body bgcolor=white>");
     writer.println("<table border=\"0\">");
     writer.println("<tr>");
     writer.println("<td>");
     writer.println("<img src=\"images/tomcat.gif\">");
     writer.println("</td>");
     writer.println("<td>");
     writer.println("<h1>Sample Application Servlet</h1>");
     writer.println("This is the output of a servlet that is part of");
     writer.println(employee.toString());
     writer.println("</td>");
     writer.println("</tr>");
     writer.println("</table>");
     writer.println("</body>");
     writer.println("</html>");
     
     entitymanager.getTransaction().commit();
     entitymanager.close( );
     emfactory.close( );
     
     
 }
}
