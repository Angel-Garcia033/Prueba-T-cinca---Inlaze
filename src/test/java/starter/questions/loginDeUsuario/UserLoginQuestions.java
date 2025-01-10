package starter.questions.loginDeUsuario;

import net.serenitybdd.screenplay.Question;
import starter.ui.loginDeUsuario.UserLoginView;

public class UserLoginQuestions {
    public static Question<Boolean> stateSignInButton() {
        return actor -> UserLoginView.SIGN_IN_BUTTON.resolveFor(actor).isEnabled();
    }
    public static Question<String> nameUserText() {
        return actor -> UserLoginView.NAME_USER_TEXT.resolveFor(actor).getText();
    }
    public static Question<String> errorLoginMessage() {
        return actor -> UserLoginView.ERROR_LOGIN_MESSAGE.resolveFor(actor).getText();
    }
    public static Question<String> signInTitle() {
        return actor -> UserLoginView.SIGN_IN_TITLE.resolveFor(actor).getText();
    }
}
