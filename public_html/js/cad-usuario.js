$(document).ready(function () {
    
    var dados = sessionStorage.getItem('login');
    if(dados === null){
        window.location.href = "index.html";
    }

    $('#cadastrar').click(function () {

        if (validaParametro()) {

            var users = sessionStorage.getItem('users');
            users = JSON.parse(users);

            var nome = $('#nome').val();
            var senha = $('#senha').val();

            var newUser =
            {
                "user": nome,
                "pass": senha
            };
            
            users.push(newUser);
            
            users = JSON.stringify(users);
            
            sessionStorage.setItem('users', users);
            limpaCampos();
            
            alert('Usuário cadastrado com sucesso!');
        }
    });
    
    $('#voltar').click(function (){
        window.location.href = "gerenciador.html";
    });
    
    function limpaCampos(){
        $('#nome').val('');
        $('#senha').val('');
        $('#email').val('');
    }

    function validaParametro() {

        var nome = $('#nome').val();
        var senha = $('#senha').val();

        if (nome == '') {
            alert('Insira o nome');
            return false;
        }
        if (senha == '') {
            alert('Insira a senha');
            return false;
        }

        return true;
    }
});
