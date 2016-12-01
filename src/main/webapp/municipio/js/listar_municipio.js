$(function () {
    var carregar = {
        municipio: function (id) {
            $.ajax({
                url: 'municipio',
                type: 'POST',
                dataType: 'json',
                data: {
                    id_uf: id,
                    acao: 'ajax_listar'
                },
                success: function (data, textStatus, jqXHR, errorThrown) {
                    $.each(data.array, function (k, v) {
                        $('#select_mun').append('<option value="' + v.id + '">' + v.municipio + '</option>');
                    });
                    
                    $('#select_uf').change(function(){
                        $('#select_mun').html('');
                    });
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(errorThrown);
                }
            });
        }
    };

    $('#select_uf').change(function () {
        carregar.municipio($('#select_uf').val());
    });
});