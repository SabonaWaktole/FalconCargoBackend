```markdown
# Nordic Cargo Backend

A simple backend service for managing cargo shipments from Ethiopia to other countries. Built with **Java** and **Spring Boot**.

```

## 📁 Project Structure

```

src/
├── main/
│   ├── java/com/nordic/cargo/backend/
│   │   ├── Common/        # Configs, Exceptions, Responses, Utils
│   │   ├── Controller/    # REST controllers
│   │   ├── Model/         # Entity models (Person, Good)
│   │   ├── Repositories/  # Spring Data JPA repositories
│   │   ├── Service/       # Business logic
│   │   └── NordicCargoBackendApplication.java  # Main application
│   └── resources/         # application.properties, templates, static files
└── test/                  # Unit tests

```


## ⚡ Features

- Store and manage cargo shipment info (`PersonModel`, `GoodModel`).  
- RESTful API with Spring Boot (`InfoController`).  
- Handles sender/receiver roles using `PersonRole` enum.  
- Custom exceptions and API responses (`BadRequestException`, `ApiResponse`, etc.).  

---

## 🛠️ Technologies

- Java 21+  
- Spring Boot  
- Spring Data JPA / Hibernate  
- Maven  
- PostgreSQL or any JPA-supported DB  

---

## 🚀 Running the Project

1. Clone the repository:

```bash
git clone git@github.com:BojuCode/NordicCargo-Backend.git
cd NordicCargoBackend
````

2. Build the project:

```bash
./mvnw clean install
```

3. Run the application:

```bash
./mvnw spring-boot:run
```

4. Access APIs at:

```
http://localhost:8080/api
```

---

## 📦 Notes

* All configuration is in `src/main/resources/application.properties`.
* Entities are in `Model/` folder, services in `Service/`, and controllers in `Controller/`.
* Utils, exceptions, and response classes are under `Common/`.

---

## 🔖 License

This project is licensed under the [Apache License 2.0](https://github.com/BojuCode/NordicCargo-Backend/blob/main/LICENSE).


```
