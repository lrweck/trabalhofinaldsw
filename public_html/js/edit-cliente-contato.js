$(document).ready(function () {

    var dados = sessionStorage.getItem('login');
    if (dados === null) {
        window.location.href = "index.html";
    }

    $('#voltar').click(function () {
        window.location.href = "gerenciador.html";
    });

    $('#resultado').hide();

    $('#pesquisar').click(function () {

        $('#tr-busca').remove();

        var busca = $('#busca').val();
        var tipoCad = $('input[name="cliente-contato"]:checked').val();

        var listaDados = tipoPesquisa(tipoCad);

        var registro = {};
        var registro = executaPesquisa(busca, listaDados);
        if (registro !== null) {

            var tipoCont = '';
            switch (registro.tipoContato)
            {
                case '1':
                    tipoCont = 'Telefone';
                    break;
                case '2':
                    tipoCont = 'Email';
                    break;
                case '3':
                    tipoCont = 'Site';
                    break;
            }

            var html = '\
                    <tr id="tr-busca">\n\
                        <td><input id="nome-busca" type="text" value="' + registro.nome + '" /></td>\n\
                        <td><input id="telefone-busca" type="text" value="' + registro.telefone + '" /></td>\n\
                        <td><input id="email-busca" type="text" value="' + registro.email + '" /></td>\n\
                        <td>' + tipoCont + '</td>\n\
                        <td><input id="salvar-busca" type="button" value="Salvar" data-id="' + registro.id + '" data-tipo="' + tipoCad + '" /></td>\n\
                        <td><input id="excluir-busca" type="button" value="Excluir" data-id="' + registro.id + '" data-tipo="' + tipoCad + '" /></td>\n\
                    </tr>';

            $('#table-resultados').append(html);

            $('#resultado').show();

        } else {
            $('#resultado').hide();
            alert('Não foi encontrado nenhum registro!');
        }
    });

    $(document).on('click', '#salvar-busca', function () {

        if (verificaCampos())
        {
            var id = $(this).data('id');
            var tipo = $(this).data('tipo');

            var listaDadosTipo = tipoPesquisa(tipo);

            for (i = 0; i < listaDadosTipo.length; i++)
            {
                if (id == listaDadosTipo[i].id) {
                    
                    var nome = $('#nome-busca').val();
                    var telefone = $('#telefone-busca').val();
                    var email = $('#email-busca').val();
                    
                    listaDadosTipo[i].nome = nome;
                    listaDadosTipo[i].telefone = telefone;
                    listaDadosTipo[i].email = email;
                    
                    var session = '';
                    if(tipo == 2)
                    {
                        session = 'clientes';
                    }else{
                        session = 'contatos';
                    }

                    sessionStorage.removeItem(session);
                    listaDadosTipo = JSON.stringify(listaDadosTipo);
                    sessionStorage.setItem(session, listaDadosTipo);
                    
                    $('#tr-busca').remove();
                    $('#resultado').hide();
                    $('#busca').val('');
                    alert('Sucesso ao editar o registro');
                    
                    break;
                }
            }
        }
    });

    $(document).on('click', '#excluir-busca', function () {

        var id = $(this).data('id');
        var tipo = $(this).data('tipo');        
        if(excluir(id, tipo))
        {
            $('#tr-busca').remove();
            $('#resultado').hide();
            $('#busca').val('');
            alert('Sucesso ao excluir');
        }else
        {
            alert('Erro ao excluir');
        }
    });

    function excluir(id, tipoCad) {
        
        var listaDadosTipo = tipoPesquisa(tipoCad);

        var result = null;
        for (i = 0; i < listaDadosTipo.length; i++)
        {
            if (id == listaDadosTipo[i].id)
            {
                listaDadosTipo.splice(i, 1);
                
                var session = '';
                if(tipoCad == 2)
                {
                    session = 'clientes';
                }else{
                    session = 'contatos';
                }
                
                sessionStorage.removeItem(session);
                listaDadosTipo = JSON.stringify(listaDadosTipo);
                sessionStorage.setItem(session, listaDadosTipo);
                
                return true;
            }
        }
        
        return false;
    }

    function executaPesquisa(busca, listaDados) {

        for (i = 0; i < listaDados.length; i++)
        {
            if (busca == listaDados[i].nome)
            {
                return listaDados[i];
            }

        }
        return null;
    }

    function tipoPesquisa(tipoCad) {

        var listData = [];

        if (tipoCad == 1) {
            listData = sessionStorage.getItem('contatos');
            listData = JSON.parse(listData);

        } else {
            listData = sessionStorage.getItem('clientes');
            listData = JSON.parse(listData);
        }

        return listData;
    }

    function verificaCampos() {
        var nome = $('#nome-busca').val();
        var telefone = $('#telefone-busca').val();
        var email = $('#email-busca').val();

        if (nome == '')
        {
            alert('Insira o nome');
            return false;
        }
        if (telefone == '')
        {
            alert('Insira o telefone');
            return false;
        }
        if (email == '')
        {
            alert('Insira o email');
            return false;
        }
        return true;
    }
});
    