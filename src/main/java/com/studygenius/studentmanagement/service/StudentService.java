package com.studygenius.studentmanagement.service;

import com.studygenius.studentmanagement.entity.Student;
import com.studygenius.studentmanagement.exception.ResourceNotFoundException;
import com.studygenius.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    public Student createStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new IllegalArgumentException("Email already exists: " + student.getEmail());
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        
        // Check if email is being changed and if it already exists
        if (!student.getEmail().equals(studentDetails.getEmail()) && 
            studentRepository.findByEmailAndIdNot(studentDetails.getEmail(), id).isPresent()) {
            throw new IllegalArgumentException("Email already exists: " + studentDetails.getEmail());
        }
        
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setPhone(studentDetails.getPhone());
        
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }

    public List<Student> searchStudentsByName(String name) {
        List<Student> byFirstName = studentRepository.findByFirstNameContainingIgnoreCase(name);
        List<Student> byLastName = studentRepository.findByLastNameContainingIgnoreCase(name);
        
        // Combine and remove duplicates
        byFirstName.addAll(byLastName);
        return byFirstName.stream().distinct().toList();
    }

    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}