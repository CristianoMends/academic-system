
const registerForm = document.getElementById('registerForm');

const btnLogin = document.getElementById('btnLogin');

btnLogin.addEventListener('click', function(event){
    event.preventDefault();
    registerForm.action = "/login";    
    registerForm.submit();
});

//--------------------------------------------------------------


//--------------------------------------------------------------


registerForm.addEventListener("submit", function(event) {
    event.preventDefault(); // Evita o envio do formulário padrão

    const nome = document.getElementById("name").value;
    const sobrenome = document.getElementById("surname").value;
    const dataNascimento = document.getElementById("date").value;
    const peso = document.getElementById("weight").value;
    const altura = document.getElementById("height").value;
    const nomeUsuario = document.getElementById("username").value;
    const senha = document.getElementById("password").value;

    const registerData = {
        nome:nome,
        sobrenome:sobrenome,
        dataNascimento:dataNascimento,
        peso:peso,
        altura:altura,
        nomeUsuario:nomeUsuario,
        senha:senha
    };

    fetch("/register/user", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(registerData)
    })
    .then(response => {
        if (response.ok) {
            alert("ok")
        } else {
            alert("deu erro")
        }
    })
    .catch(error => console.error("Erro ao fazer login:", error));
});