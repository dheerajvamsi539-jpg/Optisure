import React, { useState, useEffect } from 'react';
import { Typography, Container, List, ListItem, ListItemText } from '@mui/material';
import { getPolicies } from '../services/api';

const AgentPortal = () => {
  const [policies, setPolicies] = useState([]);

  useEffect(() => {
    fetchPolicies();
  }, []);

  const fetchPolicies = async () => {
    try {
      const response = await getPolicies();
      setPolicies(response.data);
    } catch (error) {
      console.error('Error fetching policies:', error);
    }
  };

  return (
    <Container>
      <Typography variant="h4" gutterBottom>
        Agent Portal - Policies
      </Typography>
      <List>
        {policies.map((policy) => (
          <ListItem key={policy.id}>
            <ListItemText
              primary={`Policy #${policy.policyNumber}`}
              secondary={`Type: ${policy.policyType} - Premium: $${policy.premiumAmount}`}
            />
          </ListItem>
        ))}
      </List>
    </Container>
  );
};

export default AgentPortal;
