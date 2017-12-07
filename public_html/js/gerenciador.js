$(document).ready(function(){
   
    var dados = sessionStorage.getItem('login');
    if(dados === null){
        window.location.href = "index.html";
    }
    
    $('#voltar').click(function (){
        window.location.href = "layout.html";
    });
   
   $('#logout').click(function (){
        
        sessionStorage.removeItem("login");
        window.location.href = "layout.html";
    });
    
    var empresa = sessionStorage.getItem('empresa');
    empresa = JSON.parse(empresa);
    
    
    var html = '<select>';
    for(i = 1; i < 4; i++){
        
        var selected = '';
        if(i == empresa.layout)
        {
            selected = 'selected';
        }
        html += '<option value="'+i+'" '+selected+'>Layout '+i+'</option>';
    }
    html += '</select>';
    $('#select-layout').append(html);
    
    $('#select-layout').change(function(){
        
        var novoLayout = $(this).find(":selected").val();
        
        var dataEmpresa = sessionStorage.getItem('empresa');
        dataEmpresa = JSON.parse(dataEmpresa);
        dataEmpresa.layout = novoLayout;
        
        dataEmpresa = JSON.stringify(dataEmpresa);
        
        sessionStorage.removeItem('empresa');
        sessionStorage.setItem('empresa', dataEmpresa);
        
        alert('Novo layout selecionado com sucesso');
    });
    
    var listaCliente = sessionStorage.getItem('clientes');
    listaCliente = JSON.parse(listaCliente);
    if(listaCliente.length > 0){
        gerarGrafico(listaCliente, 'graf-cliente');
    }
    
    var listaContato = sessionStorage.getItem('contatos');
    listaContato = JSON.parse(listaContato);
    if(listaContato.length > 0){
        gerarGrafico(listaContato, 'graf-contato');
    }
    
    var listaProdutos = sessionStorage.getItem('produtos');
    listaProdutos = JSON.parse(listaProdutos);
    if(listaProdutos !== null || listaProdutos.length > 0){
        gerarGrafico(listaProdutos, 'graf-produto');
    }
    
    //listaDados array de objetos JS que contém as informações nencessárias para gerar o gráfico
    //tipoGrafico nome da div que será gerado o gráfico
    function gerarGrafico(listaDados, tipoGrafico) {
        
        var telefone =0;
        var email =0;
        var site =0;
        for(i = 0; i < listaDados.length; i++)
        {
            if(listaDados[i].tipoContato == 1){
                telefone++;
            }
            if(listaDados[i].tipoContato == 2){
                email++;
            }
            if(listaDados[i].tipoContato == 3){
                site++;
            }
        }
        
        Morris.Donut({
            element: tipoGrafico,
            data: [
                {label: "Telefone", value: telefone},
                {label: "Email", value: email},
                {label: "Site", value: site}
            ]
        });
    }
    
});
