package JavaProject;

import java.sql.SQLException;
import java.util.List;

public interface DAO<EMP> {
      EMP get(int id) throws SQLException;
      
      List<EMP> getall() throws SQLException;
      
      int insert(EMP emp) throws SQLException;
      
      int update (EMP emp) throws SQLException;
      
      int delete(EMP emp) throws SQLException;
      
      
}
