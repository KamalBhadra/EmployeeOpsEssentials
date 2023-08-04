package JavaProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeptDAOImpl implements DeptDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

   //view Single Department Record Using ID
	
	public Dept get1(int id) throws SQLException {
	
		Connection con=Database.getConnection();
		
		Dept dept=null;
		String sql="SELECT id1,dept_id,dept_name FROM department where id1=?";

		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			
			int oid=rs.getInt("id1");
			int deptId=rs.getInt("dept_id");
			String deptName=rs.getString("dept_name");
			dept=new Dept(oid,deptId,deptName);
					
		}
		return dept;
		
	}
	
	//view all department Record
	public List<Dept> getall() throws SQLException {
		
		
		Connection con=Database.getConnection();
		String sql="SELECT id1,dept_id,dept_name FROM department";
		
		List<Dept> dept=new ArrayList<>();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id1=rs.getInt("id1");
			int deptId=rs.getInt("dept_id");
			String deptName=rs.getString("dept_name");
			
			Dept department=new Dept(id1,deptId,deptName);
			dept.add(department);
		}
		return dept;
	
	}
		
		
    //Insert Method to add Department.
	public int insert(Dept dpt) throws SQLException {
		
		    Connection con=Database.getConnection();
		    String sql="INSERT INTO department(id1,dept_id,dept_name)VALUES(?,?,?)";
		    
		    PreparedStatement ps=con.prepareStatement(sql);
		    
		    ps.setInt(1,dpt.getId1());
		    ps.setInt(2,dpt.getDeptId());
		    ps.setString(3,dpt.getDeptName());
		   
		    int result=ps.executeUpdate();
		    
		    Database.closePreparedStatement(ps);
		    Database.closeConnection(con);
		    
		    return result;
		 }
	

	//Update Method to Update Department Record.
	
	public int update(Dept dpt) throws SQLException {
        Connection connection=Database.getConnection();
		
		String sql="UPDATE department set dept_id=?,dept_name=? where id1=?";
		
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ps.setInt(1,dpt.getDeptId());
		ps.setString(2,dpt.getDeptName());
		ps.setInt(3,dpt.getId1());
		
		int result=ps.executeUpdate();
		
		
		Database.closePreparedStatement(ps);
		Database.closeConnection(connection);
		
		return result;
		
	}
	
	//Delete Method to Delete Department Record.
	
	public int delete(Dept dpt) throws SQLException {
        
		
		Connection connection=Database.getConnection();
		
		String sql="DELETE FROM department WHERE id1=?";
		
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ps.setInt(1,dpt.getId1());
		
		int result=ps.executeUpdate();
		
		
		Database.closePreparedStatement(ps);
		Database.closeConnection(connection);
		
		return result;
	}

}
