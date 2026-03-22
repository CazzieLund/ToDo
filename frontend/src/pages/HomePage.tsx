import {useEffect, useState} from "react";
import {getBoards} from "../services/boardService.ts";


function HomePage() {

    const [boards, setBoards] = useState<any[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchBoards = async () => {
            try {
                const data = await getBoards();
                console.log("Boards from backend:", data);

                setBoards(data);
            } catch (error) {
                console.error("Error fetching boards:", error);
                setError("Failed to load boards");
            } finally {
                setLoading(false);
            }
        };

        fetchBoards();
    }, []);

    return (
        <div>
            <h1>Kanban</h1>
            <p>Frontend initialized with Vite + React + Typescript.</p>

            {loading && <p>Loading boards...</p>}

            {error && <p>{error}</p>}

            {!loading && boards.length === 0 && (
                <p>No boards yet</p>
            )}

            {boards.map((board: any) => (
                <div
                    key={board.id}
                    style={{
                        border: "1px solid #ccc",
                        padding: "1rem",
                        marginBottom: "1rem",
                        borderRadius: "8px"
                    }}
                >
                    <h3>{board.name}</h3>
                    <p>{board.description || "No description"}</p>
                </div>
            ))}
        </div>
    );
}

export default HomePage;