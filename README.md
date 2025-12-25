# 📱 Automatización de Pruebas Mobile – AutoReserva
Caleb Flores Tambracc
---
### **Appium + Serenity BDD + Screenplay + Cucumber**

Proyecto de automatización de pruebas funcionales para una aplicación Android de reservas de autos, desarrollado como parte del examen de **Pruebas de Software** en Cibertec.

---

## 🧪 Descripción del Proyecto

Este proyecto automatiza escenarios **End-to-End (E2E)** sobre la aplicación Android **AutoReserva**, validando el flujo completo de gestión de reservaciones mediante:

* ✅ **Creación** de reservaciones.
* ✏️ **Edición** de reservaciones.
* 🗑️ **Eliminación** de reservaciones.

La automatización está implementada siguiendo el patrón **Screenplay**, utilizando **Appium** para la interacción móvil y **Serenity BDD** para la generación de reportes detallados y orquestación.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** ☕ Java 17
* **Driver:** 📱 Appium
* **Framework:** 🧩 Serenity BDD
* **Patrón:** 🧠 Screenplay Pattern
* **BDD:** 🥒 Cucumber (Gherkin)
* **Gestor:** 🔧 Maven
* **Entorno:** 🤖 Android Emulator

---

## 📂 Estructura del Proyecto

El proyecto sigue la estructura estándar para implementaciones de Serenity con Screenplay:

```text
src
 └── test
     ├── java
     │   └── com.coudevi
     │       ├── ui              # Localizadores de UI (Target)
     │       ├── tasks           # Acciones de alto nivel (Create, Edit, Delete)
     │       ├── interactions    # Interacciones personalizadas (Scroll, Wait)
     │       ├── questions       # Validaciones y Aserciones
     │       ├── stepdefinitions # Implementación de los pasos de Cucumber
     │       └── runners         # Clase para ejecutar las pruebas
     └── resources
         ├── features            # Archivos .feature en lenguaje Gherkin
         └── serenity.conf       # Configuración de Driver y Capabilities


