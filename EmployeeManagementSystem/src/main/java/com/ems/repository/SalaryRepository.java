package com.ems.repository;
import com.ems.model.Salary; import org.springframework.data.jpa.repository.JpaRepository;
public interface SalaryRepository extends JpaRepository<Salary,Long>{}