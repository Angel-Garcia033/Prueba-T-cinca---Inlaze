package starter.stepdefinations.loginDeUsuario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.questions.loginDeUsuario.UserLoginQuestions;
import starter.tasks.loginDeUsuario.LogOut;
import starter.ui.loginDeUsuario.UserLoginView;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class SuccessfulLogoutSteps {
    // El paso Given se hereda de SuccessfulRegistrationSteps
    // El paso And se hereda de SuccessfulLoginSteps

    @When("^el usuario cierra sesion de si perfil$")
    public void sendLoginForm() {
        theActorInTheSpotlight().attemptsTo(
                new LogOut()
        );
    }

    @Then("^el sistema muestra la pantalla de login$")
    public void validateSuccessLogin(DataTable dataTable) {
        List<String> caseData = dataTable.asList();
        String expectedTitle = caseData.get(0);

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(UserLoginView.SIGN_IN_TITLE, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserLoginView.SIGN_IN_TITLE)
        );

        theActorInTheSpotlight().should(
                seeThat("Título Sign in", UserLoginQuestions.signInTitle(), equalTo(expectedTitle))
        );
    }
}