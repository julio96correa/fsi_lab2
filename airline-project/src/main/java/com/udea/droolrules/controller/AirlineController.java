package com.udea.droolrules.controller;

import com.udea.droolrules.model.BookingRequest;
import com.udea.droolrules.model.BookingResponse;
import com.udea.droolrules.service.AirlineBookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineBookingService bookingService;

    /**
     * Endpoint principal para evaluar una reserva de aerolínea.
     * Método: POST
     * URL:    http://localhost:8080/airline/api/evaluate
     * Body:   JSON con BookingRequest (passenger, flight, luggage)
     *
     * Si hay errores de validación, retorna un BookingResponse con el mensaje de error.
     * Si la validación pasa, delega al servicio para ejecutar las reglas Drools.
     */
    @PostMapping("/api/evaluate")
    public BookingResponse evaluateBooking(
            @Valid @RequestBody BookingRequest request,
            BindingResult result) {

        // Verificar errores de validación de Jakarta Bean Validation
        if (result.hasErrors()) {
            String errorMessages = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                    .orElse("Error de validación desconocido");

            BookingResponse errorResponse = new BookingResponse();
            errorResponse.addMessage("Error de validación: " + errorMessages);
            errorResponse.setLuggageAllowed(false);
            return errorResponse;
        }

        // Delegar al servicio de evaluación con Drools
        return bookingService.evaluateBooking(request);
    }
}
