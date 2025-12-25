package com.coudevi.tasks;

import com.coudevi.interactions.TapOn;
import com.coudevi.interactions.TypeInto;
import com.coudevi.interactions.WaitUntilVisible;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static com.coudevi.ui.ReservationFormUI.*;
import static com.coudevi.ui.ReservationFormUI.BTN_SAVE;
import static com.coudevi.ui.ReservationFormUI.INPUT_FECHA;
import static com.coudevi.ui.ReservationListUI.BTN_ADD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateReservation implements Task {
    private final String placa;
    private final String modelo;
    private final String cliente;
    private final String fecha;

    public CreateReservation(String placa, String modelo, String cliente, String fecha) {
        this.placa = placa;
        this.modelo = modelo;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public static CreateReservation with(String placa, String modelo, String cliente, String fecha) {
        return instrumented(CreateReservation.class, placa, modelo, cliente, fecha);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                TapOn.element(BTN_ADD),
                WaitUntilVisible.element(INPUT_PLACA),
                TypeInto.element(INPUT_PLACA, placa),
                TypeInto.element(INPUT_MODELO, modelo),
                TypeInto.element(INPUT_CLIENTE, cliente),
                TypeInto.element(INPUT_FECHA, fecha),
                TapOn.element(BTN_SAVE)
        );
    }



}
