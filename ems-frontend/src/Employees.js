import { useEffect, useState } from "react"
import { Table } from "react-bootstrap";
import Button from 'react-bootstrap/Button';

function App() {
  const [users, setUsers] = useState([])
  const [loading, setLoading] = useState(false)
  useEffect(() => {
    setLoading(true)
    fetch("http://localhost:8080/api/employees")
      .then(response => response.json())
      .then(json => setUsers(json))
      .finally(() => {
        setLoading(false)
      })
  }, [])

    const UpdateEmployee = id => {
      window.location = '/update/'+id
    }

    const EmployeeDelete = id => {
      var data = {
        'id': id
      }
      fetch('http://localhost:8080/api/delete-employee', {
        method: 'DELETE',
        headers: {
          Accept: 'application/form-data',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      })
      .then(res => res.json())
      .then(
        (result) => {
          alert(result['message'])
          if (result['status'] === 'ok') {
              setLoading(true)
              fetch("http://localhost:8080/api/employees")
                .then(response => response.json())
                .then(json => setUsers(json))
                .finally(() => {
                  setLoading(false)
                })
          }
        }
      )
    }

  return (
    <div className="App">
      {loading ? (
        <div>Loading...</div>
      ) : (
        <>
          <h1>Employees</h1>
          <Table bordered hover responsive border={1}>
            <thead>
              <tr>
                <th>Employee ID</th>
                <th>Name</th>
                <th>Email ID</th>
                <th>Action</th>
              </tr>
            </thead>
            {users.map(user => (
              <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.name}</td>
                <td>{user.email}</td>
                <td>
                  <Button variant="warning" onClick={() => UpdateEmployee(user.id)}>Update</Button>{' '}
                  <Button variant="danger" onClick={() => EmployeeDelete(user.id)}>Delete</Button>{' '}
                </td>
              </tr>
            ))}
          </Table>
        </>
      )}
    </div>
  )
}

export default App