/*------------------------------------------------------------------------------ */
//acoes ao clicar em cadastrar conta
const loginForm = document.getElementById('loginForm');
const btnCreateAccount = document.getElementById('btnCreateAccount');

btnCreateAccount.addEventListener('click', function (event) {
    event.preventDefault();
    window.location = "/register"
    
});

/*------------------------------------------------------------------------------- */
loginForm.addEventListener('submit', function (event) {
    event.preventDefault();

    const checkbox = document.getElementById('remember');

    if (checkbox.checked) {
        const email = loginForm.elements['email'].value;
        const password = loginForm.elements['password'].value;

        localStorage.setItem('formData', JSON.stringify({ email, password }));

    } else {
        localStorage.removeItem('formData');
    }
})

// Preencher o formulário com os dados salvos, se existirem

window.addEventListener('load', function () {
    const savedData = localStorage.getItem('formData');

    if (savedData) {
        const { email, password } = JSON.parse(savedData);

        document.getElementById('email').value = email;
        document.getElementById('password').value = password;
    }
});

/*--------------------------------------------------------------------------- */

/*--------------------------------------------------------------------------- */
loginForm.addEventListener("submit", function(event) {
    event.preventDefault(); // Evita o envio do formulário padrão

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const loginData = {
        email: email,
        password: password
    };

    const alertMessage = document.getElementById("alertMessage");



    fetch("/login/user", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(loginData)
    })
    .then(response => {
        if (response.ok) {
            alertMessage.innerText = "Login bem sucedido!";
            alertMessage.innerHTML += `<div id="load" class="load"></div>`;
            alertMessage.classList.add('show');
        
            setTimeout(function() {
                alertMessage.classList.remove('show');
                window.location = '/';
            }, 2000);
        } else {
            alertMessage.innerText = "Email ou senha inválidas. Por favor, tente novamente.";
            //alertMessage.innerHTML += `<div id="load" class="load"></div>`;
            alertMessage.classList.add('show');
        
            setTimeout(function() {
                alertMessage.classList.remove('show');
            }, 2000);
        }
    })
    .catch(error => console.error("Erro ao fazer login:", error));
});
