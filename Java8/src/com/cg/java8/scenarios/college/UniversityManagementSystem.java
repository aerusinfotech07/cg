package com.cg.java8.scenarios.college;

import java.util.*;
import java.util.stream.Collectors;

class Fee {
    private double amount;
    private String dueDate;

    public Fee(double amount, String dueDate) {
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Fee: " + amount + " (Due: " + dueDate + ")";
    }
}

class Course {
    private String name;
    private int credits;
    private double fee;

    public Course(String name, int credits, double fee) {
        this.name = name;
        this.credits = credits;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public double getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return name + " (Credits: " + credits + ", Fee: " + fee + ")";
    }
}

class Student {
    private String name;
    private int grade;
    private List<Course> courses;
    private Fee fee;

    public Student(String name, int grade, List<Course> courses, Fee fee) {
        this.name = name;
        this.grade = grade;
        this.courses = courses;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Fee getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return name + " (Grade: " + grade + ", Fee: " + fee.getAmount() + ")";
    }
}

class College {
    private String name;
    private List<Student> students;

    public College(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return name + " (Students: " + students.size() + ")";
    }
}

class University {
    private String name;
    private List<College> colleges;

    public University(String name) {
        this.name = name;
        this.colleges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCollege(College college) {
        colleges.add(college);
    }

    public List<College> getColleges() {
        return colleges;
    }

    @Override
    public String toString() {
        return name + " (Colleges: " + colleges.size() + ")";
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating courses
        Course math = new Course("Math", 4, 500);
        Course science = new Course("Science", 3, 300);
        Course art = new Course("Art", 2, 200);
        Course history = new Course("History", 3, 400);

        // Creating fees
        Fee feeAlice = new Fee(1500, "2024-05-15");
        Fee feeBob = new Fee(1200, "2024-06-01");
        Fee feeCharlie = new Fee(1300, "2024-05-20");
        Fee feeDavid = new Fee(1100, "2024-04-30");
        Fee feeEve = new Fee(1600, "2024-05-10");

        // Creating students
        Student alice = new Student("Alice", 85, Arrays.asList(math, science), feeAlice);
        Student bob = new Student("Bob", 70, Arrays.asList(history, math), feeBob);
        Student charlie = new Student("Charlie", 90, Arrays.asList(math, art), feeCharlie);
        Student david = new Student("David", 60, Arrays.asList(science, history), feeDavid);
        Student eve = new Student("Eve", 75, Arrays.asList(art, math), feeEve);

        // Creating colleges
        College engineering = new College("Engineering");
        engineering.addStudent(alice);
        engineering.addStudent(bob);

        College arts = new College("Arts");
        arts.addStudent(charlie);
        arts.addStudent(david);
        arts.addStudent(eve);

        // Creating university
        University university = new University("Tech University");
        university.addCollege(engineering);
        university.addCollege(arts);

        // 1. Print all students in the university
        university.getColleges().forEach(college -> {
            System.out.println(college);
            college.getStudents().forEach(System.out::println);
        });

        // 2. Filter students with grades > 75
        List<Student> topStudents = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getGrade() > 75)
            .collect(Collectors.toList());
        System.out.println("Top Students: " + topStudents);

        // 3. Get the average grade of all students
        double averageGrade = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .mapToInt(Student::getGrade)
            .average()
            .orElse(0.0);
        System.out.println("Average Grade: " + averageGrade);

        // 4. Count the number of students in the university
        long studentCount = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .count();
        System.out.println("Total Students: " + studentCount);

        // 5. Get names of all students
        List<String> studentNames = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .map(Student::getName)
            .collect(Collectors.toList());
        System.out.println("Student Names: " + studentNames);

        // 6. Find the highest grade in the university
        Optional<Student> topStudent = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .max(Comparator.comparingInt(Student::getGrade));
        topStudent.ifPresent(s -> System.out.println("Top Student: " + s));

        // 7. Group students by college
        Map<String, List<Student>> studentsByCollege = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream()
                .map(student -> new AbstractMap.SimpleEntry<>(college.getName(), student)))
            .collect(Collectors.groupingBy(Map.Entry::getKey, 
                Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        System.out.println("Students by College: " + studentsByCollege);

        // 8. Find students enrolled in Math
        List<Student> mathStudents = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getCourses().stream().anyMatch(c -> c.getName().equals("Math")))
            .collect(Collectors.toList());
        System.out.println("Students in Math: " + mathStudents);

        // 9. Check if any student has a grade below 60
        boolean hasFailingStudents = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .anyMatch(s -> s.getGrade() < 60);
        System.out.println("Any Failing Students: " + hasFailingStudents);

        // 10. Sort students by name
        List<Student> sortedByName = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .sorted(Comparator.comparing(Student::getName))
            .collect(Collectors.toList());
        System.out.println("Students Sorted by Name: " + sortedByName);

        // 11. Join student names into a single string
        String joinedNames = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .map(Student::getName)
            .collect(Collectors.joining(", "));
        System.out.println("Joined Student Names: " + joinedNames);

        // 12. Calculate total fee for all students
        double totalFees = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .map(Student::getFee)
            .mapToDouble(Fee::getAmount)
            .sum();
        System.out.println("Total Fees Collected: " + totalFees);

        // 13. Find the student with the highest fee
        Optional<Student> highestFeeStudent = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .max(Comparator.comparing(s -> s.getFee().getAmount()));
        highestFeeStudent.ifPresent(s -> System.out.println("Student with Highest Fee: " + s));

        // 14. Find students who have not paid fees
        List<Student> unpaidFeeStudents = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getFee().getAmount() > 1000) // Example condition
            .collect(Collectors.toList());
        System.out.println("Students with Unpaid Fees: " + unpaidFeeStudents);

