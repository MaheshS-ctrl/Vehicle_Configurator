// authService.js
import api from "./axiosConfig";

const authService = {
  login: async (credentials) => {
    const response = await api.post("/api/auth/login", credentials);

    if (response.data?.token) {
      sessionStorage.setItem("accessToken", response.data.token);
    }

    return response.data;
  },

  logout: () => {
    sessionStorage.removeItem("accessToken");
  },
};

export default authService;
