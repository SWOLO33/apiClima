# 🌦️ Proyecto **Apiclima**
Aplicación Java con Maven y NetBeans para consultar la API de **OpenWeather** y mostrar el clima actual ingresando una ciudad desde la consola.

---

## 🚀 Tecnologías utilizadas
- ☕ **Java 17+**
- 📦 **Maven**
- 🧩 **Gson (Google)**
- 🏗️ **NetBeans**
- 🌐 **OpenWeather API**
- 🐙 **Git & GitHub**

---

## 🧠 ¿Qué aprendí en este proyecto?

### 🔹 Uso de NetBeans con Maven  
El uso de NetBeans con Maven facilitó el manejo del proyecto:  
- Descarga de dependencias automáticamente  
- Organización estándar del código  
- Ejecución sencilla del proyecto  
- Integración con Git sin configuraciones complicadas  

Gracias a Maven, solo tuve que concentrarme en la lógica de *Apiclima*.

---

### 🔹 Manejo profesional de Git y GitHub  
Durante el proceso aprendí a usar GitHub para:  
- Controlar el historial del proyecto  
- Crear commits significativos  
- Subir cambios desde NetBeans  
- Mantener una versión pública del proyecto

También aprendí algo clave de seguridad: **nunca subir credenciales o API keys al repositorio**.  
Para corregir el error inicial:

- 🚫 Eliminé el repositorio antiguo de GitHub  
- 🔐 Revocé la API key comprometida en OpenWeather  
- 🧹 Borré el historial Git local (carpeta `.git`)  
- 🔄 Inicié un repositorio limpio sin la clave  
- ⚙️ Moví la API key a una **variable de entorno**  
- 🌱 Creé un repo nuevo totalmente seguro

Esto reforzó buenas prácticas de seguridad y control de versiones.

---

## 🏗️ ¿Cómo funciona Apiclima?

1. El usuario ejecuta la aplicación.
2. El programa solicita una ciudad desde consola.
3. Llama a la API de OpenWeather usando:
   - Variable de entorno:  
     ```bash
     OPENWEATHER_API_KEY=tu_api_key
     ```
4. Obtiene el clima y lo muestra con formato claro:

---- Clima Actual ----
| Ciudad : Puebla
| Descripcion : Cielo claro
| Temperatura : 22.4 C
| Sensacion termica : 21.8 C
| Humedad : 36%
| Pais : MX

