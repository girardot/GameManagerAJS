'use strict';

$('.console-list-items').on('click', function (e) {
    var previous = $(this).closest(".list-group").children(".console-list-items").children(".active");
    previous.removeClass('active'); // previous list-item
    $(e.target).addClass('active'); // activated list-item
});

function getNextProgression(gameProgression) {
    var nextGameProgression = 'DONE'
    if (gameProgression == 'TO_DO') {
        nextGameProgression = 'IN_PROGRESS';
    }
    else if (gameProgression == 'IN_PROGRESS') {
        nextGameProgression = 'DONE';
    }
    else if (gameProgression == 'DONE') {
        nextGameProgression = 'TO_DO';
    }
    return nextGameProgression;
}

function fillPercentProgression(game) {
    switch (game.progression) {
        case "TO_DO":
            game.percentProgression = 40;
            break;
        case "IN_PROGRESS":
            game.percentProgression = 70;
            break;
        case "DONE":
            game.percentProgression = 100;
            break;
    }
}