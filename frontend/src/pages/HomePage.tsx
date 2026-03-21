import {useEffect} from "react";
import {getBoards} from "../services/boardService.ts";

function HomePage() {
    useEffect(() => {
        const fetchBoards = async () => {
            try {
                const data = await getBoards();
                console.log("Boards from backend:", data);
            } catch (error) {
                console.error("Error fetching boards:", error);
            }
        };

        fetchBoards();
    }, []);
    
    return (
        <div>
            <h1>Kanban</h1>
            <p>Frontend initialized with Vite + React + Typescript.</p>
        </div>
    );
}

export default HomePage;