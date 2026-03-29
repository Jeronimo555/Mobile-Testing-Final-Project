# Mobile Automation Final Project

This repository contains the final project for the Mobile Automation course. The primary objective is to consolidate knowledge in mobile test automation using **Java 17**, **Maven**, **Appium**, and **TestNG**. The tests are executed on a native Android application (WDIO dummy app) using the Page Object Model (POM) design pattern to ensure test independence, maintainability, and robustness.

## Tech Stack & Prerequisites
Before you begin, ensure you have the following installed on your machine:
* **Java 17** (JDK)
* **Maven**
* **Node.js & npm** (To install Appium)
* **Appium Server** 2.x
* **Android Studio** (For the emulator and SDK tools)

---

## Environment Setup

### 1. Starting the Pixel 7 Emulator (Android Studio)
To run the tests, you need a running Android device. This project is configured to run on a **Pixel 7** emulator.

1. Open **Android Studio**.
2. Navigate to **Tools > Device Manager**.
3. Locate your **Pixel 7** emulator in the list. *(If you don't have one, click "Create Device", select Pixel 7, and download a recent system image like API 33 or higher).*
4. Click the **Play button** next to the Pixel 7 to launch the emulator.
5. Wait for the emulator to fully boot up to the home screen.

### 2. Starting the Appium Server
Appium acts as the bridge between your Java code and the Android emulator.

1. Open your terminal or command prompt.
2. If you haven't installed Appium yet, run: `npm install -g appium`
3. If you haven't installed the UIAutomator2 driver, run: `appium driver install uiautomator2`
4. Start the server by running the following command:
   ```bash
   appium

## Running the Tests
The test suite covers four main scenarios: Bottom Navigation Bar, Successful Sign Up, Successful Login, and Swipe Cards. Each test is designed to run independently.

1. Open the project in IntelliJ IDEA.
2. Navigate to ```src/test/java/com/globant/mobile/tests/.```
3. To run all tests, right-click the ```tests``` folder and select Run **'Tests in 'tests'**.
4. To run a specific test (e.g., SwipeTest.java), open the file, click the green Play arrow next to the class name or the @Test method, and select Run.
   

## Project Structure
This project strictly adheres to the Page Object Model (POM) pattern, separating UI selectors and interactions from test assertions.
```│   .gitignore
│   pom.xml
│   README.md
├───.idea   
├───.mvn
├───src
│   └───test
│       └───java
│           └───com
│               └───globant
│                   └───mobile
│                       ├───screens
│                       │       BaseScreen.java
│                       │       DragScreen.java
│                       │       FormScreen.java
│                       │       HomeScreen.java
│                       │       LoginScreen.java
│                       │       MenuScreen.java
│                       │       SwipeScreen.java
│                       │       WebViewScreen.java
│                       │       
│                       ├───tests
│                       │       BaseTest.java
│                       │       BottomBarNavigationTest.java
│                       │       LoginTest.java
│                       │       SignUpTest.java
│                       │       SwipeTest.java
│                       │       
│                       └───utils
│                               DataGenerator.java
```

## Scenarios Automated
- Bottom Navigation Bar (```BottomBarNavigationTest.java```): Navigates through each section using the bottom bar and asserts visibility of expected elements.

- Successful Sign Up (```SignUpTest.java```): Navigates to the Signup section, generates dynamic unique email data via DataGenerator.java, and verifies successful registration.

- Successful Login (```LoginTest.java```): Logs in with a generated user and verifies success.

- Swipe Cards (```SwipeTest.java```): Swipes horizontally through a carousel verifying card visibility states, then performs a vertical swipe to locate hidden text.