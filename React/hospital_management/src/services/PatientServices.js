import axios from "axios";

const BASE_URL = "http://localhost:8080/api/patients"; // Change according to your backend API

class PatientServices {
  getPatients() {
    return axios.get(BASE_URL);
  }
}


export default new PatientServices();
