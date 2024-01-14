### How to Run
1. Clone the project.
2. Open it in VS-code or Eclipse.
3. Click on the run button. (In the case of Eclipse, choose "Run as Spring Boot Application")

**Note: Install appropriate plugins for smooth running for any Spring Boot application.**

### Postman Collection

[Postman Collection](./Anji%20Reddy-Kirana%20Register.postman_collection.json)

### Project Overview

- This project is designed for storing credit/debit card transactions.
- It generates detailed daily reports.
- Provides functionality to view all recorded transactions.

**Note: Features like customer management, security, card level management, multi-user, etc., are mentioned in the assignment.**

### About Database Transaction Management

- Utilizes `@Transactional` for the `recordTransaction` method to ensure atomic database operations.
- Spring Data JPA uses optimistic locking by default.
- Potential race conditions in `getDailyReport` if multiple transactions modify the same data concurrently. However, as of now, there is no exposed API to modify transactions, so it is fine.