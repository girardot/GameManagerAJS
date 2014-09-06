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

