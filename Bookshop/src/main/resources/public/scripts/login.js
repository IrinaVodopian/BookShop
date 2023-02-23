function login(){
            var body = validateForm();
            sendValidateRequest(body);
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

//CHECK ALERT USERS NAME stays only before loading
function sendValidateRequest(body){
    return $.ajax({
                    type: 'GET',
                    url: '/user' + '?login=' + body.login,
                    success: function(data) {
                      $.each(data, function(i, item) {
                      var password = item.password;
                      if(password == body.password)
                      {
                                      alert("Logged in, you may proceed to the next page!");
                                      location.href = "../pages/catalogCustomer.html";
//                                      document.querySelector("#name-placeholder").textContent = 'somethingNew';
                                      localStorage.setItem('user', body.login);
                                  }
                      }
                      )
                    }
                });
}