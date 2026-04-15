# Aerolínea Drools — Guía de Pruebas en Postman

## Configuración General
- **Método:** POST  
- **URL:** `http://localhost:8080/airline/api/evaluate`  
- **Header:** `Content-Type: application/json`

---

## Prueba 1 — UpgradeToBusinessClassForFrequentFlyersWithDelays
**Condición:** Pasajero Gold/Platinum con retraso > 60 min → Upgrade a Business

```json
{
  "passenger": {
    "name": "Carlos Restrepo",
    "age": 42,
    "membershipStatus": "Gold",
    "travelingWithChildren": false,
    "seatPreference": "Window",
    "loyaltyPoints": 1200
  },
  "flight": {
    "flightNumber": "AV301",
    "delayMinutes": 90,
    "durationHours": 3.5,
    "emergencyExitSeatAvailable": false
  },
  "luggage": {
    "weightKg": 18.0
  }
}
```
**Resultado esperado:** `upgradeClass: "Business"`, mensaje de regla 1 activada.

---

## Prueba 2 — PriorityCheckInForSeniors
**Condición:** Pasajero mayor de 65 años → check-in prioritario

```json
{
  "passenger": {
    "name": "Rosa Martínez",
    "age": 70,
    "membershipStatus": "Basic",
    "travelingWithChildren": false,
    "seatPreference": "Aisle",
    "loyaltyPoints": 0
  },
  "flight": {
    "flightNumber": "AV102",
    "delayMinutes": 0,
    "durationHours": 1.5,
    "emergencyExitSeatAvailable": false
  },
  "luggage": {
    "weightKg": 12.0
  }
}
```
**Resultado esperado:** `priorityCheckIn: true`, mensaje de regla 2 activada.

---

## Prueba 3 — DiscountForLightLuggage
**Condición:** Equipaje < 10 kg → descuento del 10%

```json
{
  "passenger": {
    "name": "Andrés López",
    "age": 30,
    "membershipStatus": "Silver",
    "travelingWithChildren": false,
    "seatPreference": "Window",
    "loyaltyPoints": 300
  },
  "flight": {
    "flightNumber": "AV205",
    "delayMinutes": 10,
    "durationHours": 2.0,
    "emergencyExitSeatAvailable": false
  },
  "luggage": {
    "weightKg": 7.5
  }
}
```
**Resultado esperado:** `discountPercent: 10.0`, mensaje de regla 3 activada.

---

## Prueba 4 — DenyUpgradeForOverweightLuggage
**Condición:** Equipaje > 23 kg → no elegible para ascenso

```json
{
  "passenger": {
    "name": "Juliana Soto",
    "age": 35,
    "membershipStatus": "Gold",
    "travelingWithChildren": false,
    "seatPreference": "Any",
    "loyaltyPoints": 800
  },
  "flight": {
    "flightNumber": "AV410",
    "delayMinutes": 30,
    "durationHours": 4.0,
    "emergencyExitSeatAvailable": false
  },
  "luggage": {
    "weightKg": 25.0
  }
}
```
**Resultado esperado:** `eligibleForUpgrade: false`, mensaje de regla 4 activada.

---

## Prueba 5 — AssignEmergencyExitSeatToYoungAdults
**Condición:** 18-40 años, seatPreference "Any", asiento de emergencia disponible

```json
{
  "passenger": {
    "name": "Miguel Torres",
    "age": 25,
    "membershipStatus": "Basic",
    "travelingWithChildren": false,
    "seatPreference": "Any",
    "loyaltyPoints": 0
  },
  "flight": {
    "flightNumber": "AV515",
    "delayMinutes": 0,
    "durationHours": 3.0,
    "emergencyExitSeatAvailable": true
  },
  "luggage": {
    "weightKg": 11.0
  }
}
```
**Resultado esperado:** `seatAssigned: "Emergency-Exit-Row"`, mensaje de regla 5 activada.

---

## Prueba 6 — CompensationForExtremeDelays
**Condición:** Retraso > 180 minutos → compensación de $200

