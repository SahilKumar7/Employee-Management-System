import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';

function Navigationbar() {
  return (
    <Container>
      <Navbar expand="lg" className="bg-body-tertiary" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="#">Employee Management System</Navbar.Brand>
        </Container>
      </Navbar>
    </Container>
  );
}

export default Navigationbar;