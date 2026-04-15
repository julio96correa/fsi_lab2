package com.udea.droolrules.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Luggage {

    @NotNull(message = "El peso del equipaje es obligatorio")
    @Min(value = 0, message = "El peso no puede ser negativo")
    private double weightKg;

    // Modificado por las reglas: true = equipaje permitido, false = no permitido
    private boolean allowed = true;

    // Descuento aplicado (en porcentaje)
    private double discountPercent = 0.0;

    public Luggage() {}

    public Luggage(double weightKg) {
        this.weightKg = weightKg;
        this.allowed = true;
    }

    // ── Getters & Setters ─────────────────────────────────────────────────────

    public double getWeightKg() { return weightKg; }
    public void setWeightKg(double weightKg) { this.weightKg = weightKg; }

    public boolean isAllowed() { return allowed; }
    public void setAllowed(boolean allowed) { this.allowed = allowed; }

    public double getDiscountPercent() { return discountPercent; }
    public void setDiscountPercent(double discountPercent) { this.discountPercent = discountPercent; }
}
