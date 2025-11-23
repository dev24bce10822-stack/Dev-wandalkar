package com.studygenius.studentmanagement.config;

import com.studygenius.studentmanagement.entity.Student;
import com.studygenius.studentmanagement.entity.Course;
import com.studygenius.studentmanagement.service.StudentService;
import com.studygenius.studentmanagement.service.CourseService;
import com.studygenius.studentmanagement.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Override
    public void run(String... args) throws Exception {
        // Create sample students
        Student student1 = new Student("John", "Doe", "john.doe@email.com", "1234567890");
        Student student2 = new Student("Jane", "Smith", "jane.smith@email.com", "0987654321");
        Student student3 = new Student("Bob", "Johnson", "bob.johnson@email.com", "1122334455");

        studentService.createStudent(student1);
        studentService.createStudent(student2);
        studentService.createStudent(student3);

        // Create sample courses
        Course course1 = new Course("CS101", "Introduction to Computer Science", "Basic computer science concepts", 3);
        Course course2 = new Course("MATH201", "Calculus I", "Differential and integral calculus", 4);
        Course course3 = new Course("ENG101", "English Composition", "Academic writing and composition", 3);

        courseService.createCourse(course1);
        courseService.createCourse(course2);
        courseService.createCourse(course3);

        // Create sample enrollments
        enrollmentService.createEnrollment(1L, 1L); // John in CS101
        enrollmentService.createEnrollment(1L, 2L); // John in MATH201
        enrollmentService.createEnrollment(2L, 1L); // Jane in CS101
        enrollmentService.createEnrollment(3L, 3L); // Bob in ENG101

        // Add grades
        enrollmentService.updateGrade(1L, "A");
        enrollmentService.updateGrade(2L, "B+");
        enrollmentService.updateGrade(3L, "A-");
        enrollmentService.updateGrade(4L, "B");

        System.out.println("Sample data loaded successfully!");
    }
}