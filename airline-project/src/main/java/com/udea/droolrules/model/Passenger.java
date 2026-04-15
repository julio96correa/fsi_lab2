package com.udea.droolrules.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Passenger {

    @NotBlank(message = "El nombre del pasajero no puede estar vacío")
    private String name;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    private int age;

    @NotBlank(message = "El estatus de membresía es obligatorio")
    // Valores válidos: Basic, Silver, Gold, Platinum
    private String membershipStatus;

    private boolean travelingWithChildren;

    // Valores válidos: Window, Aisle, Any
    private String seatPreference;

    // Campos modificados por las reglas
    private int loyaltyPoints;
    private double compensation;
    private boolean vipLoungeAccess;
    private boolean eligibleForUpgrade = true;
    private boolean priorityCheckIn;

    public Passenger() {}

    public Passenger(String name, int age, String membershipStatus,
                     boolean travelingWithChildren, String seatPreference,
                     int loyaltyPoints) {
        this.name = name;
        this.age = age;
        this.membershipStatus = membershipStatus;
        this.travelingWithChildren = travelingWithChildren;
        this.seatPreference = seatPreference;
        this.loyaltyPoints = loyaltyPoints;
        this.eligibleForUpgrade = true;
    }

    // ── Getters & Setters ─────────────────────────────────────────────────────

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getMembershipStatus() { return membershipStatus; }
    public void setMembershipStatus(String membershipStatus) { this.membershipStatus = membershipStatus; }

    public boolean isTravelingWithChildren() { return travelingWithChildren; }
    public void setTravelingWithChildren(boolean travelingWithChildren) { this.travelingWithChildren = travelingWithChildren; }

    public String getSeatPreference() { return seatPreference; }
    public void setSeatPreference(String seatPreference) { this.seatPreference = seatPreference; }

    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }

    public double getCompensation() { return compensation; }
    public void setCompensation(double compensation) { this.compensation = compensation; }

    public boolean isVipLoungeAccess() { return vipLoungeAccess; }
    public void setVipLoungeAccess(boolean vipLoungeAccess) { this.vipLoungeAccess = vipLoungeAccess; }

    public boolean isEligibleForUpgrade() { return eligibleForUpgrade; }
    public void setEligibleForUpgrade(boolean eligibleForUpgrade) { this.eligibleForUpgrade = eligibleForUpgrade; }

    public boolean isPriorityCheckIn() { return priorityCheckIn; }
    public void setPriorityCheckIn(boolean priorityCheckIn) { this.priorityCheckIn = priorityCheckIn; }
}
