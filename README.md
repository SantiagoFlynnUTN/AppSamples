# TP:

### Instrucciones

Crea una aplicación simple que realice dos tareas simultáneamente. Cada tarea está explicada a continuación:

### **Tarea 1: Obtener cada 10º carácter**

1. Descarga el contenido de la página https://www.compass.com/about/ desde la web.
2. Selecciona cada décimo carácter (por ejemplo, el carácter número 10, 20, 30, etc.).
3. Muestra estos caracteres en la pantalla en una lista.

### **Tarea 2: Contar palabras**

1. Descarga el mismo contenido de la página https://www.compass.com/about/ desde la web.
2. Separa el texto en palabras usando caracteres en blanco como espacios, tabulaciones o saltos de línea.
3. Cuenta cuántas veces aparece cada palabra (sin distinguir entre mayúsculas y minúsculas).
4. Muestra cada palabra y su cantidad en la pantalla en una lista.

Nota: Trata el contenido de la página como si fuera texto plano, sin importar el formato en que lo recibas. Cualquier cosa que esté separada por espacios o caracteres en blanco cuenta como una palabra, incluyendo etiquetas HTML. Por ejemplo, el texto `"<p> Compass Hello World </p>"` cuenta como 5 palabras: `"<p>"`, `"Compass"`, `"Hello"`, `"World"` y `"</p>"`.

### La aplicación debe cumplir con lo siguiente:

1. **Mostrar un botón** en pantalla para ejecutar ambas tareas al mismo tiempo.
2. **Mostrar los resultados** de cada tarea en cuanto estén listos. Usa listas o vistas adecuadas para presentar los datos:
    - Cada décimo carácter en una lista.
    - El conteo de palabras en otra lista.
3. **Almacenar en caché los datos** obtenidos para que estén disponibles sin conexión después de la primera vez.
4. **Escribir pruebas unitarias** para asegurar que el código funcione correctamente.

Notas:

- El proyecto tiene que hacer uso de la arquitectura MVI, usar datasources, repository, useCases, y funciones helper de tipo fetchData() y excecuteUseCase()
- El proyecto debe ser multimodulo, para entender que funcion tiene cada modulo y como interaccionan entre si los componentes.
- Cada cambio tiene que corresponder a un ticket en trello que tienen que armar ustedes, y los PRs deben ser a la rama main.

La app debe quedar aproximadamente asi:

https://github.com/user-attachments/assets/25e34842-a5fc-4d9e-99a1-308e5f024165
