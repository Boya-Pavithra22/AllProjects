// src/components/FootballPlayer.js
import React, { useEffect, useState } from "react";
import axios from "axios";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import { Table, Button } from "react-bootstrap";

// ✅ Validation schema using Yup
const PlayerSchema = Yup.object().shape({
  name: Yup.string().min(3, "At least 3 chars").required("Required"),
  age: Yup.number().min(16).max(40).required("Required"),
  position: Yup.string().required("Required"),
  club: Yup.string().required("Required"),
  nationality: Yup.string().required("Required"),
  goals: Yup.number().min(0).required("Required"),
  matchesPlayed: Yup.number().min(0).required("Required"),
  jerseyNumber: Yup.number().min(1).max(99).required("Required"),
  email: Yup.string().email("Invalid email").required("Required"),
  contactNumber: Yup.string()
    .matches(/^[0-9]{10}$/, "Must be 10 digits")
    .required("Required"),
});

function FootballPlayer() {
  const [players, setPlayers] = useState([]);
  const [editingPlayer, setEditingPlayer] = useState(null);

  // ✅ Load players on mount
  useEffect(() => {
    fetchPlayers();
  }, []);

  const fetchPlayers = async () => {
    const res = await axios.get("http://localhost:5001/FootballPlayers");
    setPlayers(res.data);
  };

  // ✅ Add player
  const addPlayer = async (player, { resetForm }) => {
    await axios.post("http://localhost:5001/FootballPlayers", player);
    fetchPlayers();
    resetForm();
  };

  // ✅ Update player
  const updatePlayer = async (player) => {
    await axios.put(`http://localhost:5001/FootballPlayers/${player.id}`, player);
    fetchPlayers();
    setEditingPlayer(null);
  };

  // ✅ Delete player
  const deletePlayer = async (id) => {
    await axios.delete(`http://localhost:5001/FootballPlayers/${id}`);
    fetchPlayers();
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-3">⚽ Football Player Management</h2>

      {/* Formik Form */}
      <Formik
        initialValues={
          editingPlayer || {
            name: "",
            age: "",
            position: "",
            club: "",
            nationality: "",
            goals: "",
            matchesPlayed: "",
            jerseyNumber: "",
            email: "",
            contactNumber: "",
          }
        }
        validationSchema={PlayerSchema}
        enableReinitialize
        onSubmit={editingPlayer ? updatePlayer : addPlayer}
      >
        {({ isSubmitting }) => (
          <Form className="p-3 border rounded bg-light">
            {[
              "name",
              "age",
              "position",
              "club",
              "nationality",
              "goals",
              "matchesPlayed",
              "jerseyNumber",
              "email",
              "contactNumber",
            ].map((field) => (
              <div className="mb-2" key={field}>
                <label className="form-label text-capitalize">{field}</label>
                <Field
                  className="form-control"
                  type={field === "email" ? "email" : "text"}
                  name={field}
                />
                <ErrorMessage
                  name={field}
                  component="div"
                  className="text-danger small"
                />
              </div>
            ))}
            <Button type="submit" disabled={isSubmitting}>
              {editingPlayer ? "Update Player" : "Add Player"}
            </Button>
            {editingPlayer && (
              <Button
                variant="secondary"
                className="ms-2"
                onClick={() => setEditingPlayer(null)}
              >
                Cancel
              </Button>
            )}
          </Form>
        )}
      </Formik>

      {/* Players Table */}
      <Table striped bordered hover className="mt-4">
        <thead>
          <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Position</th>
            <th>Club</th>
            <th>Goals</th>
            <th>Matches</th>
            <th>Jersey</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {players.map((p) => (
            <tr key={p.id}>
              <td>{p.name}</td>
              <td>{p.age}</td>
              <td>{p.position}</td>
              <td>{p.club}</td>
              <td>{p.goals}</td>
              <td>{p.matchesPlayed}</td>
              <td>{p.jerseyNumber}</td>
              <td>{p.email}</td>
              <td>{p.contactNumber}</td>
              <td>
                <Button
                  variant="warning"
                  size="sm"
                  onClick={() => setEditingPlayer(p)}
                >
                  Edit
                </Button>{" "}
                <Button
                  variant="danger"
                  size="sm"
                  onClick={() => deletePlayer(p.id)}
                >
                  Delete
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}

export default FootballPlayer;
