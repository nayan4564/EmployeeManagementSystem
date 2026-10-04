package com.ems.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="leave_requests")
public class LeaveRequest {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne @JoinColumn(name="employee_id",nullable=false) private Employee employee;
 private LocalDate fromDate; private LocalDate toDate; private String reason;
 private String status="PENDING";
 public Long getId(){return id;} public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
 public LocalDate getFromDate(){return fromDate;} public void setFromDate(LocalDate v){fromDate=v;}
 public LocalDate getToDate(){return toDate;} public void setToDate(LocalDate v){toDate=v;}
 public String getReason(){return reason;} public void setReason(String v){reason=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}