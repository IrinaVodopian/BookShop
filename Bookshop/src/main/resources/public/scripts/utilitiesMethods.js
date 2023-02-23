 window.onload = function() {
    fetch("../elements/navbar.html")
        .then(response => {
             return response.text()
     })
     .then(data => {
         document.querySelector("#nav-placeholder").innerHTML = data;
             if (localStorage.getItem("userName") != null) {
                   document.querySelector("#navBar-name").textContent = localStorage.getItem("userName");
                 }
     });
  }
