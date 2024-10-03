package com.cg.java8.scenarios.courses;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int grade;
    private List<String> courses;

    public Student(String name, int grade, List<String> courses) {
        this.name = name;
        this.grade = grade;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return name + " (Grade: " + grade + ")";
    }
}

class Course {
    private String name;
    private int credits;

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return name + " (Credits: " + credits + ")";
    }
}

public class CoursesManagementSystem {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85, Arrays.asList("Math", "Science")),
            new Student("Bob", 70, Arrays.asList("History", "Math")),
            new Student("Charlie", 90, Arrays.asList("Math", "Art")),
            new Student("David", 60, Arrays.asList("Science", "History")),
            new Student("Eve", 75, Arrays.asList("Art", "Math"))
        );

        List<Course> courses = Arrays.asList(
            new Course("Math", 4),
            new Course("Science", 3),
            new Course("Art", 2),
            new Course("History", 3)
        );

        // 1. Print all students
        students.forEach(System.out::println);

        // 2. Filter students with grades > 75
        List<Student> topStudents = students.stream()
            .filter(s -> s.getGrade() > 75)
            .collect(Collectors.toList());
        System.out.println("Top Students: " + topStudents);

        // 3. Get the average grade
        double averageGrade = students.stream()
            .mapToInt(Student::getGrade)
            .average()
            .orElse(0.0);
        System.out.println("Average Grade: " + averageGrade);

        // 4. Count the number of students
        long studentCount = students.stream().count();
        System.out.println("Total Students: " + studentCount);

        // 5. Get names of all students
        List<String> studentNames = students.stream()
            .map(Student::getName)
            .collect(Collectors.toList());
        System.out.println("Student Names: " + studentNames);

        // 6. Find the highest grade
        Optional<Student> topStudent = students.stream()
            .max(Comparator.comparingInt(Student::getGrade));
        topStudent.ifPresent(s -> System.out.println("Top Student: " + s));

        // 7. Group students by grade
        Map<Integer, List<Student>> studentsByGrade = students.stream()
            .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("Students by Grade: " + studentsByGrade);

        // 8. Find students enrolled in Math
        List<Student> mathStudents = students.stream()
            .filter(s -> s.getCourses().contains("Math"))
            .collect(Collectors.toList());
        System.out.println("Students in Math: " + mathStudents);

        // 9. Check if any student has a grade below 60
        boolean hasFailingStudents = students.stream()
            .anyMatch(s -> s.getGrade() < 60);
        System.out.println("Any Failing Students: " + hasFailingStudents);

        // 10. Sort students by name
        List<Student> sortedByName = students.stream()
            .sorted(Comparator.comparing(Student::getName))
            .collect(Collectors.toList());
        System.out.println("Students Sorted by Name: " + sortedByName);

        // 11. Join student names into a single string
        String joinedNames = students.stream()
            .map(Student::getName)
            .collect(Collectors.joining(", "));
        System.out.println("Joined Student Names: " + joinedNames);

        // 12. Filter courses with more than 3 credits
        List<Course> highCreditCourses = courses.stream()
            .filter(c -> c.getCredits() > 3)
            .collect(Collectors.toList());
        System.out.println("High Credit Courses: " + highCreditCourses);

        // 13. Find a course by name
        String courseName = "Math";
        Optional<Course> mathCourse = courses.stream()
            .filter(c -> c.getName().equals(courseName))
            .findFirst();
        mathCourse.ifPresent(c -> System.out.println("Found Course: " + c));

        // 14. Get total credits for all courses
        int totalCredits = courses.stream()
            .mapToInt(Course::getCredits)
            .sum();
        System.out.println("Total Credits: " + totalCredits);

        // 15. Distinct course names
        List<String> distinctCourseNames = courses.stream()
            .map(Course::getName)
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Distinct Course Names: " + distinctCourseNames);

        // 16. Find the number of unique courses taken by students
        Set<String> uniqueCourses = students.stream()
            .flatMap(s -> s.getCourses().stream())
            .collect(Collectors.toSet());
        System.out.println("Unique Courses: " + uniqueCourses);

        // 17. Filter students with grades between 70 and 85
        List<Student> midRangeStudents = students.stream()
            .filter(s -> s.getGrade() >= 70 && s.getGrade() <= 85)
            .collect(Collectors.toList());
        System.out.println("Students with grades between 70 and 85: " + midRangeStudents);

        // 18. Count courses for each student
        Map<String, Long> studentCourseCount = students.stream()
            .collect(Collectors.toMap(Student::getName, s -> (long) s.getCourses().size()));
        System.out.println("Student Course Count: " + studentCourseCount);

        // 19. Find the student with the longest name
        Optional<Student> longestNameStudent = students.stream()
            .max(Comparator.comparingInt(s -> s.getName().length()));
        longestNameStudent.ifPresent(s -> System.out.println("Student with longest name: " + s));

        // 20. Calculate the grade distribution
        Map<Integer, Long> gradeDistribution = students.stream()
            .collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        System.out.println("Grade Distribution: " + gradeDistribution);

        // 21. Find students who are enrolled in both Math and Science
        List<Student> dualEnrolled = students.stream()
            .filter(s -> s.getCourses().contains("Math") && s.getCourses().contains("Science"))
            .collect(Collectors.toList());
        System.out.println("Students enrolled in both Math and Science: " + dualEnrolled);

        // 22. Convert courses to a string representation
        String courseRepresentation = courses.stream()
            .map(Course::toString)
            .collect(Collectors.joining(", "));
        System.out.println("Course Representation: " + courseRepresentation);

        // 23. Print students with grades sorted descending
        List<Student> descendingGradeStudents = students.stream()
            .sorted(Comparator.comparingInt(Student::getGrade).reversed())
            .collect(Collectors.toList());
        System.out.println("Students Sorted by Grade (Descending): " + descendingGradeStudents);

        // 24. Check if all students passed
        boolean allPassed = students.stream()
            .allMatch(s -> s.getGrade() >= 60);
        System.out.println("All Students Passed: " + allPassed);

        // 25. Find the first course with 3 credits
        Optional<Course> firstThreeCreditCourse = courses.stream()
            .filter(c -> c.getCredits() == 3)
            .findFirst();
        firstThreeCreditCourse.ifPresent(c -> System.out.println("First 3 Credit Course: " + c));

        // 26. Create a map of student names to their grades
        Map<String, Integer> studentGrades = students.stream()
            .collect(Collectors.toMap(Student::getName, Student::getGrade));
        System.out.println("Student Grades Map: " + studentGrades);

        // 27. Calculate total credits for courses a student is enrolled in
        /*students.forEach(s -> {
            int totalCourseCredits = s.getCourses().stream()
                .map(courseName -> courses.stream().filter(c -> c.getName().equals(courseName)).findFirst().orElse(new Course(courseName, 0)))
                .mapToInt(Course::getCredits)
                .sum();
            System.out.println(s.getName() + " Total Credits: " + totalCourseCredits);
        });
		*/
        // 28. Find students who have not enrolled in any course
        List<Student> noCourseStudents = students.stream()
            .filter(s -> s.getCourses().isEmpty())
            .collect(Collectors.toList());
        System.out.println("Students with no enrolled courses: " + noCourseStudents);

        // 29. Find students whose names start with 'A'
        List<Student> aStudents = students.stream()
            .filter(s -> s.getName().startsWith("A"))
            .collect(Collectors.toList());
        System.out.println("Students whose names start with 'A': " + aStudents);

        // 30. Group students by number of courses taken
        Map<Integer, List<Student>> studentsByCourseCount = students.stream()
            .collect(Collectors.groupingBy(s -> s.getCourses().size()));
        System.out.println("Students Grouped by Course Count: " + studentsByCourseCount);

        // 31. Find the course with the maximum credits
        Optional<Course> maxCreditCourse = courses.stream()
            .max(Comparator.comparingInt(Course::getCredits));
        maxCreditCourse.ifPresent(c -> System.out.println("Course with Max Credits: " + c));

        // 32. Print all distinct grades
        List<Integer> distinctGrades = students.stream()
            .map(Student::getGrade)
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Distinct Grades: " + distinctGrades);

        // 33. Create a list of courses offered
        List<String> offeredCourses = students.stream()
            .flatMap(s -> s.getCourses().stream())
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Courses Offered: " + offeredCourses);

        // 34. Check if a specific student exists
        boolean studentExists = students.stream().anyMatch(s -> s.getName().equals("Alice"));
        System.out.println("Does Alice exist? " + studentExists);

        // 35. Create a list of students sorted by their number of courses (ascending)
        List<Student> sortedByCourseCount = students.stream()
            .sorted(Comparator.comparingInt(s -> s.getCourses().size()))
            .collect(Collectors.toList());
        System.out.println("Students Sorted by Course Count: " + sortedByCourseCount);

        // 36. Calculate the percentage of students passing
        long passingCount = students.stream().filter(s -> s.getGrade() >= 60).count();
        double passingPercentage = (double) passingCount / studentCount * 100;
        System.out.println("Passing Percentage: " + passingPercentage + "%");

        // 37. Create a map of students to their enrolled courses
        Map<String, List<String>> studentCourseMap = students.stream()
            .collect(Collectors.toMap(Student::getName, Student::getCourses));
        System.out.println("Student to Course Map: " + studentCourseMap);

        // 38. Print the total number of courses
        long totalCoursesCount = courses.size();
        System.out.println("Total Courses Offered: " + totalCoursesCount);

        // 39. Get the names of courses for students with grades above 80
        List<String> highGradeCourseNames = students.stream()
            .filter(s -> s.getGrade() > 80)
            .flatMap(s -> s.getCourses().stream())
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Courses for Students with Grades Above 80: " + highGradeCourseNames);

        // 40. Find the student with the lowest grade
        Optional<Student> lowestGradeStudent = students.stream()
            .min(Comparator.comparingInt(Student::getGrade));
        lowestGradeStudent.ifPresent(s -> System.out.println("Student with Lowest Grade: " + s));

        // 41. Count the number of students in each course
        Map<String, Long> courseEnrollmentCount = students.stream()
            .flatMap(s -> s.getCourses().stream())
            .collect(Collectors.groupingBy(course -> course, Collectors.counting()));
        System.out.println("Course Enrollment Count: " + courseEnrollmentCount);

        // 42. Find students who take more than one course
        List<Student> multipleCourses = students.stream()
            .filter(s -> s.getCourses().size() > 1)
            .collect(Collectors.toList());
        System.out.println("Students Taking More Than One Course: " + multipleCourses);

        // 43. Find the course with the least credits
        Optional<Course> minCreditCourse = courses.stream()
            .min(Comparator.comparingInt(Course::getCredits));
        minCreditCourse.ifPresent(c -> System.out.println("Course with Least Credits: " + c));

        // 44. Get a list of students who scored above average
        List<Student> aboveAverageStudents = students.stream()
            .filter(s -> s.getGrade() > averageGrade)
            .collect(Collectors.toList());
        System.out.println("Students Scoring Above Average: " + aboveAverageStudents);

        // 45. Get the first two students alphabetically
        List<Student> firstTwoStudents = students.stream()
            .sorted(Comparator.comparing(Student::getName))
            .limit(2)
            .collect(Collectors.toList());
        System.out.println("First Two Students Alphabetically: " + firstTwoStudents);

        // 46. Count the total number of courses across all students
        long totalCoursesTaken = students.stream()
            .flatMap(s -> s.getCourses().stream())
            .count();
        System.out.println("Total Courses Taken by All Students: " + totalCoursesTaken);

        // 47. Find students who are not taking Math
        List<Student> notTakingMath = students.stream()
            .filter(s -> !s.getCourses().contains("Math"))
            .collect(Collectors.toList());
        System.out.println("Students Not Taking Math: " + notTakingMath);

        // 48. Get the highest grade of a student taking Art
        Optional<Integer> highestArtGrade = students.stream()
            .filter(s -> s.getCourses().contains("Art"))
            .map(Student::getGrade)
            .max(Integer::compareTo);
        highestArtGrade.ifPresent(grade -> System.out.println("Highest Grade in Art: " + grade));

        // 49. Find students with names ending with 'e'
        List<Student> eStudents = students.stream()
            .filter(s -> s.getName().endsWith("e"))
            .collect(Collectors.toList());
        System.out.println("Students with Names Ending with 'e': " + eStudents);

        // 50. Create a list of students sorted by grades then by names
        List<Student> sortedByGradeAndName = students.stream()
            .sorted(Comparator.comparingInt(Student::getGrade).thenComparing(Student::getName))
            .collect(Collectors.toList());
        System.out.println("Students Sorted by Grade and Name: " + sortedByGradeAndName);

        // 51. Print out the courses each student is taking
        students.forEach(s -> System.out.println(s.getName() + " is taking " + s.getCourses()));
    }
}
