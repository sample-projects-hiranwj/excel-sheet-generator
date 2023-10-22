package com.hiranwj.excel_export.repository;

import com.hiranwj.excel_export.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CourseRepository extends JpaRepository<Course, Serializable> {
}
