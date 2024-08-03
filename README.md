# Crime Record Management System

This project is an automated system for managing and storing all the records related to criminals over a particular area. It includes records for all criminals according to their crimes, dates of crimes, and punishment periods.


## Installation

1. Clone the repository
    ```sh
    git clone https://github.com/saneeitas/crime-record-management-system.git
    ```
2. Navigate to the project directory
    ```sh
    cd crime-record-management-system
    ```
3. Configure your PostgreSQL database in `application.properties`
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/crime_db
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    ```
4. Install the project dependencies
    ```sh
    mvn install
    ```

## Running the Application

1. Run the application using your IDE or the command line
    ```sh
    mvn spring-boot:run
    ```
2. The application will start on port `8080` by default.

## API Documentation

### Criminal Endpoints

#### Create a Criminal

**Endpoint:** `POST /api/criminals`

**Request Body:**
```json
{
  "name": "Sanee Itas",
  "dateOfBirth": "1990-01-01"
}
```

#### Get All Criminals
**Endpoint:** `POST /api/criminals`

#### Get Criminal by ID
**Endpoint:** `GET /api/criminals/{id}`


####  Update a Criminal
**Endpoint:** `PUT /api/criminals/{id}`
**Request Body:**
```json
{
  "name": "Muhammad Sani",
  "dateOfBirth": "2000-01-01"
}
```

#### Delete a Criminal
**Endpoint:** `DELETE /api/criminals/{id}`


#### Crime Endpoints

#### Create a Crime
**Endpoint:** `POST /api/crimes`
**Request Body:**
```json
{
  "type": "Robbery",
  "description": "Bank robbery",
  "dateOfCrime": "2022-01-01",
  "criminalId": 1
}
```

#### Get All Crimes
**Endpoint:** `GET /api/crimes`

#### Get Crime by ID
**Endpoint:** `GET /api/crimes/{id}`

#### Update a Crime
**Endpoint:** `PUT /api/crimes/{id}`
**Request Body:**
```json
{
  "type": "Robbery Updated",
  "description": "Bank robbery updated",
  "dateOfCrime": "2022-01-01",
  "criminalId": 1
}
```
#### Delete a Crime
**Endpoint:** `DELETE /api/crimes/{id}`


#### Punishment Endpoints

#### Create a Punishment
**Endpoint:** `POST /api/punishments`
**Request Body:**
```json
{
  "type": "Imprisonment",
  "duration": "5 years",
  "criminalId": 1,
  "crimeId": 1
}
```
#### Get All Punishments
**Endpoint:** `GET /api/punishments`

#### Get Punishment by ID
**Endpoint:** `GET /api/punishments/{id}`

#### Update a Punishment
**Endpoint:** Endpoint: PUT /api/punishments/{id}
**Request Body:**
```json
{
  "type": "Imprisonment Updated",
  "duration": "6 years",
  "criminalId": 1,
  "crimeId": 1
}
```
#### Delete a Punishment
**Endpoint:** `DELETE /api/punishments/{id}`