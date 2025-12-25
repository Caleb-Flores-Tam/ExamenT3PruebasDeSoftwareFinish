package com.coudevi.ui;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ReservationFormUI {

    public static final By INPUT_PLACA =
            AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");

    public static final By INPUT_MODELO =
            AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");

    public static final By INPUT_CLIENTE =
            AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]");

    public static final By INPUT_FECHA =
            AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.EditText[4]");

    public static final By BTN_SAVE =
            AppiumBy.accessibilityId("btn_save_reservation");
}
