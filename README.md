# CRUD de Productos con Estadísticas

Este proyecto es una aplicación CRUD para la gestión de productos, desarrollada utilizando Java 17 y Spring Boot 3.3. Además, incluye características de autenticación básica y estadísticas de uso.

## Descripción

La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en productos, y está protegida por autenticación básica. La API RESTful expone endpoints para interactuar con los productos y registrar estadísticas de uso del sistema.

## Compilación del Proyecto

Para compilar el proyecto, sigue estos pasos:

1. Clonar el repositorio:

    ```bash
    git clone https://github.com/tu-usuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. Crear el archivo `toolchains.xml` en el directorio `.m2` de tu usuario. Este archivo es necesario para especificar la versión de Java que se utilizará durante la compilación. Asegúrate de que `toolchains.xml` tenga el siguiente contenido:

    ```xml
    <?xml version="1.0" encoding="UTF8"?>
    <toolchains>
        <toolchain>
            <type>jdk</type>
            <provides>
                <version>17</version>
                <vendor>oracle</vendor>
            </provides>
            <configuration>
                <jdkHome>/path/to/your/jdk-17</jdkHome>
            </configuration>
        </toolchain>
    </toolchains>
    ```

    Reemplaza `/path/to/your/jdk-17` con la ruta de tu instalación de JDK 17.

3. Compilar el proyecto usando Maven:

    ```bash
    ./mvn clean package
    ```

## Ejecución y Despliegue Local

Para ejecutar y desplegar la aplicación localmente, sigue estos pasos:

1. Ejecutar la aplicación:

    ```bash
    ./mvn spring-boot:run
    ```

2. La aplicación estará disponible en `http://localhost:8080/productos-estadisticas`.

3. Para probar los endpoints protegidos, utiliza herramientas como Postman o cURL. Por ejemplo, para listar los productos autenticándote con las credenciales definidas (usuario: `user`, contraseña: `password`):

    ```bash
    curl -u user:password http://localhost:8080/productos-estadisticas/api/products
    ```

4. Puedes acceder a la documentación de la API generada por Swagger en:

    ```bash
    http://localhost:8080/productos-estadisticas/swagger-ui.html
    ```