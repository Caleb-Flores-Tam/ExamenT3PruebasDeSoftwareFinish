package com.coudevi.stepdefinitions;

import com.coudevi.tasks.CreateReservation;
import com.coudevi.tasks.DeleteReservation;
import com.coudevi.tasks.EditReservation;
import io.appium.java_client.AppiumBy;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.awaitility.Awaitility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.coudevi.questions.ReservationVisible.withPlaca;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ReservationSteps {

    private Actor usuario;
    @Before
    public void setUp() {
        usuario = Actor.named("Usuario");
        WebDriver driver = getDriver();

        System.out.println("Driver class => " + driver.getClass().getName());

        WebDriver proxied = ((WebDriverFacade) driver).getProxiedDriver();
        System.out.println("Proxied driver => " + proxied.getClass().getName());
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("que el Usuario abrió la app AutoReserva")
    public void que_usuario_abrio_la_app() {

    }
    @Then("debería ver el texto {string}")
    public void deberia_ver_el_texto(String textoEsperado) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//*[@text='" + textoEsperado + "']")
        ));
    }
    @When("crea una reservación con:")
    public void crea_una_reservacion_con(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps();
        Map<String, String> r = rows.get(0);

        usuario.attemptsTo(
                CreateReservation.with(
                        r.get("placa"),
                        r.get("modelo"),
                        r.get("cliente"),
                        r.get("fecha")
                )
        );
    }
    @Then("debería ver la reservación {string} en el listado")
    public void deberia_ver_la_reservacion_en_el_listado(String placa) {
        usuario.attemptsTo(
                Ensure.that(withPlaca(placa)).isTrue()
        );
    }

    @Given("existe una reservación con:")
    public void existe_una_reservacion_con(DataTable dataTable) {
        Map<String, String> r = dataTable.asMaps().get(0);

        usuario.attemptsTo(
                CreateReservation.with(
                        r.get("placa"),
                        r.get("modelo"),
                        r.get("cliente"),
                        r.get("fecha")
                )
        );
    }
    @When("edita la reservación {string} con:")
    public void edita_la_reservacion_con(String placa, DataTable dataTable) {
        Map<String, String> r = dataTable.asMaps().get(0);

        usuario.attemptsTo(
                EditReservation.with(
                        placa,
                        r.get("modelo"),
                        r.get("cliente"),
                        r.get("fecha")
                )
        );
    }

    @When("elimina la reservación {string}")
    public void elimina_la_reservacion(String placa) {
        usuario.attemptsTo(
                DeleteReservation.withPlaca(placa)
        );
    }

    @Then("no debería ver la reservación {string} en el listado")
    public void no_deberia_ver_la_reservacion_en_el_listado(String placa) {

        // Espera activa hasta que ya no exista
        Awaitility.await()
                .atMost(10, TimeUnit.SECONDS)
                .until(() -> !withPlaca(placa).answeredBy(usuario));

        usuario.attemptsTo(
                Ensure.that(withPlaca(placa)).isFalse()
        );
    }




}
