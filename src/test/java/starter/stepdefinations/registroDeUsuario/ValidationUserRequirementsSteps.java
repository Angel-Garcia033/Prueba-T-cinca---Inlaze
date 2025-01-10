package starter.stepdefinations.registroDeUsuario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.questions.registroDeUsuario.UserRegistrationQuestions;
import starter.tasks.registroDeUsuario.FillRegistrationForm;
import starter.ui.registroDeUsuario.UserRegistrationView;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class ValidationUserRequirementsSteps {
    // El paso Given se hereda de SuccessfulRegistrationSteps
    // El paso And se hereda de SuccessfulRegistrationSteps

    @When("^diligencia el formulario de registro con los datos requeridos$")
    public void fillRegistrationForm(DataTable dataTable) {
        List<Map<String, String>> caseData = dataTable.asMaps();

        for (Map<String, String> data : caseData) {
            String fullName = data.get("Nombre");
            String email = data.get("Correo");
            String password = data.get("Contrasena");
            String confirmPassword = data.get("Confirmar Contrasena");

            theActorInTheSpotlight().attemptsTo(
                    FillRegistrationForm.withData(fullName, email, password, confirmPassword)
            );
        }
    }

    @Then("^comprueba el estado del botón registrar$")
    public void validateSignUpButtonState(DataTable dataTable) {
        List<String> caseData = dataTable.asList();
        Boolean expectedState = Boolean.parseBoolean(caseData.get(0));

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(UserRegistrationView.SIGN_UP_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserRegistrationView.SIGN_UP_BUTTON)
        );

        theActorInTheSpotlight().should(
                seeThat("Estado Boton registrar", UserRegistrationQuestions.stateSignUpButton(), equalTo(expectedState))
        );
    }
}