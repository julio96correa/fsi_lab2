# Airline Booking Rules Engine 

Sistema de evaluación de reglas de negocio para reservas aéreas desarrollado con **Spring Boot** y el motor de reglas **Drools 7**. El proyecto automatiza la toma de decisiones complejas basadas en el perfil del pasajero, el estado del vuelo y las restricciones de equipaje.

## Requisitos Técnicos
* **Java:** 17 (Versión requerida por compatibilidad con Drools 7).
* **Gestor de Java:** Se recomienda [SDKMAN!](https://sdkman.io/).
* **IDE:** IntelliJ IDEA.
* **Build Tool:** Maven 3.6+.

## Estructura del Proyecto
* `droolsrules`: código realizado por el profesor en la práctica.
* `airline-project`: Implementación de la lógica de negocio, modelos (POJOs), controladores REST y archivos de reglas (`.drl`).

---

##  Instalación y Configuración

### 1. Entorno de Java
Asegúrate de tener instalada la versión 17. Si usas SDKMAN:
```bash
sdk install java 17.0.10-tem
sdk use java 17.0.10-tem
```
### 2. Ejecución
Desde la raíz del proyecto airline-project:

```bash
mvn clean spring-boot:run
```
La API estará disponible en http://localhost:8080/airline/api/evaluate.

### 3. Pruebas
Puede encontrar una guía de pruebas de Postman en la carpeta /airline-project para probar escenarios como:

* Ascensos VIP por retrasos.
* Restricciones de equipaje en vuelos cortos.
* Descuentos por equipaje ligero.

<img width="415" height="418" alt="image" src="https://github.com/user-attachments/assets/9c55d8e6-0359-4fb3-bcdf-7f74dd1de8d5" />
<img width="415" height="428" alt="image" src="https://github.com/user-attachments/assets/8ffbc842-60f0-480c-adbe-bcd1f23d6eef" />

