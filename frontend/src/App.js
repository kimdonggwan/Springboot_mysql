// src/App.js
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import RootPage from "./pages/RootPage";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<RootPage />} />
      </Routes>
    </Router>
  );
}

export default App;
