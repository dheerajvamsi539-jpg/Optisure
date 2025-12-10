import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

// Policy APIs
export const getPolicies = () => axios.get(`${API_URL}/policies`);
export const getPolicyById = (id) => axios.get(`${API_URL}/policies/${id}`);
export const createPolicy = (policy) => axios.post(`${API_URL}/policies`, policy);
export const updatePolicy = (id, policy) => axios.put(`${API_URL}/policies/${id}`, policy);
export const deletePolicy = (id) => axios.delete(`${API_URL}/policies/${id}`);

// Claim APIs
export const getClaims = () => axios.get(`${API_URL}/claims`);
export const getClaimById = (id) => axios.get(`${API_URL}/claims/${id}`);
export const createClaim = (claim) => axios.post(`${API_URL}/claims`, claim);
export const updateClaim = (id, claim) => axios.put(`${API_URL}/claims/${id}`, claim);
export const deleteClaim = (id) => axios.delete(`${API_URL}/claims/${id}`);

// Premium APIs
export const getPremiums = () => axios.get(`${API_URL}/premiums`);
export const getPremiumById = (id) => axios.get(`${API_URL}/premiums/${id}`);
export const createPremium = (premium) => axios.post(`${API_URL}/premiums`, premium);
export const updatePremium = (id, premium) => axios.put(`${API_URL}/premiums/${id}`, premium);
export const deletePremium = (id) => axios.delete(`${API_URL}/premiums/${id}`);
