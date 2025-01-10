# Proyecto de Automatización de Casos de Prueba: Prueba Técinca - Inlaze

## Descripción

Este proyecto implementa la automatización de los casos de prueba para las funcionalidades de **registro** y **login** utilizando Selenium con Java y Serenity BDD. La estructura está diseñada para facilitar la organización y escalabilidad del proyecto.

## Estructura del Proyecto

```
src/
├── test/
│   ├── starter/
│   │   ├── questions/            # Clases que contienen preguntas para verificar condiciones del sistema.
│   │   ├── stepdefinations/      # Definiciones de los pasos en los escenarios Gherkin.
│   │   ├── task/                 # Tareas reutilizables en los scripts de automatización.
│   │   └── ui/                   # Mapas de objetos de interfaz de usuario.
│   ├── resources/
│   │   ├── features/             # Casos de prueba escritos en lenguaje Gherkin.
│   │   └── serenity.conf         # Archivo de configuración de Serenity.
├── README.md                     # Instrucciones del proyecto.
└── pom.xml                       # Archivo de dependencias y configuración para Maven.
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

El archivo `pom.xml` incluye las dependencias clave del proyecto.

## Recursos

- [Documentación oficial de Serenity BDD](https://serenity--bdd-github-io.translate.goog/docs/reporting/living_documentation?_x_tr_sl=en&_x_tr_tl=es&_x_tr_hl=es&_x_tr_pto=tc)
- [Documentación oficial de Selenium](https://www.selenium.dev/documentation/)
