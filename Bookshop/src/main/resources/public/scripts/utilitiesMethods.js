window.onload = function() {
    if (localStorage.getItem("userRole") == null) {
        fetch("../elements/navbarAnonymous.html")
            .then(response => {
                return response.text()
            })
            .then(data => {
                document.querySelector("#nav-placeholder").innerHTML = data;
                if (localStorage.getItem("userName") != null) {
                    document.querySelector("#navBar-name").textContent = localStorage.getItem("userName");
                }
            });

    } else if (localStorage.getItem("userRole") == 'CUSTOMER') {
        fetch("../elements/navbarCustomer.html")
            .then(response => {
                return response.text()
            })
            .then(data => {
                document.querySelector("#nav-placeholder").innerHTML = data;
                if (localStorage.getItem("userName") != null) {
                    document.querySelector("#navBar-name").textContent = localStorage.getItem("userName");
                }
            });
    } else {
        fetch("../elements/navbarManager.html")
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
}