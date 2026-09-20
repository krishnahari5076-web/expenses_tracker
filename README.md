# Expense Tracker

A backend Expense Tracker application built using **Java, Spring Boot, Spring Data JPA, and PostgreSQL**. The application provides REST APIs for managing expenses and generating useful expense summaries.

## 🚀 Features

* Add a new expense
* Get all expenses
* Get an expense by ID
* Update an existing expense
* Delete an expense
* Filter expenses by category
* Calculate daily total expenses
* Calculate total expenses for the current month
* Calculate category-wise monthly expenses

## 🛠️ Technologies Used

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **PostgreSQL**
* **Gradle**
* **REST API**
* **Postman** for API testing

## 📂 Project Structure

```text
src/main/java/com/example/expensestracker
│
├── Controller
│   └── ExpensesController.java
│
├── Service
│   └── ExpensesService.java
│
├── repository
│   └── ExpensesRepository.java
│
└── entity
    └── Expenses.java
```

## 🔗 API Endpoints

| Method | Endpoint                                         | Description                     |
| ------ | ------------------------------------------------ | ------------------------------- |
| POST   | `/expenses`                                      | Add a new expense               |
| GET    | `/expenses`                                      | Get all expenses                |
| GET    | `/expenses/{id}`                                 | Get expense by ID               |
| PUT    | `/expenses/{id}`                                 | Update an expense               |
| DELETE | `/expenses/{id}`                                 | Delete an expense               |
| GET    | `/expenses/category?category=Food`               | Filter expenses by category     |
| GET    | `/expenses/monthly-total`                        | Get current month's total       |
| GET    | `/expenses/category/monthly-total?category=Food` | Get category-wise monthly total |

## 💾 Database

The application uses **PostgreSQL** to store expense information.

Each expense contains:

* ID
* Title
* Amount
* Category
* Description
* Date

## 🧪 API Testing

All REST APIs were tested using **Postman**.

Example request:

```text
GET /expenses/category?category=Food
```

Example response:

```json
[
  {
    "id": 1,
    "title": "Breakfast",
    "amount": 100,
    "category": "Food",
    "description": "Morning breakfast",
    "date": "2026-09-20"
  }
]
```

## 🔮 Future Enhancements

* Date-wise expense view
* Monthly budget management
* Budget alerts
* Category-wise analytics
* Expense charts and dashboard
* Search and advanced filtering
* User authentication and authorization
* Frontend integration

## 👨‍💻 Author

**Hari Krishna**

This project is being developed as part of my learning journey in **Java Backend and Full Stack Development**.