```json
{
  "passenger": {
    "name": "Sara Gómez",
    "age": 28,
    "membershipStatus": "Silver",
    "travelingWithChildren": false,
    "seatPreference": "Window",
    "loyaltyPoints": 500
  },
  "flight": {
    "flightNumber": "AV620",
    "delayMinutes": 210,
    "durationHours": 5.0,
    "emergencyExitSeatAvailable": false
  },
  "luggage": {
    "weightKg": 14.0
  }
}
```
**Resultado esperado:** `compensation: 200.0`, mensaje de regla 6 activada.

---

## Prueba 7 — ExtraLoyaltyPointsForLongFlights
**Condición:** Membresía != Basic y vuelo > 5 horas → +500 puntos

```json
{
  "passenger": {
    "name": "Felipe Ríos",
    "age": 45,
    "membershipStatus": "Gold",
    "travelingWithChildren": false,
    "seatPreference": "Aisle",
    "loyaltyPoints": 2000
  },
  "flight": {
    "flightNumber": "AV725",
    "delayMinutes": 20,
    "durationHours": 6.5,
    "emergencyExitSeatAvailable": false
  },
  "luggage": {
    "weightKg": 20.0
  }
}
```
**Resultado esperado:** `bonusLoyaltyPoints: 500`, mensaje de regla 7 activada.

---

## Prueba 8 — RestrictLuggageOnShortFlights
**Condición:** Equipaje > 15 kg y vuelo < 2 horas → equipaje no permitido

```json
{
  "passenger": {
    "name": "Valentina Cruz",
    "age": 33,
    "membershipStatus": "Basic",
    "travelingWithChildren": false,
    "seatPreference": "Window",
    "loyaltyPoints": 0
  },
  "flight": {
    "flightNumber": "AV830",
    "delayMinutes": 0,
    "durationHours": 1.2,
    "emergencyExitSeatAvailable": false
  },
  "luggage": {
    "weightKg": 18.0
  }
}
```
**Resultado esperado:** `luggageAllowed: false`, mensaje de regla 8 activada.

---

## Prueba 9 — VipLoungeAccessForPlatinumMembers
**Condición:** Membresía Platinum → acceso al salón VIP

```json
{
  "passenger": {
    "name": "Diego Herrera",
    "age": 50,
    "membershipStatus": "Platinum",
    "travelingWithChildren": false,
    "seatPreference": "Aisle",
    "loyaltyPoints": 5000
  },
  "flight": {
    "flightNumber": "AV940",
    "delayMinutes": 15,
    "durationHours": 4.0,
    "emergencyExitSeatAvailable": false
  },
  "luggage": {
    "weightKg": 22.0
  }
}
```
**Resultado esperado:** `vipLoungeAccess: true`, mensaje de regla 9 activada.

---

## Prueba 10 — PreferentialSeatForFamilies
**Condición:** Viajando con niños y seatPreference "Any" → asiento familiar

```json
{
  "passenger": {
    "name": "Laura Peña",
    "age": 38,
    "membershipStatus": "Silver",
    "travelingWithChildren": true,
    "seatPreference": "Any",
    "loyaltyPoints": 600
  },
  "flight": {
    "flightNumber": "AV1050",
    "delayMinutes": 5,
    "durationHours": 2.5,
    "emergencyExitSeatAvailable": false
  },
  "luggage": {
    "weightKg": 13.0
  }
}
```
**Resultado esperado:** `seatAssigned: "FamilyZone-A1"`, mensaje de regla 10 activada.

---

## Prueba Combinada — Múltiples reglas activas
**Pasajero Platinum, vuelo muy demorado, equipaje ligero, vuelo largo**

```json
{
  "passenger": {
    "name": "Camilo Vargas",
    "age": 45,
    "membershipStatus": "Platinum",
    "travelingWithChildren": false,
    "seatPreference": "Window",
    "loyaltyPoints": 3000
  },
  "flight": {
    "flightNumber": "AV9999",
    "delayMinutes": 200,
    "durationHours": 7.0,
    "emergencyExitSeatAvailable": false
  },
  "luggage": {
    "weightKg": 8.0
  }
}
```
**Resultado esperado:** Se activan reglas 1 (upgrade Business), 3 (descuento 10%), 6 (compensación $200), 7 (+500 puntos) y 9 (acceso VIP). Todos los mensajes aparecen en el array `messages`.
