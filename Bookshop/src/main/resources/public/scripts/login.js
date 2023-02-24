function login(){
            var body = validateForm();
            sendValidateRequest(body);
            }

function logOut(){
            localStorage.removeItem('userId');
            localStorage.removeItem('userRole');
            localStorage.setItem('userName', 'Anonymous user');
            alert("Logged out");
            location.reload();
            }

function validateForm() {
        var body = {
            login: $("#login").val(),
            password: $("#password").val()
        };
        if (body.login == "" || body.password == "") {
                alert('Please fill all the fields');
                return false;
            }
        return body;
}

function sendValidateRequest(body){
    return $.ajax({
                    type: 'GET',
                    url: '/user' + '?login=' + body.login,
                    success: function(data) {
                      $.each(data, function(i, item) {
                      var password = item.password;
                      if(password == body.password)
                      {
                                      localStorage.setItem('userId', item.userId);
                                      localStorage.setItem('userRole', item.role);
                                      localStorage.setItem('userName', item.userName);
                                      alert("Logged in, you may proceed to the next page!");
                                      location.href = "../pages/catalogCustomer.html";
                                  }
                      }
                      )
                    }
                });
}