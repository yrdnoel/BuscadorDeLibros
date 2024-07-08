# Proyecto de Búsqueda de Libros

Este proyecto consiste en una aplicación en Java que permite buscar libros en la API de Gutendex y realizar diversas operaciones sobre los resultados obtenidos. La aplicación está construida utilizando Spring Boot para facilitar la gestión y configuración del proyecto.

## Estructura del Proyecto

El proyecto se estructura en los siguientes paquetes y clases:

### com.aluracursos.desafio.model
- **Datos**: Clase que representa los datos obtenidos de la API.
- **DatosAutor**: Clase que representa los datos de un autor.
- **DatosLibros**: Clase que representa los datos de un libro.

### com.aluracursos.desafio.principal
- **Principal**: Clase que contiene la lógica principal del menú interactivo.

### com.aluracursos.desafio.service
- **ConsumoAPI**: Clase para realizar las llamadas a la API de Gutendex.
- **ConvierteDatos**: Clase para convertir los datos JSON obtenidos de la API a objetos Java.

### application.properties
- Archivo de configuración de la aplicación.

## Recursos Necesarios

Para ejecutar este proyecto, necesitas:

1. **Java 17**: La aplicación está construida utilizando Java 17.
2. **Spring Boot**: Para facilitar la configuración y ejecución de la aplicación.
3. **PostgreSQL**: Base de datos para almacenar la información obtenida de la API.

## Configuración de la Base de Datos

Configura las credenciales de PostgreSQL en el archivo `application.properties`:

```properties
spring.application.name=desafio
spring.datasource.url=jdbc:postgresql://localhost/literAlura_base
spring.datasource.username=postgres
spring.datasource.password=1234
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
 ## Funcionalidades
La aplicación presenta un menú interactivo con las siguientes opciones:

1. Búsqueda de libro por título: Permite buscar un libro por su título y muestra los detalles del primer libro encontrado.
2. Listar libros registrados: Muestra una lista de los libros que han sido registrados durante las búsquedas.
3. Listar autores registrados: Muestra una lista de los autores de los libros registrados.
4. Listar autores vivos en un determinado año: Muestra los autores que estaban vivos en un año específico.
5. Listar libros por idiomas: Muestra los libros registrados agrupados por idiomas.
6. Salir: Termina la ejecución del programa.
   
## Mensajes de Advertencia
La aplicación incluye mensajes de advertencia para los casos en que el usuario introduce un dato erróneo. Si el usuario ingresa una opción no válida en el menú, se le mostrará un mensaje de advertencia y se le pedirá que ingrese una opción válida.

## Ejemplo de Uso
Aquí se muestra un ejemplo del funcionamiento de la aplicación con varias búsquedas y operaciones:

Seleccione una opción:
1. Búsqueda de libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año de los libros registrados
5. Listar libros por idiomas
0. Salir
Ingrese su opción: 1
Ingrese el nombre del libro que desea buscar:
quijote

Título: Don Quijote
Autor: Cervantes Saavedra, Miguel de
Idiomas: es
Número de Descargas: 16728.0

Seleccione una opción:
1. Búsqueda de libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año de los libros registrados
5. Listar libros por idiomas
0. Salir
Ingrese su opción: 1
Ingrese el nombre del libro que desea buscar:
juliet

Título: Romeo and Juliet
Autor: Shakespeare, William
Idiomas: en
Número de Descargas: 77782.0

Seleccione una opción:
1. Búsqueda de libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año de los libros registrados
5. Listar libros por idiomas
0. Salir
Ingrese su opción: 1
Ingrese el nombre del libro que desea buscar:
moby

Título: Moby Dick; Or, The Whale
Autor: Melville, Herman
Idiomas: en
Número de Descargas: 71888.0

Seleccione una opción:
1. Búsqueda de libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año de los libros registrados
5. Listar libros por idiomas
0. Salir
Ingrese su opción: 1
Ingrese el nombre del libro que desea buscar:
captain

Título: Captain Blood
Autor: Sabatini, Rafael
Idiomas: en
Número de Descargas: 1013.0

Seleccione una opción:
1. Búsqueda de libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año de los libros registrados
5. Listar libros por idiomas
0. Salir
Ingrese su opción: 1
Ingrese el nombre del libro que desea buscar:
best

Título: Best Russian Short Stories
Autor: 
Idiomas: en
Número de Descargas: 2337.0

Seleccione una opción:
1. Búsqueda de libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año de los libros registrados
5. Listar libros por idiomas
0. Salir
Ingrese su opción: 2
Libros registrados:

Título: Don Quijote
Autor: Cervantes Saavedra, Miguel de
Idiomas: es
Número de Descargas: 16728.0

Título: Romeo and Juliet
Autor: Shakespeare, William
Idiomas: en
Número de Descargas: 77782.0

Título: Moby Dick; Or, The Whale
Autor: Melville, Herman
Idiomas: en
Número de Descargas: 71888.0

Título: Captain Blood
Autor: Sabatini, Rafael
Idiomas: en
Número de Descargas: 1013.0

Título: Best Russian Short Stories
Autor: 
Idiomas: en
Número de Descargas: 2337.0

Seleccione una opción:
1. Búsqueda de libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año de los libros registrados
5. Listar libros por idiomas
0. Salir
Ingrese su opción: 3
Autores registrados:
Cervantes Saavedra, Miguel de
Shakespeare, William
Melville, Herman
Sabatini, Rafael

Seleccione una opción:
1. Búsqueda de libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año de los libros registrados
5. Listar libros por idiomas
0. Salir
   
Ingrese su opción: 4

Ingrese el año para listar los autores vivos en ese año:

Ingrese el año: 1790

Autores vivos en el año 1790:
Cervantes Saavedra, Miguel de
Shakespeare, William

Seleccione una opción:

1. Búsqueda de libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año de los libros registrados
5. Listar libros por idiomas
0. Salir
   
Ingrese su opción: 5

Libros por idioma:

en: 4 libros

  Título: Romeo and Juliet
  
  Título: Moby Dick; Or, The Whale
  
  Título: Captain Blood
  
  Título: Best Russian Short Stories
  
es: 1 libros
  Título: Don Quijote

Seleccione una opción:

1. Búsqueda de libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año de los libros registrados
5. Listar libros por idiomas
0. Salir
   
Ingrese su opción: 0

Saliendo del programa...

## Instrucciones de Ejecución

1. **Configura tu entorno**: Asegúrate de tener instalado Java 17 y PostgreSQL.
2. **Clona el repositorio**: Clona el repositorio del proyecto en tu máquina local.
3. **Configura la base de datos**: Asegúrate de que PostgreSQL esté en funcionamiento y configura las credenciales en el archivo `application.properties`.
4. **Ejecuta la aplicación**: Usa IntelliJ IDEA o cualquier otro IDE compatible con Spring Boot para ejecutar la clase principal `DesafioApplication`.

## Capturas de Pantalla

![Captura de Pantalla](ruta/a/la/captura.png)

## Desarrollador

Desarrollado por [Leondry M].

## Agradecimientos

Agradecimientos especiales al programa de [AluraLATAM](https://www.alura.com.br/) por proporcionar los recursos y la formación necesarios para llevar a cabo este proyecto.



