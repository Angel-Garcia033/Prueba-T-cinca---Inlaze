package starter.questions.registroDeUsuario;

import net.serenitybdd.screenplay.Question;
import starter.ui.registroDeUsuario.UserRegistrationView;

public class UserRegistrationQuestions {
    public static Question<String> successfulRegistrationMessage() {
        return actor -> UserRegistrationView.SUCCESSFUL_REGISTRATION_MESSAGE.resolveFor(actor).getText();
    }
    public static Question<Boolean> stateSignUpButton() {
        return actor -> UserRegistrationView.SIGN_UP_BUTTON.resolveFor(actor).isEnabled();
    }
    public static Question<String> errorRegistrationMessage() {
        return actor -> UserRegistrationView.ERROR_REGISTRATION_MESSAGE.resolveFor(actor).getText();
    }
    public static Question<String> passwordsNotMatchMessage() {
        return actor -> UserRegistrationView.PASSWORD_NOT_MATCH_MESSAGE.resolveFor(actor).getText();
    }
}
