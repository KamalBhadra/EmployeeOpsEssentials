package JavaProject;

import java.sql.SQLException;

public interface LoginDAO {
     
	public boolean authenticate(String user,String password) throws SQLException;

	public void insertdata()throws SQLException;
     
}
