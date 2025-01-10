@FuncionalidadLoginDeUsuarios
Feature: Validar que se cumplan los requerimientos del usuario para la funcionalidad "Login de Usuario"

  Como QA Engineer de Inlaze
  Quiero comprobar el correcrto funcionamiento de la funcionalidad Login de Usuario
  Para verificar que se cumplan satisfactoriamente los requerimientos del usuario

  @LoginExitoso
     #SuccessfulLoginSteps
  Scenario: Validar que se pueda logear exitosamente un usuario en el sistema
    Given Juan Pérez tiene acceso al aplicativo
    When inicia sesion con las credenciales requeridas
      | Correo                 | Contrasena   |
      | juan-perez@example.com | Contraseña1! |
    Then el sistema muestra el nombre del usuario en la pantalla principal
      | Juan Pérez |

  @ValidacionCamposObligatoriosLogin
     #ValidationFieldsEmptySteps
  Scenario Outline: Validar que si se presenta uno o más campos sin diligenciar, no se habilite el boton iniciar sesion
    Given Juan Pérez tiene acceso al aplicativo
    When inicia sesion con los datos de <Correo> y <Contrasena>
    Then comprueba el estado del botón iniciar sesion
      | false |
    Examples:
      | Correo                 | Contrasena   |
      |                        |              |
      | juan-perez@example.com |              |
      |                        | Contraseña1! |

  @LoginFallido
     #FailedLoginSteps
  Scenario: Validar el mensaje de error al tratar de loguearse con contraseñas incorrectas
    Given Juan Pérez tiene acceso al aplicativo
    When inicia sesion con las credenciales requeridas
      | Correo                 | Contrasena   |
      | juan-perez@example.com | Incorrecta1! |
    Then el sistema muestra un mensaje de error em la pantalla de login
      | Password doesn't match |

  @CierreSesion
     #SuccessfulLogoutSteps
  Scenario: Validar que se pueda cerrar sesión correctamente del sistema
    Given Juan Pérez tiene acceso al aplicativo
    And inicia sesion con las credenciales requeridas
      | Correo                 | Contrasena   |
      | juan-perez@example.com | Contraseña1! |
    When el usuario cierra sesion de si perfil
    Then el sistema muestra la pantalla de login
      | Sign in |