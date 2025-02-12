
# Certificate Generation and Management System

## 📌 Project Description
The **Certificate Generation and Management System** is a web-based ERP project that automates the process of requesting, verifying, and issuing certificates for students. It provides role-based access for different users, ensuring smooth interaction between students and administrative departments.

## 🚀 Features
- **Role-Based Login:** Separate access for Students, Admin, Library, Accounts, and Scholarship departments.
- **Student Module:** Request certificates, check notifications, and collect certificates from the office.
- **Admin Module:** Verify student requests, generate certificates, and notify students.
- **Library, Accounts, and Scholarship Modules:** Verify and approve department-specific certificate requests.
- **Notifications System:** Automated notifications for students regarding certificate request status.

## 🛠️ Tech Stack
- **Backend:** Spring Boot (Spring MVC)
- **Frontend:** HTML, CSS, Bootstrap, JavaScript
- **Database:** MySQL

## 📂 Folder Structure
```
📦 ERP-Project
├── 📁 src        # Spring Boot backend and frontend files
├── 📁 database   # Database schema and scripts
└── README.md     # Project Overview
```

## 🔧 Setup Instructions
1. **Clone the Repository**
   ```bash
   git clone https://github.com/Ajinkya-Dhavale/ERP-Project.git
   cd ERP-Project
   ```
2. **Backend & Frontend Setup** (Spring Boot + Spring MVC)
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
3. **Database Setup** (MySQL)
   - Import the provided SQL schema from the `database` folder.
   - Update `application.properties` with database credentials.

## 🎯 Usage
- Students can request certificates and track their status.
- Admin can verify requests, generate certificates, and send notifications.
- Departments (Library, Accounts, Scholarship) handle approvals before certificate issuance.

## 🤝 Contributing
Contributions are welcome! Feel free to fork the repository and submit pull requests.

## 📜 License
This project is open-source and available under the [MIT License](LICENSE).
