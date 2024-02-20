/*------------------------------------------------------------------------------ */
//acoes ao clicar em cadastrar conta
const loginForm = document.getElementById('loginForm');
const btnCreateAccount = document.getElementById('btnCreateAccount');

btnCreateAccount.addEventListener('click', function (event) {
    event.preventDefault();
    loginForm.action = "/register";
    loginForm.submit();
});

/*------------------------------------------------------------------------------- */
loginForm.addEventListener('submit', function (event) {
    event.preventDefault();

    const checkbox = document.getElementById('remember');

    if (checkbox.checked) {
        const username = loginForm.elements['username'].value;
        const password = loginForm.elements['password'].value;

        localStorage.setItem('formData', JSON.stringify({ username, password }));

    } else {
        localStorage.removeItem('formData');
    }
})

// Preencher o formulário com os dados salvos, se existirem

window.addEventListener('load', function () {
    const savedData = localStorage.getItem('formData');

    if (savedData) {
        const { username, password } = JSON.parse(savedData);

        document.getElementById('username').value = username;
        document.getElementById('password').value = password;
    }
});

/*--------------------------------------------------------------------------- */

/*------------------------------------------------------------------------------- */
//Acoes de slide de background
const main = document.querySelector('main');
const NUM_IMAGES = 4;
const INTERVALO = 10000;

const images = [];
for (let i = 1; i <= NUM_IMAGES; i++) {
    const img = new Image();
    img.src = `/src/b${i}.jpg`;
    images.push(img);
}

function changeBackground(num) {
    const imageIndex = num % NUM_IMAGES || NUM_IMAGES;

    const imageBackground = `url(/src/b${imageIndex}.jpg)`;
    main.style.backgroundImage = imageBackground;

    setTimeout(function () {
        changeBackground(num + 1);
    }, INTERVALO);
}
changeBackground(1);
/*--------------------------------------------------------------------------- */
loginForm.addEventListener("submit", function(event) {
    event.preventDefault(); // Evita o envio do formulário padrão

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const loginData = {
        nomeUsuario: username,
        senha: password
    };

    fetch("/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(loginData)
    })
    .then(response => {
        if (response.ok) {
            window.location.href = '/main';
        } else {
            const alertMessage = document.getElementById("alertMessage");
            alertMessage.textContent = "Usuário ou senha inválidas. Por favor, tente novamente.";
            alertMessage.style.display = 'flex';

            setTimeout(function() {
                alertMessage.style.display = 'none';
            }, 3000);
        }
    })
    .catch(error => console.error("Erro ao fazer login:", error));
});
