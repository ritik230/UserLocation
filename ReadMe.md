
**User Location Solution**


Technologies Used

Spring Boot
Gradle
HSQLDB
Spring Security


Requirements

Java 8 or higher
Gradle


Installation

Clone the repository.
Run the following command to start the application: ./gradlew bootRun.


Usage

Endpoint 1: /get_userLocation (GET) - Retrieve a list of users.
Endpoint 2: /create_userLocation (POST) - Create a new user.
Endpoint 3: /users/{id} (PUT) - Update a specific user by ID.


Security

ADMIN role: Can perform CRUD operations.
READER role: Can only perform GET operations.



Authors

RITIK GUPTA