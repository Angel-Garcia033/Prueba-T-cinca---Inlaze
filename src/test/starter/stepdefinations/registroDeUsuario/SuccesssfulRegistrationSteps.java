package starter.stepdefinations.registroDeUsuario;

public class SuccesssfulRegistrationSteps {
    @Given("^(.*) tiene acceso al aplicativo$")
    public void openWebApplication (String actor) {
        OnStage.theActorCalled(actor).attemptsTo(Open.browserOn().thePageNamed("pages.Inlaze"));
    }
}