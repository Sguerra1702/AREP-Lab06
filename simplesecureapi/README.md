# 🔐 Simple Secure API: Spring Boot with JWT Authentication and AWS Deployment

## 📌 Overview
Simple Secure API is a **Spring Boot** application that implements **JWT-based authentication** to secure REST endpoints. It provides a simple authentication system with **Spring Security**, **MongoDB**, and a secure HTTPS connection using a keystore. The application is deployed on **AWS EC2 (Amazon Linux 2023)**.

---

## ✨ Features

✅ **User authentication with JWT** (Login, Token Generation, Token Validation).  
✅ **Role-based authorization** (Secure endpoints using JWT).  
✅ **MongoDB for user storage** (Spring Data MongoDB).  
✅ **CORS Configuration** for frontend integration.  
✅ **Keystore-based HTTPS security**.  
✅ **Deployment on AWS EC2 (Amazon Linux 2023)**.

---

## 🚀 Setup and Execution

### 🛠 Prerequisites

🔹 **Java 23+**  
🔹 **Maven**  
🔹 **MongoDB** (Local or Atlas)  
🔹 **AWS EC2 Instance (Amazon Linux 2023)**


---
## 🌐 Frontend Deployment on AWS EC2

### 1️⃣ **Launch an EC2 Instance for the Frontend**
- Choose **Amazon Linux 2023**.
- Configure security group to allow **HTTP (port 80)**.
- Connect via SSH:
  ```sh
  ssh -i your-key.pem ec2-user@your-ec2-public-ip
  ```

### 2️⃣ **Install Apache HTTP Server**
```sh
sudo yum update -y
sudo yum install -y httpd
sudo systemctl start httpd
sudo systemctl enable httpd
```

### 3️⃣ **Deploy Frontend Files**
Upload your frontend files (`index.html`, `app.js`, `styles.css`, etc.) to `/var/www/html/`:
```sh
cd /var/www/html/
```
✅ Your directory structure should look like this:
```
/var/www/html/
├── index.html
├── register.html
├── app.js
├── styles.css
```

### 4️⃣ **Access the Frontend**
- Open your browser and enter the **EC2 Public IP**:
  ```
  http://your-ec2-public-ip/
  ```

### 🌐 Deploying the backend on AWS EC2 (Amazon Linux 2023)

1️⃣ **Connect to your AWS EC2 instance**
```sh
ssh -i your-key.pem ec2-user@your-ec2-instance-ip
```

2️⃣ **Install Java 17 on EC2**
```sh
sudo yum install -y java-23-amazon-corretto
```

3️⃣ **Transfer the JAR file to EC2**  
On your local machine:
```sh
scp -i your-key.pem target/simplesecureapi.jar ec2-user@your-ec2-instance-ip:/home/ec2-user/
```

4️⃣ **Run the application on EC2**
```sh
java -jar simplesecureapi.jar &
```

5️⃣ **Access the application**
```sh
https://your-ec2-instance-ip:8080/
```

---

## 📂 Project Structure

```
simplesecureapi/
├── src/
│   ├── main/
│   │   ├── java/edu/eci/arep/simplesecureapi/
│   │   │   ├── config/
│   │   │   │   ├── CorsConfig.java
│   │   │   │   ├── SecurityConfig.java
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── SecureController.java
│   │   │   ├── model/
│   │   │   │   ├── User.java
│   │   │   ├── repository/
│   │   │   │   ├── UserRepository.java
│   │   │   ├── security/
│   │   │   │   ├── JwtUtil.java
│   │   │   ├── service/
│   │   │   │   ├── UserService.java
│   ├── resources/
│   │   ├── keystore/
│   │   │   ├── keystore.p12
│   │   ├── application.properties
├── target/
│   ├── simplesecureapi-0.0.1-SNAPSHOT.jar
├── README.md
```

---

## 🔥 REST API Endpoints

### 📌 Authentication
| **Endpoint**          | **Method** | **Description** |
|----------------------|------------|----------------|
| `/auth/login`       | **POST**    | User login and JWT generation |
| `/auth/register`    | **POST**    | Register new user |


📌 **Example Login Request**

The examples can be seen in the video inserted in the moodle asignment


---

## **👨‍💻 Author**
📌 Developed by **Santiago Guerra Penagos**.

🔹 GitHub: [Sguerra1702](https://github.com/Sguerra1702)  
🔹 Email: santiago.guerra@mail.escuelaing.edu.co

