package JavaProject;

import java.sql.SQLException;
import java.util.List;



public interface DAO1<DPT> {
	
	      DPT get1(int id) throws SQLException;
	      
	      List<DPT> getall() throws SQLException;
	      
	      int insert(DPT dpt) throws SQLException;
	      
	      int update (DPT dpt) throws SQLException;
	      
	      int delete(DPT dpt) throws SQLException;
}

