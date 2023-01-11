package com.trustrace;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employeesCollection")
public class Employee {
    @Id
    private String employeeId;
    private String name;
    private String email;
    private String phoneNumber;
    public Employee(String employeeId, String name, String email, String phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
