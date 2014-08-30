'use strict';

$('.console-list-items').on('click', function (e) {
    var previous = $(this).closest(".list-group").children(".console-list-items").children(".active");
    previous.removeClass('active'); // previous list-item
    $(e.target).addClass('active'); // activated list-item
});