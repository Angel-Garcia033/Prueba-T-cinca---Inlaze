package starter.ui.loginDeUsuario;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserLoginView {
    public static final Target EMAIL_FIELD = Target.the("Campo Correo")
            .located(By.id("email"));
    public static final Target PASSWORD_FIELD = Target.the("Campo Contraseña")
            .located(By.xpath("//input[@type='password'][1]"));
    public static final Target SIGN_IN_BUTTON = Target.the("Boton Sign in")
            .located(By.xpath("//button[contains(text(),' Sign in ')]"));
    public static final Target NAME_USER_TEXT = Target.the("Texto Nombre del usuario")
            .located(By.xpath("/html/body/app-root/app-panel-root/app-navbar/div/div[2]/div/div/h2"));
    public static final Target ERROR_LOGIN_MESSAGE = Target.the("Mensaje Usuario no pudo iniciar sesión")
            .located(By.xpath("/html/body/app-root/app-toasts-container/div/app-toast/div/div[2]"));
    public static final Target AVATAR_USER_IMAGE = Target.the("Avatar del usuario")
            .located(By.xpath("/html/body/app-root/app-panel-root/app-navbar/div/div[2]/div/div/label/div/img"));
    public static final Target LOGOUT_OPTION = Target.the("Opción Logout")
            .located(By.xpath("//a[contains(text(),'Logout')]"));
    public static final Target SIGN_IN_TITLE = Target.the("Título Sign in")
            .located(By.xpath("//app-sign-in-form/h1\n"));
}
