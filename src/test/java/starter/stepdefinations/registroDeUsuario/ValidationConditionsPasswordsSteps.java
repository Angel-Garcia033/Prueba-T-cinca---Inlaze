package starter.stepdefinations.registroDeUsuario;

import io.cucumber.java.en.When;
import starter.tasks.registroDeUsuario.FillRegistrationForm;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidationConditionsPasswordsSteps {
    // El paso Given se hereda de SuccessfulRegistrationSteps
    // El paso And se hereda de SuccessfulRegistrationSteps
    // El paso Then se hereda de SuccessfulRegistrationSteps

    @When("^diligencia el formulario de registro con los datos de (.*), (.*), (.*) y (.*)$")
    public void fillRegistrationFormOutline(String fullName, String email, String password, String confirmPassword) {
        theActorInTheSpotlight().attemptsTo(
                FillRegistrationForm.withData(fullName, email, password, confirmPassword)
        );
    }
}