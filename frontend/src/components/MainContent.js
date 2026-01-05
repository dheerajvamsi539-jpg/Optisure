import React from 'react';
import { Routes, Route } from 'react-router-dom';
import { Container, Typography } from '@mui/material';
import AgentPortal from '../pages/AgentPortal';
import CustomerPortal from '../pages/CustomerPortal';

const MainContent = () => {
    return (
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
    );
};

export default MainContent;
