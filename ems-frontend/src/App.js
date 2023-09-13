import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import 'bootstrap/dist/css/bootstrap.min.css';
import Navigationbar from './Navigationbar'
import Employees from './Employees'

function App() {
  return (
    <Router>
      <Navigationbar />
      <Employees />
    </Router>
  );
}

export default App;
