const API_URL = "https://apisguerra-arep.ddns.net:8443/api";

async function register() {
    const username = document.getElementById("new-username").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("new-password").value;

    const response = await fetch(`${API_URL}/register`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, email, password })
    });

    const data = await response.json();
    
    if (response.ok) {
        alert("Registro exitoso. Redirigiendo a inicio de sesión...");
        window.location.href = "index.html"; // Redirige a la página de login
    } else {
        alert(data.message || "Error en el registro");
    }
}

async function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const response = await fetch(`${API_URL}/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    });

    const data = await response.json();
    
    if (response.ok) {
        localStorage.setItem("token", data.token);
        alert("Inicio de sesión exitoso");
        document.getElementById("auth").style.display = "none";
        document.getElementById("secured-content").style.display = "block";
    } else {
        alert(data.message || "Error en el inicio de sesión");
    }
}

async function getGreeting() {
    const token = localStorage.getItem("token");
    console.log("Token enviado:", token);
    const response = await fetch(`${API_URL}/greeting`, {
        headers: { "Authorization": `Bearer ${token}` }
    });

    const data = await response.text();
    document.getElementById("response").innerText = data;
}

async function getServerTime() {
    const token = localStorage.getItem("token");

    const response = await fetch(`${API_URL}/time`, {
        headers: { "Authorization": `Bearer ${token}` }
    });

    const data = await response.text();
    document.getElementById("response").innerText = data;
}
