document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("logout").addEventListener("click", () => {
        logout();
    });

    document.getElementById("registerForm").addEventListener("submit", (e) => {
        e.preventDefault();
        registerTransaction();
    });
});

function openRegisterModal() {
    document.getElementById('registerModal').style.display = 'block';
}

function closeRegisterModal() {
    document.getElementById('registerModal').style.display = 'none';
}

function navigateToGraphs() {
    window.location.href = "/student/graphs";
}

function navigateToPlanner() {
    window.location.href = "/student/planner";
}

function navigateToReport() {
    window.location.href = "/student/report";
}

function logout() {
    fetch("/api/logout", {
        method: "POST",
    })
        .then(response => {
            if (response.ok) {
                window.location.href = "/login";
            }
        })
        .catch(error => console.error("Error cerrando sesión:", error));
}

function registerTransaction() {
    const transaction = {
        tipo: document.getElementById("type").value,
        categoria: document.getElementById("category").value,
        descripcion: document.getElementById("description").value,
        monto: parseFloat(document.getElementById("amount").value),
        fecha: new Date().toISOString().split('T')[0]  // Fecha actual en formato YYYY-MM-DD
    };

    fetch("/api/transactions", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(transaction)
    })
        .then(response => {
            if (response.ok) {
                closeRegisterModal();
                alert("Transacción registrada con éxito.");
                // Aquí puedes agregar código para actualizar la vista o los datos de la página
            } else {
                alert("Error registrando la transacción.");
            }
        })
        .catch(error => console.error("Error registrando la transacción:", error));
}
