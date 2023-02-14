var magazines = null;

$.get("readMagazines", function (data) {
    if (data !== '') {
        magazines = data;
    }
}).done(function () {
    var cardsContent = '';

    jQuery.each(magazines, function (i, value) {

        cardsContent += "<div class='col'>" +
            "<div class='card'>" +
            "<div class='card-body'>" +
            "<h5 class='card-title'>" + value.name + "</h5>" +
            "<p class='card-text'>" + value.description + "</p>" +
            "<h6 class='card-subtitle mb-2 text-muted'>" + value.subscribePrice + "$" + "</h6>" +
            "<a href='magazine?id=" + value.id + "' class='card-link'>Subscribe</a>" +
            "</div>" +
            "</div>" +
            "</div>" +
            "</div>"
    });

    $('.magazine-cards').html(cardsContent);
    
}).done(function() {
	$.get("getAccessLevel", function(data) {
		if (data !== '') {
			accessLevel = data;
		}
	}).done(function() {
		if(accessLevel === 'ADMIN'){
			$('a.card-link').hide();
		}
	});
});