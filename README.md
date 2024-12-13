# Spring Security Register with Email Validate
This project implements a user registration system with email validation using Spring Boot. The process ensures that when a new user signs aup, he/she receives a confirmation email containing a unique token to activate his/her account.

## Key Features

- **User Registration**: Users can register with their details such as name, username, email, and password.
- **Contiuonus Project** The relevant user information goes through the verification methods in the projects mentioned below. This project is a continuation of the mentioned projects;
  - https://github.com/RBaykan/Spring_Security_Validating_Data
  - https://github.com/RBaykan/Spring_Security_Validate_Data_With_Database
- **Email Validation**: After registration, a verification email containing a confirmation link is sent to the user's email address.
- **Token Based Validation**: The confirmation link contains a unique token that is used to verify the user's account.

## How It Works

### 1. User Registration

When a user's submits registration details via a POST request to the `/api/user` endpoint, a new user is created in the system. The registration process includes:

- Storing the user's information (name, surname, username, email, password). - A unique verification token is generated and stored in the database.

- An email containing a confirmation link is sent to the user.

### 2. Email Verification

When the user registers, they will receive an email to the provided address. The email contains a link to confirm their registration. The link looks like this:
`http://localhost:8080/api/user/registrationConfirm?token=some-unique-token`

The user needs to click the link to activate their account. The token in the URL is used to verify the user's identity and check if the token is still valid (not expired).

### 3. Email Sending

The email is sent through the system's mail service (configured in the application). Here’s what happens when the registration event is triggered:

- A **UUID token** is generated.
- A new **verification token** is created and stored in the database.
- The user’s email address is used to send the email containing the confirmation link.

#### Email Content:

- **Subject**: Registration Confirmation
- **Body**: The body of the email includes a message like this:
  - `Thank you for registering. Please confirm your email by clicking the link below: <confirmation URL>`

The confirmation URL will direct the user to the system, where the token will be validated.

### 4. Token Verification

Once the user clicks the confirmation link, they are directed to the `/api/user/registrationConfirm` endpoint with a query parameter `token`. The system verifies if the token is valid and not expired.

If the token is valid:
- The user’s account is marked as **enabled** (activated).
- A success message is returned, and the user is notified that their account has been enabled.

If the token is invalid or expired:
- The user receives an error message indicating the issue (e.g., "Invalid token" or "Expired token").

## How to Use

1. **Register a new user**:
 - Send a POST request to `/api/user` with the necessary user details (first name, last name, username, email, password).
 
2. **Confirm the registration**:
 - After receiving the email, click on the confirmation link sent to your email.

3. **Activate the account**:
 - Upon successfully confirming the token, your account will be activated.

## Notes:
- Define the email server and user.
  - I would set a place for this in the YAML file.
  - Instead of YAML, you can define a JavaMailSender object as @Bean. In this, I created a 'MailConfiguration' class in the 'configuration' package. You can fill it there.
  - With Depencedy Injection, your objects marked with YAML or @Bean will be connected to the Event Listener.
- In the message.properties file, you can create your message. The defined variable here is used in the EventListener.


## Technologies Used

- **Spring Boot**: Framework for building the backend services.
- **Spring Data JPA**: Used for managing user and verification token data.
- **Spring Mail**: For sending emails.
- **UUID**: For generating unique tokens for email verification.


