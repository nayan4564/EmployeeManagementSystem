package com.ems.repository;
import com.ems.model.Attendance; import org.springframework.data.jpa.repository.JpaRepository;
public interface AttendanceRepository extends JpaRepository<Attendance,Long>{}