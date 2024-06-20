// dashboard.js
document.addEventListener("DOMContentLoaded", function() {
    const dashboardContent = document.getElementById('dashboard-content');

    // Aquí puedes agregar lógica para cargar dinámicamente el contenido del dashboard
    dashboardContent.innerHTML = `
        <p>Bienvenido, estudiante. Aquí podrás ver tu información y gestionar tus finanzas.</p>
    `;
});


// Abrir el modal
function openModal() {
    document.getElementById('modal').style.display = 'flex';
}

// Cerrar el modal
function closeModal() {
    document.getElementById('modal').style.display = 'none';
}

// Cerrar el modal cuando el usuario haga clic fuera de él
window.onclick = function(event) {
    var modal = document.getElementById('modal');
    if (event.target == modal) {
        modal.style.display = 'none';
    }
}
