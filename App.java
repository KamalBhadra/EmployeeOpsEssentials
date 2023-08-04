package JavaProject;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App  {
	 
		public static void login() throws SQLException {
				
				
				Scanner sc=new Scanner(System.in);
		        LoginDAOImpl loginDao=new LoginDAOImpl(sc);
		        System.out.println(loginDao);
				
		        
		      }
	

    public static void main(String[] args) throws SQLException {
                      
    	              login();   
    	              int choice=0;
    	             
    	              
    	              
    	              do {
    	            	  
    	            	   Scanner sc=new Scanner(System.in);
    		               choice=sc.nextInt();
			               System.out.println("Enter Your Choice Again");
    		               EmployeeDAO employeeDAO=new EmployeeDAOImpl();
    		               DeptDAO deptDAO=new DeptDAOImpl();
			 
	                  switch(choice){
	                      
		                     
	                         //Add Employee. 
		          	         case 1:
						             System.out.println("Add Employee");
						             System.out.println("Enter id");
						             int eid = sc.nextInt();
						             System.out.println("Enter Employee id");
						             int emp_id = sc.nextInt();
						             System.out.println("Enter First Name");
						             String f_name = sc.next();
						             System.out.println("Enter Last Name");
						             String l_name = sc.next();
						             System.out.println("Enter Department Id");
						             int d_id = sc.nextInt();
						             Employee employee3=new Employee(eid,emp_id,f_name,l_name,d_id);
						             employeeDAO.insert(employee3);
						             System.out.println("Employee Record Added Successfully");
						             break;
				 
			                //View Single Employee Record.
			                case 2:
						            System.out.println("View Employee");
						            System.out.println("Enter id");
						            int id1 = sc.nextInt();
						            Employee employee=employeeDAO.get(id1);
						            if(employee.getId()==id1) {
							                    System.out.println(employee);	  
						                        }
						           break;
			 
			              //view All Employee Record.	   
			               case 3:
								   System.out.println("View All Employee");
								   List<Employee> data;
								   data=employeeDAO.getall();
								   for(Employee emp:data) {
								             System.out.println(emp);
								         }
								   break;
				   
				          //Update Emplyoee Record.	   
					      case 4:
								   System.out.println("Update Employee Details");
								   System.out.println("Enter Id to Update");
								   int id2=sc.nextInt();
								   Employee employee1=employeeDAO.get(id2);
								   if(employee1.getId()==id2) {
									   System.out.println("Enter id");
									   int id = sc.nextInt();
									   System.out.println("Enter Employee id");
									   int employee_id = sc.nextInt();
									   System.out.println("Enter First Name");
									   String first_name = sc.next();
									   System.out.println("Enter Last Name");
									   String last_name = sc.next();
									   System.out.println("Enter Department Id");
									   int dept_id = sc.nextInt();
									   employee1.setId(id);
									   employee1.setEmployeeId(employee_id);
									   employee1.setFirstName(first_name);
									   employee1.setLastName(last_name);;
									   employee1.setDeptId(dept_id);
									   employeeDAO.update(employee1);
									   System.out.println("Employee Record Updated Successfully");
							           break;
						               }
				 
					        //Delete Employee Record.	   
					     case 5:
						              System.out.println("Delete Employee Data");
								      System.out.println("Enter Id to Delete Record");
								      int id3=sc.nextInt();
								      Employee employee2=employeeDAO.get(id3);
								      if(employee2.getId()==id3) {
									      employeeDAO.delete(employee2);
									       System.out.println("Record Deleted Successfully");
								      }
								      break;
				   		     
						 //Add Department Record.
					    case 6:
								     System.out.println("Enter id");
			                         int eid1 = sc.nextInt();
			                         System.out.println("Enter Department id");
				                     int dpt_id = sc.nextInt();
				                     System.out.println("Enter Department Name");
				                     String dpt_name = sc.next();
				                     Dept dpt3=new Dept(eid1,dpt_id,dpt_name);
				                     deptDAO.insert(dpt3);
				                     System.out.println("Department Added Successfully");
				                     break;
						     
		                     
			                 
			           //view  department        
					   case 7: 
								     System.out.println("View Department");
					                 System.out.println("Enter Department id");
					                 int deptId = sc.nextInt();
					                 Dept dept =deptDAO.get1(deptId);
					                 if(dept.getId1()==deptId) {
						                     System.out.println(dept);	  
					                       }
					                 
					                 break;
							       
			               
					 
					  //View All Department.
					   case 8: 
						    
								   System.out.println("View All Depatments");
							        
								   List<Dept> data1;
								   data1=deptDAO.getall();
								   for(Dept dpt:data1) {
								             System.out.println(dpt);
								        }
								   break;
					  //Update Department Record.		            
					  case 9: 
							        System.out.println("Enter Id to Update");
							        int id4=sc.nextInt();
							        Dept department=deptDAO.get1(id4);
							        if(department.getId1()==id4) 
							        {
								         System.out.println("Enter  id");
								         int id5 = sc.nextInt();
								         System.out.println("Enter Department id");
								         int deptID= sc.nextInt();
								         System.out.println("Enter Department Name");
								         String deptName = sc.next();
								   
								         department.setId1(id5);
								         department.setDeptId(deptID);
								         department.setDeptName(deptName);
								         deptDAO.update(department);
								   
								         System.out.println("Department Record Updated Successfully");
						                 
					                 }
							        break;
					       
				    //Delete department record 
					case 10: 
							     System.out.println("Delete Department Data");
						         System.out.println("Enter Department Id to Delete Record");
						         int id6=sc.nextInt();
						         Dept dept2=deptDAO.get1(id6);
						         if(dept2.getId1()==id6) {
							              deptDAO.delete(dept2);
							             System.out.println("Department Record Deleted Successfully");
						          }
						         break;
						    
					case 11:
								 System.out.println("Thank you for using the Application");
						         System.exit(0);
				           
			 
			        default:
			        	        
			        	        System.out.println("Please Enter a Valid Choice");
			        	        
				                break;
				              
			         }
    	           }while(choice!=0);
    	       }
		  
	     }
        
		
	


