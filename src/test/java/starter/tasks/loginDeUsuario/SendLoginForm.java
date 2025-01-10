package starter.tasks.loginDeUsuario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.loginDeUsuario.UserLoginView;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SendLoginForm implements Task {
    private final String email, password;

    public SendLoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static SendLoginForm withData(String email, String password) {
        return new SendLoginForm(email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(UserLoginView.EMAIL_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserLoginView.EMAIL_FIELD),
                Enter.theValue(email).into(UserLoginView.EMAIL_FIELD),

                Scroll.to(UserLoginView.PASSWORD_FIELD),
                Click.on(UserLoginView.PASSWORD_FIELD),
                Enter.theValue(password).into(UserLoginView.PASSWORD_FIELD),

                Scroll.to(UserLoginView.SIGN_IN_BUTTON),
                Click.on(UserLoginView.SIGN_IN_BUTTON)
        );
    }
}
