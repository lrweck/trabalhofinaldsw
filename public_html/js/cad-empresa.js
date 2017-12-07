$(document).ready(function(){
    
    $('#clear').click(function(){
        sessionStorage.clear();
    });
    $('#enviar').click(function(){
        
        if(validaParametro()){
            
            var nome = $('#nome-empresa').val();
            var cnpj = $('#cnpj-empresa').val();
            var email = $('#email-empresa').val();
            var telefone = $('#telefone-empresa').val();
            var layout = $('input[name="layout"]:checked').val();

            var empresa = {
                "nome": nome,
                "cnpj": cnpj,
                "email": email,
                "telefone": telefone,
                "layout": layout
            };
            
            var myJSON = JSON.stringify(empresa);
            
            sessionStorage.setItem('empresa', myJSON);
            admUser();
            contatos();
            clientes();
            window.location.href = "layout.html";
        }
    });
    
    function validaParametro(){
        
        var nome = $('#nome-empresa').val();
        var cnpj = $('#cnpj-empresa').val();
        var email = $('#email-empresa').val();
        var telefone = $('#telefone-empresa').val();
        
        if(nome == ''){
            alert('Insira o nome');
            return false;
        }
        if(cnpj == ''){
            alert('Insira o cnpj');
            return false;
        }
        if(email == ''){
            alert('Insira o email');
            return false;
        }
        if(telefone == ''){
            alert('Insira o telefone');
            return false;
        }
        
        return true;
    }
    
    function admUser(){
        
        var users = [];
        
        var admin = {
            "user": "admin",
            "pass": "admin"
        };
        
        users.push(admin);

        var myJSON = JSON.stringify(users);
        sessionStorage.setItem('users', myJSON);
        
        alert('Usuário: "admin" / Senha: "admin"');
    }
    function contatos(){
        
        var contatos = [];
        contatos = JSON.stringify(contatos);
        sessionStorage.setItem('contatos', contatos);
    }
    
    function clientes(){
        
        var clientes = [];
        clientes = JSON.stringify(clientes);
        sessionStorage.setItem('clientes', clientes);
    }
});