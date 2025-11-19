# Proyecto Final: The Sandwich Guy  - Avance II

## Integrantes del Grupo
| Nombre | Carné | Usuario Git | Correo Git |
| :--- | :--- | :--- | :--- |
| Brenda Granados Ramirez | FI24039956 | bngranados | bgranados70835@ufide.ac.cr |
| Mayquelin Narbaez Guido | FI22023961 | Mayquelin | mayquelin1984@gmail.com |
| Mariangel Barrios Muñoz | FI24036629 | MariangelB | mariamgelbarrios5@gmail.com |
| Brandon Lanzoni Rodriguez| FI25049122 | Brandon120105|brandongabriel120105@gmail.com |
| ... | ... | ... | ... |

## Editores / IDEs Utilizados
- Los IDE utilizados son NetBeans y Visual Studio Code.
  
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
- Implementacion de GridLayout en Java Swing:
  - Utilizado para darle una mejor interfaz a la hora de correrlo.
  [https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html](https://inforux.wordpress.com/2009/03/21/java-practicando-con-gridlayout/)[https://www.youtube.com/watch?v=xvvMSJ3nfT8]
  - Ayuda con Gemini: [https://gemini.google.com/app/d99af3ba63ea9788?hl=es]
-  Module estándar XML (Dado por el profesor):
  [https://docs.oracle.com/en/java/javase/21/docs/api/java.xml/module-summary.html]
-  Swing (Dado por el profesor):
  [https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/package-summary.html]
  -  java.awt (Dado por el profesor):
  [https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/java/awt/package-summary.html]

### 1. Instalación
- Se utiliza **Java SE 21** (JDK 21), que es la versión Long-Term Support recomendada.  
- No se requiere instalar librerías externas adicionales, ya que el proyecto usa únicamente las librerías incluidas en Java:
  - `java.util` para estructuras de datos como listas.
  - `java.awt` y `javax.swing` para la interfaz gráfica.  
- Para los entornos de desarrollo:
  - **VS Code:** instalar la extensión de Java y configurar la ruta al JDK 21.
  - **NetBeans:** configurar el JDK 21 en las opciones de plataformas de Java.

### 2. Compilación
- Desde el IDE: usar **Run** o **Build** para generar los `.class`.
- Desde la terminal:
  1. Ubicarse en la carpeta `Proyecto_Avance2`.
  2. Compilar con:
     ```sh
     javac -d bin *.java
     ```

### 3. Ejecución
- Desde el IDE: ejecutar la clase principal `Carta`.
- Desde la terminal:
  ```sh
  java -cp bin Proyecto_Avance2.Carta
  
---

<img width="1136" height="720" alt="image" src="https://github.com/user-attachments/assets/6a2665a5-b2db-4f88-a12f-346aaa64e019" />





