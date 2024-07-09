## Second test task of the _Doczilla_ platform
### 🟦 Description:
The application operates an own (_internal_) student database. The application allows adding entries to the database and deleting them, as well as fetching all entries from it. The first two operations can be done via the user interface (via the buttons). The fetching of the entries happens automatically whenever the page loads.

The application has both front-end and back-end implemented, written on _**Vanilla JavaScript**_ and on _**Java**_ using _**Spring Boot**_ respectively.

### 🟩 Application Start:
The application uses `PostgreSQL`.\
It can be started by running the ```main``` method of the ```Application``` class.

### ❗ Important Notes:
The app automatically creates the schema and the table **in default database** for performing the database operations, so **make sure `PostgreSQL` is installed and configured before running the application**.

### ⛔ Constraints:
* The student list is **not** updated without updating the page.
* The unique numbers are not being updated after deletion of an entry, meaning if a student entry is deleted with the unique number of `6` and there were `6` entries in the table before the deletion, the new entry will have a unique number `7`. In other words, **the increment of the unique numbers does not reset**.