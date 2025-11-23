# **UML Diagrams**



Use Case Diagram



┌─────────────────┐

│ Administrator │

└─────────────────┘

|

| Manages

|

┌─────────────────────────────────────┐

│ Student Management System │

└─────────────────────────────────────┘

|

┌────┴────┐

| |

┌─────────┐ ┌─────────┐

│ Student │ │ Course │

│ Management││ Management│

└─────────┘ └─────────┘

| |

| |

┌─────────┐ ┌─────────┐

│Enrollment││ Reporting│

│ Management││ \& Analytics│

└─────────┘ └─────────┘





Class Diagram



StudentManagementSystem

├── - students: List<Student>

├── - courses: List<Course>

├── - enrollments: List<Enrollment>

├── + initializeSampleData()

├── + searchStudentsByName()

├── + searchCoursesByName()

├── + enrollStudent()

├── + updateGrade()

└── + getStudentWithMostCourses()



Student

├── - id: Long

├── - firstName: String

├── - lastName: String

├── - email: String

├── - phone: String

├── - enrollmentDate: LocalDateTime

├── + getFullName()

└── + toString()



Course

├── - id: Long

├── - courseCode: String

├── - courseName: String

├── - description: String

├── - credits: int

└── + toString()



Enrollment

├── - id: Long

├── - student: Student

├── - course: Course

├── - grade: String

├── - enrollmentDate: LocalDateTime

├── + setGrade()

└── + toString()





Sequence Diagram - Student Enrollment



Administrator StudentManagementSystem Student Course Enrollment

| | | | |

| enrollStudent() | | | |

|----------------->| | | |

| | findStudentById()| | |

| |----------------->| | |

| | Student Object | | |

| |<-----------------| | |

| | findCourseById() | | |

| |-------------------------------->| |

| | Course Object | | |

| |<--------------------------------| |

| | createEnrollment()| | |

| |---------------------------------------------->|

| | | | |

| Success | | | |

|<-----------------| | | |





