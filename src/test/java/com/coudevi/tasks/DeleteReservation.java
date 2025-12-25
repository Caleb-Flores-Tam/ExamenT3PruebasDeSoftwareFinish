package com.coudevi.tasks;

import com.coudevi.interactions.TapOn;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static com.coudevi.ui.ReservationListUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteReservation implements Task {

    private final String placa;

    public DeleteReservation(String placa) {
        this.placa = placa;
    }

    public static DeleteReservation withPlaca(String placa) {
        return instrumented(DeleteReservation.class, placa);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                TapOn.element(itemWithPlaca(placa)),
                TapOn.element(BTN_DELETE)
        );
    }


}
