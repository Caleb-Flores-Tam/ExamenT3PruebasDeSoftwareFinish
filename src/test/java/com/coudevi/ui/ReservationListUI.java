package com.coudevi.ui;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ReservationListUI {
    public static final By BTN_ADD =
            AppiumBy.accessibilityId("fab_add_reservation");

    public static By itemWithPlaca(String placa) {
        return AppiumBy.xpath("//*[contains(@text,'" + placa + "')]");
    }

    public static final By BTN_EDIT =
            AppiumBy.accessibilityId("btn_edit_reservation");

    public static final By BTN_DELETE =
            AppiumBy.accessibilityId("btn_delete_reservation");


}
