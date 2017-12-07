$(document).ready(function(){
    
    var dados = sessionStorage.getItem('empresa');
    if(dados.length == 0){
        window.location.href = "index.html";
        
    }    
    
    $('#cadastro').hide();
    $('#cadastre-se').click(function(){
        $('#cadastro').show();
    });
    
    $('#registrar-contato').click(function (){
        
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
            
            var listContatos = sessionStorage.getItem('contatos');
            listContatos = JSON.parse(listContatos);
            listContatos.push(contato);
            listContatos = JSON.stringify(listContatos);
            sessionStorage.setItem('contatos', listContatos);
            limparContato();
            alert('Contato salvo com sucesso');
            
        }
        
    });
    
    function limparContato(){
        $('#cadastro-nome').val('');
        $('#cadastro-telefone').val('');
        $('#cadastro-email').val('');
        $('#cadastro').hide();
    }
    
    dados = JSON.parse(dados);
    
    var props = carregarPropiedades(dados.layout);
    
    $('body').css({"background": props.backcolor, "font-family": props.font});
    
    $('#title').addClass(props.h1);
    $('#title').text(dados.nome);
    $('#cnpj').text('CNPJ: '+dados.cnpj);
    
    $('#gerenciador').click(function(){
        
        var dados = sessionStorage.getItem('login');
        
        console.log(dados);
        if(dados !== null){
            window.location.href = "gerenciador.html";
        
        }else{
            window.location.href = "login.html";
        }
    });
    
    var listaProdutos = sessionStorage.getItem('produtos');
    
    var html = '';
    if(listaProdutos === null){
        
        var html = '<span>Nenhum produto cadastrado!!!</span>';
        $('body').append(html);
    
    }else{
        
        listaProdutos = JSON.parse(listaProdutos);
        console.log(listaProdutos);
        
        for(i = 0; i < listaProdutos.length; i++){
            html = '<div class="produto"><img class="img-produto" src="img/'+i+'.jpg" /><br /><label class="nome-produto">'+ listaProdutos[i].nome + '</label><br /><label class="valor">Preço (R$) : '+listaProdutos[i].valor+'</label><br /></div>';
            $('#lista-produtos').append(html);
        }
    }
    
    function carregarPropiedades(layout){

        var color = '';
        var font = '';

        if(layout == 1){
            color = 'red';
            font = 'Serif';
        }else if(layout ==2){
            color = 'yellow';
            font = 'Sans-serif';
        }else{
            color = 'green';
            font = 'Monospace';
        }

        var propriedades = 
        {
            "h1" : "h1-layout" + layout,
            "backcolor" : color,
            "font" : font
        };

        return propriedades;
    }
    
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
});