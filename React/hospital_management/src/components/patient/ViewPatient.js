import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import PatientServices from "../../services/PatientServices";

const ViewPatient = () => {
  const { id } = useParams();
  const [patient, setPatient] = useState({});
  const navigate = useNavigate();

  useEffect(() => {
    PatientServices.getPatientById(id).then((res) => setPatient(res.data));
  }, [id]);

  return (
    <div className="container">
      <h2>Patient Details</h2>
      <p><strong>First Name:</strong> {patient.firstName}</p>
      <p><strong>Last Name:</strong> {patient.lastName}</p>
      <p><strong>DOB:</strong> {patient.dob}</p>
      <p><strong>Age:</strong> {patient.age}</p>
      <button onClick={() => navigate("/")}>Back</button>
    </div>
  );
};

export default ViewPatient;