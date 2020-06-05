package employee.model;

public class EmployeeAddInfo {
	private int id;
	private String value;
	private Employee employee;

	enum infoType {
		ADDRESS, CONTACT_INFO
	}

	public EmployeeAddInfo() {
	}

	public int getId() {
		return id;
	}

	public void setEmployeeId(int employeeId) {
		this.id = employeeId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
