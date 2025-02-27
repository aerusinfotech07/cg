import axios from "axios";

const BASE_URL = "http://localhost:8080/api/patients"; // Change according to your backend API

class PatientServices {
  getPatients() {
    return axios.get(BASE_URL);
  }

  addPatient(patient) {
    return axios.post(BASE_URL, patient);
  }

  getPatientById(id) {
    return axios.get(`${BASE_URL}/${id}`);
  }

  updatePatient(id, patient) {
    return axios.put(`${BASE_URL}/${id}`, patient);
  }

  deletePatient(id) {
    return axios.delete(`${BASE_URL}/${id}`);
  }
}

export default new PatientServices();