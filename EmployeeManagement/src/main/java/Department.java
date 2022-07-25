
public class Department {
	private int deptNo;
	private String departmentName;
	private String location;
	
	
	public Department(int deptNo, String departmentName, String location) {
		super();
		this.deptNo = deptNo;
		this.departmentName = departmentName;
		this.location = location;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", departmentName=" + departmentName + ", location=" + location + "]";
	}
	
	
}
