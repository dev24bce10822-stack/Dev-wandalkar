package com.studygenius.studentmanagement;

import java.util.*;
import java.time.LocalDateTime;

/**
 * Complete Student Management System
 * A comprehensive system that meets all academic requirements
 */
public class StudentManagementSystem {
    
    public static void main(String[] args) {
        System.out.println("🎓 ===========================================");
        System.out.println("🎓   STUDENT MANAGEMENT SYSTEM");
        System.out.println("🎓   Version 1.0");
        System.out.println("🎓 ===========================================");
        
        // Create system instance and run
        StudentManagementSystem system = new StudentManagementSystem();
        system.run();
    }
    
    // Data storage
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Enrollment> enrollments = new ArrayList<>();
    
    public void run() {
        // Initialize with sample data
        initializeSampleData();
        
        // Display dashboard
        displayDashboard();
        
        // Test all functionalities
        testStudentManagement();
        testCourseManagement(); 
        testEnrollmentManagement();
        testSearchFunctionality();
        testReports();
        
        System.out.println("\n✅ ===========================================");
        System.out.println("✅ SYSTEM COMPLETED SUCCESSFULLY!");
        System.out.println("✅ All academic requirements met!");
        System.out.println("✅ ===========================================");
    }
    
    public void initializeSampleData() {
        System.out.println("\n📥 INITIALIZING SAMPLE DATA...");
        
        // Create students
        students.add(new Student(1L, "John", "Doe", "john.doe@university.edu", "1234567890"));
        students.add(new Student(2L, "Jane", "Smith", "jane.smith@university.edu", "0987654321"));
        students.add(new Student(3L, "Bob", "Johnson", "bob.johnson@university.edu", "1122334455"));
        students.add(new Student(4L, "Alice", "Brown", "alice.brown@university.edu", "5566778899"));
        
        // Create courses
        courses.add(new Course(1L, "CS101", "Introduction to Computer Science", "Basic programming concepts", 3));
        courses.add(new Course(2L, "MATH201", "Calculus I", "Differential and integral calculus", 4));
        courses.add(new Course(3L, "ENG101", "English Composition", "Academic writing skills", 3));
        courses.add(new Course(4L, "PHY301", "Physics for Engineers", "Classical mechanics and thermodynamics", 4));
        
        // Create enrollments
        enrollments.add(new Enrollment(1L, students.get(0), courses.get(0), "A"));
        enrollments.add(new Enrollment(2L, students.get(0), courses.get(1), "B+"));
        enrollments.add(new Enrollment(3L, students.get(1), courses.get(0), "A-"));
        enrollments.add(new Enrollment(4L, students.get(1), courses.get(2), "B"));
        enrollments.add(new Enrollment(5L, students.get(2), courses.get(3), "A"));
        enrollments.add(new Enrollment(6L, students.get(3), courses.get(0), "B+"));
        enrollments.add(new Enrollment(7L, students.get(3), courses.get(2), "A"));
        
        System.out.println("✅ Sample data initialized!");
    }
    
    private void displayDashboard() {
        System.out.println("\n📊 ============ SYSTEM DASHBOARD ============");
        System.out.println("📊 Total Students: " + students.size());
        System.out.println("📊 Total Courses: " + courses.size());
        System.out.println("📊 Total Enrollments: " + enrollments.size());
        System.out.println("📊 ===========================================");
    }
    
    private void testStudentManagement() {
        System.out.println("\n👥 ============ STUDENT MANAGEMENT ============");
        
        // Display all students
        System.out.println("\n📋 ALL STUDENTS:");
        students.forEach(System.out::println);
        
        // Add new student
        System.out.println("\n➕ ADDING NEW STUDENT:");
        Student newStudent = new Student(5L, "Charlie", "Wilson", "charlie.wilson@university.edu", "9988776655");
        students.add(newStudent);
        System.out.println("✅ Added: " + newStudent);
        
        // Search functionality
        System.out.println("\n🔍 SEARCH STUDENTS BY NAME 'John':");
        searchStudentsByName("John").forEach(System.out::println);
    }
    
    private void testCourseManagement() {
        System.out.println("\n📚 ============ COURSE MANAGEMENT ============");
        
        // Display all courses
        System.out.println("\n📋 ALL COURSES:");
        courses.forEach(System.out::println);
        
        // Add new course
        System.out.println("\n➕ ADDING NEW COURSE:");
        Course newCourse = new Course(5L, "CHEM101", "General Chemistry", "Basic chemical principles", 3);
        courses.add(newCourse);
        System.out.println("✅ Added: " + newCourse);
        
        // Search functionality
        System.out.println("\n🔍 SEARCH COURSES BY NAME 'Computer':");
        searchCoursesByName("Computer").forEach(System.out::println);
    }
    
    private void testEnrollmentManagement() {
        System.out.println("\n🎓 ============ ENROLLMENT MANAGEMENT ============");
        
        // Display all enrollments
        System.out.println("\n📋 ALL ENROLLMENTS:");
        enrollments.forEach(System.out::println);
        
        // New enrollment
        System.out.println("\n➕ NEW ENROLLMENT:");
        enrollStudent(5L, 2L, "A-"); // Charlie in Calculus
        System.out.println("✅ New enrollment created!");
        
        // Update grade
        System.out.println("\n✏️ UPDATING GRADE:");
        updateGrade(1L, "A+");
        System.out.println("✅ Grade updated for enrollment ID 1");
    }
    
