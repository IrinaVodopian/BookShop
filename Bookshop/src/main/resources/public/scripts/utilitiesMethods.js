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
     const pathCustomer = ["/pages/catalogCustomer.html", "/pages/bookingCustomer.html", "/pages/userProfile.html", "/pages/login.html"];
     const pathAnonymous = ["/pages/userProfile.html", "/pages/login.html"];
     var pathname = window.location.pathname;
     if (localStorage.getItem("userRole") == null && !pathAnonymous.includes(pathname)) {
             alert("Access only for registered users. Please register");
             location.href = "../pages/login.html";
             }
     if (localStorage.getItem("userRole") == 'CUSTOMER' && !pathCustomer.includes(pathname)) {
                  alert("Access only for users with manager status. Please register as a manager");
                  location.href = "../pages/login.html";
                  }
  }