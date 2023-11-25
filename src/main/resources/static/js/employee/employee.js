document.getElementById('employeeForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var employee = {
        firstName: document.getElementById('firstName').value,
        middleName: document.getElementById('middleName').value,
        lastName: document.getElementById('lastName').value,
        email: document.getElementById('email').value,
        hireDate: document.getElementById('hireDate').value,
        role: document.getElementById('role').value,
        dateOfBirth: document.getElementById('dateOfBirth').value,
        phone: document.getElementById('phone').value,
        address: document.getElementById('address').value,
        idProof: document.getElementById('idproof').files[0],
        password: document.getElementById('password').value,
        profilePicture: document.getElementById('profilePicture').files[0],
        resume: document.getElementById('resume').files[0]
    };

    var formData = new FormData();
    for (var key in employee) {
        formData.append(key, employee[key]);
    }

    fetch('/api/employee/create', {
        method: 'POST',
        body: formData,
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});