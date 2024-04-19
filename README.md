[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/xq5TwZF7)

# rc2-template-proyecto-individual-final

# LA LLAMA LASER STUDIO

Crea chivatos de cámara personalizados con tu diseño y recíbelos en casa.

![La Llama Logo](./frontend/src/presentation/assets/images/logo.png)

¡Olvídate de los chivatos aburridos! Personaliza tu cámara con nuestra app.

**Diseña chivatos únicos:**

- Elige entre diferentes tipografías y colores.
- Añade el texto que quieras.
- Impresión láser de alta calidad.
- Envío directo a tu casa.

**No solo chivatos:**

- Estrellas de foco para la felicidad de tu foquista.
- Etiquetas personalizadas para maletas Pelicase.

Sé el mejor auxiliar de cámara con todo lo necesario!

Descarga la app y empieza a crear.

## User Journey

[Enlace al Mural](https://app.mural.co/t/lallamalaserstudio5568/m/lallamalaserstudio5568/1710260674048/eb32dc281964ad79c6b8ae3f7c0c13afd030d255?sender=u5254e35ee752a47fd5003532)

## Design

[Diseño en Figma](https://www.figma.com/file/U4inHKj5Ddsl5EHHuv8w3k/La-Llama-Laser-Studio?type=design&node-id=0-1&mode=design&t=VFdynTUq1oA1VBe4-0)

## Technologies

![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![Vite](https://img.shields.io/badge/vite-%23646CFF.svg?style=for-the-badge&logo=vite&logoColor=white)
![React Router](https://img.shields.io/badge/React_Router-CA4245?style=for-the-badge&logo=react-router&logoColor=white)
![NPM](https://img.shields.io/badge/NPM-%23CB3837.svg?style=for-the-badge&logo=npm&logoColor=white)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)

![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)

![Markdown](https://img.shields.io/badge/markdown-%23000000.svg?style=for-the-badge&logo=markdown&logoColor=white)

## Installation

### FRONTEND

En la carpeta frontend introduce los siguientes comandos:

```
cd frontend
npm install
npm run dev
```

### BACKEND

Para lanzar el backend necesitamos una base de datos PostgreSQL según
la configuración de `src/main/resources/application.properties`.

```
./mvnw spring:boot run
```

## Architecture

### FRONTED FOLDER STRUCTURE

```
src
├───middleware
│   ├───context
│   └───router
├───presentation
│   ├───assets
│   │   ├───fonts
│   │   └───images
│   ├───components
│   │   ├───Banner
│   │   ├───Cart
│   │   ├───CartBar
│   │   ├───CustomModal
│   │   ├───Footer
│   │   ├───Header
│   │   ├───ModifyModal
│   │   ├───ProductDetail
│   │   ├───ProductList
│   │   └───TotalPrice
│   └───pages
└───services
```

### BACKEND FOLDER STRUCTURE

```
src
├───main
│   ├───java
│   │   └───com
│   │       └───lallamalaserstudio
│   │           └───backend
│   │               ├───controllers
│   │               │   ├───cart
│   │               │   └───tag
│   │               ├───persistence
│   │               │   ├───cart
│   │               │   └───tag
│   │               └───services
│   └───resources
│       ├───static
│       └───templates
└───test
    └───java
        └───com
            └───lallamalaserstudio
                └───backend
```

### BACKEND METHODS

| Method | Path              | Description                               |
| ------ | ----------------- | ----------------------------------------- |
| GET    | /api/products     | Shows all the products                    |
| GET    | /api/products/:id | Shows one product by id                   |
| GET    | /api/cart         | Shows all the products in the cart        |
| POST   | /api/cart         | Adds a product to the cart                |
| DELETE | /api/cart/:id     | Deletes product by id from the cart       |
| PUT    | /api/cart/:id     | Modifies product by id from from the cart |

## Screen shots

**Main page:**

![Capture Main page](./frontend/public/capture01.png)

**Detail page:**

![Capture Detail page](./frontend/public/capture02.png)

**Modal Customize:**

![Capture Customize modal](./frontend/public/capture03.png)

**Modal Customize Confirmation:**

![Capture Customize moda OK ](./frontend/public/capture04.png)

**Cart page:**

![Capture Customize moda OK ](./frontend/public/capture05.png)

## Credits

_Developer:_ [Olaya Sánchez](https://github.com/osaga-fu)
