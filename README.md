What is this Project about?
The idea behind this project is simple but powerful:
Most people don't realize how fast life moves until they see it. 
So we built a visual timeline that breaks down your life—week by week—from the day you were born.

With this app, users can not only view every week they've lived,
but also mark personal milestones, track major life events, and even reflect on global happenings that shaped their journey.
___________________________________________________________________________________________________________________________________
Project details :

Step1- The following must be installed in our system- 
(i)  JAVA (Programming language)
(ii) IDE (Eclipse/vscode)
(iii)MySQL (Database to store data)
(iv) POSTMAN (for sending request to server or send data to server in the form of JSON, since not created GUI using REACT/ANGULAR for sending request to server). we can also use Swagger to send request to server.
(v)Git (to upload projects on our github account)

Extra details that i have not added -
For Frontend(GUI)-
(v)React/Angular
--------------------------------------------------------------------------------------------------------------
Note: This is a Springboot + maven project (Powerful combo for building and running Java backend projects easily)	
      Spring Boot(Java framework to build web apps fast) 
      Maven(Tool to manage dependencies & build process)
-------------------------------------------------------------
Step2- Type 'Spring Initialize' on a browser &
       Start Creating Spring Initializer Project structure by giving Name,ArtifactId, group name,package name & choose java , java version, springboot .
       Need to add Some dependencies like (Spring Web ,Spring Boot DevTools, Lombok, Spring Data JPA,  MySQL Driver, Validation, Spring Security)cre
       Click generate then extract that downloaded zip & open in an IDE(Eclipse/VS code etc)

---------------------------------------------------------------------------------------------------------------

Step3- Start developing app so, Create the following packages and classes, or any other packages & classes depending on requirements of the project.
// === PACKAGE & CLASSES STRUCTURE ===

com.lifeinweeks.backend
├── controller
│   └── AuthController.java
│   └── EventController.java
├── dto
│   └── LoginRequestDto.java
│   └── RegisterRequestDto.java
│   └── EventDto.java
├── entity
│   └── User.java
│   └── Event.java
├── exception
│   └── ResourceNotFoundException.java
│   └── ValidationException.java
├── repository
│   └── UserRepository.java
│   └── EventRepository.java
├── service
│   └── UserService.java
│   └── EventService.java
│   └── impl
│       └── UserServiceImpl.java
│       └── EventServiceImpl.java
└── LifeInWeeksBackendApplication.java
___________________________________________________________________
In this project following things are managed:
✅ 1. User Management 
✅ 2. Event Management 
✅ 3. Backend & DB Configuration
✅ 4. DTOs (Data Transfer Objects) 
✅ Validation 
✅ Error Handling
----------------------------------------------------
Its apis are-
For User Apis-
POST: http://localhost:8081/api/user/register
POST: http://localhost:8081/api/user/login

For User Event Apis-
POST: http://localhost:8081/api/event/user/2/create
GET: http://localhost:8081/api/event/user/2/getAll
POST: http://localhost:8081/api/event/1
DELETE: http://localhost:8081/api/event/user/1/1/delete

--------------------------------------------------------
✅ 1. User Registration
POST /api/user/register
Accepts: username, email, password, birthDate
Validates input using @Valid
Saves user to database

✅ 2. User Login
POST /api/user/login
Accepts: username and password

✅ 3. Backend & DB Configuration
Configured MySQL database with Hibernate JPA
JDBC connection using application.properties
Table auto-creation using spring.jpa.hibernate.ddl-auto=update
Show SQL logs using spring.jpa.show-sql=true

✅ 4. DTOs (Data Transfer Objects)
RegisterRequestDto, LoginRequestDto, UserResponseDto for clean API input/output
EventDto for event input/output

✅ Validation
Using @Valid, @NotBlank, @Email, etc. in DTOs
Error messages shown if fields are missing or invalid

✅ Error Handling
Custom ResourceNotFoundException thrown if:
User not found
Event not found
Invalid login credentials
____________________________________________________________________

1).Add error handling for cases like:-
User not found
Event not found
Access denied
Validation errors

###################################################################################

_____________________USER IN POSTMAN______________________________________________________
Send User data in json form like the follwing using these apis- 
------------------------------------------------------------------------------
For User Registration:-
(i) Api - POST http://localhost:8081/api/user/register
(ii)Json data
{
  "username": "pragya",
  "password": "pragya123",
  "email": "p@example.com",
  "birthDate": "2000-01-01"
}
-------------------------------------------------------------------
For User Login :-
(i) Api -  POST http://localhost:8081/api/user/login
(ii)Json data
{
  "username": "pragya",
  "password": "pragya123"
}

