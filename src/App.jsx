import { useState, useEffect } from 'react';
import axios from "axios";

const API_URL = "http://localhost:8080/api/movies";

const App = () => {
  const [name, setName] = useState("");
  const [author, setAuthor] = useState("");
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    fetchMovies();
  }, []);

  const fetchMovies = async () => {
    try {
      const response = await axios.get(API_URL);
      setMovies(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const addMovie = async () => {
    if (!name.trim()) {
      alert("Movie name can't be empty");
      return;
    }
    if (!author.trim()) {
      alert("Author name can't be empty");
      return;
    }
    try {
      const res = await axios.post(API_URL, { name, author });
      setMovies([...movies, res.data]);
      setName("");
      setAuthor("");
    } catch (err) {
      console.error(err);
    }
  };

  const deleteMovie = async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      setMovies(movies.filter((movie) => movie.id !== id));
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div className="container my-4">
      <div className="mb-3">
        <input
          type="text"
          className="form-control mb-2"
          placeholder="Movie Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="text"
          className="form-control mb-2"
          placeholder="Author Name"
          value={author}
          onChange={(e) => setAuthor(e.target.value)}
        />
        <button className="btn btn-primary" onClick={addMovie}>
          Add Movie
        </button>
      </div>

      <div className="row">
        {movies.map((movie) => (
          <div className="col-md-4 mb-4" key={movie.id}>
            <div className="card">
              <div className="card-body">
                <h5 className="card-title">{movie.name}</h5>
                <p className="card-text">Author: {movie.author}</p>
                <button
                  className="btn btn-danger"
                  onClick={() => deleteMovie(movie.id)}
                >
                  Delete
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default App;
