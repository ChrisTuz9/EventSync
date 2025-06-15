# EventSync

## Setting Up Environment Variables

To securely configure your database credentials and other
sensitive information, you need to set environment variables
on your local machine. Follow the steps below to set up the
required environment variables.

⚠️ Note:
The H2 database credentials (such as spring.datasource.username and spring.datasource.password) are configured via environment variables purely for demonstration purposes.

### Example Environment Variables
- `H2_DB`: DB name key (e. g., testdb).
- `H2_USERNAME`: DB user key.
- `H2_PASSWORD`: DB password key.
- `HF_API_TOKEN`: Hugging Face api token.

### Setting Environment Variables on Windows

1. Go to System Properties → Advanced → Environment Variables.
2. Add a new variable under User variables or System variables.
3. Set the name and value, then click OK.

### Setting Environment Variables on macOS/Linux

1. Open Terminal.
2. Add the `export` commands to your shell configuration file (e.g., `~/.bashrc`, `~/.zshrc`):

    ```sh
    echo "export H2_DB=testdb" >> ~/.bashrc
    echo "export H2_USER=your_username" >> ~/.bashrc
    echo "export H2_PASSWORD=your_password" >> ~/.bashrc
    echo "export HF_API_TOKEN=your_api_token" >> ~/.bashrc
    ```

3. Source the configuration file to apply the changes:

    ```sh
    source ~/.bashrc
    ```

### Setting Environment Variables in IntelliJ IDEA (Alternative)

1. Open IntelliJ IDEA and go to `Run` → `Edit Configurations`.
2. Select your Spring Boot/Gradle run configuration.
3. In the `Environment Variables` field, click the `...` button.
4. Add the required environment variables.
5. Click `OK` to save the configuration.

## Running Locally

### Using Local H2

1. You can run the application from your IDE (e.g., IntelliJ IDEA) using your configured run configuration, or from the terminal using:
   ```sh
    ./mvnw spring-boot:run
    ```
2. After starting the application, you can access the H2 web console at:
   ```sh
    http://localhost:8080/h2-console
    ```
   Use the following connection settings:
   * JDBC URL: your_database (e. g., jdbc:h2:mem:testdb)
   * Username: your_username
   * Password: your_password