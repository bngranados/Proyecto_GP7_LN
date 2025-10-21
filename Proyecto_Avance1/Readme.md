# Proyecto Final: The Sandwich Guy  - Avance I

## Integrantes del Grupo
| Nombre | Carné | Usuario Git | Correo Git |
| :--- | :--- | :--- | :--- |
| Brenda Granados Ramirez | FI24039956 | bngranados | bgranados70835@ufide.ac.cr |
| Mayquelin Narbaez Guido | FI22023961 | Mayquelin | mayquelin1984@gmail.com |
| Mariangel Barrios Muñoz | FI24036629 | MariangelB | mariamgelbarrios5@gmail.com |
|Brandon Lanzoni Rodriguez| FI25049122 |Brandon120105|brandongabriel120105@gmail.com |
| ... | ... | ... | ... |

## Editores / IDEs Utilizados
- El IDE utilizado sería NetBeans y Visual Studio Code
  
## Instructivo de Uso
- El proyecto está desarrollado en **Java SE 21 & JDK 21**.

## Especificaciones técnicas
La versión para desarrollar el proyecto es **Java SE 21 & JDK 21 (Standard Edition & Java Development Kit version 21)**, la cual es **LTS (Long-Term Support)**.  
Se recomienda utilizar la implementación de **OpenJDK** o de **Oracle**.

Al ser una aplicación de escritorio (Desktop) con interfaz gráfica, se utiliza la librería **Swing**, incluida de forma nativa en Java. Esta permite construir interfaces gráficas interactivas sin necesidad de instalar librerías externas.

# Referencias y Prompts Utilizados

## 1. Referencias
- Documentación oficial de **Java SE 21**:  
  [https://docs.oracle.com/en/java/javase/21/docs/api/index.html](https://docs.oracle.com/en/java/javase/21/docs/api/index.html)  
- Tutoriales sobre **Swing en Java**:  
  [https://docs.oracle.com/javase/tutorial/uiswing/](https://docs.oracle.com/javase/tutorial/uiswing/)  
- NetBeans IDE – Guía de usuario:  
  [https://netbeans.apache.org/kb/docs/](https://netbeans.apache.org/kb/docs/)  
- VS Code – Extensión de Java y configuración de JDK:  
  [https://code.visualstudio.com/docs/java/java-tutorial](https://code.visualstudio.com/docs/java/java-tutorial)  


### 1. Instalación
- Se utiliza **Java SE 21** (JDK 21), que es la versión Long-Term Support recomendada.  
- No se requiere instalar librerías externas adicionales, ya que el proyecto usa únicamente las librerías incluidas en Java:
  - `java.util` para estructuras de datos como listas.
  - `java.awt` y `javax.swing` para la interfaz gráfica.  
- Para los entornos de desarrollo:
  - **VS Code:** instalar la extensión de Java y configurar la ruta al JDK 21.
  - **NetBeans:** configurar el JDK 21 en las opciones de plataformas de Java.

## 2. Compilación
- En **VS Code** o **NetBeans** no se necesitan parámetros especiales para compilar.  
- El proyecto se puede compilar directamente desde el IDE utilizando las opciones de **Run** o **Build**, las cuales compilan automáticamente todos los archivos `.java`.  
- Si se compila desde terminal, solo se necesita indicar la ubicación de los archivos fuente y del JDK 21.

## 3. Ejecución
- La ejecución se realiza desde el IDE seleccionando **Run** sobre la clase principal (`Carta`).  
- Desde terminal, se ejecuta la máquina virtual de Java apuntando a la carpeta donde se encuentran los archivos compilados.  
- La ejecución abrirá la interfaz gráfica del juego, mostrando los paneles de cartas y los botones de interacción para iniciar y controlar la partida.
