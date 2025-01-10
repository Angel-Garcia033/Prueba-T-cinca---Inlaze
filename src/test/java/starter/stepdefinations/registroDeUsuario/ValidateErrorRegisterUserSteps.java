package starter.stepdefinations.registroDeUsuario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.questions.registroDeUsuario.UserRegistrationQuestions;
import starter.ui.registroDeUsuario.UserRegistrationView;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class ValidateErrorRegisterUserSteps {
    // El paso Given se hereda de SuccessfulRegistrationSteps
    // El paso And se hereda de SuccessfulRegistrationSteps
    // El paso When se hereda de SuccessfulRegistrationSteps

    @Then("^el sistema muestra un mensaje de error$")
    public void validateErrorRegisterUser(DataTable dataTable) {
        List<String> caseData = dataTable.asList();
        String expectedMessage = caseData.get(0);

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(UserRegistrationView.ERROR_REGISTRATION_MESSAGE, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserRegistrationView.ERROR_REGISTRATION_MESSAGE)
        );

        theActorInTheSpotlight().should(
                seeThat("Mensaje Usuario no se pudo registrar", UserRegistrationQuestions.errorRegistrationMessage(), equalTo(expectedMessage))
        );
    }

    @Then("^el sistema indica que las contraseñas no coinciden$")
    public void validateErrorPasswwordNotMatch(DataTable dataTable) {
        List<String> caseData = dataTable.asList();
        String expectedMessage = caseData.get(0);

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(UserRegistrationView.PASSWORD_NOT_MATCH_MESSAGE, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserRegistrationView.PASSWORD_NOT_MATCH_MESSAGE)
        );

        theActorInTheSpotlight().should(
                seeThat("Mensaje Contraseñas no coinciden", UserRegistrationQuestions.passwordsNotMatchMessage(), equalTo(expectedMessage))
        );
    }
}