        // 15. Print courses for each student
        university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .forEach(s -> System.out.println(s.getName() + " is taking: " + s.getCourses()));

        // 16. Group students by their grades
        Map<Integer, List<Student>> studentsByGrade = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("Students Grouped by Grade: " + studentsByGrade);

        // 17. Find courses taken by students with grades above average
        List<Course> aboveAverageCourses = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getGrade() > averageGrade)
            .flatMap(s -> s.getCourses().stream())
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Courses Taken by Students Above Average: " + aboveAverageCourses);

        // 18. Find the average fee per student
        double averageFee = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .map(Student::getFee)
            .mapToDouble(Fee::getAmount)
            .average()
            .orElse(0.0);
        System.out.println("Average Fee per Student: " + averageFee);

        // 19. Print the total number of courses across all students
        long totalCoursesTaken = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .flatMap(s -> s.getCourses().stream())
            .count();
        System.out.println("Total Courses Taken by All Students: " + totalCoursesTaken);

        // 20. Find students with names containing 'a'
        List<Student> studentsWithA = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getName().toLowerCase().contains("a"))
            .collect(Collectors.toList());
        System.out.println("Students with 'a' in their name: " + studentsWithA);

        // 21. Get the first two students with the highest grades
        List<Student> topTwoStudents = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .sorted(Comparator.comparingInt(Student::getGrade).reversed())
            .limit(2)
            .collect(Collectors.toList());
        System.out.println("Top Two Students: " + topTwoStudents);

        // 22. Check if all students are paying their fees on time
        boolean allFeesPaidOnTime = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .allMatch(s -> !s.getFee().getDueDate().isEmpty()); // Example condition
        System.out.println("All Fees Paid On Time: " + allFeesPaidOnTime);

        // 23. Count the number of students in each college
        Map<String, Long> collegeStudentCount = university.getColleges().stream()
            .collect(Collectors.toMap(College::getName, college -> (long) college.getStudents().size()));
        System.out.println("Student Count by College: " + collegeStudentCount);

        // 24. List courses taken by students in the 'Engineering' college
        List<Course> engineeringCourses = university.getColleges().stream()
            .filter(college -> college.getName().equals("Engineering"))
            .flatMap(college -> college.getStudents().stream())
            .flatMap(s -> s.getCourses().stream())
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Courses Taken by Engineering Students: " + engineeringCourses);

        // 25. Find the student with the lowest fee
        Optional<Student> lowestFeeStudent = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .min(Comparator.comparing(s -> s.getFee().getAmount()));
        lowestFeeStudent.ifPresent(s -> System.out.println("Student with Lowest Fee: " + s));

        // 26. Find all courses offered in the university
        List<Course> allCourses = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .flatMap(s -> s.getCourses().stream())
            .distinct()
            .collect(Collectors.toList());
        System.out.println("All Courses Offered: " + allCourses);

        // 27. Get a summary of fees for each college
        Map<String, Double> collegeFeesSummary = university.getColleges().stream()
            .collect(Collectors.toMap(College::getName, college ->
                college.getStudents().stream()
                    .map(Student::getFee)
                    .mapToDouble(Fee::getAmount)
                    .sum()));
        System.out.println("College Fees Summary: " + collegeFeesSummary);

        // 28. Find students who are enrolled in more than one course
        List<Student> multiCourseStudents = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getCourses().size() > 1)
            .collect(Collectors.toList());
        System.out.println("Students Enrolled in More Than One Course: " + multiCourseStudents);

        // 29. Print the fees of each student
        university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .forEach(s -> System.out.println(s.getName() + " Fee: " + s.getFee()));

        // 30. Get the average credits per course
        double averageCredits = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .flatMap(s -> s.getCourses().stream())
            .mapToInt(Course::getCredits)
            .average()
            .orElse(0.0);
        System.out.println("Average Credits per Course: " + averageCredits);

        // 31. List students whose fees are greater than $1200
        List<Student> highFeeStudents = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getFee().getAmount() > 1200)
            .collect(Collectors.toList());
        System.out.println("Students with Fees Greater Than $1200: " + highFeeStudents);

        // 32. Count the number of students with grades in the A range (85-100)
        long aGradeCount = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getGrade() >= 85)
            .count();
        System.out.println("Number of Students with A Grade: " + aGradeCount);

        // 33. List the courses for students with grades below average
        List<Course> belowAverageCourses = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getGrade() < averageGrade)
            .flatMap(s -> s.getCourses().stream())
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Courses Taken by Students Below Average: " + belowAverageCourses);

        // 34. Find the total number of credits for all courses taken by students
        int totalCredits = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .flatMap(s -> s.getCourses().stream())
            .mapToInt(Course::getCredits)
            .sum();
        System.out.println("Total Credits for All Courses Taken: " + totalCredits);

        // 35. Print students enrolled in courses with fees over $300
        List<Student> highFeeCourseStudents = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getCourses().stream().anyMatch(c -> c.getFee() > 300))
            .collect(Collectors.toList());
        System.out.println("Students Enrolled in High Fee Courses: " + highFeeCourseStudents);

        // 36. Find the course with the highest fee
        Optional<Course> highestFeeCourse = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .flatMap(s -> s.getCourses().stream())
            .max(Comparator.comparingDouble(Course::getFee));
        highestFeeCourse.ifPresent(c -> System.out.println("Course with Highest Fee: " + c));

        // 37. List all unique student names
        List<String> uniqueStudentNames = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .map(Student::getName)
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Unique Student Names: " + uniqueStudentNames);

        // 38. Find the total fees due this month
        double totalFeesDueThisMonth = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getFee().getDueDate().startsWith("2024-05")) // Example condition
            .map(Student::getFee)
            .mapToDouble(Fee::getAmount)
            .sum();
        System.out.println("Total Fees Due This Month: " + totalFeesDueThisMonth);

        // 39. Print the name and grade of each student
        university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .forEach(s -> System.out.println(s.getName() + " has a grade of: " + s.getGrade()));

        // 40. Count the number of students in each grade bracket (60-69, 70-79, etc.)
        Map<String, Long> gradeBrackets = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .collect(Collectors.groupingBy(s -> {
                if (s.getGrade() < 60) return "F";
                else if (s.getGrade() < 70) return "60-69";
                else if (s.getGrade() < 80) return "70-79";
                else return "80-100";
            }, Collectors.counting()));
        System.out.println("Student Count by Grade Bracket: " + gradeBrackets);

        // 41. Print the names of students taking Art
        List<Student> artStudents = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getCourses().stream().anyMatch(c -> c.getName().equals("Art")))
            .collect(Collectors.toList());
        System.out.println("Students Taking Art: " + artStudents);

        // 42. List all fees sorted in ascending order
        List<Double> sortedFees = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .map(Student::getFee)
            .map(Fee::getAmount)
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Sorted Fees: " + sortedFees);

        // 43. Get the first student with a grade above 90
        Optional<Student> firstHighGradeStudent = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getGrade() > 90)
            .findFirst();
        firstHighGradeStudent.ifPresent(s -> System.out.println("First Student with Grade > 90: " + s));

        // 44. Count how many courses each student is taking
        Map<String, Long> courseCountByStudent = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .collect(Collectors.toMap(Student::getName, s -> (long) s.getCourses().size()));
        System.out.println("Course Count by Student: " + courseCountByStudent);

        // 45. List students who are enrolled in both Math and Science
        List<Student> mathAndScienceStudents = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getCourses().stream().anyMatch(c -> c.getName().equals("Math")) &&
                         s.getCourses().stream().anyMatch(c -> c.getName().equals("Science")))
            .collect(Collectors.toList());
        System.out.println("Students Enrolled in Math and Science: " + mathAndScienceStudents);

        // 46. Print students whose fee amount is less than $1200
        List<Student> lowFeeStudents = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getFee().getAmount() < 1200)
            .collect(Collectors.toList());
        System.out.println("Students with Fees Less Than $1200: " + lowFeeStudents);

        // 47. Calculate total credits for all students enrolled in Art
        int totalArtCredits = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getCourses().stream().anyMatch(c -> c.getName().equals("Art")))
            .flatMap(s -> s.getCourses().stream())
            .mapToInt(Course::getCredits)
            .sum();
        System.out.println("Total Credits for Students in Art: " + totalArtCredits);

        // 48. Find the average fee for students with grades above 75
        double averageHighFee = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .filter(s -> s.getGrade() > 75)
            .map(Student::getFee)
            .mapToDouble(Fee::getAmount)
            .average()
            .orElse(0.0);
        System.out.println("Average Fee for Students with Grades > 75: " + averageHighFee);

        // 49. List students sorted by their fees in descending order
        /*List<Student> sortedByFees = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .sorted(Comparator.comparing(s -> s.getFee().getAmount()).reversed())
            .collect(Collectors.toList());
        System.out.println("Students Sorted by Fees: " + sortedByFees);
		*/
        // 50. Get a list of unique courses across the university
        List<Course> uniqueCourses = university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .flatMap(s -> s.getCourses().stream())
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Unique Courses in the University: " + uniqueCourses);

        // 51. List students along with their respective fees
        university.getColleges().stream()
            .flatMap(college -> college.getStudents().stream())
            .forEach(s -> System.out.println(s.getName() + " - Fee: " + s.getFee().getAmount()));
    }
}

