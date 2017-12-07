$(document).ready(function () {
    var dados = sessionStorage.getItem('login');
    if(dados === null){
        window.location.href = "index.html";
    }
   
   $('#voltar').click(function (){
        window.location.href = "gerenciador.html";
    });
    
    $('#cadastrar').click(function (){
        
        if(validaParametro()){
            cadastraProduto();
        }
    });
    
    function cadastraProduto(){
        
        var lista = criarListaProdutos();
        
        var nome = $('#nome').val();
        var descricao = $('#descricao').val();
        var valor = $('#valor').val();
        var categoria = $('#categoria').val();
//            var imagem = $('#imagem')[0].files[0];

        var produto = 
        {
          "nome": nome,          
          "descricao": descricao,          
          "valor": valor,
          "tipoContato": categoria
        };
        
        lista.push(produto);
        lista = JSON.stringify(lista);
        sessionStorage.setItem('produtos', lista);
        limparCampos();
        
        alert('produto salvo com sucesso');
    }
    
    function limparCampos(){
        $('#nome').val('');
        $('#descricao').val('');
        $('#valor').val('');
    }
    
    function criarListaProdutos(){
        
        var data = sessionStorage.getItem('produtos');
        
        if(data === null)
        {
            var produtos = [];
            produtos = JSON.stringify(produtos);
            sessionStorage.setItem('produtos', produtos);
            data = sessionStorage.getItem('produtos');
        }
        
        data = JSON.parse(data);
        
        return data;
    }
    
    function validaParametro() {

        var nome = $('#nome').val();
        var descricao = $('#descricao').val();
        var valor = $('#valor').val();

        if (nome == '') {
            alert('Insira o nome');
            return false;
        }
        if (descricao == '') {
            alert('Insira a descricao');
            return false;
        }
        if (valor == 0) {
            alert('Insira o valor');
            return false;
        }

        return true;
    }
});
