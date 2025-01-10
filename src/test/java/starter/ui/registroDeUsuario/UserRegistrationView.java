package starter.ui.registroDeUsuario;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserRegistrationView {
    public static final Target SIGN_UP_OPTION = Target.the("Sign up option")
            .located(By.xpath("//a[contains(text(),'Sign up')]"));
    public static final Target NAME_FIELD = Target.the("Campo Nombre completo")
            .located(By.id("full-name"));
    public static final Target EMAIL_FIELD = Target.the("Campo Correo")
            .located(By.id("email"));
    public static final Target PASSWORD_FIELD = Target.the("Campo Contraseña")
            .located(By.xpath("//input[@type='password'][1]"));
    public static final Target CONFIRM_PASSWORD_FIELD = Target.the("Campo Confirmar contraseña")
            .located(By.xpath("(//input[@type='password'])[2]"));
    public static final Target SIGN_UP_BUTTON = Target.the("Boton Sign up")
            .located(By.xpath("//button[contains(text(),' Sign up ')]"));
    public static final Target SUCCESSFUL_REGISTRATION_MESSAGE = Target.the("Mensaje Usuario registrado exitosamente")
            .located(By.xpath("//div[contains(text(),'Successful registration!')]"));
    public static final Target ERROR_REGISTRATION_MESSAGE = Target.the("Mensaje Usuario no se pudo registrar")
            .located(By.xpath("/html/body/app-root/app-toasts-container/div/app-toast[3]/div/div[2]"));
    public static final Target PASSWORD_NOT_MATCH_MESSAGE = Target.the("Mensaje Contraseñas no coinciden")
            .located(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/form/div[4]/label[2]/span"));
}
