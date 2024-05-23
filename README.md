# Library Management System

This is a simple command-line interface (CLI) Library Management System built with Java and Gradle.

## Prerequisites

- Java 17 or later
- Gradle

## Setup and Usage

### 1. Clone the Repository

```sh
git clone <repository_url>
cd <repository_directory>
```


### 2. Build the Project

To compile the project, run the following command:

```sh
./gradlew build
```

This command will compile the source code, run the tests, and package the application.

### 3. Run the Application

To run the application, use the following command:

```sh
./gradlew run
```

### 4. Running Tests

To run the tests, use the following command:

```sh
./gradlew test
```

This command will compile the test source code and run the tests using JUnit 5 and EasyMock.

### Gradle Tasks

- `./gradlew build`: Compiles the source code, runs the tests, and packages the application.
- `./gradlew run`: Runs the main application.
- `./gradlew test`: Compiles and runs the tests.

## Dependencies

This project uses the following dependencies:

- **JUnit 5**: For writing and running tests.
- **EasyMock**: For mocking dependencies in tests.

These dependencies are specified in the `build.gradle` file:

```gradle
dependencies {
    testImplementation 'org.easymock:easymock:5.2.0'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.2'
}
```

## Notes

- Ensure your project directory follows the appropriate structure for Gradle to recognize your source and test files.
- The main source files should be located in `src/main/java`.
- The test source files should be located in `src/test/java`.
- Modify the `build.gradle` file if you change the directory structure or add new dependencies.
