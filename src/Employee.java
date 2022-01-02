
public class Employee {
	private String name;
	private int empId;
	private String dept;
	private int sal;
	private int phoneNum;
	private String email;
	
	
	public Employee(String name, int empId, String dept, int sal, int phoneNum, String email) {
		super();
		this.name = name;
		this.empId = empId;
		this.dept = dept;
		this.sal = sal;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", dept=" + dept + ", sal=" + sal +" ron" + ", phoneNum="
				+ phoneNum + ", email=" + email + "]";
	}
}