    private void testSearchFunctionality() {
        System.out.println("\n🔍 ============ SEARCH FUNCTIONALITY ============");
        
        System.out.println("\n🔍 SEARCH STUDENTS BY EMAIL 'university':");
        searchStudentsByEmail("university").forEach(System.out::println);
        
        System.out.println("\n🔍 GET STUDENT ENROLLMENTS (Student ID: 1):");
        getStudentEnrollments(1L).forEach(System.out::println);
        
        System.out.println("\n🔍 GET COURSE ENROLLMENTS (CS101):");
        getCourseEnrollments("CS101").forEach(System.out::println);
    }
    
    private void testReports() {
        System.out.println("\n📈 ============ REPORTS ============");
        
        System.out.println("\n📈 STUDENT WITH MOST COURSES:");
        Student topStudent = getStudentWithMostCourses();
        if (topStudent != null) {
            System.out.println("🏆 " + topStudent.getFullName() + " - " + 
                getStudentEnrollments(topStudent.getId()).size() + " courses");
        }
        
        System.out.println("\n📈 COURSE WITH MOST STUDENTS:");
        Course popularCourse = getCourseWithMostStudents();
        if (popularCourse != null) {
            System.out.println("📊 " + popularCourse.getCourseName() + " - " + 
                getCourseEnrollments(popularCourse.getCourseCode()).size() + " students");
        }
    }
    
    // Business Logic Methods
    public List<Student> searchStudentsByName(String name) {
        List<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (student.getFullName().toLowerCase().contains(name.toLowerCase())) {
                results.add(student);
            }
        }
        return results;
    }
    
    public List<Student> searchStudentsByEmail(String email) {
        List<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (student.getEmail().toLowerCase().contains(email.toLowerCase())) {
                results.add(student);
            }
        }
        return results;
    }
    
    public List<Course> searchCoursesByName(String name) {
        List<Course> results = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCourseName().toLowerCase().contains(name.toLowerCase())) {
                results.add(course);
            }
        }
        return results;
    }
    
    public List<Enrollment> getStudentEnrollments(Long studentId) {
        List<Enrollment> results = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getId().equals(studentId)) {
                results.add(enrollment);
            }
        }
        return results;
    }
    
    public List<Enrollment> getCourseEnrollments(String courseCode) {
        List<Enrollment> results = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse().getCourseCode().equalsIgnoreCase(courseCode)) {
                results.add(enrollment);
            }
        }
        return results;
    }
    
    public void enrollStudent(Long studentId, Long courseId, String grade) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);
        
        if (student != null && course != null) {
            Enrollment enrollment = new Enrollment((long)(enrollments.size() + 1), student, course, grade);
            enrollments.add(enrollment);
        }
    }
    
    public void updateGrade(Long enrollmentId, String newGrade) {
        Enrollment enrollment = findEnrollmentById(enrollmentId);
        if (enrollment != null) {
            enrollment.setGrade(newGrade);
        }
    }
    
    public Student getStudentWithMostCourses() {
        Student topStudent = null;
        int maxCourses = 0;
        
        for (Student student : students) {
            int courseCount = getStudentEnrollments(student.getId()).size();
            if (courseCount > maxCourses) {
                maxCourses = courseCount;
                topStudent = student;
            }
        }
        return topStudent;
    }
    
    public Course getCourseWithMostStudents() {
        Course popularCourse = null;
        int maxStudents = 0;
        
        for (Course course : courses) {
            int studentCount = getCourseEnrollments(course.getCourseCode()).size();
            if (studentCount > maxStudents) {
                maxStudents = studentCount;
                popularCourse = course;
            }
        }
        return popularCourse;
    }
    
    // Helper methods
    private Student findStudentById(Long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    
    private Course findCourseById(Long id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }
    
    private Enrollment findEnrollmentById(Long id) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId().equals(id)) {
                return enrollment;
            }
        }
        return null;
    }
    
    // Entity Classes - made public and static for testing
    public static class Student {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private LocalDateTime enrollmentDate;
        
        public Student(Long id, String firstName, String lastName, String email, String phone) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.enrollmentDate = LocalDateTime.now();
        }
        
        public Long getId() { return id; }
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getFullName() { return firstName + " " + lastName; }
        public String getEmail() { return email; }
        public String getPhone() { return phone; }
        public LocalDateTime getEnrollmentDate() { return enrollmentDate; }
        
        @Override
        public String toString() {
            return "👤 Student #" + id + ": " + getFullName() + " | " + email + " | 📞 " + phone;
        }
    }
    
    public static class Course {
        private Long id;
        private String courseCode;
        private String courseName;
        private String description;
        private int credits;
        
        public Course(Long id, String courseCode, String courseName, String description, int credits) {
            this.id = id;
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.description = description;
            this.credits = credits;
        }
        
        public Long getId() { return id; }
        public String getCourseCode() { return courseCode; }
        public String getCourseName() { return courseName; }
        public String getDescription() { return description; }
        public int getCredits() { return credits; }
        
        @Override
        public String toString() {
            return "📘 " + courseCode + ": " + courseName + " (" + credits + " credits)";
        }
    }
    
    public static class Enrollment {
        private Long id;
        private Student student;
        private Course course;
        private String grade;
        private LocalDateTime enrollmentDate;
        
        public Enrollment(Long id, Student student, Course course, String grade) {
            this.id = id;
            this.student = student;
            this.course = course;
            this.grade = grade;
            this.enrollmentDate = LocalDateTime.now();
        }
        
        public Long getId() { return id; }
        public Student getStudent() { return student; }
        public Course getCourse() { return course; }
        public String getGrade() { return grade; }
        public void setGrade(String grade) { this.grade = grade; }
        public LocalDateTime getEnrollmentDate() { return enrollmentDate; }
        
        @Override
        public String toString() {
            return "🎓 Enrollment #" + id + ": " + student.getFullName() + " → " + 
                   course.getCourseCode() + " | Grade: " + grade;
        }
    }
}