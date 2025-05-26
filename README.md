# 🕵️‍♂️ Aplicación de Consulta de IPs con Historial

Aplicación de escritorio desarrollada en **Java** con interfaz gráfica **Swing**, que permite a los usuarios consultar información sobre direcciones IP. Los usuarios registrados pueden guardar un historial de sus búsquedas, mientras que los no registrados solo pueden realizar consultas sin almacenamiento.

---

## 📦 Características

- ✅ Registro e inicio de sesión de usuarios
- 🌐 Consulta de información sobre direcciones IP
- 🗃️ Almacenamiento de historial por usuario
- 🔒 Conexión a base de datos MySQL
- 🖼️ Interfaz gráfica intuitiva construida con Swing

---

## BBDD
### 🧍‍♂️ Tabla: `tb_user`

Representa a los usuarios registrados en la app.

| Campo           | Tipo         | Restricciones                     |
|----------------|--------------|----------------------------------|
| id             | int(11)      | PRIMARY KEY, AUTO_INCREMENT      |
| nombre_usuario | varchar(50)  | NOT NULL, UNIQUE                 |
| contrasena     | varchar(50)  | NOT NULL                         |

🔸 **Trigger:** `TRG_PERSONAS` → Inserta automáticamente un log en `personas_log` al crear un nuevo usuario.

---

### 🌐 Tabla: `historial_ips`

Almacena el historial de IPs consultadas por los usuarios.

| Campo        | Tipo         | Restricciones                                |
|-------------|--------------|---------------------------------------------|
| id          | int(11)      | PRIMARY KEY, AUTO_INCREMENT                  |
| usuario_id  | int(11)      | FOREIGN KEY → `tb_user.id` ON DELETE CASCADE |
| ip          | varchar(45)  | NOT NULL                                     |
| hostname    | varchar(255) | NULL                                         |
| ciudad      | varchar(100) | NULL                                         |
| pais        | varchar(10)  | NULL                                         |
| coordenadas | varchar(50)  | NULL                                         |
| fecha       | datetime     | DEFAULT current_timestamp()                 |

---

### 🧾 Tabla: `personas_log`

Bitácora de creación de usuarios.

| Campo           | Tipo         | Restricciones                     |
|----------------|--------------|----------------------------------|
| ID_LOG         | int(11)      | PRIMARY KEY, AUTO_INCREMENT      |
| NOMBRE_USUARIO | varchar(100) | NULL                             |
| HORA_CREACION  | datetime     | DEFAULT current_timestamp()      |

⚠️ **Nota:** No tiene clave foránea, pero se alimenta desde el trigger de `tb_user`.

---

### 🔗 Diagrama Entidad-Relación (ASCII)

```
+----------------+           +--------------------+
|    tb_user     |1--------< |   historial_ips    |
|----------------|           |--------------------|
| id (PK)        |           | id (PK)            |
| nombre_usuario |           | usuario_id (FK)    |
| contrasena     |           | ip                 |
+----------------+           | hostname           |
        |                    | ciudad             |
        |                    | pais               |
        |                    | coordenadas        |
        |                    | fecha              |
        |                    +--------------------+
        |
        |  (AFTER INSERT)
        v
+------------------+
|  personas_log    |
|------------------|
| ID_LOG (PK)      |
| NOMBRE_USUARIO   |
| HORA_CREACION    |
+------------------+
```

---

## 🛠️ Requisitos

- Java JDK 8 o superior
- MySQL Server (o servicio tipo phpMyAdmin)
- IDE compatible (Eclipse, IntelliJ, NetBeans, etc.)

---

## ⚙️ Instalación

1. **Clona o descarga este repositorio:**

   ```bash
   git clone https://github.com/DaGuz06/proyectoAppJava
   ```

2. Añadir al Build Path las librerias
#### Opcional (Si lo quieres correr en local)
1. Abrir en XAMPP tanto Apache como MySQL
2. Importar la estructura de la base de datos
3. Correr el programa
---

## 🧑‍💻 Desarrolladores

Desarrollado por **David** y **Manuel**, estudiantes de desarrollo de aplicaciones web.
