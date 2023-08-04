package JavaProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginDAOImpl implements LoginDAO {

	
	Scanner sc;
	String user,password;
	
	public LoginDAOImpl(Scanner sc) throws SQLException {
		this.sc=sc;
		insertdata();
	   }
	
	public void insertdata() throws SQLException {
		System.out.println("******Welcome to the Banking Application*****\n");
		System.out.println("Enter UserName:");
		user=sc.nextLine();
		System.out.println("Enter Password");
		password=sc.nextLine();
	    authenticate(user,password);
	}
	
	
	public boolean authenticate(String user, String password) throws SQLException {
		boolean isUser=false;
		try {
			 Connection con=Database.getConnection();
		     
			 String sql="SELECT user,pass FROM login where user=? and pass=?";
		     
			 PreparedStatement ps=con.prepareStatement(sql);
		     
			 ps.setString(1,user);
		     ps.setString(2,password);
		     
		     ResultSet rs=ps.executeQuery();
		
	if(rs.next()) {
		    	  isUser=true;
		   
		    	       System.out.println("Welcome to the Java CRUD Project\n\n****Employee Management****"+"\n\n1.Add Employee"+"\n2.View Employee"+
		    		   "\n3.View All Employees"+"\n4.Update Employee Details"+"\n5.Delete Employee Data\n\n****Department Management****"+"\n\n6.Add Department"+""
		    		   + "\n7.view department"+"\n8.View All Department"+"\n9. Update Department"+"\n10.Delete Department"+"\n\n11.Exit\n");
		    		   System.out.println("Enter Your Choice");
		          
		     
		     
		     
		     
		     
	     	     }
		         
		     else{
		        	 System.out.println("Invalid id or password !");
		         }
		     }
		   catch(Exception e) {
		             System.out.println("Database Error");
		             e.printStackTrace();
		        }
                 return isUser;
	}

}

