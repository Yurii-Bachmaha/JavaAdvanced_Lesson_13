$('button.create-magazine-btn').click(function () {
    var name = $('form.create-magazine input.name').val();
    var description = $('form.create-magazine input.description').val();
    var subscribePrice = $('form.create-magazine input.subscribe-price').val();

    if (name == '' || description == '' || subscribePrice == '') {
        alert("Please fill all fields!");
    } else {
        var magazine = {
            name: name,
            description: description,
            subscribePrice: subscribePrice
        };

        $.post("magazine", magazine, function (data) {
            $('.create-magazine').trigger('reset');
            alert(data);
        });
    }
});

$("button.buy-magazine").click(function () {
    var magazineId = jQuery(this).attr("magazineId");

    $.post("subscribe", { 'magazineId': magazineId },
        function (data) {
            if (data == 'Success') {
                $('#buyMagazineModal').hide();
                $('.modal-backdrop').remove();
            }
        });
});