$(document).ready(function() {
    if (localStorage.getItem('status') === 'success') {
       $("#validation-success").fadeIn(3000).fadeOut(3000);
        localStorage.setItem('status', '');
    };
    $.getJSON("/user", function(data, status) {
        $.each(data, function(i, item) {
            $tdForCheckbox = $('<td>').append(
                $('<input>', {
                    class: "w3-check",
                    type: "checkbox"
                }));
            var $tr = $('<tr class="users-row users-row-' + item.userId + '">').append(
                $tdForCheckbox,
                $('<td id="user-id">').text(item.userId),
                $('<td id="user-name">').text(item.userName),
                $('<td id="login">').text(item.login),
                $('<td id="email">').text(item.email),
                $('<td id="address">').text(item.address)
            ).appendTo('#users');
        });
    });

    $('#delete-user').on('click', function() {
            var users = getSelectedUsers();
            $.ajax({
                    type: 'DELETE',
                    url: '/user',
                    data: JSON.stringify(users),
                    success: function(data) {
                        $("#validation-success").fadeIn(3000).fadeOut(3000);
                        alert("The user has been deleted!");
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
                location.reload();
        });

        $('#search-user').on('click', function() {
                    clearTable();
                    var id = document.getElementById('inputUserId').value;
                    $.getJSON("/user/userId/" + id, function(data, status) {
                                $tdForCheckbox = $('<td>').append(
                                    $('<input>', {
                                        class: "w3-check",
                                        type: "checkbox"
                                    }));
                                var $tr = $('<tr class="users-row users-row-' + data.userId + '">').append(
                                    $tdForCheckbox,
                                    $('<td id="user-id">').text(data.userId),
                                    $('<td id="user-name">').text(data.userName),
                                    $('<td id="login">').text(data.login),
                                    $('<td id="email">').text(data.email),
                                    $('<td id="address">').text(data.address)
                                ).appendTo('#users');
                        });
            });
});

function getSelectedUsers() {
    var selected = [];
    $("tr.users-row").each(function() {
        $this = $(this);
        var isSelected = $this.find(".w3-check").is(':checked');
        if (isSelected) {
            selected.push($this.find("#user-id").text());
        }
    });
    return selected;
}

function editUser(){
    var userId = getSelectedUsers();
    localStorage.setItem('editUser', userId[0]);
    location.href = "../pages/userProfile.html";
}

function createUser(){
    localStorage.setItem('editUser', 'user id');
    location.href = "../pages/userProfile.html";
}

function clearTable(){
    $("tr.users-row").each(function() {
            $(this).remove();
        });
}