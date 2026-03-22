import { useEffect, useState } from "react";
import { getBoards} from "../services/boardService.ts";

function BoardList() {
    const [boards, setBoards] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
            const fetchBoards = async () => {
                try {
                    const data = await getBoards();
                    setBoards(data);
                } catch (err) {
                    console.error(err);
                    setError("Failed to load boards");
                } finally {
                    setLoading(false);
                }
            };

            fetchBoards();
    }, []);

    //Loading state
    if (loading) {
        return <p>Loading boards...</p>;
    }

    //Error state
    if (error) {
        return <p>(error)</p>;
    }

    //Empty state
    if (boards.length === 0) {
        return <p>No boards yet</p>
    }

    //Dynamisk rendering
    return (
        <div>
            <h2>Boards</h2>

            {boards.map((board: any) => (
                <div key = {board.id}>
                    <h3>{board.name}</h3>
                    <p>{board.description}</p>
                </div>
            ))}
        </div>
    )
}

export default BoardList;