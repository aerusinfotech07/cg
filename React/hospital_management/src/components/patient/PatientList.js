import React, { useEffect, useState } from "react";
import PatientServices from "../../services/PatientServices";
import { useNavigate } from "react-router-dom";
import "../../App.css";

const PatientList = () => {
  const [patients, setPatients] = useState([]);
  const navigate = useNavigate();
  const [filteredPatients, setFilteredPatients] = useState([]);
  const [searchFirstName, setSearchFirstName] = useState("");
  const [searchLastName, setSearchLastName] = useState("");
  const [minAge, setMinAge] = useState("");
  const [maxAge, setMaxAge] = useState("");
  useEffect(() => {
    loadPatients();
    //filterPatients();
  }, []);

  useEffect(() => {
    filterPatients();
  }, [searchFirstName, searchLastName, minAge, maxAge, patients]);

  const loadPatients = () => {
    PatientServices.getPatients()
      .then((response) => {
        if (response.status === 204) {
          console.warn("No patients found.");
          setPatients([]); // Set an empty array or handle accordingly
        } else {
          setPatients(response.data);
        }
      })
      .catch((error) => {
        console.error("Error fetching patients:", error);
      });
  };
  const filterPatients = () => {
    let filtered = patients.filter((patient) => {
      return (
        (searchFirstName === "" ||
          patient.firstName.toLowerCase().includes(searchFirstName.toLowerCase())) &&
        (searchLastName === "" ||
          patient.lastName.toLowerCase().includes(searchLastName.toLowerCase())) &&
        (minAge === "" || patient.age >= parseInt(minAge)) &&
        (maxAge === "" || patient.age <= parseInt(maxAge))
      );
    });
    //console.log(filtered);
    setFilteredPatients(filtered);
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
          {/* Filter Row */}
          <tr>
            <th></th>
            <th>
              <input
                type="text"
                placeholder="Search First Name"
                value={searchFirstName}
                onChange={(e) => setSearchFirstName(e.target.value)}
              />
            </th>
            <th>
              <input
                type="text"
                placeholder="Search Last Name"
                value={searchLastName}
                onChange={(e) => setSearchLastName(e.target.value)}
              />
            </th>
            <th></th>
            <th>
              <input
                type="number"
                placeholder="Min Age"
                value={minAge}
                onChange={(e) => setMinAge(e.target.value)}
              />
              <input
                type="number"
                placeholder="Max Age"
                value={maxAge}
                onChange={(e) => setMaxAge(e.target.value)}
              />
            </th>
            <th></th>
          </tr>
        </thead>
        <tbody>
        {filteredPatients.length > 0 ? (
            filteredPatients.map((patient) => (
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
            ))
            ) : (
            <tr>
                <td colSpan="6" style={{ textAlign: "center", fontWeight: "bold", padding: "10px" }}>
                No Data Found
                </td>
            </tr>
            )}

        </tbody>
      </table>
    </div>
  );
};

export default PatientList;