package com.student_crud_api.model;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Component
@Entity
public class Student {
    @Id @GeneratedValue
    private int id;
    @NonNull
    @Column(unique = true)
    private String RollNo;
    @NonNull
    private String Name;
    @NonNull
    private String Address;
    @NonNull
    private String mobileNumber;
    @NonNull
    private String BatchNumber;

    @NonNull
    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(@NonNull String rollNo) {
        RollNo = rollNo;
    }

    @NonNull
    public String getName() {
        return Name;
    }

    public void setName(@NonNull String name) {
        Name = name;
    }

    @NonNull
    public String getAddress() {
        return Address;
    }

    public void setAddress(@NonNull String address) {
        Address = address;
    }

    @NonNull
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@NonNull String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @NonNull
    public String getBatchNumber() {
        return BatchNumber;
    }

    public void setBatchNumber(@NonNull String batchNumber) {
        BatchNumber = batchNumber;
    }
}
