import React, { useEffect, useState } from "react";
import PatientServices from "../../services/PatientServices";


const PatientList = () => {
    const [patients, setPatients] = useState([]);
  
    useEffect(() => {
      loadPatients();
    }, []);
  
    const loadPatients = () => {
      PatientServices.getPatients()
        .then((response) => {
          setPatients(response.data);
        })
        .catch((error) => {
          console.error("Error fetching patients:", error);
        });
    };



    return (
        <div className="container">
          <h2>Patient List</h2>
         
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Age</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {patients.map((patient) => (
                <tr key={patient.id}>
                  <td>{patient.id}</td>
                  <td>{patient.firstName}</td>
                  <td>{patient.lastName}</td>
                  <td>{patient.dob}</td>
                  <td>{patient.age}</td>
                  <td>
                    
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      );
    };
    
    export default PatientList;