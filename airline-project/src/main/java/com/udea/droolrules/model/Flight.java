package com.udea.droolrules.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Flight {

    @NotBlank(message = "El número de vuelo es obligatorio")
    private String flightNumber;

    @NotNull(message = "Los minutos de retraso son obligatorios")
    @Min(value = 0, message = "Los minutos de retraso no pueden ser negativos")
    private int delayMinutes;

    @NotNull(message = "La duración del vuelo es obligatoria")
    @Min(value = 0, message = "La duración no puede ser negativa")
    private double durationHours;

    private boolean emergencyExitSeatAvailable;

    public Flight() {}

    public Flight(String flightNumber, int delayMinutes,
                  double durationHours, boolean emergencyExitSeatAvailable) {
        this.flightNumber = flightNumber;
        this.delayMinutes = delayMinutes;
        this.durationHours = durationHours;
        this.emergencyExitSeatAvailable = emergencyExitSeatAvailable;
    }

    // ── Getters & Setters ─────────────────────────────────────────────────────

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public int getDelayMinutes() { return delayMinutes; }
    public void setDelayMinutes(int delayMinutes) { this.delayMinutes = delayMinutes; }

    public double getDurationHours() { return durationHours; }
    public void setDurationHours(double durationHours) { this.durationHours = durationHours; }

    public boolean isEmergencyExitSeatAvailable() { return emergencyExitSeatAvailable; }
    public void setEmergencyExitSeatAvailable(boolean emergencyExitSeatAvailable) {
        this.emergencyExitSeatAvailable = emergencyExitSeatAvailable;
    }
}
