Proyecto 1 Implementación

Uso del Proyecto
1. Requisitos Previos
Antes de comenzar la instalación, asegúrate de tener los siguientes componentes instalados y configurados en tu entorno:

1.1. Herramientas necesarias:
Java JDK (versión 11 o superior)
Apache Maven (para gestionar las dependencias del proyecto)
Spring Boot (versión adecuada para tu proyecto)
Oracle Database (versión 19c o superior)
SQL Developer o cualquier herramienta para ejecutar scripts SQL en Oracle.
Postman (para realizar pruebas de las APIs REST).
1.2. Configuración de la Base de Datos Oracle:
Tener un usuario y contraseña de acceso a la base de datos Oracle.
Tener privilegios de creación de tablas y ejecución de consultas.
1.3. Dependencias adicionales:
Oracle JDBC Driver: Asegúrate de tener el controlador JDBC de Oracle para conectarte desde Spring Boot.
2. Instalación y Configuración del Proyecto
2.1. Clonar o Descargar el Proyecto
Descarga el proyecto desde el repositorio o clónalo si está en GitHub:

bash
Copiar código
git clone https://github.com/MxrixLu/G06_Proyecto_1_SISTRANS.git
cd proyecto-spring
2.2. Estructura del Proyecto
El proyecto contiene las siguientes carpetas importantes:

/src: Código fuente del proyecto.
/docs: Documentación del proyecto en formato .pdf.
/sql: Scripts SQL para la creación y población de la base de datos.

2.3. Configuración de la Base de Datos
Crea la Base de Datos en Oracle:

Accede a tu base de datos Oracle utilizando SQL Developer u otra herramienta.
Crea un usuario o usa uno existente.
Ejecuta los scripts SQL para crear las tablas y poblar la base de datos. Los scripts se encuentran en la carpeta /sql/.
Scripts a ejecutar:

Proyecto.sql: Este archivo contiene los comandos SQL necesarios para crear las tablas de la base de datos.
Poblacion.sql: Este archivo contiene sentencias SQL para insertar datos en las tablas.
Ejecuta estos archivos en el orden adecuado:

sql
Copiar código
@create_tables.sql;
@populate_tables.sql;

2.4. Configuración del Proyecto Spring Boot
Configura el archivo application.properties: Dentro de la carpeta src/main/resources, encontrarás el archivo de configuración de Spring Boot.

Abre application.properties y configura la conexión a tu base de datos Oracle:

properties
Copiar código
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=tu_usuario_oracle
spring.datasource.password=tu_contraseña_oracle
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
Instala las dependencias con Maven:

2.5. Ejecutar el Proyecto
Una vez que hayas configurado todo, puedes iniciar la aplicación Spring Boot utilizando Maven:

Si la aplicación se inicia correctamente, deberías ver en la consola que el servidor está escuchando en localhost:8080.

3. Documentación
La documentación completa del proyecto se encuentra en la carpeta /docs en formato PDF. Incluye los siguientes apartados:

Análisis y revisión del modelo de datos: Explicación de los modelos UML y relacional, con una revisión de las formas normales aplicadas.
Documentación del código Java y arquitectura: Descripción de las clases Java y la estructura de la arquitectura del proyecto Spring Boot.
Traza del plan de pruebas: Resultados de las pruebas, capturas de pantalla y scripts de prueba.
Usuario de Oracle: Detalle del usuario Oracle donde se encuentra la base de datos poblada.


4. Uso de Postman para probar las APIs
Importar el archivo de colección Postman: Dentro de la carpeta /docs, se encuentra un archivo de colección Postman (postman_collection.json) que contiene todas las solicitudes predefinidas para probar las funcionalidades del sistema (RF y RFC).


5. Plan de Pruebas
El plan de pruebas incluyó los siguientes puntos:

Inserción de datos en las tablas principales (productos, clientes, ventas).
Modificación de datos utilizando las APIs disponibles.
Validación de las integraciones con Oracle Database para asegurarse de que los datos se insertan, modifican y eliminan correctamente.
Para mayor detalle sobre las pruebas, consulta el archivo PDF dentro de la carpeta /docs.

6. Balance del Plan de Pruebas
El plan de pruebas alcanzó los siguientes logros:

Se probaron satisfactoriamente todas las operaciones CRUD (crear, leer, actualizar, eliminar) en las entidades del sistema.
Se realizaron pruebas de integración con Oracle a través de las APIs, verificando la consistencia de los datos.

7. Observaciones Finales
Si encuentras problemas durante la instalación o ejecución, asegúrate de revisar los siguientes aspectos:

Verificar la conexión a la base de datos Oracle en el archivo application.properties.
Asegurarte de que las tablas están correctamente creadas y pobladas antes de ejecutar las pruebas con Postman.
Verificar que todas las dependencias de Maven están instaladas correctamente.