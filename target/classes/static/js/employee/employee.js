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
        //password: document.getElementById('password').value
    };

    var formData = new FormData();
    formData.append('employee', JSON.stringify(employee)); // Send employee as a JSON string
    formData.append('idProof', document.getElementById('idProof').files[0]);
    formData.append('profilePicture', document.getElementById('profilePicture').files[0]);
    formData.append('resume', document.getElementById('resume').files[0]);

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