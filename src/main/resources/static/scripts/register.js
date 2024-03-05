
const registerForm = document.getElementById('registerForm');

const btnLogin = document.getElementById('btnLogin');

btnLogin.addEventListener('click', function(event){
    event.preventDefault();
    window.location = "/login";
});

//--------------------------------------------------------------


//--------------------------------------------------------------


registerForm.addEventListener("submit", function(event) {
    event.preventDefault(); // Evita o envio do formulário padrão

    const name = document.getElementById("name").value;
    const surname = document.getElementById("surname").value;
    const courseName = document.getElementById("courses").value;
    const year = document.getElementById("year").value;
    const semester = document.getElementById("semester").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const registerData = {
        name:name,
        surname:surname,
        courseName:courseName,
        startYear:year,
        startSemester:semester,
        email:email,
        password:password
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
            alertMessage.innerText = "Cadastro bem sucedido!.";
            alertMessage.classList.add('show');
        
            setTimeout(function() {
                alertMessage.classList.remove('show');
                window.location.href = '/login';
            }, 2000);
        } else {
            alertMessage.innerText = "Ocorreu um erro, tente novamente!.";
            alertMessage.classList.add('show');
        
            setTimeout(function() {
                alertMessage.classList.remove('show');
            }, 2000);
        }
    })
    .catch(error => console.error("Erro ao fazer login:", error));
});