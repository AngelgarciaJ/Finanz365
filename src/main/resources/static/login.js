document.getElementById('loginForm').addEventListener('submit', async function(e) {
    e.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const response = await fetch('/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    });

    if (response.ok) {
        const data = await response.json();
        // Redirigir al dashboard del estudiante
        window.location.href = `/dashboard?role=${data.role}`;
    } else {
        alert('Login fallido. Por favor, verifique sus credenciales.');
    }
});
