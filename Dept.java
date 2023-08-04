package JavaProject;

public class Dept {
    
	private int id1;
    private int deptId;
    private String deptName;
	
    
    public Dept(int id1, int deptId, String deptName) {
		super();
		this.id1 = id1;
		this.deptId = deptId;
		this.deptName = deptName;
	}
    
	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
 
	@Override
	public String toString() {
		return "Dept [id1=" + id1 + ", deptId=" + deptId + ", deptName=" + deptName + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
