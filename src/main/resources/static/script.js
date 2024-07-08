const apiUrl = 'http://localhost:8080/api';

document.getElementById('addStudentForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const student = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        patronymic: document.getElementById('patronymic').value,
        dateOfBirth: document.getElementById('dateOfBirth').value,
        studyGroup: document.getElementById('group').value
    };

    fetch(apiUrl + '/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(student)
    }).then(response => {
        if (response.ok) {
            alert('The student has been added successfully');
        } else {
            alert('Error when adding a student');
        }
    });
});

document.getElementById('deleteStudentForm')
    .addEventListener('submit', function(event) {
    event.preventDefault();

    const studentId = document.getElementById('studentIdToDelete').value;

    fetch(apiUrl + '/delete?id=' + studentId, {
        method: 'DELETE'
    }).then(response => {
        if (response.ok) {
            alert('The student has been deleted successfully');
        } else {
            alert('Error when deleting a student');
        }
    });
});

function fetchStudents() {
    fetch(apiUrl + '/get-all')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('studentTableBody');
            data.forEach(e => {
                const row = document.createElement('tr');
                row.innerHTML = `
                            <td>${e.id}</td>
                            <td>${e.first_name || ''}</td>
                            <td>${e.last_name || ''}</td>
                            <td>${e.patronymic || ''}</td>
                            <td>${e.date_of_birth || ''}</td>
                            <td>${e.study_group || ''}</td>
                        `;
                tableBody.appendChild(row);
            });
        });
}

fetchStudents();