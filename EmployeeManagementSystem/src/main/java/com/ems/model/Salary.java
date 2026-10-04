package com.ems.model;
import jakarta.persistence.*; import java.time.YearMonth;
@Entity @Table(name="salary")
public class Salary {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne @JoinColumn(name="employee_id",nullable=false) private Employee employee;
 private Integer payMonth; private Integer payYear; private Double basic; private Double allowance; private Double deduction;
 public Long getId(){return id;} public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
 public Integer getPayMonth(){return payMonth;} public void setPayMonth(Integer v){payMonth=v;}
 public Integer getPayYear(){return payYear;} public void setPayYear(Integer v){payYear=v;}
 public Double getBasic(){return basic;} public void setBasic(Double v){basic=v;}
 public Double getAllowance(){return allowance;} public void setAllowance(Double v){allowance=v;}
 public Double getDeduction(){return deduction;} public void setDeduction(Double v){deduction=v;}
 public Double getNetSalary(){return (basic==null?0:basic)+(allowance==null?0:allowance)-(deduction==null?0:deduction);}
}