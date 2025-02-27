import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import PatientList from "./components/patient/PatientList";
import AddPatient from "./components/patient/AddPatient";
import EditPatient from "./components/patient/EditPatient";
import ViewPatient from "./components/patient/ViewPatient";
import NavBar from "./components/common/NavBar";
import HomeComponent from "./components/common/HomeComponent";

function App() {
  return (
    <Router>
      <NavBar />
      <Routes>
        <Route path="/" element={<HomeComponent />} />
        <Route path="/patients" element={<PatientList />} />
        <Route path="/add-patient" element={<AddPatient />} />
        <Route path="/edit-patient/:id" element={<EditPatient />} />
        <Route path="/view-patient/:id" element={<ViewPatient />} />
      </Routes>
    </Router>
  );
}

export default App;