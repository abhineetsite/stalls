document.getElementById('employeeForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var employee = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        email: document.getElementById('email').value,
        hireDate: document.getElementById('hireDate').value
    };

    fetch('/api/employee/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(employee),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});