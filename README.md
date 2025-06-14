# EventSync

## Setting Up Environment Variables

To securely configure your database credentials and other
sensitive information, you need to set environment variables
on your local machine. Follow the steps below to set up the
required environment variables.

### Example Environment Variables

- `POSTGRES_USER`: DB user key.
- `POSTGRES_PASSWORD`: DB password key.
- `POSTGRES_DB`: DB name key.
- `POSTGRES_HOST`: DB host key.
- `POSTGRES_PORT`: DB port.
- `HF_API_TOKEN`: Hugging Face api token.

### Setting Environment Variables on Windows

1. Go to System Properties → Advanced → Environment Variables.
2. Add a new variable under User variables or System variables.
3. Set the name and value, then click OK.

### Setting Environment Variables on macOS/Linux

1. Open Terminal.
2. Add the `export` commands to your shell configuration file (e.g., `~/.bashrc`, `~/.zshrc`):

    ```sh
    echo "export POSTGRES_USER=your_username" >> ~/.bashrc
    echo "export POSTGRES_PASSWORD=your_password" >> ~/.bashrc
    echo "export POSTGRES_DB=your_database" >> ~/.bashrc
    echo "export POSTGRES_HOST=localhost" >> ~/.bashrc
    echo "export POSTGRES_PORT=5432" >> ~/.bashrc
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
5. Click `OK` to save the configuration.****

## Running Locally

### Using Local PostgreSQL

1. Start your PostgreSQL instance and create the database.
2. Set the environment variables as above.
3. Run the application:

    ```sh
    ./mvnw spring-boot:run
    ```