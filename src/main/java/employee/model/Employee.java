package employee.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Table(name = "employee")
public class Employee {
	public enum Gender {
		FEMALE, MALE
	}

	public enum MaritalStatus {
		SINGLE, MARRIED, WIDOWED, DIVORCED, SPACESHIP
	}

	public enum Position {
		CEO, ENGINEER, KAINUMAN
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "birth_date")
	private String birthDate;

	@Column(name = "date_hired")
	private String dateHired;

	@Column(name = "marital_status")
	private MaritalStatus maritalStatus;

	@Column(name = "gender")
	private Gender gender;

	@Column(name = "position")
	private String position;

	@Column(name = "contact_info")
	private String contactInfo;

	@Column(name = "address_info")
	private String addressInfo;

	@Transient
	private int age;

	@Transient
	private int renderedYears;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDateHired() {
		return dateHired;
	}

	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}

	public int getAge() {
		try {
			Date birthDate = new SimpleDateFormat("yyyy-dd-MM").parse(this.birthDate);
			Date dateNow = new Date();
			setAge(dateNow.getYear() - birthDate.getYear());
		} catch (Exception e) {
			return -1;
		}
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRenderedYears() {
		try {
			Date dateHired = new SimpleDateFormat("yyyy-dd-MM").parse(this.dateHired);
			Date dateNow = new Date();
			setRenderedYears(dateNow.getYear() - dateHired.getYear());
		} catch (Exception e) {
			return -1;
		}
		return renderedYears;
	}

	public void setRenderedYears(int renderedYears) {
		this.renderedYears = renderedYears;
	}
}
