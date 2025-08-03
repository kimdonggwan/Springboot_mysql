// src/api/userApi.js
import axios from "axios";

export const signupUser = async (userData) => {
    const response = await axios.post("/api/users", userData);
    return response.data;
}