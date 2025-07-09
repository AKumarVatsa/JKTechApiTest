

## Tech Stack

| Tool/Library      | Purpose                                |
|-------------------|----------------------------------------|
| Java (17)         | Programming language                   |
| RestAssured       | API automation                         |
| TestNG            | Test execution framework               |
| ExtentReports     | HTML reporting                         |
| Maven             | Build and dependency management        |
| GitHub Actions    | CI/CD pipeline                         |
| JaCoCo            | Code coverage                          |

## API Coverage

**CRUD operations** 

- **User Management**  
  - Create User  
  - Generate Token  
  - Get User  

- **Book Collection**  
  - Add Book  
  - Get Book
  - Update Book
  - Delete Book 

## How to View GitHub Actions Reports
Go to repo URL (https://github.com/AKumarVatsa/JKTechApiTest.git) → Actions
Click on the latest workflow run.
Scroll to Artifacts.
Download-Extent Report (ExtentReports.html)

Generate Allure Report
allure serve target/allure-results
allure generate target/allure-results --clean -o target/allure-report



