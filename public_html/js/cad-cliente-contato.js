$(document).ready(function(){
   
    var dados = sessionStorage.getItem('login');
    if(dados === null){
        window.location.href = "index.html";
    }
    
    $('#voltar').click(function (){
        window.location.href = "gerenciador.html";
    });
    
    $('#registrar-cliente').click(function (){
        
        if(verificaCampos())
        {
            var nome = $('#cadastro-nome').val();
            var telefone = $('#cadastro-telefone').val();
            var email = $('#cadastro-email').val();
            var tipoContato = $('input[name="cadastro-tipo"]:checked').val();
            var id = new Date().getTime();
             
            var contato = 
            {
                "id": ''+id,
                "nome": nome,
                "telefone": telefone,
                "email": email,
                "tipoContato": tipoContato
            };
            
            var tipoCad = $('input[name="cliente-contato"]:checked').val();
            
            if(tipoCad ==2){
                var listaClientes = sessionStorage.getItem('clientes');
                listaClientes = JSON.parse(listaClientes);
                listaClientes.push(contato);
                listaClientes = JSON.stringify(listaClientes);
                sessionStorage.setItem('clientes', listaClientes);
                limpar();
                alert('Cliente salvo com sucesso');
                
            }else{
                var listContatos = sessionStorage.getItem('contatos');
                listContatos = JSON.parse(listContatos);
                listContatos.push(contato);
                listContatos = JSON.stringify(listContatos);
                sessionStorage.setItem('contatos', listContatos);
                limpar();
                alert('Contato salvo com sucesso');
            }
            
        }
        
    });
    function verificaCampos(){
        var nome = $('#cadastro-nome').val();
        var telefone = $('#cadastro-telefone').val();
        var email = $('#cadastro-email').val();
        
        if(nome == '')
        {
            alert('Insira o nome');
            return false;
        }
        if(telefone == '')
        {
            alert('Insira o telefone');
            return false;
        }
        if(email == '')
        {
            alert('Insira o email');
            return false;
        }
        return true;
    }
    
    function limpar(){
        $('#cadastro-nome').val('');
        $('#cadastro-telefone').val('');
        $('#cadastro-email').val('');
    }
});
    