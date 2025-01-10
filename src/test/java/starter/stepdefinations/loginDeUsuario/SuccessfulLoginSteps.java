package starter.stepdefinations.loginDeUsuario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.questions.loginDeUsuario.UserLoginQuestions;
import starter.tasks.loginDeUsuario.SendLoginForm;
import starter.ui.loginDeUsuario.UserLoginView;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class SuccessfulLoginSteps {
    // El paso Given se hereda de SuccessfulRegistrationSteps

    @When("^inicia sesion con las credenciales requeridas$")
    public void sendLoginForm(DataTable dataTable) {
        List<Map<String, String>> caseData = dataTable.asMaps();

        for (Map<String, String> data : caseData) {
            String email = data.get("Correo");
            String password = data.get("Contrasena");

            theActorInTheSpotlight().attemptsTo(
                    SendLoginForm.withData(email, password)
            );
        }
    }

    @Then("^el sistema muestra el nombre del usuario en la pantalla principal$")
    public void validateSuccessLogin(DataTable dataTable) {
        List<String> caseData = dataTable.asList();
        String expectedName = caseData.get(0);

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(UserLoginView.NAME_USER_TEXT, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserLoginView.NAME_USER_TEXT)
        );

        theActorInTheSpotlight().should(
                seeThat("Mensaje Usuario registrado exitosamente", UserLoginQuestions.nameUserText(), equalTo(expectedName))
        );
    }
}