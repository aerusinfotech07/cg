package com.cg.hospital.management.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.hospital.management.model.Patient;
import com.cg.hospital.management.model.StatusEnum;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

	List<Patient> findByFirstNameContaining(String firstName);
	List<Patient> findByFirstNameContainingAndLastNameContaining(String firstName,String lastName);
	List<Patient> findByFirstNameContainingAndAgeGreaterThan(String firstName,int age);
	 // Finds patients by their last name
    List<Patient> findByLastName(String lastName);

    // JPQL query for the same purpose
    @Query("SELECT p FROM Patient p WHERE p.lastName = :lastName")
    List<Patient> findPatientsByLastName(String lastName);
    
    // Finds patients older than a specified age
    List<Patient> findByAgeGreaterThan(int age);

    // Finds patients younger than a specified age
    List<Patient> findByAgeLessThan(int age);

    // JPQL queries for the same purposes
    @Query("SELECT p FROM Patient p WHERE p.age > :age")
    List<Patient> findPatientsOlderThan(int age);

    @Query("SELECT p FROM Patient p WHERE p.age < :age")
    List<Patient> findPatientsYoungerThan(int age);

    // Finds patients with date of birth within a specific range
    @Query("SELECT p FROM Patient p WHERE p.dob BETWEEN :startDate AND :endDate")
    List<Patient> findPatientsByDobBetween(String startDate, String endDate);

  //************************************If You Have Address******************
    // Finds patients residing in a specific city
    /*@Query("SELECT p FROM Patient p JOIN p.address a WHERE a.city = :city")
    List<Patient> findPatientsByCity(String city);
     */
    // Finds patients on a specific street
    /*@Query("SELECT p FROM Patient p JOIN p.address a WHERE a.street = :street")
    List<Patient> findPatientsByStreet(String street);
	*/
    // Finds patients with a specific last name and age greater than the specified value
    @Query("SELECT p FROM Patient p WHERE p.lastName = :lastName AND p.age > :age")
    List<Patient> findPatientsByLastNameAndAgeGreaterThan(String lastName, int age);
    //************************************For Appointment******************
 // 1. Find patients by appointment date
    @Query("SELECT p FROM Patient p JOIN p.appointments a WHERE a.appointmentDate = :appointmentDate")
    List<Patient> findPatientsByAppointmentDate(Date appointmentDate);

    // 2. Find patients by appointment status
    @Query("SELECT p FROM Patient p JOIN p.appointments a WHERE a.status = :status")
    List<Patient> findPatientsByAppointmentStatus(StatusEnum status);

    // 3. Find patients by appointment fees greater than a certain amount
    @Query("SELECT p FROM Patient p JOIN p.appointments a WHERE a.fees > :fees")
    List<Patient> findPatientsByAppointmentFeesGreaterThan(double fees);

    // 4. Find patients with appointments within a date range
    @Query("SELECT p FROM Patient p JOIN p.appointments a WHERE a.appointmentDate BETWEEN :startDate AND :endDate")
    List<Patient> findPatientsByAppointmentDateRange(Date startDate, Date endDate);

    // 5. Find patients by appointment status and fees greater than a specified amount
    @Query("SELECT p FROM Patient p JOIN p.appointments a WHERE a.status = :status AND a.fees > :fees")
    List<Patient> findPatientsByAppointmentStatusAndFeesGreaterThan(StatusEnum status, double fees);

    // 6. Find patients who have an appointment on a given date and with specific status
    @Query("SELECT p FROM Patient p JOIN p.appointments a WHERE a.appointmentDate = :appointmentDate AND a.status = :status")
    List<Patient> findPatientsByAppointmentDateAndStatus(Date appointmentDate, StatusEnum status);
    

}
