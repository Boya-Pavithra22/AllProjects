import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const MovieForm = () => {
  const [form, setForm] = useState({
    title: "",
    director: "",
    year: "",
    genre: "",
    rating: "",
    description: "",
    streamingPlatforms: []
  });

  const [movies, setMovies] = useState([]);

  // handle input change
  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm({ ...form, [name]: value });
  };

  // handle checkbox change
  const handleCheckboxChange = (e) => {
    const { value, checked } = e.target;
    setForm((prev) => ({
      ...prev,
      streamingPlatforms: checked
        ? [...prev.streamingPlatforms, value]
        : prev.streamingPlatforms.filter((p) => p !== value)
    }));
  };

  // submit form
  const handleSubmit = (e) => {
    e.preventDefault();
    setMovies([...movies, form]);
    setForm({
      title: "",
      director: "",
      year: "",
      genre: "",
      rating: "",
      description: "",
      streamingPlatforms: []
    });
  };

  return (
    <div className="container mt-4">
      <div className="card shadow p-3">
        <h3 className="mb-3">Movie Form</h3>
        <form onSubmit={handleSubmit}>
          {/* Movie Title */}
          <input
            name="title"
            value={form.title}
            onChange={handleChange}
            placeholder="Movie Title"
            className="form-control mb-2"
            required
          />

          {/* Director */}
          <input
            name="director"
            value={form.director}
            onChange={handleChange}
            placeholder="Director"
            className="form-control mb-2"
            required
          />

          {/* Release Year */}
          <input
            type="number"
            name="year"
            value={form.year}
            onChange={handleChange}
            placeholder="Release Year"
            className="form-control mb-2"
            required
          />

          {/* Genre */}
          <select
            name="genre"
            value={form.genre}
            onChange={handleChange}
            className="form-control mb-2"
            required
          >
            <option value="">-- Select Genre --</option>
            <option>Action</option>
            <option>Comedy</option>
            <option>Drama</option>
            <option>Sci-Fi</option>
            <option>Horror</option>
          </select>

          {/* Rating */}
          <div className="mb-2">
            <label className="fw-bold">Rating:</label>
            <div>
              {[1, 2, 3, 4, 5].map((r) => (
                <div key={r} className="form-check form-check-inline">
                  <input
                    type="radio"
                    name="rating"
                    value={r}
                    checked={form.rating === String(r)}
                    onChange={handleChange}
                    className="form-check-input"
                    id={`rating${r}`}
                  />
                  <label className="form-check-label" htmlFor={`rating${r}`}>
                    {r}
                  </label>
                </div>
              ))}
            </div>
          </div>

          {/* Description */}
          <textarea
            name="description"
            value={form.description}
            onChange={handleChange}
            placeholder="Movie Description"
            className="form-control mb-2"
          />

          {/* Streaming Platforms */}
          <label className="fw-bold">Available On:</label>
          <div className="form-check">
            <input
              type="checkbox"
              value="Netflix"
              checked={form.streamingPlatforms.includes("Netflix")}
              onChange={handleCheckboxChange}
              className="form-check-input"
              id="netflix"
            />
            <label className="form-check-label" htmlFor="netflix">
              Netflix
            </label>
          </div>

          <div className="form-check">
            <input
              type="checkbox"
              value="Amazon Prime"
              checked={form.streamingPlatforms.includes("Amazon Prime")}
              onChange={handleCheckboxChange}
              className="form-check-input"
              id="prime"
            />
            <label className="form-check-label" htmlFor="prime">
              Amazon Prime
            </label>
          </div>

          <div className="form-check">
            <input
              type="checkbox"
              value="Disney+"
              checked={form.streamingPlatforms.includes("Disney+")}
              onChange={handleCheckboxChange}
              className="form-check-input"
              id="disney"
            />
            <label className="form-check-label" htmlFor="disney">
              Disney+
            </label>
          </div>

          <button className="btn btn-primary w-100 mt-3">Add Movie</button>
        </form>
      </div>

      {/* Display Movies */}
      {movies.length > 0 && (
        <table className="table table-bordered table-striped mt-4">
          <thead className="table-dark">
            <tr>
              <th>Title</th>
              <th>Director</th>
              <th>Year</th>
              <th>Genre</th>
              <th>Rating</th>
              <th>Description</th>
              <th>Streaming Platforms</th>
            </tr>
          </thead>
          <tbody>
            {movies.map((m, i) => (
              <tr key={i}>
                <td>{m.title}</td>
                <td>{m.director}</td>
                <td>{m.year}</td>
                <td>{m.genre}</td>
                <td>{m.rating}</td>
                <td>{m.description}</td>
                <td>{m.streamingPlatforms.join(", ")}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default MovieForm;
