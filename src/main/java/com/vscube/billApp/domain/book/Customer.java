package com.vscube.billApp.domain.book;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
    public static final String SEQUENCE_NAME = "customer";
    @Id
    private Long id;
    private String name;
    private String Address;
    private String AMCode;
    private String fax;
    private String contact;

    public String getAMCode() {
        return AMCode;
    }

    public void setAMCode(String AMCode) {
        this.AMCode = AMCode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    private String email;
    private String phone;
    private String idGST;

    public Customer() {
    }

    @Version
    private long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdGST() {
        return idGST;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Address='" + Address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", idGST='" + idGST + '\'' +
                ", version=" + version +
                '}';
    }

    public void setIdGST(String idGST) {
        this.idGST = idGST;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
