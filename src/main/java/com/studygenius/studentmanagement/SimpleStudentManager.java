package com.studygenius.studentmanagement;

import java.util.*;
import java.time.LocalDateTime;

public class SimpleStudentManager {
    private static List<Student> students = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();
    private static List<Enrollment> enrollments = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("🚀 Student Management System Started!");
        System.out.println("=====================================\n");
        
        // Initialize sample data
        initializeSampleData();
        
        // Display all data
        displayAllStudents();
        displayAllCourses();
        displayAllEnrollments();
        
        // Test search functionality
        searchStudentByName("John");
        searchCourseByName("Computer");
        
        System.out.println("\n✅ Application completed successfully!");
    }
    
    private static void initializeSampleData() {
        // Create students
        students.add(new Student("John", "Doe", "john.doe@email.com", "1234567890"));
        students.add(new Student("Jane", "Smith", "jane.smith@email.com", "0987654321"));
        students.add(new Student("Bob", "Johnson", "bob.johnson@email.com", "1122334455"));
        
        // Create courses
        courses.add(new Course("CS101", "Introduction to Computer Science", 3));
        courses.add(new Course("MATH201", "Calculus I", 4));
        courses.add(new Course("ENG101", "English Composition", 3));
        
        // Create enrollments
        enrollments.add(new Enrollment(students.get(0), courses.get(0), "A"));
        enrollments.add(new Enrollment(students.get(0), courses.get(1), "B+"));
        enrollments.add(new Enrollment(students.get(1), courses.get(0), "A-"));
        enrollments.add(new Enrollment(students.get(2), courses.get(2), "B"));
        
        System.out.println("✅ Sample data initialized successfully!");
    }
    
    private static void displayAllStudents() {
        System.out.println("\n📋 ALL STUDENTS:");
        System.out.println("=================");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    private static void displayAllCourses() {
        System.out.println("\n📚 ALL COURSES:");
        System.out.println("================");
        for (Course course : courses) {
            System.out.println(course);
        }
    }
    
    private static void displayAllEnrollments() {
        System.out.println("\n🎓 ALL ENROLLMENTS:");
        System.out.println("====================");
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }
    
    private static void searchStudentByName(String name) {
        System.out.println("\n🔍 SEARCH STUDENTS BY NAME: '" + name + "'");
        System.out.println("=================================");
        for (Student student : students) {
            if (student.getFullName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Found: " + student);
            }
        }
    }
    
    private static void searchCourseByName(String name) {
        System.out.println("\n🔍 SEARCH COURSES BY NAME: '" + name + "'");
        System.out.println("=================================");
        for (Course course : courses) {
            if (course.getCourseName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Found: " + course);
            }
        }
    }
    
    // Student class
    static class Student {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private LocalDateTime enrollmentDate;
        
        public Student(String firstName, String lastName, String email, String phone) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.enrollmentDate = LocalDateTime.now();
        }
        
        public String getFullName() {
            return firstName + " " + lastName;
        }
        
        @Override
        public String toString() {
            return "👤 Student: " + getFullName() + " | Email: " + email + " | Phone: " + phone + " | Enrolled: " + enrollmentDate.toLocalDate();
        }
    }
    
    // Course class
    static class Course {
        private String courseCode;
        private String courseName;
        private int credits;
        
        public Course(String courseCode, String courseName, int credits) {
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.credits = credits;
        }
        
        public String getCourseName() {
            return courseName;
        }
        
        @Override
        public String toString() {
            return "📘 Course: " + courseCode + " - " + courseName + " (" + credits + " credits)";
        }
    }
    
    // Enrollment class
    static class Enrollment {
        private Student student;
        private Course course;
        private String grade;
        private LocalDateTime enrollmentDate;
        
        public Enrollment(Student student, Course course, String grade) {
            this.student = student;
            this.course = course;
            this.grade = grade;
            this.enrollmentDate = LocalDateTime.now();
        }
        
        @Override
        public String toString() {
            return "🎓 Enrollment: " + student.getFullName() + " in " + course.courseCode + " | Grade: " + grade + " | Date: " + enrollmentDate.toLocalDate();
        }
    }
}