package com.studygenius.studentmanagement.repository;

import com.studygenius.studentmanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCourseCode(String courseCode);
    List<Course> findByCourseNameContainingIgnoreCase(String courseName);
    
    @Query("SELECT c FROM Course c WHERE c.courseCode = :courseCode AND c.id != :id")
    Optional<Course> findByCourseCodeAndIdNot(@Param("courseCode") String courseCode, @Param("id") Long id);
    
    boolean existsByCourseCode(String courseCode);
}