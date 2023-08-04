package JavaProject;

import java.sql.SQLException;
import java.util.Scanner;

class Login  {
	
	 
	public static void login() throws SQLException {
			
			
			Scanner sc=new Scanner(System.in);
	        LoginDAOImpl loginDao=new LoginDAOImpl(sc);
	        System.out.println(loginDao);
	        
	      }

}
