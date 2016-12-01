$(function () {
    $.ajax({
        url: 'uf',
        type: 'POST',
        dataType: 'json',
        data: {
            acao: 'ajax_listar'
        },
        success: function (data, textStatus, jqXHR) {
            $.each(data.array, function (k, v) {
                $('#select_uf').append('<option value="' + v.id + '">' + v.text + '</option>');
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
        }
    });
});