____________________EVENT IN POSTMAN_____________________________________________________
🔹 Create Event :
POST http://localhost:8081/api/event/user/userId/create
Body (JSON):
--------------------------------------------------
1
  {
    "title": "Joined University",
    "category": "Education",
    "description": "Started computer science degree",
    "date": "2018-08-10"
  }
-------------------------------
2
{
  "title": "My Milestone",
  "category": "Personal",
  "description": "Graduated!",
  "date": "2022-06-01"
}
-------------------------------
3.
  {
    "title": "Started Hackathon Project",
    "category": "Project",
    "description": "Began developing 'Life in Weeks' app",
    "date": "2025-06-10"
  }
--------------------------------------------------------------------
🔹 Get All Events:
GET http://localhost:8081/api/event/user/userId/getAll
(Use same Basic Auth)

🔹 Update Event:
PUT http://localhost:8081/api/event/eventId

🔹 Delete Event:
DELETE http://localhost:8081/api/event/user/userId/eventId/delete

_____________Notes on Security:________________________________________________________________

We can use httpBasic() in the project for security.
we can also switch to JWT for token-based authentication if preferred.
Note: JWT is better for modern APIs (especially for Angular frontend). 
__________________________________________________________________
Validate Security Flow-
------------------------------------------------------------------
Action	        Endpoint	            Auth Required? Auth Type
------------------------------------------------------------------
Register User      POST /api/auth/register   ❌ No	       None
Login (test)	 POST /api/auth/login      ❌ No	       None
-------------------------------------------------------------------
Create Event	  POST /api/events	        ✅ Yes	Basic Auth
View All Events     GET/api/events	              ✅ Yes	Basic Auth
Update Event	  PUT  /api/events/{id}	        ✅ Yes	Basic Auth
Delete Event	  DELETE /api/events/{id}	  ✅ Yes	Basic Auth
*****************************************************************************************************

application properties changed from this to deploy on cloud:
# MySQL DB Config
spring.datasource.url=jdbc:mysql://localhost:3306/lifeinweeks_db
spring.datasource.username=root
spring.datasource.password=7488
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Config
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Swagger for documents all apis
#springdoc.api-docs.path=/api-docs
#springdoc.swagger-ui.path=/swagger-ui.html


#_____________________________________________________________________________________________________________
#How to Connect Front-end Angular(deployed on Netlify ) to Back-end Spring Boot(deployed on render):
Note:  Angular Frontend needs to know where the Backend is, similarly Spring Boot Backend also needs to know where requests are coming from.
1.Get Your render backend URL- here 'https://lifeinweeks-backend.onrender.com/api'
2.Update Angular's API base URL-  In api.service.ts or environment.prod.ts (where back-end dev URL is placed)
3.Update Config class- 'https://lifeinweeks-frontend.netlify.app' 
#______________________________________________________________________________________________________________________
To deploy on render successfully, need to do first: -
Run this 'chmod +x mvnw' on gitbash on local within project path - (this command adds  'execute' permission to the mvnw file)
Without this permission, Render throws a "Permission denied" error during build

Now that mvnw is executable:
Commit and push the change to GitHub:
git add mvnw
git commit -m "Add execute permission to mvnw"
git push origin master

Why it matters:
Render\u2019s build system uses Linux.
On Linux, a script like mvnw must be executable to run it.
chmod +x mvnw ensures it can be executed on Render.

#_______Also create render.yaml file in project add these properties____________________________________

services:
  - type: web
    name: lifeinweeks-backend
    env: java
    buildCommand: ./mvnw clean install
    startCommand: java -jar target/lifeinweeks-backend-0.0.1-SNAPSHOT.jar
    envVars:
      - key: PORT
        value: 8080
      - key: SPRING_DATASOURCE_URL
        value: "jdbc:postgresql://dpg-d1847jodl3ps738pqsjg-a.oregon-postgres.render.com:5432/lifeinweeks_db"
      - key: SPRING_DATASOURCE_USERNAME
        value: "lifeinweeks_db_user"
      - key: SPRING_DATASOURCE_PASSWORD
        value:"password of postgre db created on render"

#--------------------------------------------------------------
if aks render then fill-
Build command=  ./mvnw clean install
Start command=  java -jar target/*.jar  OR  java -jar target/lifeinweeks-backend-0.0.1-SNAPSHOT.jar

#------------------------------------
when create db in render it provides like this:
Hostname =dpg-d1847jodl3ps738pqsjg-a
Port =5432
Database= lifeinweeks_db
Username =lifeinweeks_db_user
Password = tskA5PPESvSdSM6UseZZTeLwdH3P0aN
External Database URL =postgresql://lifeinweeks_db_user:tskA5PPESvSdSM6UseZZTeLwdH3P0aNA@dp-d1847jodl3ps738pqsjg-a.oregon-postgres.render.com/lifeinweeks_db
#------------------------------------











