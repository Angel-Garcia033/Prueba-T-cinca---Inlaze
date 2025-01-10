package starter.stepdefinations.loginDeUsuario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.questions.loginDeUsuario.UserLoginQuestions;
import starter.tasks.loginDeUsuario.FillLoginForm;
import starter.ui.loginDeUsuario.UserLoginView;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class ValidationFieldsEmptySteps {
    // El paso Given se hereda de SuccessfulRegistrationSteps

    @When("^inicia sesion con los datos de (.*) y (.*)$")
    public void sendLoginFormOutline(String email, String password) {
        theActorInTheSpotlight().attemptsTo(
                FillLoginForm.withData(email, password)
        );
    }

    @Then("^comprueba el estado del botón iniciar sesion$")
    public void validateStateLoginButton(DataTable dataTable) {
        List<String> caseData = dataTable.asList();
        Boolean expectedState = Boolean.parseBoolean(caseData.get(0));

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(UserLoginView.SIGN_IN_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserLoginView.SIGN_IN_BUTTON)
        );

        theActorInTheSpotlight().should(
                seeThat("Estado Boton Sign In", UserLoginQuestions.stateSignInButton(), equalTo(expectedState))
        );
    }
}