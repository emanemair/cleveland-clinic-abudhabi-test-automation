# 🧪 Cleveland Clinic Abu Dhabi Website Test Automation

This project is an automated UI test suite for verifying the functionality of the [Cleveland Clinic Abu Dhabi](https://www.clevelandclinicabudhabi.ae/en) website using Selenium WebDriver, TestNG, and Java.

## 📌 Features Covered

- ✅ Homepage loading with visible banners and footer
- ✅ Navigation menu links verification
- ✅ Language validation (HTML lang attribute)
- ✅ Global search functionality
- ✅ Request an appointment form submission
- ✅ BMI Calculator logic verification

## 🧰 Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven (optional)
- ChromeDriver
- JavaScriptExecutor (for complex interactions)


## 🧪 Test Cases Overview

| Test ID | Description |
|--------|-------------|
| T001 | Validate Homepage layout (Navbar, banners, footer) |
| T002 | Test navigation links and verify expected URLs |
| T003 | Verify HTML language tag is `en` |
| T004 | Test global search input and result |
| T005 | Automate and verify full appointment form submission |
| T006 | Verify BMI calculator computes and displays correct result |

## ⚙️ Setup Instructions

1. Clone the repository.
2. Ensure you have [Java JDK 8+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/) installed.
3. Install dependencies using Maven or add them manually to your IDE.
4. Update values in `TestData.java` to fit your test parameters.
5. Run tests using TestNG XML configuration or directly through your IDE.

## 🚨 Important Notes

- Use JS executor to handle elements that are not interactable by default.
- Make sure the website is accessible and you're not blocked by IP/firewall when running the tests.
- Handle waits carefully as many elements on the site load asynchronously.

## 👩🏻‍💻 Author

Eman Emair  
📫 emanimair2@gmail.com  


---


