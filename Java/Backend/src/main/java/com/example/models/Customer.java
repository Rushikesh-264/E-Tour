package com.example.models;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customerid")
    private Long Customerid;

    @Column(name="email")
    private String email;

    @Column(nullable = false)
    private String firstName;

    private String middleName;
    
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    private String address;
    private String identificationProofType;
    private String identificationProofId;
    private String gender;

    private Long phoneNumber1;
    private Long phoneNumber2;

    // Default Constructor
    public Customer() {
    }

    // Getters and Setters
    public Long getId() {
        return Customerid;
    }

    public void setId(Long id) {
        this.Customerid = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentificationProofType() {
        return identificationProofType;
    }

    public void setIdentificationProofType(String identificationProofType) {
        this.identificationProofType = identificationProofType;
    }

    public String getIdentificationProofId() {
        return identificationProofId;
    }

    public void setIdentificationProofId(String identificationProofId) {
        this.identificationProofId = identificationProofId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(Long phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public Long getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(Long phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

	@Override
	public String toString() {
		return "Customer [email=" + email + ", password=" + password + "]";
	}
    
    
}