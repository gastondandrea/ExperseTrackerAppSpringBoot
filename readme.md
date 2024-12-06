# **AVANCE 1**

**Creación del Proyecto en Java**

1. [x] Crea el proyecto como una aplicación de Java en IntelliJ IDEA.

2. [x] Organiza las carpetas necesarias para estructurar adecuadamente el proyecto.

**Estructura Fundamental del Proyecto**

3. [x] Llamar la clase principal ExpenseTrackerApp, que servirá como punto de entrada de la aplicación.

4. [x] Definir las clases Expense, Category y User, asegurándose de utilizar conceptos de POO como herencia, encapsulación y polimorfismo.

5. [x] La clase Expense debe tener propiedades como amount, date, category y description.

6. [x] La clase Category debe tener propiedades como name y description.

7. [x] La clase User debe tener propiedades como name, email y un arreglo de expenses.

8. [x] Implementar métodos básicos en estas clases para agregar, modificar y eliminar gastos.

9. [x] Crear métodos como addExpense(), removeExpense() y updateExpense() en la clase User.

10. [x] Implementar manejo de excepciones para gestionar errores comunes, como intentos de acceso a elementos inexistentes en la lista.

11. [x] Crear excepciones personalizadas como ExpenseNotFoundException.

12. [x] Utilizar bloques try-catch para manejar estas excepciones en métodos como removeExpense() y updateExpense().

**Contador para Identificadores Únicos**

13. [x] Crear un contador para manejar un identificador único para cada gasto. Esto nos permitirá asignar a cada gasto un ID incremental generado por el contador, lo cual será útil para llevar un seguimiento ordenado de nuestros gastos y facilitar su gestión.

**Manipulación de Cadenas de Texto**

14. [x] Realizar la manipulación de cadenas de texto, específicamente en las categorías de nuestros gastos. Podemos aplicar una transformación para que todas las categorías sean almacenadas en minúsculas, independientemente de cómo fueron escritas originalmente.

15. [x] Esto nos ayudará a tener uniformidad en nuestros datos y simplificará las operaciones de búsqueda y filtrado posteriormente.

**Implementación de Excepciones Customizadas**

16. [x] Crear al menos una excepción customizada y relanzarla en algunos puntos de nuestra aplicación donde antes mostrábamos simplemente un error por consola.

17. [x] Detectar algún punto de flujo indeseado en nuestra aplicación y capturar esa excepción. Esto puede incluir, por ejemplo, un NumberFormatException o IllegalArgumentException si estamos pasando un tipo de dato erróneo, o un NullPointerException si un valor se pasa como nulo y estamos tratando de manipularlo para hacer algo.

**Tips**

_Aplicar principios de POO adecuadamente: Asegúrate de utilizar herencia, encapsulación y polimorfismo en la definición de clases y métodos._

_Utilizar modificadores de acceso: (public, private) para encapsular los datos correctamente._

_Documentar el código: con comentarios claros para facilitar su comprensión._

_Mantener una estructura de paquetes organizada: para una mejor mantenibilidad._

# **AVANCE 2**

**Implementación de la Lista de Gastos**

1. [x] Implementa una lista de gastos utilizando una colección de Java adecuada (por ejemplo, ArrayList)   

**Gestión de Gastos en la Clase User**

2. [x] En la clase User, agrega una propiedad expenses de tipo List<Expense>.

3. [x] Inicializa la lista en el constructor de User.

**Interfaces para Gestión de Gastos**

4. [x] Genera una interfaz funcional y otra con métodos, que definan métodos para validar gastos, calcular gastos, etc. 

**Uso de Genéricos en Colecciones**

5. [x] Utiliza genéricos para manejar distintos tipos de datos en las colecciones.

6. [x] Asegúrate de que las listas y otros tipos de colecciones utilicen genéricos para especificar el tipo de objetos que contendrán.

**Programación Funcional con Streams**

7. [x] Aplica programación funcional para realizar operaciones sobre las colecciones, como filtrado y mapeo de gastos.

8. [x] Utiliza streams para filtrar gastos por categoría o por rango de fechas.


**Ejemplo**

`List<Expense> filteredExpenses = expenses.stream().filter(expense -> expense.getCategory().equals("Food")).collect(Collectors.toList());`

**Tips**

_Revisa la documentación de las colecciones de Java para seleccionar la más adecuada para tu necesidad._

_Explora las funciones lambda y streams de Java para simplificar operaciones sobre colecciones._

_Asegúrate de que tus métodos sean robustos y manejen correctamente las excepciones._

# **AVANCE 3**

**Configuración de la Base de Datos**

1. [x] Configurar la base de datos en memoria H2 en el proyecto.

2. [x] Añadir la dependencia (archivo JAR) de H2 en el classpath del proyecto.

3. [x] Establecer la conexión a la base de datos utilizando JDBC.

4. [x] Crear una clase DatabaseConnection para manejar la conexión a la base de datos.

5. [x] Utilizar la clase DriverManager para obtener una conexión a la base de datos H2.

6. [x] Crear una tabla en la base de datos para almacenar los gastos.

7. [x] Definir la estructura de la tabla expenses en un script SQL.

9. [x] Asegurarse de que la tabla tenga columnas para todas las propiedades de la clase Expense.

**Implementación de Operaciones CRUD**

10. [x] Implementar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad Expense.

11. [x] Crear una clase ExpenseDAO (Data Access Object) para manejar las operaciones de base de datos.

12. [x] Implementar métodos como addExpense(), getAllExpenses(), updateExpense() y deleteExpense().

