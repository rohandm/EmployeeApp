# EmployeeApp
Employee management application

This is a demo microservice which exposes basic employee management apis to frontend/batch client.

## Table Of Contents
* [Running the service](#execute-app)
* [Loading data](#load-data)
* [Invoking APIs](#invoke-app)
  * [Load Initial data](#load-data)
  * [Add Employee](#add-emp)
  * [Update Employee](#update-emp)
  * [Delete Employee](#delete-emp)
  * [Get Employee by Id](#get-emp)
  * [Get all Employees](#get-all-emp)

## <a name="tech"></a>Technologies used
  * Spring Boot
  * Spring JPA
  * Spring REST
  * Spring Security
  * H2 embedded database
  * Maven
## <a name="execute-app"></a>Running the service
  * Download the code and run the service from command prompt using below command
  `java -jar target/EmployeeApp.jar` command.
  
## <a name="load-data"></a>Loading data
  * Copy the required data which the service needs to be intialized with to ./data/init.csv and invoke loadData api using below command
  ``
## <a name="invoke-app"></a>Invoking APIs
  ### <a name="add-emp"></a>Add Employee
  * Use postman tool or run below curl command
  `curl -i -X POST -H "Content-type:application/json" -d '{"firstName":"firstName1", "lastName":"lastName1", "dateOfBirth":"12-05-1085", "dateOfEmployment":"12-05-1085"}' localhost:8080/employees -u admin:password`
  
  ### <a name="update-emp"></a>Update Employee
  * Use postman tool or run below curl command
  `curl -i -X PUT -H "Content-type:application/json" -d '{"firstName":"firstName1", "lastName":"lastName1", "dateOfBirth":"12-05-1085", "dateOfEmployment":"12-05-1085"}' localhost:8080/employees -u admin:password`
  
  ### <a name="delete-emp"></a>Delete Employee
  * Use postman tool or run below curl command
  `curl -i -X DELETE localhost:8080/employees/1 -u admin:password`
  
  ### <a name="get-emp"></a>Get Employee by Id
  * Use postman tool or run below curl command
  `curl localhost:8080/employees/1 -u user:password` where 1 is employee Id.
  
  ### <a name="get-all-emp"></a>Get all Employees
  * Use postman tool or run below curl command
  `curl localhost:8080/employees -u user:password`
  


