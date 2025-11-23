package com.studygenius.studentmanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple test for Student Management System
 */
public class SystemTest {

    @Test
    public void testSystemCreation() {
        StudentManagementSystem system = new StudentManagementSystem();
        assertNotNull(system);
    }
    
    @Test
    public void testDataInitialization() {
        StudentManagementSystem system = new StudentManagementSystem();
        system.initializeSampleData();
        
        // Test that data was initialized
        var students = system.searchStudentsByName("John");
        var courses = system.searchCoursesByName("Computer");
        
        assertTrue(students.size() > 0, "Should find students named John");
        assertTrue(courses.size() > 0, "Should find computer courses");
    }
    
    @Test
    public void testStudentOperations() {
        StudentManagementSystem system = new StudentManagementSystem();
        system.initializeSampleData();
        
        // Test student search
        var johnStudents = system.searchStudentsByName("John");
        assertTrue(johnStudents.size() >= 1);
        
        // Test email search
        var emailResults = system.searchStudentsByEmail("university");
        assertTrue(emailResults.size() >= 4);
    }
    
    @Test
    public void testCourseOperations() {
        StudentManagementSystem system = new StudentManagementSystem();
        system.initializeSampleData();
        
        // Test course search
        var computerCourses = system.searchCoursesByName("Computer");
        assertTrue(computerCourses.size() >= 1);
        
        // Test enrollments
        var cs101Enrollments = system.getCourseEnrollments("CS101");
        assertTrue(cs101Enrollments.size() >= 2);
    }
    
    @Test
    public void testEnrollmentOperations() {
        StudentManagementSystem system = new StudentManagementSystem();
        system.initializeSampleData();
        
        // Test student enrollments
        var johnEnrollments = system.getStudentEnrollments(1L);
        assertTrue(johnEnrollments.size() >= 2);
        
        // Test reports
        var topStudent = system.getStudentWithMostCourses();
        var popularCourse = system.getCourseWithMostStudents();
        
        assertNotNull(topStudent);
        assertNotNull(popularCourse);
    }
}