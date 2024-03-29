package com.validity.workspace.pojo;

import java.util.Objects;

import com.validity.workspace.ReadAndProcessCSV.ReadAndProcessCSV;

public class Person {

    //Declaration of Person attributes 
	private int id;
    private String first_name;
    private String last_name;
    private String company;
    private String email;
    private String address1;
    private String address2;
    private String zip;
    private String city;
    private String state_long;
    private String state;
    private String phone;

    
    //Getter and setters of attributes
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState_long() {
        return state_long;
    }

    public void setState_long(String state_long) {
        this.state_long = state_long;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //Overriding the equals method to differentiate not only by their identity but also by their properties value  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        //Leveraging edit distance to compare strings requiring certain number of edits to be equal
        //can add or remove attributes based on your preference 
        //currently will display records that are exactly equal on mentioned properties
        return  ReadAndProcessCSV.editDist(this.getFirst_name(),person.getFirst_name(),this.first_name.length(),person.getFirst_name().length())==0 &&
                ReadAndProcessCSV.editDist(this.getLast_name(),person.getLast_name(),this.last_name.length(),person.getLast_name().length())==0 &&
                ReadAndProcessCSV.editDist(this.getCompany(),person.getCompany(),this.company.length(),person.getCompany().length())==0 &&
                ReadAndProcessCSV.editDist(this.getEmail(),person.getEmail(),this.email.length(),person.getEmail().length())==0 &&
                //Objects.equals(company, person.company) &&
                Objects.equals(id, person.id)&&
                Objects.equals(address1, person.address1) &&
                Objects.equals(address2, person.address2) &&
                Objects.equals(zip, person.zip) &&
                Objects.equals(city, person.city) &&
                Objects.equals(state_long, person.state_long) &&
                Objects.equals(state, person.state) &&
                Objects.equals(phone, person.phone);
    }

    //overriding hash code as I overrrided equals method(to prevent violation)
    @Override
    public int hashCode() {
        return Objects.hash(id,address1, address2, zip, city, state_long, state, phone);
    }

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

