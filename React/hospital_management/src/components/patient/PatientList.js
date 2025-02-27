import React, { useEffect, useState } from "react";
import PatientServices from "../../services/PatientServices";
import { useNavigate } from "react-router-dom";
import "../../App.css";

const PatientList = () => {
  const [patients, setPatients] = useState([]);
  const navigate = useNavigate();

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

  const deletePatient = (id) => {
    PatientServices.deletePatient(id).then(() => loadPatients());
  };

  return (
    <div className="container">
      <h2>Patient List</h2>
      <button onClick={() => navigate("/add-patient")} className="btn">
        Add Patient
      </button>
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
                <button onClick={() => navigate(`/edit-patient/${patient.id}`)}>Edit</button>
                <button onClick={() => deletePatient(patient.id)}>Delete</button>
                <button onClick={() => navigate(`/view-patient/${patient.id}`)}>View</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PatientList;