package com.udea.droolrules.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class BookingRequest {

    @NotNull(message = "El pasajero es obligatorio")
    @Valid
    private Passenger passenger;

    @NotNull(message = "El vuelo es obligatorio")
    @Valid
    private Flight flight;

    @NotNull(message = "El equipaje es obligatorio")
    @Valid
    private Luggage luggage;

    public BookingRequest() {}

    public BookingRequest(Passenger passenger, Flight flight, Luggage luggage) {
        this.passenger = passenger;
        this.flight = flight;
        this.luggage = luggage;
    }

    // ── Getters & Setters ─────────────────────────────────────────────────────

    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }

    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }

    public Luggage getLuggage() { return luggage; }
    public void setLuggage(Luggage luggage) { this.luggage = luggage; }
}
