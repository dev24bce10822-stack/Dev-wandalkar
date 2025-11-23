package com.studygenius.studentmanagement.service;

import com.studygenius.studentmanagement.entity.Course;
import com.studygenius.studentmanagement.exception.ResourceNotFoundException;
import com.studygenius.studentmanagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
    }

    public Course createCourse(Course course) {
        if (courseRepository.existsByCourseCode(course.getCourseCode())) {
            throw new IllegalArgumentException("Course code already exists: " + course.getCourseCode());
        }
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = getCourseById(id);
        
        if (!course.getCourseCode().equals(courseDetails.getCourseCode()) && 
            courseRepository.findByCourseCodeAndIdNot(courseDetails.getCourseCode(), id).isPresent()) {
            throw new IllegalArgumentException("Course code already exists: " + courseDetails.getCourseCode());
        }
        
        course.setCourseCode(courseDetails.getCourseCode());
        course.setCourseName(courseDetails.getCourseName());
        course.setDescription(courseDetails.getDescription());
        course.setCredits(courseDetails.getCredits());
        
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }

    public List<Course> searchCoursesByName(String name) {
        return courseRepository.findByCourseNameContainingIgnoreCase(name);
    }

    public Optional<Course> getCourseByCode(String courseCode) {
        return courseRepository.findByCourseCode(courseCode);
    }
}