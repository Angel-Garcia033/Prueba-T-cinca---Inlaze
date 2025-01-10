package starter.stepdefinations.registroDeUsuario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.questions.registroDeUsuario.UserRegistrationQuestions;
import starter.tasks.registroDeUsuario.GoToRegistrationForm;
import starter.tasks.registroDeUsuario.SendRegistrationForm;
import starter.ui.registroDeUsuario.UserRegistrationView;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class SuccessfulRegistrationSteps {
    @Given("^(.*) tiene acceso al aplicativo$")
    public void openWebApplication(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(Open.browserOn().thePageNamed("pages.Inlaze"));
    }

    @And("^ingresa al formulario de registro de usuario nuevo$")
    public void goToRegistrationForm() {
        theActorInTheSpotlight().attemptsTo(
                new GoToRegistrationForm()
        );
    }

    @When("^envia el formulario de registro con los datos requeridos$")
    public void sendRegistrationForm(DataTable dataTable) {
        List<Map<String, String>> caseData = dataTable.asMaps();

        for (Map<String, String> data : caseData) {
            String fullName = data.get("Nombre");
            String email = data.get("Correo");
            String password = data.get("Contrasena");
            String confirmPassword = data.get("Confirmar Contrasena");

            theActorInTheSpotlight().attemptsTo(
                    SendRegistrationForm.withData(fullName, email, password, confirmPassword)
            );
        }
    }

    @Then("^el sistema muestra un mensaje de confirmación de registro exitoso$")
    public void validateSuccessRegistration(DataTable dataTable) {
        List<String> caseData = dataTable.asList();
        String expectedMessage = caseData.get(0);

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(UserRegistrationView.SUCCESSFUL_REGISTRATION_MESSAGE, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserRegistrationView.SUCCESSFUL_REGISTRATION_MESSAGE)
        );

        theActorInTheSpotlight().should(
                seeThat("Mensaje Usuario registrado exitosamente", UserRegistrationQuestions.successfulRegistrationMessage(), equalTo(expectedMessage))
        );
    }
}