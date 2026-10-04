package com.ems.controller;
import com.ems.model.*; import com.ems.repository.*;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
@Controller
public class WebController {
 private final EmployeeRepository employees; private final DepartmentRepository departments;
 private final AttendanceRepository attendance; private final LeaveRequestRepository leaves; private final SalaryRepository salaries;
 public WebController(EmployeeRepository e,DepartmentRepository d,AttendanceRepository a,LeaveRequestRepository l,SalaryRepository s){employees=e;departments=d;attendance=a;leaves=l;salaries=s;}
 @GetMapping("/login") public String login(){return "login";}
 @GetMapping("/") public String dashboard(Model m){m.addAttribute("employeeCount",employees.count());m.addAttribute("activeCount",employees.countByStatus("ACTIVE"));m.addAttribute("departmentCount",departments.count());m.addAttribute("leaveCount",leaves.count());return "dashboard";}
 @GetMapping("/employees") public String employees(Model m){m.addAttribute("employees",employees.findAll());return "employees";}
 @GetMapping("/employees/new") public String newEmployee(Model m){m.addAttribute("employee",new Employee());m.addAttribute("departments",departments.findAll());return "employee-form";}
 @PostMapping("/employees/save") public String saveEmployee(@ModelAttribute Employee e,@RequestParam(required=false) Long departmentId){
  if(departmentId!=null)e.setDepartment(departments.findById(departmentId).orElse(null));employees.save(e);return "redirect:/employees";}
 @GetMapping("/employees/edit/{id}") public String editEmployee(@PathVariable Long id,Model m){m.addAttribute("employee",employees.findById(id).orElseThrow());m.addAttribute("departments",departments.findAll());return "employee-form";}
 @GetMapping("/employees/delete/{id}") public String deleteEmployee(@PathVariable Long id){employees.deleteById(id);return "redirect:/employees";}
 @GetMapping("/departments") public String departments(Model m){m.addAttribute("departments",departments.findAll());m.addAttribute("department",new Department());return "departments";}
 @PostMapping("/departments/save") public String saveDepartment(@ModelAttribute Department d){departments.save(d);return "redirect:/departments";}
 @GetMapping("/departments/delete/{id}") public String deleteDepartment(@PathVariable Long id){departments.deleteById(id);return "redirect:/departments";}
 @GetMapping("/attendance") public String attendance(Model m){m.addAttribute("records",attendance.findAll());m.addAttribute("employees",employees.findAll());m.addAttribute("record",new Attendance());return "attendance";}
 @PostMapping("/attendance/save") public String saveAttendance(@ModelAttribute Attendance a,@RequestParam Long employeeId){a.setEmployee(employees.findById(employeeId).orElseThrow());if(a.getAttendanceDate()==null)a.setAttendanceDate(LocalDate.now());attendance.save(a);return "redirect:/attendance";}
 @GetMapping("/leaves") public String leaves(Model m){m.addAttribute("leaves",leaves.findAll());m.addAttribute("employees",employees.findAll());m.addAttribute("leave",new LeaveRequest());return "leaves";}
 @PostMapping("/leaves/save") public String saveLeave(@ModelAttribute LeaveRequest l,@RequestParam Long employeeId){l.setEmployee(employees.findById(employeeId).orElseThrow());leaves.save(l);return "redirect:/leaves";}
 @GetMapping("/leaves/status/{id}/{status}") public String leaveStatus(@PathVariable Long id,@PathVariable String status){var l=leaves.findById(id).orElseThrow();if(status.equals("APPROVED")||status.equals("REJECTED"))l.setStatus(status);leaves.save(l);return "redirect:/leaves";}
 @GetMapping("/salary") public String salary(Model m){m.addAttribute("salaries",salaries.findAll());m.addAttribute("employees",employees.findAll());m.addAttribute("salary",new Salary());return "salary";}
 @PostMapping("/salary/save") public String saveSalary(@ModelAttribute Salary s,@RequestParam Long employeeId){s.setEmployee(employees.findById(employeeId).orElseThrow());salaries.save(s);return "redirect:/salary";}
}