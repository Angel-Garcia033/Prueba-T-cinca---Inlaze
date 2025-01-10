package starter.tasks.registroDeUsuario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.registroDeUsuario.UserRegistrationView;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SendRegistrationForm implements Task {
    private final String fullName, email, password, confirmPassword;

    public SendRegistrationForm(String fullName, String email, String password, String confirmPassword) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public static SendRegistrationForm withData(String fullName, String email, String password, String confirmPassword) {
        return new SendRegistrationForm(fullName, email, password, confirmPassword);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(UserRegistrationView.NAME_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(UserRegistrationView.NAME_FIELD),
                Enter.theValue(fullName).into(UserRegistrationView.NAME_FIELD),

                Scroll.to(UserRegistrationView.EMAIL_FIELD),
                Enter.theValue(email).into(UserRegistrationView.EMAIL_FIELD),

                Scroll.to(UserRegistrationView.PASSWORD_FIELD),
                Enter.theValue(password).into(UserRegistrationView.PASSWORD_FIELD),

                Scroll.to(UserRegistrationView.CONFIRM_PASSWORD_FIELD),
                Click.on(UserRegistrationView.CONFIRM_PASSWORD_FIELD),
                Enter.theValue(confirmPassword).into(UserRegistrationView.CONFIRM_PASSWORD_FIELD),

                Scroll.to(UserRegistrationView.SIGN_UP_BUTTON),
                Click.on(UserRegistrationView.SIGN_UP_BUTTON)
        );
    }
}
