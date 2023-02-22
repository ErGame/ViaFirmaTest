# ViafirmaTest

Java and maven application that add a blank page to every pdf file in a directory.

You can run the application with the next command line:
```
java PdfAdding/src/main/java/com/ergame/viafirmatest/PdfAdding/App.java 'YourDirectory'
```


### ¿Cómo harías para poder ejecutar N veces el proceso sobre el mismo directorio y solo modificar cada pdf una sola vez?

Ahora mismo la aplicación no tiene implementada la opción de que solo se añada una página nueva si no tiene otra anterior. Sin embargo se podria implementar perfectamente con PdfBox. esta librería tiene la funcion de ver los datos de una página concreto, por lo que se podria comprobar si la última página de los archivos está vacía y añadir una si no lo está.


### ¿Qué pasa si el directorio contiene un fichero que no es un pdf?

No lo modifica. La aplicación verifica que el archivo que se está modificando es un pdf.


### ¿Cómo probar / ejecutar la aplicación?

Se puede ejecutar como se ha explicado anteriormente. Si se quiere ejecutar con la variable de entorno VIAFIRMA_PATH, habria que sustituir `'YourDirectory'` por `${VIAFIRMA_PATH}`.

### ¿Cómo podemos ver los logs?

La aplicación crea un archivo `log/log` en el proyecto. Es un archivo xml el cual registra los logs de la aplicacion.
