import axios from "axios"

const serverUri = "http://localhost:8080";

const api = {
    get: async(url, params) => {
        try {
            const response = await axios.get(`${serverUri}/${url}`, params)
            
            if (response.status === 200) {
                return response.data;
            }

            return response;
        } catch (err) {
            return Promise.reject(err);
        }
    }
}

export default api;