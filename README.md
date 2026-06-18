# -_proyecto_factorizacion_de_derivadas_- :.
# Proyecto Factorización de Derivadas:

<img width="1254" height="1254" alt="image" src="https://github.com/user-attachments/assets/d63f6d0f-bbbe-4fd8-93ee-e7921ebea4e2" />  

```
## Java 21 + IntelliJ IDEA + Swing + Oracle Database 19c .

---

# Descripcion

Proyecto completo desarrollado en **Java 21** utilizando **IntelliJ IDEA**, **Swing** y **Oracle Database 19c**, que permite:

- Ingresar una función polinómica.
- Calcular su derivada.
- Factorizar la derivada (cuando sea factorizable).
- Mostrar el procedimiento y el resultado.
- Almacenar la información en Oracle Database 19c.
- Consultar el historial de cálculos almacenados.
- Utilizar una interfaz gráfica desarrollada en Swing.

---

# Funcionalidades

- ✅ Interfaz gráfica (Swing)
- ✅ Campo para ingresar la función
- ✅ Botón **Derivar**
- ✅ Botón **Guardar**
- ✅ Botón **Consultar**
- ✅ Historial mediante **JTable**
- ✅ Conexión a Oracle Database 19c mediante JDBC
- ✅ Arquitectura por capas
- ✅ Patrón DAO
- ✅ Arquitectura MVC

```

---

# Arquitectura del Proyecto

```
ProyectoFactorizacionDerivadas
│
├── src
│   ├── conexion
│   │      ConexionOracle.java
│   │
│   ├── modelo
│   │      Derivada.java
│   │
│   ├── dao
│   │      DerivadaDAO.java
│   │
│   ├── logica
│   │      CalculadoraDerivadas.java
│   │
│   ├── vista
│   │      FrmPrincipal.java
│   │
│   └── Main.java
│
└── script.sql
```

---

# Base de Datos Oracle

## Tabla

```sql
CREATE TABLE DERIVADAS
(
    ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,

    FUNCION VARCHAR2(300),

    DERIVADA VARCHAR2(300),

    FACTORIZACION VARCHAR2(300),

    FECHA_REGISTRO DATE DEFAULT SYSDATE
);
```

---

# Información Almacenada

Cada cálculo registrará la siguiente información:

| Campo | Ejemplo |
|--------|----------|
| Función | x² − 9 |
| Derivada | 2x |
| Factorización | 2(x) |
| Fecha | 17/06/2026 |

---

# Ejemplos de Funcionamiento

## Ejemplo 1

### Función

```text
f(x)=x²−9
```

### Derivada

```text
f'(x)=2x
```

### Factorización

```text
2x = 2(x)
```

---

## Ejemplo 2

### Función

```text
f(x)=x²+6x+9
```

### Derivada

```text
2x+6
```

### Factorización

```text
2(x+3)
```

---

## Ejemplo 3

### Función

```text
f(x)=3x²−12x
```

### Derivada

```text
6x−12
```

### Factorización

```text
6(x−2)
```

---

## Ejemplo 4

### Función

```text
f(x)=5x²+20x
```

### Derivada

```text
10x+20
```

### Factorización

```text
10(x+2)
```

---

## Ejemplo 5

### Función

```text
f(x)=4x³−12x²
```

### Derivada

```text
12x²−24x
```

### Factorización

```text
12x(x−2)
```

---

# Interfaz Gráfica

```text
-------------------------------------------------------

            FACTORIZACIÓN DE DERIVADAS

Función:

[________________________________________]

                [ DERIVAR ]

Derivada:

2x + 6

Factorización:

2(x+3)

        [ GUARDAR ]     [ CONSULTAR ]

-------------------------------------------------------

| Función | Derivada | Factorización | Fecha |
|----------|----------|---------------|-------|
|                                            |
|               JTable                       |
|                                            |

-------------------------------------------------------
```

---

# Registro en Oracle Database

Al presionar el botón **Guardar** se ejecutará:

```sql
INSERT INTO DERIVADAS
(
    FUNCION,
    DERIVADA,
    FACTORIZACION
)
VALUES
(
    ?,
    ?,
    ?
);
```

---

# Consulta del Historial

```sql
SELECT *
FROM DERIVADAS
ORDER BY ID;
```

---

# Tecnologías Utilizadas

- Java 21
- IntelliJ IDEA
- Swing
- JDBC
- Oracle Database 19c
- JTable
- MVC (Modelo – Vista – Controlador)
- DAO (Data Access Object)

---

# Flujo del Sistema

```text
Usuario

      │

      ▼

Ingresa Función

      │

      ▼

CalculadoraDerivadas

      │

      ├────────► Derivar

      │

      ├────────► Factorizar

      │

      ▼

Mostrar Resultado

      │

      ▼

Guardar

      │

      ▼

Oracle Database 19c

      │

      ▼

Consultar Historial

      │

      ▼

JTable
```

---

# Ventajas del Proyecto

- Arquitectura organizada por capas.
- Código modular y reutilizable.
- Fácil mantenimiento.
- Integración con Oracle Database 19c.
- Interfaz gráfica intuitiva.
- Persistencia de resultados.
- Separación entre lógica de negocio y acceso a datos.
- Escalable para incorporar nuevas funcionalidades.

---

# Posibles Mejoras

- Exportar resultados a PDF.
- Exportar historial a Excel.
- Gráfica de la función y su derivada.
- Historial con filtros por fecha.
- Búsqueda por función.
- Eliminación de registros.
- Edición de registros.
- Modo oscuro.
- Internacionalización (Español / Inglés).
- Integración con bibliotecas de álgebra simbólica.

---

# Observación Importante

La factorización simbólica de derivadas es un problema de **álgebra computacional**.

Si el programa debe aceptar expresiones arbitrarias (por ejemplo, polinomios de cualquier grado o expresiones más complejas), es recomendable integrar 
una biblioteca de matemáticas simbólicas, como **Symja**, para realizar la derivación y factorización de forma automática, robusta y precisa.

En cambio, si el alcance del proyecto se limita a polinomios de grado conocido, la lógica de derivación y factorización puede implementarse 
directamente en Java mediante algoritmos específicos para ese tipo de expresiones.

---

# Autor

Proyecto académico desarrollado con:

- Java 21
- IntelliJ IDEA
- Swing
- Oracle Database 19c
- JDBC
- Arquitectura MVC
- Patrón DAO

---
:. . / .