13. [x] Utilizar PreparedStatement para ejecutar las consultas SQL.

**Desarrollo de Pruebas Unitarias**

14. [x] Configurar JUnit 5 Jupiter y Mockito en el proyecto.

15. [x] Añadir las dependencias (múltiples JAR) al classpath del proyecto.   

16. [x] Escribir pruebas unitarias para las clases y métodos principales de la aplicación.

17. [x] Crear una clase de prueba ExpenseServiceTest.

18. [x] Escribir pruebas para métodos como addExpense(), removeExpense(), y updateExpense().

19. [x] Utilizar Mockito para simular dependencias y aislar las unidades de prueba.

20. [x] Crear mocks de las dependencias utilizando @Mock y @InjectMocks. Ejemplo:
    
    `@Mock private ExpenseDAO expenseDAO; @InjectMocks private ExpenseService expenseService;`

21. [x] Ejecutar las pruebas y asegurarse de que todas pasen correctamente.

22. [x] Utilizar assertions para verificar los resultados esperados. Ejemplo:

    `assertEquals(expectedExpense, actualExpense);`

**Tips**

_Asegúrate de incluir la dependencia de H2 en tu archivo de configuración de Maven o Gradle._

_Revisa la documentación de JDBC para entender cómo establecer conexiones y ejecutar consultas SQL._

_Realiza pruebas unitarias para verificar que las operaciones CRUD funcionen correctamente._

_Divide tus pruebas en pequeñas unidades que verifiquen funciones específicas._

_Utiliza las anotaciones de JUnit 5 (@Test, @BeforeEach, @AfterEach) para organizar tus pruebas._

_Revisa la documentación de Mockito para entender cómo crear mocks y stubs._

_Documenta tu código y utiliza logs para facilitar la depuración._

_Asegúrate de que todas las pruebas sean independientes y repetibles._

**Recomendación**

_Se recomienda desarrollar un componente más de negocio, otra funcionalidad para la app, usando como práctica de desarrollo, TDD_

# **AVANCE 4**

**Generación del Proyecto Base**

1. [ ] Utiliza Spring Initializr para generar un proyecto base con Spring Boot, incorporando la dependencia de Spring Web, en principio.

**Migración de Clases Modelo y Lógica de Negocio**

2. [ ] Comienza a migrar las clases modelo y aquellas con lógica de negocio al nuevo proyecto de Spring. 

**Implementación de Controladores REST**

3. [ ] Implementa controladores REST para gestionar las solicitudes HTTP relacionadas con los gastos. 

**Creación del ExpenseController**

4. [ ] Crea una clase ExpenseController con endpoints como:

        `@GetMapping("/expenses")`

        `@PostMapping("/expenses")`

        `@PutMapping("/expenses/{id}")`

        `@DeleteMapping("/expenses/{id}")`

**Aplicación del Patrón MVC**

5. [ ] Utiliza el patrón MVC para separar las responsabilidades de la aplicación

**Gestión de Lógica de Negocio y Persistencia**

6. [ ] Crea clases ExpenseService y ExpenseRepository para manejar la lógica de negocio y la persistencia de datos.

**Conexión a la Base de Datos**

7. [ ] Para conectarte a la base de datos, incorpora la API JDBC de Spring como dependencia.

**Anotación de Clases con @Service y @Repository**

8. [ ] Utiliza @Service y @Repository para anotar estas clases.

**Documentación y Pruebas de Endpoints**

9. [ ] Documenta los endpoints creados y pruébalos utilizando herramientas como Insomnia (o algún otro cliente HTTP).

**Organización y Pruebas con Insomnia**

10. [ ] Crea un archivo de colección en Insomnia para organizar y probar los endpoints.

**Tips**

_Utiliza las anotaciones de Spring Boot (@RestController, @GetMapping, @PostMapping, etc) para definir tus controladores._

_Organiza tu código siguiendo el patrón MVC para mantener una estructura clara y mantenible._

_Asegúrate de probar cada endpoint para verificar que responda correctamente a las solicitudes HTTP._

_Migra, refactoriza y genera nuevos tests unitarios para las clases service y repository._

# **AVANCE 5**

**Logging del Flujo de la Aplicación**

1. [ ] Anota clases con @Slf4j y realiza logging del flujo de la aplicación en lugares clave, usando diferentes niveles de logging.

**Implementación de Spring Data JPA**

2. [ ] Incorpora la dependencia e implementa Spring Data JPA para facilitar la conexión y manipulación de datos en la base de datos.

**Mapeo de Entidades con Anotaciones**

3. [ ] Anota la entidad Expense con @Entity y @Id en su propiedad principal, y agrega todas las anotaciones necesarias para mapear la entidad con la base de datos, teniendo en cuenta cualquier relación que pueda tener con otras entidades. 

**Refactorización del Repositorio**

4. [ ] Refactoriza el repositorio ExpenseRepository para que sólo extienda de JpaRepository.

**Pruebas de Integración en Controladores**

5. [ ] Desarrolla pruebas de integración en las clases controller para asegurar que todos los componentes del sistema funcionen correctamente al integrarse. 

**Carga del Contexto de la Aplicación**

6. [ ] Utiliza @SpringBootTest para cargar el contexto completo de la aplicación.

**Tips**

_Configura correctamente SLF4J y utiliza logs para monitorear el comportamiento de la aplicación._

_Realiza pruebas exhaustivas de integración para verificar la interacción entre los diferentes componentes de la aplicación._

_Documenta todos los pasos y asegúrate de que el proyecto esté bien organizado y listo para ser presentado._