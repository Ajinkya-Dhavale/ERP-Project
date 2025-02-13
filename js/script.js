let previousSection = 'student-login'; 

document.addEventListener("DOMContentLoaded", function () {
    const buttons = document.querySelectorAll(".role-button-container button");
    const underline = document.querySelector(".underline");

    buttons.forEach((button) => {
        button.addEventListener("click", function () {
          
            setActiveButton(this);
            moveUnderline(this, underline);
        });
    });

 
    const defaultActiveButton = document.querySelector(".btn-student");
    if (defaultActiveButton) {
        defaultActiveButton.click();
    }
});

function showStudentLogin() {
    toggleVisibility('student-login');
    setActiveButton(document.querySelector('.btn-student'));
    previousSection = 'student-login';
}

function showDepartmentOptions() {
    toggleVisibility('department-selection');
    setActiveButton(document.querySelector('.btn-department'));
    previousSection = 'department-selection';
}

function showDepartmentLogin(dept) {
    document.getElementById('department-title').innerText = dept + " Login";
    toggleVisibility('department-login');
    setActiveButton(document.querySelector('.btn-department'));
    previousSection = 'student-login'; // Update to department login
}

function showAdminLogin() {
    toggleVisibility('admin-login');
    setActiveButton(document.querySelector('.btn-admin'));
    previousSection = 'admin-login';
}

function showForgotPassword() {
    toggleVisibility('forgot-password');
    setActiveButton(document.querySelector('.btn-student')); // Set active button to student
    previousSection = 'student-login';
}

function goBack() {
    let sections = ['student-login', 'department-selection', 'department-login', 'admin-login', 'forgot-password'];
    sections.forEach(section => document.getElementById(section).classList.add('hidden'));

    if (previousSection === 'department-login') {
        showDepartmentOptions();
    } else if (previousSection === 'forgot-password') {
        showStudentLogin();
    } else {
        showStudentLogin();
    }

    const studentButton = document.querySelector('.btn-student');
    setActiveButton(studentButton); // Set the active button to student
    moveUnderline(studentButton, document.querySelector('.underline')); // Move underline to student button
}

function toggleVisibility(sectionId) {
    let sections = ['student-login', 'department-selection', 'department-login', 'admin-login', 'forgot-password'];
    sections.forEach(section => {
        if (section === sectionId) {
            document.getElementById(section).classList.remove('hidden');
        } else {
            document.getElementById(section).classList.add('hidden');
        }
    });
}

function setActiveButton(button) {
    const buttons = document.querySelectorAll('.role-button-container button');
    buttons.forEach(btn => {
        btn.classList.remove('active');
    });
    button.classList.add('active');
}

function moveUnderline(button, underline) {
    const buttonRect = button.getBoundingClientRect();
    const containerRect = button.parentElement.getBoundingClientRect();
    underline.style.width = `${buttonRect.width}px`;
    underline.style.left = `${buttonRect.left - containerRect.left}px`;
    underline.style.transition = "left 0.3s ease, width 0.3s ease"; // Add transition for smooth movement
}