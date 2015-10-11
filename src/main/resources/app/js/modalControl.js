function openModalDeletion(itemType, itemName) {
    $('#modalDeletion').modal({
        keyboard: true
    });
    $('#modalDeletionItemType').text(itemType);
    $('#modalDeletionItemName').text(itemName);
}

function closeModalDeletion() {
    $('#modalDeletion').modal('hide');
}

$('#modalDeletionButtonNo').on('click', function () {
    closeModalDeletion()
});

function openModalStartToPlay(itemName) {
    $('#modalStartToPlay').modal({
        keyboard: true
    });
    $('#modalStartToPlayItemName').text(itemName);
}

function closeModalStartToPlay() {
    $('#modalStartToPlay').modal('hide');
}

$('#modalStartToPlayButtonNo').on('click', function () {
    closeModalStartToPlay()
});