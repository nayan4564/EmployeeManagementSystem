package com.ems.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="attendance",uniqueConstraints=@UniqueConstraint(columnNames={"employee_id","attendance_date"}))
public class Attendance {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne @JoinColumn(name="employee_id",nullable=false) private Employee employee;
 @Column(name="attendance_date",nullable=false) private LocalDate attendanceDate;
 private String status;
 public Long getId(){return id;} public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
 public LocalDate getAttendanceDate(){return attendanceDate;} public void setAttendanceDate(LocalDate v){attendanceDate=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
}