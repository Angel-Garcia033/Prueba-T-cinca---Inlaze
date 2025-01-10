package starter.tasks.loginDeUsuario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.loginDeUsuario.UserLoginView;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LogOut implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(UserLoginView.AVATAR_USER_IMAGE, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserLoginView.AVATAR_USER_IMAGE),
                Click.on(UserLoginView.AVATAR_USER_IMAGE),

                Click.on(UserLoginView.LOGOUT_OPTION)
        );
    }
}
