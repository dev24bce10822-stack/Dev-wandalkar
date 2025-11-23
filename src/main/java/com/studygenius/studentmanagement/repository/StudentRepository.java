package com.studygenius.studentmanagement.repository;

import com.studygenius.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    List<Student> findByFirstNameContainingIgnoreCase(String firstName);
    List<Student> findByLastNameContainingIgnoreCase(String lastName);
    
    @Query("SELECT s FROM Student s WHERE s.email = :email AND s.id != :id")
    Optional<Student> findByEmailAndIdNot(@Param("email") String email, @Param("id") Long id);
    
    boolean existsByEmail(String email);
}