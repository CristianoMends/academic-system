function navigateTo(route) {
    switch (route) {
        case 'home':
            window.location.href = '/';
            break;
        case 'forum':
            window.location.href = '/forum';
            break;
        case 'profile':
            window.location.href = '/profile';
            break;
        default:
            break;
    }
}

//botao de ir para perfil
const btnUser = document.getElementById("btnUser");
btnUser.addEventListener('click',function(){
    window.location = '/profile';
})

function btnLoginOut(element){
    if(element.innerText == 'Logout'){
        document.getElementById('customAlert').style.display = 'block';
    }else if(element.innerText == 'Login'){
        window.location = '/login';
    }
}


//funcao de fechar confirmacao
function closeCustomAlert() {
    document.getElementById('customAlert').style.display = 'none';
}

function confirmAction() {
    window.location = '/logout'
    closeCustomAlert();
}

