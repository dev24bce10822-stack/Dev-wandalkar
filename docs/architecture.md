# **System Architecture**



High-Level Architecture



┌─────────────────┐ ┌──────────────────┐ ┌──────────────────┐

│ Presentation │ │ Business │ │ Data Storage │

│ Layer │ │ Logic Layer │ │ Layer │

│ │ │ │ │ │

│ • Console UI │◄──►│ • StudentMgmt │◄──►│ • In-Memory │

│ • User Input │ │ System │ │ Collections │

│ • Output Display│ │ • Business Rules │ │ • ArrayLists │

│ │ │ • Validation │ │ • Data Entities │

└─────────────────┘ └──────────────────┘ └──────────────────┘





Component Description



Presentation Layer

\- Console Interface: Handles user interaction through command line

\- Input Processing: Captures and validates user inputs

\- Output Display: Formats and presents data to users



Business Logic Layer  

\- Student Management System: Main controller coordinating all operations

\- Business Rules: Enrollment validation, grade management, search logic

\- Data Validation: Input sanitization and business rule enforcement



Data Storage Layer

\- In-Memory Collections: ArrayList-based storage for students, courses, enrollments

\- Entity Management: Student, Course, Enrollment entity classes

\- Data Relationships: Maintains relationships between entities



Data Flow

1\. User input → Presentation Layer

2\. Validation → Business Logic Layer  

3\. Processing → Business Logic Layer

4\. Data operations → Data Storage Layer

5\. Results → Presentation Layer → User

