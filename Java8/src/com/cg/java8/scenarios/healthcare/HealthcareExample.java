package com.cg.java8.scenarios.healthcare;

import java.util.*;
import java.util.stream.Collectors;

enum Department {
    CARDIOLOGY, NEUROLOGY, ORTHOPEDICS, PEDIATRICS
}

class Patient {
    private String name;
    private int age;
    private String condition;
    private String roomNumber;

    public Patient(String name, int age, String condition, String roomNumber) {
        this.name = name;
        this.age = age;
        this.condition = condition;
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCondition() {
        return condition;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", condition='" + condition + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Nurse> nurses;

    public Hospital(String name, List<Doctor> doctors, List<Nurse> nurses) {
        this.name = name;
        this.doctors = doctors;
        this.nurses = nurses;
    }

    public String getName() {
        return name;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", doctors=" + doctors +
                ", nurses=" + nurses +
                '}';
    }
}

class Doctor {
    private String name;
    private Department department;
    private int yearsOfExperience;

    public Doctor(String name, Department department, int yearsOfExperience) {
        this.name = name;
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", department=" + department +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}

class Nurse {
    private String name;
    private int yearsOfExperience;

    public Nurse(String name, int yearsOfExperience) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "name='" + name + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}

class Room {
    private String roomNumber;
    private String type;
    private boolean isOccupied;

    public Room(String roomNumber, String type, boolean isOccupied) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isOccupied = isOccupied;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", type='" + type + '\'' +
                ", isOccupied=" + isOccupied +
                '}';
    }
}

public class HealthcareExample {

    private List<Patient> getPatients() {
        return List.of(
                new Patient("Alice", 30, "Cardiac Arrest", "101"),
                new Patient("Bob", 25, "Fractured Arm", "102"),
                new Patient("Charlie", 40, "Pneumonia", "103"),
                new Patient("David", 35, "Migraine", "104"),
                new Patient("Eva", 28, "Diabetes", "105")
        );
    }

    private List<Doctor> getDoctors() {
        return List.of(
                new Doctor("Dr. Smith", Department.CARDIOLOGY, 10),
                new Doctor("Dr. Brown", Department.NEUROLOGY, 8),
                new Doctor("Dr. Green", Department.ORTHOPEDICS, 5),
                new Doctor("Dr. White", Department.PEDIATRICS, 12)
        );
    }

    private List<Nurse> getNurses() {
        return List.of(
                new Nurse("Nurse Mary", 6),
                new Nurse("Nurse John", 3),
                new Nurse("Nurse Sarah", 10),
                new Nurse("Nurse Kate", 2)
        );
    }

    private List<Room> getRooms() {
        return List.of(
                new Room("101", "ICU", true),
                new Room("102", "General", true),
                new Room("103", "General", false),
                new Room("104", "Surgical", true),
                new Room("105", "Recovery", false)
        );
    }

    private Hospital getHospital() {
        return new Hospital("City Hospital", getDoctors(), getNurses());
    }

    public void runExamples() {
        List<Patient> patientList = getPatients();
        List<Doctor> doctorList = getDoctors();
        List<Nurse> nurseList = getNurses();
        List<Room> roomList = getRooms();
        Hospital hospital = getHospital();

        // 1. Filter: Find all patients with a specific condition
        List<Patient> cardiacPatients = patientList.stream()
                .filter(patient -> patient.getCondition().equals("Cardiac Arrest"))
                .collect(Collectors.toList());
        System.out.println("Patients with Cardiac Arrest: " + cardiacPatients);

        // 2. Map: Get a list of patient names
        List<String> patientNames = patientList.stream()
                .map(Patient::getName)
                .collect(Collectors.toList());
        System.out.println("Patient Names: " + patientNames);

        // 3. Count: Count patients above a certain age
        long countAbove30 = patientList.stream()
                .filter(patient -> patient.getAge() > 30)
                .count();
        System.out.println("Count of patients above 30: " + countAbove30);

        // 4. Grouping: Count patients by their room number
        Map<String, Long> patientsByRoom = patientList.stream()
                .collect(Collectors.groupingBy(Patient::getRoomNumber, Collectors.counting()));
        System.out.println("Count of patients by room: " + patientsByRoom);

        // 5. Sorted: Sort patients by age in ascending order
        List<Patient> sortedByAge = patientList.stream()
                .sorted(Comparator.comparingInt(Patient::getAge))
                .collect(Collectors.toList());
        System.out.println("Patients sorted by age: " + sortedByAge);

        // 6. Peek: Print each patient while counting them
        long totalPatients = patientList.stream()
                .peek(patient -> System.out.println("Patient: " + patient))
                .count();
        System.out.println("Total number of patients: " + totalPatients);

        // 7. Limit: Get the first 3 patients
        List<Patient> firstThreePatients = patientList.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First three patients: " + firstThreePatients);

        // 8. Skip: Skip the first 2 patients
        List<Patient> skippedPatients = patientList.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Patients after skipping the first 2: " + skippedPatients);

        // 9. Find First: Find the first patient with a specific condition
        Optional<Patient> firstDiabeticPatient = patientList.stream()
                .filter(patient -> patient.getCondition().equals("Diabetes"))
                .findFirst();
        firstDiabeticPatient.ifPresent(patient -> System.out.println("First diabetic patient: " + patient));

        // 10. Find Any: Find any patient in a specific room
        Optional<Patient> anyPatientInRoom103 = patientList.stream()
                .filter(patient -> patient.getRoomNumber().equals("103"))
                .findAny();
        anyPatientInRoom103.ifPresent(patient -> System.out.println("Any patient in room 103: " + patient));

        // 11. Reduce: Find the total age of all patients
        int totalAge = patientList.stream()
                .mapToInt(Patient::getAge)
                .sum();
        System.out.println("Total age of all patients: " + totalAge);

        // 12. Collect: Gather patients with age above 40 into a list
        List<Patient> olderPatients = patientList.stream()
                .filter(patient -> patient.getAge() > 40)
                .collect(Collectors.toList());
        System.out.println("Patients older than 40: " + olderPatients);

        // 13. Grouping by Department: Group doctors by their department
        Map<Department, List<Doctor>> doctorsByDepartment = doctorList.stream()
                .collect(Collectors.groupingBy(Doctor::getDepartment));
        System.out.println("Doctors grouped by department: " + doctorsByDepartment);

        // 14. Join: Join all nurse names into a single string
        String nurseNames = nurseList.stream()
                .map(Nurse::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Nurse Names: " + nurseNames);

        // 15. Distinct: Get distinct room types
        List<String> distinctRoomTypes = roomList.stream()
                .map(Room::getType)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct room types: " + distinctRoomTypes);

        // 16. Average Years of Experience: Calculate average years of experience of doctors
        OptionalDouble averageDoctorExperience = doctorList.stream()
                .mapToInt(Doctor::getYearsOfExperience)
                .average();
        averageDoctorExperience.ifPresent(avg -> System.out.println("Average doctor experience: " + avg));

        // 17. Count Doctors by Experience: Count doctors with more than 5 years of experience
        long countExperiencedDoctors = doctorList.stream()
                .filter(doctor -> doctor.getYearsOfExperience() > 5)
                .count();
        System.out.println("Count of experienced doctors: " + countExperiencedDoctors);

        // 18. Total Experience of Nurses: Calculate total experience of all nurses
        int totalNurseExperience = nurseList.stream()
                .mapToInt(Nurse::getYearsOfExperience)
                .sum();
        System.out.println("Total years of experience of nurses: " + totalNurseExperience);

        // 19. Patients by Age Group: Group patients by age group (0-30, 31-50, 51+)
        Map<String, List<Patient>> patientsByAgeGroup = patientList.stream()
                .collect(Collectors.groupingBy(patient -> {
                    if (patient.getAge() <= 30) return "0-30";
                    else if (patient.getAge() <= 50) return "31-50";
                    else return "51+";
                }));
        System.out.println("Patients grouped by age: " + patientsByAgeGroup);

        // 20. Find Nurses by Experience: Find all nurses with less than 5 years of experience
        List<Nurse> juniorNurses = nurseList.stream()
                .filter(nurse -> nurse.getYearsOfExperience() < 5)
                .collect(Collectors.toList());
        System.out.println("Nurses with less than 5 years of experience: " + juniorNurses);

        // 21. Room Occupancy: Count occupied and unoccupied rooms
        Map<Boolean, Long> roomOccupancy = roomList.stream()
                .collect(Collectors.partitioningBy(Room::isOccupied, Collectors.counting()));
        System.out.println("Room occupancy: " + roomOccupancy);

        // 22. Find Doctor by Name: Find a doctor by name
        Optional<Doctor> doctorSmith = doctorList.stream()
                .filter(doctor -> doctor.getName().equals("Dr. Smith"))
                .findFirst();
        doctorSmith.ifPresent(doctor -> System.out.println("Found Doctor: " + doctor));

        // 23. Find All Patients in Room: Find all patients in a specific room
        List<Patient> patientsInRoom101 = patientList.stream()
                .filter(patient -> patient.getRoomNumber().equals("101"))
                .collect(Collectors.toList());
        System.out.println("Patients in room 101: " + patientsInRoom101);

        // 24. Most Experienced Doctor: Find the doctor with the most experience
        Optional<Doctor> mostExperiencedDoctor = doctorList.stream()
                .max(Comparator.comparingInt(Doctor::getYearsOfExperience));
        mostExperiencedDoctor.ifPresent(doctor -> System.out.println("Most experienced doctor: " + doctor));

        // 25. Patients Sorted by Condition: Sort patients by their condition
        List<Patient> patientsSortedByCondition = patientList.stream()
                .sorted(Comparator.comparing(Patient::getCondition))
                .collect(Collectors.toList());
        System.out.println("Patients sorted by condition: " + patientsSortedByCondition);

        // 26. Count Patients per Room: Count how many patients are in each room
        Map<String, Long> countPatientsPerRoom = patientList.stream()
                .collect(Collectors.groupingBy(Patient::getRoomNumber, Collectors.counting()));
        System.out.println("Patients per room: " + countPatientsPerRoom);

        // 27. Collect Unique Room Numbers: Collect unique room numbers
        Set<String> uniqueRoomNumbers = patientList.stream()
                .map(Patient::getRoomNumber)
                .collect(Collectors.toSet());
        System.out.println("Unique room numbers: " + uniqueRoomNumbers);

        // 28. Group Nurses by Years of Experience: Group nurses by years of experience
        Map<Integer, List<Nurse>> nursesByExperience = nurseList.stream()
                .collect(Collectors.groupingBy(Nurse::getYearsOfExperience));
        System.out.println("Nurses grouped by years of experience: " + nursesByExperience);

        // 29. Patients with Specific Condition: Count how many patients have a specific condition
        long countPneumoniaPatients = patientList.stream()
                .filter(patient -> patient.getCondition().equals("Pneumonia"))
                .count();
        System.out.println("Count of pneumonia patients: " + countPneumoniaPatients);

        // 30. Find Available Rooms: Find all available (unoccupied) rooms
        List<Room> availableRooms = roomList.stream()
                .filter(room -> !room.isOccupied())
                .collect(Collectors.toList());
        System.out.println("Available rooms: " + availableRooms);

        // 31. Room Types Count: Count how many rooms of each type exist
        Map<String, Long> roomTypesCount = roomList.stream()
                .collect(Collectors.groupingBy(Room::getType, Collectors.counting()));
        System.out.println("Count of rooms by type: " + roomTypesCount);

        // 32. Patients with Specific Age: Find patients aged exactly 30
        List<Patient> age30Patients = patientList.stream()
                .filter(patient -> patient.getAge() == 30)
                .collect(Collectors.toList());
        System.out.println("Patients aged 30: " + age30Patients);

        // 33. Group Doctors by Name Initial: Group doctors by the first letter of their names
        Map<Character, List<Doctor>> doctorsByInitial = doctorList.stream()
                .collect(Collectors.groupingBy(doctor -> doctor.getName().charAt(0)));
        System.out.println("Doctors grouped by name initial: " + doctorsByInitial);

        // 34. Longest Patient Name: Find the longest patient name
        Optional<String> longestPatientName = patientList.stream()
                .map(Patient::getName)
                .reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2);
        longestPatientName.ifPresent(name -> System.out.println("Longest patient name: " + name));

        // 35. Find All Doctors: List all doctors in the hospital
        System.out.println("All doctors in the hospital: " + hospital.getDoctors());

        // 36. Find All Nurses: List all nurses in the hospital
        System.out.println("All nurses in the hospital: " + hospital.getNurses());

        // 37. Collect All Patients' Conditions: Get a list of all patients' conditions
        List<String> patientConditions = patientList.stream()
                .map(Patient::getCondition)
                .collect(Collectors.toList());
        System.out.println("All patient conditions: " + patientConditions);

        // 38. Average Age of Patients: Calculate the average age of patients
        OptionalDouble averagePatientAge = patientList.stream()
                .mapToInt(Patient::getAge)
                .average();
        averagePatientAge.ifPresent(avg -> System.out.println("Average patient age: " + avg));

        // 39. Total Number of Nurses: Count total nurses
        long totalNurses = nurseList.stream().count();
        System.out.println("Total number of nurses: " + totalNurses);

        // 40. Find All Doctors in Cardiology: Find doctors in the cardiology department
        List<Doctor> cardiologyDoctors = doctorList.stream()
                .filter(doctor -> doctor.getDepartment() == Department.CARDIOLOGY)
                .collect(Collectors.toList());
        System.out.println("Doctors in Cardiology: " + cardiologyDoctors);

        // 41. Total Patients: Get the total number of patients
        long totalPatientsCount = patientList.stream().count();
        System.out.println("Total number of patients: " + totalPatientsCount);

        // 42. Total Experience of Doctors: Calculate total experience of all doctors
        int totalDoctorExperience = doctorList.stream()
                .mapToInt(Doctor::getYearsOfExperience)
                .sum();
        System.out.println("Total experience of all doctors: " + totalDoctorExperience);

        // 43. Patients without Room: Find patients without a room assigned
        List<Patient> patientsWithoutRoom = patientList.stream()
                .filter(patient -> patient.getRoomNumber() == null || patient.getRoomNumber().isEmpty())
                .collect(Collectors.toList());
        System.out.println("Patients without room assigned: " + patientsWithoutRoom);

        // 44. Sort Nurses by Experience: Sort nurses by their years of experience
        List<Nurse> sortedNursesByExperience = nurseList.stream()
                .sorted(Comparator.comparingInt(Nurse::getYearsOfExperience).reversed())
                .collect(Collectors.toList());
        System.out.println("Nurses sorted by experience: " + sortedNursesByExperience);

        // 45. Patients Sorted by Name: Sort patients by name
        List<Patient> sortedPatientsByName = patientList.stream()
                .sorted(Comparator.comparing(Patient::getName))
                .collect(Collectors.toList());
        System.out.println("Patients sorted by name: " + sortedPatientsByName);

        // 46. Doctors with More than 10 Years Experience: Find doctors with more than 10 years of experience
        List<Doctor> experiencedDoctors = doctorList.stream()
                .filter(doctor -> doctor.getYearsOfExperience() > 10)
                .collect(Collectors.toList());
        System.out.println("Doctors with more than 10 years of experience: " + experiencedDoctors);

        // 47. Count Rooms by Type: Count how many rooms are of a certain type
        long countICURooms = roomList.stream()
                .filter(room -> room.getType().equals("ICU"))
                .count();
        System.out.println("Count of ICU rooms: " + countICURooms);

        // 48. Patients with Same Condition: Group patients by their condition
        Map<String, List<Patient>> patientsByCondition = patientList.stream()
                .collect(Collectors.groupingBy(Patient::getCondition));
        System.out.println("Patients grouped by condition: " + patientsByCondition);

        // 49. Find All Rooms: Get a list of all rooms in the hospital
        System.out.println("All rooms in the hospital: " + roomList);

        // 50. Total Count of Patients by Condition: Count patients by their condition
        Map<String, Long> countPatientsByCondition = patientList.stream()
                .collect(Collectors.groupingBy(Patient::getCondition, Collectors.counting()));
        System.out.println("Total count of patients by condition: " + countPatientsByCondition);

        // 51. List All Rooms and their Occupancy: Print all rooms and their occupancy status
        roomList.forEach(room -> System.out.println(room + " | Occupied: " + room.isOccupied()));
    }

    public static void main(String[] args) {
        HealthcareExample example = new HealthcareExample();
        example.runExamples();
    }
}

/*
 Below is a Java program that creates `Patient`, `Hospital`, `Doctor`, `Nurse`, and `Room` classes, 
 along with more than 50 scenarios using Java Streams to demonstrate various 
 operations on these classes.

### Explanation of the Code

1. **Classes**: 
   - `Patient`: Represents a patient with attributes like name, age, condition, and room number.
   - `Hospital`: Contains lists of doctors and nurses.
   - `Doctor`: Represents a doctor with attributes like name, department, and years of experience.
   - `Nurse`: Represents a nurse with name and years of experience.
   - `Room`: Represents a hospital room with room number, type, and occupancy status.

2. **Methods**: 
   - The `getPatients`, `getDoctors`, `getNurses`, and `getRooms` methods create lists of patients, doctors, nurses, and rooms.
   - The `getHospital` method creates an instance of the hospital with its doctors and nurses.

3. **Scenarios**: 
   - The `runExamples` method demonstrates various operations on the patient, doctor, nurse, and room lists using Java Streams. It includes filtering, mapping, counting, grouping, and sorting operations.

4. **Main Method**: 
   - The `main` method creates an instance of the `HealthcareExample` class and calls the `runExamples` method to execute the scenarios.

*/
