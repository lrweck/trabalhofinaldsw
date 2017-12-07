$(document).ready(function(){
    
    $('#login').click(function(){
        
        if(verifcaUser()){
            window.location.href = "gerenciador.html";
        }else{
            alert('Usuário ou senha incorretos');
        }
        
    });
    
    function verifcaUser(){
        var dados = sessionStorage.getItem('users');
        dados = JSON.parse(dados);
        
        var user = $('#user').val();
        var pass = $('#password').val();
        
        console.log(dados);
        console.log(dados.length);
        
        for(i = 0; i < dados.length; i++){
        
            if(user == dados[i].user){
                if(pass == dados[i].pass){

                    var logado = 
                    {
                     "user" : user,          
                     "password" : pass          
                    };

                    logado = JSON.stringify(logado);
                    sessionStorage.setItem('login', logado);                

                    return true;
                    
                }
            }
        }
        return false;
    }
});