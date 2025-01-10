@FuncionalidadRegistroDeUsuarios
Feature: Validar que se cumplan los requerimientos del usuario para la funcionalidad "Registro de Usuario"

  Como QA Engineer de Inlaze
  Quiero comprobar el correcrto funcionamiento de la funcionalidad Registro de Usuario
  Para verificar que se cumplan satisfactoriamente los requerimientos del usuario

  @RegistroExitoso
     #SuccessfulRegistrationSteps
  Scenario: Validar que se pueda registrar exitosamente un usuario en el sistema cuando se cumplan todas las condiciones
    Given Juan Pérez tiene acceso al aplicativo
    And ingresa al formulario de registro de usuario nuevo
    When envia el formulario de registro con los datos requeridos
      | Nombre     | Correo                 | Contrasena   | Confirmar Contrasena |
      | Juan Pérez | juan-perez@example.com | Contraseña1! | Contraseña1!         |
    Then el sistema muestra un mensaje de confirmación de registro exitoso
      | Successful registration! |

  @ValidacionNombreMenosDosPalabras
       #ValidationUserRequirementsSteps
  Scenario: Validar que si no se introduce un nombre con más de dos palabras, no se habilite el boton registrar
    Given Juan Pérez tiene acceso al aplicativo
    And ingresa al formulario de registro de usuario nuevo
    When diligencia el formulario de registro con los datos requeridos
      | Nombre | Correo                 | Contrasena   | Confirmar Contrasena |
      | Juan   | juan.unico@example.com | Contraseña1! | Contraseña1!         |
    Then comprueba el estado del botón registrar
      | false |

  @ValidacionFormatoEmail
       #Reutilización ValidationUserRequirementsSteps
  Scenario: Validar que si no se introduce un email con el formato correcto, no se habilite el boton registrar
    Given Juan Pérez tiene acceso al aplicativo
    And ingresa al formulario de registro de usuario nuevo
    When diligencia el formulario de registro con los datos requeridos
      | Nombre     | Correo         | Contrasena   | Confirmar Contrasena |
      | Juan Pérez | @comjuan.perez | Contraseña1! | Contraseña1!         |
    Then comprueba el estado del botón registrar
      | false |

  @ValidacionEmailYaRegistrado
       #ValidateErrorRegisterUserSteps
  Scenario: Validar que si se introduce un email ya registrado, se presente un mensaje de error y no permita registrar al usuario
    Given Juan Pérez tiene acceso al aplicativo
    And ingresa al formulario de registro de usuario nuevo
    When envia el formulario de registro con los datos requeridos
      | Nombre     | Correo                 | Contrasena   | Confirmar Contrasena |
      | Juan Pérez | juan-perez@example.com | Contraseña1! | Contraseña1!         |
    Then el sistema muestra un mensaje de error
      | The email is already registered. |

  @ValidacionCondicionesContrasena
       #ValidationConditionsPasswordsSteps
  Scenario Outline: Validar que si no secumplen todas las condiciones para los campos "Contraseña" y "Confirmar contraseña", no se habilite el boton registrar
    Given Juan Pérez tiene acceso al aplicativo
    And ingresa al formulario de registro de usuario nuevo
    When diligencia el formulario de registro con los datos de <Nombre>, <Correo>, <Contrasena> y <ConfirmarContrasena>
    Then comprueba el estado del botón registrar
      | false |
    Examples:
      | Nombre     | Correo                 | Contrasena   | ConfirmarContrasena |
      | Juan Pérez | juan-perez@example.com | abc123       | abc123              |
      | Juan Pérez | juan-perez@example.com | contraseña1! | contraseña1!        |
      | Juan Pérez | juan-perez@example.com | CONTRASEÑA1! | CONTRASEÑA1!        |
      | Juan Pérez | juan-perez@example.com | Contrasena1  | Contrasena1         |
      | Juan Pérez | juan-perez@example.com | Contraseña!  | Contraseña!         |

  @ValidacionContrasenasNoCoinciden
       #ValidateErrorRegisterUserSteps
  Scenario: Validar que si al registrar un usuario las contraseñas no coinciden, no se habilite el boton registrar
    Given Juan Pérez tiene acceso al aplicativo
    And ingresa al formulario de registro de usuario nuevo
    When diligencia el formulario de registro con los datos requeridos
      | Nombre     | Correo                 | Contrasena   | Confirmar Contrasena |
      | Juan Pérez | juan-perez@example.com | Contraseña1! | Contraseña2!         |
    Then el sistema indica que las contraseñas no coinciden
      | Passwords do not match |
    And comprueba el estado del botón registrar
      | false |

  @ValidacionCamposObligatorios
       #Reutilización ValidationConditionsPasswordsSteps
  Scenario Outline: Validar que si se presenta uno o más campos sin diligenciar, no se habilite el boton registrar
    Given Juan Pérez tiene acceso al aplicativo
    And ingresa al formulario de registro de usuario nuevo
    When diligencia el formulario de registro con los datos de <Nombre>, <Correo>, <Contrasena> y <ConfirmarContrasena>
    Then comprueba el estado del botón registrar
      | false |
    Examples:
      | Nombre     | Correo                 | Contrasena   | ConfirmarContrasena |
      |            |                        |              |                     |
      |            | juan-perez@example.com | Contraseña1! | Contraseña1!        |
      | Juan Pérez |                        | Contraseña1! | Contraseña1!        |
      | Juan Pérez | juan-perez@example.com |              | Contraseña1!        |
      | Juan Pérez | juan-perez@example.com | Contraseña1! |                     |
