package com.udea.droolrules.service;

import com.udea.droolrules.model.BookingRequest;
import com.udea.droolrules.model.BookingResponse;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineBookingService {

    @Autowired
    private KieContainer kieContainer;

    /**
     * Evalúa una solicitud de reserva de aerolínea aplicando las reglas Drools.
     * Inserta el BookingRequest y el BookingResponse como hechos en la sesión,
     * ejecuta todas las reglas y retorna la respuesta enriquecida.
     *
     * @param request La solicitud de reserva con datos del pasajero, vuelo y equipaje.
     * @return BookingResponse con todas las decisiones aplicadas por las reglas.
     */
    public BookingResponse evaluateBooking(BookingRequest request) {
        // Crear la respuesta inicial con valores por defecto
        BookingResponse response = new BookingResponse();

        // Crear una nueva sesión Drools (con estado = stateful)
        KieSession kieSession = kieContainer.newKieSession();

        try {
            // Insertar los hechos en la memoria de trabajo de Drools
            kieSession.insert(request);
            kieSession.insert(response);

            // Ejecutar todas las reglas que coincidan con los hechos insertados
            kieSession.fireAllRules();

        } finally {
            // Siempre liberar la sesión para evitar fugas de memoria
            kieSession.dispose();
        }

        return response;
    }
}
