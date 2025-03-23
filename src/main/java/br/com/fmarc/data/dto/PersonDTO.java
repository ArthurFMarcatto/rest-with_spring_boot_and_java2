package br.com.fmarc.data.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.fmarc.serializer.GenderSerializer;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonPropertyOrder({"id","first_name","last_name","address"})
public class PersonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	// @JsonProperty("first_name")
	private String firstname;

	// @JsonProperty("last_name")
	private String lastname;

	//@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String phonenumber;

	@JsonFormat(pattern = "dd/MM/yyyy")
	//@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Date birthday;

	private String address;

	// @JsonIgnore
	@JsonSerialize(using = GenderSerializer.class)
	private String gender;

	public PersonDTO() {
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lasname) {
		this.lastname = lasname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public Long setId(Long id) {
		return this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, birthday, firstname, gender, id, lastname, phonenumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonDTO other = (PersonDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(birthday, other.birthday)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(gender, other.gender)
				&& Objects.equals(id, other.id) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(phonenumber, other.phonenumber);
	}
	
	

}