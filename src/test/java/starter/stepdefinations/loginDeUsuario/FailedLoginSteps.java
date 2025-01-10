package starter.stepdefinations.loginDeUsuario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.questions.loginDeUsuario.UserLoginQuestions;
import starter.ui.loginDeUsuario.UserLoginView;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class FailedLoginSteps {
    // El paso Given se hereda de SuccessfulRegistrationSteps
    // El paso When se hereda de SuccessfulLoginSteps

    @Then("^el sistema muestra un mensaje de error em la pantalla de login$")
    public void validateFailedLogin(DataTable dataTable) {
        List<String> caseData = dataTable.asList();
        String expectedMessage = caseData.get(0);

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(UserLoginView.ERROR_LOGIN_MESSAGE, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserLoginView.ERROR_LOGIN_MESSAGE)
        );

        theActorInTheSpotlight().should(
                seeThat("Mensaje Usuario no pudo iniciar sesión", UserLoginQuestions.errorLoginMessage(), equalTo(expectedMessage))
        );
    }
}