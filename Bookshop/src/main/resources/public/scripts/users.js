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
                        location.reload();
                    },
                    contentType: "application/json",
                    dataType: 'json'
                });
        });

    $('#search-user').on('click', function() {
            var id = $("#user-id").text();
            $.getJSON("/user/" + id, function(data, status) {
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

function showAlert(){
    alert("The user has been deleted!");
}