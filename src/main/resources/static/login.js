// conexioon con la api local
const BASE_URL = process.env.API_BASE_URL || 'http://localhost:8080';


document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    fetch('/api/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, password })
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Credenciales incorrectas');
            }
        })
        .then(data => {
            window.location.href = '/student/dashboard';
        })
        .catch(error => {
            alert(error.message);
        });
});
