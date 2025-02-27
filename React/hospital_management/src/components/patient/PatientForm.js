import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import PatientServices from "../../services/PatientServices";

const PatientForm = ({ isEdit }) => {
  const [patient, setPatient] = useState({ firstName: "", lastName: "", dob: "", age: "" });
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (isEdit) {
      PatientServices.getPatientById(id).then((res) => setPatient(res.data));
    }
  }, [isEdit, id]);

  const handleChange = (e) => {
    setPatient({ ...patient, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (isEdit) {
      PatientServices.updatePatient(id, patient).then(() => navigate("/"));
    } else {
      PatientServices.addPatient(patient).then(() => navigate("/"));
    }
  };

  return (
    <div className="container">
      <h2>{isEdit ? "Edit Patient" : "Add Patient"}</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="firstName" placeholder="First Name" value={patient.firstName} onChange={handleChange} required />
        <input type="text" name="lastName" placeholder="Last Name" value={patient.lastName} onChange={handleChange} required />
        <input type="date" name="dob" value={patient.dob} onChange={handleChange} required />
        <input type="number" name="age" placeholder="Age" value={patient.age} onChange={handleChange} required />
        <button type="submit">{isEdit ? "Update" : "Submit"}</button>
      </form>
    </div>
  );
};

export default PatientForm;