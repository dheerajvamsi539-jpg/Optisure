import React, { useState, useEffect } from 'react';
import { Typography, Container, List, ListItem, ListItemText } from '@mui/material';
import { getClaims } from '../services/api';

const CustomerPortal = () => {
  const [claims, setClaims] = useState([]);

  useEffect(() => {
    fetchClaims();
  }, []);

  const fetchClaims = async () => {
    try {
      const response = await getClaims();
      setClaims(response.data);
    } catch (error) {
      console.error('Error fetching claims:', error);
    }
  };

  return (
    <Container>
      <Typography variant="h4" gutterBottom>
        Customer Portal - Claims
      </Typography>
      <List>
        {claims.map((claim) => (
          <ListItem key={claim.id}>
            <ListItemText
              primary={`Claim #${claim.claimNumber}`}
              secondary={`Status: ${claim.status} - Amount: $${claim.claimAmount}`}
            />
          </ListItem>
        ))}
      </List>
    </Container>
  );
};

export default CustomerPortal;
