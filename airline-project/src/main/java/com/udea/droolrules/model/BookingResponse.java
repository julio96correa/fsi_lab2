package com.udea.droolrules.model;

import java.util.ArrayList;
import java.util.List;

public class BookingResponse {

    // Clase asignada: Economy (por defecto), Business
    private String upgradeClass = "Economy";

    // Asiento asignado: puede ser null si no aplica ninguna regla
    private String seatAssigned;

    // Lista de mensajes acumulados de todas las reglas que se activaron
    private List<String> messages = new ArrayList<>();

    // Resumen de beneficios activados
    private boolean priorityCheckIn;
    private boolean vipLoungeAccess;
    private boolean luggageAllowed = true;
    private double discountPercent;
    private double compensation;
    private int bonusLoyaltyPoints;
    private boolean eligibleForUpgrade = true;

    public BookingResponse() {}

    // Método auxiliar para agregar mensajes desde las reglas
    public void addMessage(String message) {
        this.messages.add(message);
    }

    // ── Getters & Setters ─────────────────────────────────────────────────────

    public String getUpgradeClass() { return upgradeClass; }
    public void setUpgradeClass(String upgradeClass) { this.upgradeClass = upgradeClass; }

    public String getSeatAssigned() { return seatAssigned; }
    public void setSeatAssigned(String seatAssigned) { this.seatAssigned = seatAssigned; }

    public List<String> getMessages() { return messages; }
    public void setMessages(List<String> messages) { this.messages = messages; }

    public boolean isPriorityCheckIn() { return priorityCheckIn; }
    public void setPriorityCheckIn(boolean priorityCheckIn) { this.priorityCheckIn = priorityCheckIn; }

    public boolean isVipLoungeAccess() { return vipLoungeAccess; }
    public void setVipLoungeAccess(boolean vipLoungeAccess) { this.vipLoungeAccess = vipLoungeAccess; }

    public boolean isLuggageAllowed() { return luggageAllowed; }
    public void setLuggageAllowed(boolean luggageAllowed) { this.luggageAllowed = luggageAllowed; }

    public double getDiscountPercent() { return discountPercent; }
    public void setDiscountPercent(double discountPercent) { this.discountPercent = discountPercent; }

    public double getCompensation() { return compensation; }
    public void setCompensation(double compensation) { this.compensation = compensation; }

    public int getBonusLoyaltyPoints() { return bonusLoyaltyPoints; }
    public void setBonusLoyaltyPoints(int bonusLoyaltyPoints) { this.bonusLoyaltyPoints = bonusLoyaltyPoints; }

    public boolean isEligibleForUpgrade() { return eligibleForUpgrade; }
    public void setEligibleForUpgrade(boolean eligibleForUpgrade) { this.eligibleForUpgrade = eligibleForUpgrade; }
}
