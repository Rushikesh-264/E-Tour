import React, { useState } from "react";
import { Container, Form, Button, Row, Col, Card, Alert, InputGroup } from "react-bootstrap"; // Add InputGroup here
import {
  FaCcVisa,
  FaCcMastercard,
  FaCcAmex,
  FaCcDiscover,
  FaCreditCard,
} from "react-icons/fa";
import "bootstrap/dist/css/bootstrap.min.css";
import "./PaymentPage.css"; // Custom CSS file
import { useNavigate } from "react-router-dom";


const PaymentPage = () => {
  const [cardNumber, setCardNumber] = useState("");
  const [expiryDate, setExpiryDate] = useState("");
  const [cvv, setCvv] = useState("");
  const [cardholderName, setCardholderName] = useState("");
  const [paymentMethod, setPaymentMethod] = useState("card");
  const [error, setError] = useState("");
  const navigate= useNavigate()
  const validateCardNumber = (number) => {
    return /^\d{16}$/.test(number); // Simple validation for 16 digits
  };

  const validateExpiryDate = (date) => {
    return /^(0[1-9]|1[0-2])\/\d{2}$/.test(date); // MM/YY format
  };

  const validateCVV = (cvv) => {
    return /^\d{3,4}$/.test(cvv); // 3 or 4 digits
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!validateCardNumber(cardNumber)) {
      setError("Invalid card number. Please enter a 16-digit number.");
      return;
    }

    if (!validateExpiryDate(expiryDate)) {
      setError("Invalid expiry date. Please use MM/YY format.");
      return;
    }

    if (!validateCVV(cvv)) {
      setError("Invalid CVV. Please enter 3 or 4 digits.");
      return;
    }

    if (!cardholderName.trim()) {
      setError("Please enter the cardholder's name.");
      return;
    }

    setError("");
    alert("Payment successful! Thank you for your purchase.");
    // Add your payment processing logic here
    navigate('/dashboard');
  };

  return (
    <div className="payment-page">
      <Container>
        <Row className="justify-content-center">
          <Col md={8} lg={6}>
            <Card className="payment-card">
              <Card.Body>
                <h2 className="text-center mb-4">Payment Details</h2>
                {error && <Alert variant="danger">{error}</Alert>}

                <Form onSubmit={handleSubmit}>
                  {/* Payment Method Toggle */}
                  <div className="payment-method-toggle mb-4">
                    <Button
                      variant={paymentMethod === "card" ? "primary" : "outline-primary"}
                      onClick={() => setPaymentMethod("card")}
                      className="me-2"
                    >
                      <FaCreditCard className="me-2" />
                      Credit/Debit Card
                    </Button>
                    <Button
                      variant={paymentMethod === "other" ? "primary" : "outline-primary"}
                      onClick={() => setPaymentMethod("other")}
                    >
                      Other Payment
                    </Button>
                  </div>

                  {/* Card Details */}
                  {paymentMethod === "card" && (
                    <>
                      <Form.Group className="mb-3">
                        <Form.Label>Card Number</Form.Label>
                        <InputGroup>
                          <Form.Control
                            type="text"
                            placeholder="1234 5678 9012 3456"
                            value={cardNumber}
                            onChange={(e) => setCardNumber(e.target.value)}
                            maxLength={16}
                            required
                          />
                          <InputGroup.Text>
                            {cardNumber.startsWith("4") ? (
                              <FaCcVisa size={24} />
                            ) : cardNumber.startsWith("5") ? (
                              <FaCcMastercard size={24} />
                            ) : cardNumber.startsWith("3") ? (
                              <FaCcAmex size={24} />
                            ) : cardNumber.startsWith("6") ? (
                              <FaCcDiscover size={24} />
                            ) : (
                              <FaCreditCard size={24} />
                            )}
                          </InputGroup.Text>
                        </InputGroup>
                      </Form.Group>

                      <Row className="mb-3">
                        <Col>
                          <Form.Group>
                            <Form.Label>Expiry Date</Form.Label>
                            <Form.Control
                              type="text"
                              placeholder="MM/YY"
                              value={expiryDate}
                              onChange={(e) => setExpiryDate(e.target.value)}
                              maxLength={5}
                              required
                            />
                          </Form.Group>
                        </Col>
                        <Col>
                          <Form.Group>
                            <Form.Label>CVV</Form.Label>
                            <Form.Control
                              type="text"
                              placeholder="123"
                              value={cvv}
                              onChange={(e) => setCvv(e.target.value)}
                              maxLength={4}
                              required
                            />
                          </Form.Group>
                        </Col>
                      </Row>

                      <Form.Group className="mb-4">
                        <Form.Label>Cardholder Name</Form.Label>
                        <Form.Control
                          type="text"
                          placeholder="John Doe"
                          value={cardholderName}
                          onChange={(e) => setCardholderName(e.target.value)}
                          required
                        />
                      </Form.Group>
                    </>
                  )}

                  {/* Other Payment Methods */}
                  {paymentMethod === "other" && (
                    <div className="text-center">
                      <p>Other payment methods (e.g., PayPal, Apple Pay) will be added soon.</p>
                    </div>
                  )}

                  {/* Submit Button */}
                  <Button variant="primary" type="submit" className="w-100">
                    Pay Now
                  </Button>
                </Form>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default PaymentPage;