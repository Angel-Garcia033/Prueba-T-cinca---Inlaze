package starter.tasks.registroDeUsuario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.registroDeUsuario.UserRegistrationView;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToRegistrationForm implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(UserRegistrationView.SIGN_UP_OPTION, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserRegistrationView.SIGN_UP_OPTION),
                Click.on(UserRegistrationView.SIGN_UP_OPTION)
        );
    }
}
