import api from "./api";

export const getBoards = async () => {
    const response = await api.get("/api/boards");
    return response.data;
}