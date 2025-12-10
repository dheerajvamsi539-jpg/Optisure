import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import { AppBar, Toolbar, Typography, Button, Container } from '@mui/material';
import AgentPortal from './pages/AgentPortal';
import CustomerPortal from './pages/CustomerPortal';

function App() {
  return (
    <Router>
      <div>
        <AppBar position="static">
          <Toolbar>
            <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
              OptiSure
            </Typography>
            <Button color="inherit" component={Link} to="/agent">
              Agent Portal
            </Button>
            <Button color="inherit" component={Link} to="/customer">
              Customer Portal
            </Button>
          </Toolbar>
        </AppBar>
        <Container sx={{ mt: 4 }}>
          <Routes>
            <Route path="/agent" element={<AgentPortal />} />
            <Route path="/customer" element={<CustomerPortal />} />
            <Route path="/" element={
              <Typography variant="h5" align="center">
                Welcome to OptiSure! Please select a portal.
              </Typography>
            } />
          </Routes>
        </Container>
      </div>
    </Router>
  );
}

export default App;