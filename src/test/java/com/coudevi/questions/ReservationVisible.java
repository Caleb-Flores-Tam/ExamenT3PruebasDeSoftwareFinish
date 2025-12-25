package com.coudevi.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.List;

import static com.coudevi.ui.ReservationListUI.itemWithPlaca;

public class ReservationVisible {
    public static Question<Boolean> withPlaca(String placa) {
        return actor -> {
            List<?> elements =
                    BrowseTheWeb.as(actor)
                            .getDriver()
                            .findElements(itemWithPlaca(placa));

            return !elements.isEmpty();
        };
    }
}
