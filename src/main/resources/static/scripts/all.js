
function navigateTo(route) {
    const user = document.getElementById("btnUser").innerText;
    const customAlert = document.querySelector('#customAlert');

    switch (route) {

        case 'home'://o usuario pode ir para a pagina principal a qualquer momento
            window.location.href = '/';
            break;
        case 'forum'://caso o usuario queira ir para perfil, ele precisa estar logado no sistema antes
            if(user == '...'){

                customAlert.innerHTML = `
                <div class="alert-content">
                    <span class="close" onclick="closeCustomAlert()">&times;</span>
                    <p>Você precisa estar logado para acessar esta funcionalidade.</p>
                    <button onclick="confirmAction('/login')">Entrar</button>
                    <button onclick="confirmAction('/register')">Cadastrar-se</button>
                </div>`;
                customAlert.style.display = 'block';
                return;

            }else{
                window.location.href = '/forum';
            }
            break;
        case 'profile'://caso o usuario queira ir para perfil, ele precisa estar logado no sistema antes
            if(user == '...'){

                customAlert.innerHTML = `
                <div class="alert-content">
                    <span class="close" onclick="closeCustomAlert()">&times;</span>
                    <p>Você precisa estar logado para acessar esta funcionalidade.</p>
                    <button onclick="confirmAction('/login')">Entrar</button>
                    <button onclick="confirmAction('/register')">Cadastrar-se</button>
                </div>`;
                customAlert.style.display = 'block';
                return;

            }else{
                window.location.href = '/profile';
            }
            break;
        default:
            break;
    }
}

//botao de ir para pagina de perfil
//se o usuario nao logou no sistema retorna mensagem
const btnUser = document.getElementById("btnUser");
btnUser.addEventListener('click',function(){
    if(btnUser.innerText == '...'){
        const customAlert = document.querySelector('#customAlert');
        customAlert.innerHTML = `
        <div class="alert-content">
        <span class="close" onclick="closeCustomAlert()">&times;</span>
        <p>Você precisa estar logado para acessar esta funcionalidade.</p>
        <button onclick="confirmAction('/login')">Entrar</button>
        <button onclick="confirmAction('/register')">Cadastrar-se</button>
        </div>`;
        customAlert.style.display = 'block';
        return;
    }
    window.location = '/profile';
})

function btnLoginOut(element){
    if(element.innerText == 'Logout'){
        const customAlert = document.querySelector('#customAlert');
        customAlert.innerHTML = `
        <div class="alert-content">
            <span class="close" onclick="closeCustomAlert()">&times;</span>
            <p>Deseja realmente deslogar do sistema?</p>
            <button onclick="confirmAction('/logout')">Deslogar</button>
        </div>`;
        customAlert.style.display = 'block';
    }else if(element.innerText == 'Login'){
        window.location = '/login';
    }
}

//funcao de fechar confirmacao
function closeCustomAlert() {
    document.getElementById('customAlert').style.display = 'none';
}

function confirmAction(route) {
    window.location = route
    closeCustomAlert();
}

