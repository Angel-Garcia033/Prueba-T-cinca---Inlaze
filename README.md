# Proyecto de Automatización de Casos de Prueba: Prueba Técinca - Inlaze

## Descripción

Este proyecto implementa la automatización de los casos de prueba para las funcionalidades de **registro** y **login** utilizando Selenium con Java y Serenity BDD. La estructura está diseñada para facilitar la organización y escalabilidad del proyecto.

## Documentación y Reporte de Bugs

Toda la documentación relacionada con los casos de prueba que se automatizan en este proyecto, así como el reporte de los bugs hallados durante la automatización, se encuentra disponible en el siguiente enlace:

[Documentación de Casos de Prueba y Reporte de Bugs](https://utopian-steel-744.notion.site/Prueba-T-cnica-Inlaze-176e20d7ce5780fdad28f7f9f9a98637?pvs=4)

## Estructura del Proyecto

```
src/
├── test/
│   ├── java/
│   │   ├── starter/
│   │   │      ├── questions/            # Clases que contienen preguntas para verificar condiciones del sistema.
│   │   │      ├── stepdefinations/      # Definiciones de los pasos en los escenarios Gherkin.
│   │   │      ├── task/                 # Tareas reutilizables en los scripts de automatización.
│   │   │      └── ui/                   # Mapas de objetos de interfaz de usuario.
│   ├── resources/
│   │   ├── features/                    # Casos de prueba escritos en lenguaje Gherkin.
│   │   └── serenity.conf                # Archivo de configuración de Serenity.
├── README.md                            # Instrucciones del proyecto.
└── pom.xml                              # Archivo de dependencias y configuración para Maven.
```

## Requisitos Previos

1. **Java 8 o superior**: Instala desde [aquí](https://www.oracle.com/java/technologies/javase-downloads.html).
2. **Maven**: Descarga desde [aquí](https://maven.apache.org/download.cgi).
3. **Google Chrome**: Asegúrate de que esté actualizado.
4. **ChromeDriver**: Compatible con la versión de Chrome. Descarga desde [aquí](https://chromedriver.chromium.org/downloads).
5. **IDE**: IntelliJ IDEA, Eclipse o cualquier IDE compatible con Maven.

## Configuración del Proyecto

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/Angel-Garcia033/Prueba-T-cinca---Inlaze.git
   cd Prueba-T-cinca---Inlaze
   ```

2. **Verifica la ruta del `chromedriver` en tu sistema y configúralo en tu PATH.**

## Ejecución de las Pruebas

1. **Ejecutar todas las pruebas:**
   ```bash
   mvn clean verify -Denvironment=chrome
   ```

2. **Generar reporte:**
   Serenity generará un reporte HTML automáticamente en la carpeta `target/site/serenity`.

## Dependencias

El archivo `pom.xml` incluye las dependencias clave del proyecto. A continuación se presenta un breve resumen de las dependencias:
- **net.serenity-bdd:serenity-core**  
  *Uso:* Proporciona el núcleo de Serenity BDD para la automatización de pruebas.

- **net.serenity-bdd:serenity-cucumber**  
  *Uso:* Integra Serenity BDD con Cucumber para escribir pruebas en lenguaje Gherkin.

- **net.serenity-bdd:serenity-screenplay**  
  *Uso:* Proporciona el patrón Screenplay para escribir pruebas más legibles y mantenibles.

- **net.serenity-bdd:serenity-screenplay-webdriver**  
  *Uso:* Extiende el patrón Screenplay para interactuar con navegadores web mediante WebDriver.

- **net.serenity-bdd:serenity-ensure**  
  *Uso:* Proporciona aserciones y verificaciones para las pruebas de Screenplay.

### Gestión de Controladores y Navegadores
- **io.github.bonigarcia:webdrivermanager**  
  *Uso:* Gestiona automáticamente las versiones de los controladores de navegador para Selenium.

### Plataforma de Ejecución de Pruebas
- **org.junit.platform:junit-platform-launcher**  
  *Uso:* Ejecuta pruebas en la plataforma JUnit.

- **io.cucumber:cucumber-junit-platform-engine**  
  *Uso:* Permite ejecutar pruebas de Cucumber en la plataforma JUnit.

- **org.junit.platform:junit-platform-suite**  
  *Uso:* Proporciona una suite de pruebas para JUnit.

- **org.junit.jupiter:junit-jupiter-engine**  
  *Uso:* Motor de ejecución para pruebas escritas con JUnit 5.

- **org.junit.vintage:junit-vintage-engine**  
  *Uso:* Permite ejecutar pruebas escritas con JUnit 4 en la plataforma JUnit 5.

### Registro y Logs
- **ch.qos.logback:logback-classic**  
  *Uso:* Proporciona una implementación de registro para la salida de logs.

### Aserciones
- **org.assertj:assertj-core**  
  *Uso:* Proporciona una biblioteca de aserciones fluida y rica para pruebas.

## Recursos

- [Documentación oficial de Serenity BDD](https://serenity--bdd-github-io.translate.goog/docs/reporting/living_documentation?_x_tr_sl=en&_x_tr_tl=es&_x_tr_hl=es&_x_tr_pto=tc)
- [Documentación oficial de Selenium](https://www.selenium.dev/documentation/)
