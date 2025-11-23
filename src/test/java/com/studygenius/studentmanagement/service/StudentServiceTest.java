package com.studygenius.studentmanagement.service;

import com.studygenius.studentmanagement.entity.Student;
import com.studygenius.studentmanagement.exception.ResourceNotFoundException;
import com.studygenius.studentmanagement.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setId(1L);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@email.com");
        student.setPhone("1234567890");
    }

    @Test
    void testGetAllStudents() {
        // Given
        Student student2 = new Student();
        student2.setId(2L);
        student2.setFirstName("Jane");
        student2.setLastName("Smith");
        
        List<Student> students = Arrays.asList(student, student2);
        when(studentRepository.findAll()).thenReturn(students);

        // When
        List<Student> result = studentService.getAllStudents();

        // Then
        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testGetStudentById_Success() {
        // Given
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        // When
        Student result = studentService.getStudentById(1L);

        // Then
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void testGetStudentById_NotFound() {
        // Given
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(ResourceNotFoundException.class, () -> {
            studentService.getStudentById(1L);
        });
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateStudent_Success() {
        // Given
        when(studentRepository.existsByEmail(student.getEmail())).thenReturn(false);
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        // When
        Student result = studentService.createStudent(student);

        // Then
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        verify(studentRepository, times(1)).save(student);
    }
}