package com.ems.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
import java.time.LocalDate;
@Entity @Table(name="employees")
public class Employee {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String firstName; @NotBlank private String lastName;
 @Email @NotBlank @Column(unique=true) private String email;
 private String phone; private String designation; private LocalDate joiningDate;
 private Double salary; private String status="ACTIVE";
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="department_id") private Department department;
 public Long getId(){return id;} public String getFirstName(){return firstName;} public void setFirstName(String v){firstName=v;}
 public String getLastName(){return lastName;} public void setLastName(String v){lastName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getDesignation(){return designation;} public void setDesignation(String v){designation=v;}
 public LocalDate getJoiningDate(){return joiningDate;} public void setJoiningDate(LocalDate v){joiningDate=v;}
 public Double getSalary(){return salary;} public void setSalary(Double v){salary=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public Department getDepartment(){return department;} public void setDepartment(Department v){department=v;}
 public String getFullName(){return firstName+" "+lastName;}
}