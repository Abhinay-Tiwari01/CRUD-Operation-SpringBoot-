 Student CRUD Operation — Short Description
This Spring Boot application provides a simple CRUD (Create, Read, Update, Delete) system for managing student records.

Create:
Users can add a new student by filling a form (name, address, etc.) and submitting it.
Data is saved in the database.

Read:
All saved students are displayed in a table on the welcome page.
Users can see the full student list.

Update:
Users can edit an existing student’s details by clicking the Edit button.
The same form is reused for updating.
The record is updated in the database.

Delete:
Users can delete a single student using the Delete button next to each row.
Also, there is an option to Delete All Students at once with confirmation.

 Key Features
Built with Spring Boot + Thymeleaf.

Uses Spring Data JPA for database operations.

Auto-increment primary key (@GeneratedValue).

Simple Bootstrap frontend for UI.

Search box to filter students (optional, can be added).