/*
 Explanation
This UniversityManagementSystem class incorporates the following features:

Entities: University, College, Student, Course, and Fee classes.
Java 8 Features:
Streams: For processing collections of students and courses.
Lambda Expressions: Used for filtering, mapping, and sorting operations.
Collectors: For grouping, counting, and joining data.
Optional: For safely handling the absence of values.
Scenarios Covered
Print all students.
Filter students with grades > 75.
Calculate the average grade.
Count total students.
Get names of all students.
Find the highest grade.
Group students by college.
Find students enrolled in Math.
Check for any failing students.
Sort students by name.
Join student names into a single string.
Calculate total fee.
Find the student with the highest fee.
Find students who have not paid fees.
Print courses for each student.
Group students by grade.
Find courses taken by students with grades above average.
Calculate average fee per student.
Count total courses taken.
Find students with names containing 'a'.
Get the first two students with the highest grades.
Check if all fees are paid on time.
Count students in each college.
List courses for students in a specific college.
Find the student with the lowest fee.
List all courses offered.
Summary of fees for each college.
Find students enrolled in more than one course.
Print each student's fees.
Calculate average credits per course.
List students whose fees are greater than $1200.
Count students in A grade range.
List courses for students with grades below average.
Find total credits for all courses taken.
Print students enrolled in courses with fees over $300.
Find the course with the highest fee.
List unique student names.
Calculate total fees due this month.
Print the name and grade of each student.
Count students in each grade bracket.
Print names of students taking Art.
List all fees sorted.
Get the first student with a grade above 90.
Count courses each student is taking.
List students enrolled in both Math and Science.
Print students whose fee amount is less than $1200.
Calculate total credits for students in Art.
Find average fee for students with grades above 75.
List students sorted by their fees in descending order.
Get unique courses across the university.
List students with their respective fees.

*/
