package JavaProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

	//View Employee
	public Employee get(int id) throws SQLException {
		
		Connection con=Database.getConnection();
		Employee employee=null;
		
		String sql="SELECT id,employee_id,first_name,last_name,dept_id FROM employee WHERE id=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
		
			int oid=rs.getInt("id");
			int employeeId=rs.getInt("employee_id");
			String firstName=rs.getString("first_name");
			String lastName=rs.getString("last_name");
			int deptId=rs.getInt("dept_id");
			
			employee=new Employee(oid,employeeId,firstName,lastName,deptId);
					
		}
		
		return employee;
	}

	
	//View all Employees
	public List<Employee> getall() throws SQLException {
		
		Connection con=Database.getConnection();
		
		String sql="SELECT id,employee_id,first_name,last_name,dept_id FROM employee";
		
		List<Employee> employee=new ArrayList<>();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id=rs.getInt("id");
			int employeeId=rs.getInt("employee_id");
			String firstName=rs.getString("first_name");
			String lastName=rs.getString("last_name");
			int deptId=rs.getInt("dept_id");
			
			Employee employees=new Employee(id,employeeId,firstName,lastName,deptId);
			
			employee.add(employees);
		}
		
		return employee;
		
	}

	//Add Employees
	public int insert(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
	    Connection con=Database.getConnection();
	    String sql="INSERT INTO employee(id,employee_id,first_name,last_name,dept_id)VALUES(?,?,?,?,?)";
	    
	    PreparedStatement ps=con.prepareStatement(sql);
	    
	    ps.setInt(1,employee.getId());
	    ps.setInt(2,employee.getEmployeeId());
	    ps.setString(3,employee.getFirstName());
	    ps.setString(4,employee.getLastName());
	    ps.setInt(5,employee.getDeptId());
	    
	    int result=ps.executeUpdate();
	    
	    
	    Database.closePreparedStatement(ps);
	    Database.closeConnection(con);
	    
	    return result;
	      		    
	}

	//Update Employees
	public int update(Employee employee) throws SQLException {
		Connection connection=Database.getConnection();
		
		String sql="UPDATE employee set employee_id=?,first_name=?,last_name=?,dept_id=? where id=?";
		
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ps.setInt(1,employee.getEmployeeId());
		ps.setString(2,employee.getFirstName());
		ps.setString(3,employee.getLastName());
		ps.setInt(4,employee.getDeptId());
		ps.setInt(5,employee.getId());
		
		int result=ps.executeUpdate();
		
		
		Database.closePreparedStatement(ps);
		Database.closeConnection(connection);
		
		return result;
	}

	//Delete Employees
	public int delete(Employee employee) throws SQLException {
		Connection connection=Database.getConnection();
		
		String sql="DELETE FROM employee WHERE id=?";
		
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ps.setInt(1,employee.getId());
		
		int result=ps.executeUpdate();
		
		
		Database.closePreparedStatement(ps);
		Database.closeConnection(connection);
		
		return result;
		
	}

}
