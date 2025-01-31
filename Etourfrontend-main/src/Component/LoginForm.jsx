import React, { useState } from 'react';
import { Form, Button, Container, Row, Col } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

const LoginForm = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const navigate = useNavigate();

    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*(),.?":{}|<>]).{8,16}$/;

    function passValidation(e) {
        const value = e.target.value;
        setPassword(value);
        if (passwordRegex.test(value)) {
            setErrorMessage('');
        } else {
            setErrorMessage('Invalid password.');
        }
    }

    const handleSubmit = (e) => {
        e.preventDefault();
    
        fetch('http://localhost:8086/api/customers/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email, password }),
        })
        .then((response) => {
            if (response.ok) {
                return response.text(); // Returns the success message
            } else if (response.status === 401) {
                return response.text().then((error) => {
                    throw new Error(error || 'Invalid credentials');
                });
            } else {
                throw new Error('Something went wrong. Please try again later.');
            }
        })
        .then((data) => {
            alert('Login successful!');
            navigate('/dashboard');
        })
        .catch((error) => {
            console.error('Error:', error);
            setErrorMessage(error.message || 'Something went wrong. Please try again later.');
        });
    };
    

    return (
        <Container className="d-flex justify-content-center align-items-center vh-100">
            <div style={{ width: '30%' }}>
                <Row>
                    <Col md={12}>
                        <h3 className="text-center mb-4">Login</h3>
                        <Form onSubmit={handleSubmit}>
                            <Form.Group className="mb-3" controlId="formBasicEmail">
                                <Form.Label>Email address</Form.Label>
                                <Form.Control
                                    type="email"
                                    placeholder="Enter email"
                                    value={email}
                                    onChange={(e) => setEmail(e.target.value)}
                                    required
                                />
                            </Form.Group>

                            <Form.Group className="mb-3" controlId="formBasicPassword">
                                <Form.Label>Password</Form.Label>
                                <Form.Control
                                    type="password"
                                    placeholder="Password"
                                    value={password}
                                    onChange={passValidation}
                                    required
                                />
                                {errorMessage && <span className="text-danger">{errorMessage}</span>}
                            </Form.Group>

                            <Button variant="primary" type="submit" className="w-100">
                                Login
                            </Button>

                            <div className="text-center mt-3">
                                <span
                                    className="text-muted"
                                    style={{ fontSize: '0.8rem', cursor: 'pointer', textDecoration: 'underline' }}
                                    onClick={() => navigate('/register')}
                                >
                                    Register
                                </span>
                            </div>
                        </Form>
                    </Col>
                </Row>
            </div>
        </Container>
    );
};

export default LoginForm;

