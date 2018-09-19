/**
 * 
 */

//this is the javascript validation for our login page 
var check = function() {
	  if (document.getElementById('password').value ==
	    document.getElementById('confirmPassword').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'matching';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'not matching';
	  }
	}

function showPassword() {
	var x = document.getElementById("confirmPassword");
	if (x.type === "password") {
		return x.type = "text";
	} else {
		return x.type = "password";
	}
	

function show() {
    var p = document.getElementById('pwd');
    p.setAttribute('type', 'text');
}

function hide() {
    var p = document.getElementById('pwd');
    p.setAttribute('type', 'password');
}

var pwShown = 0;

document.getElementById("eye").addEventListener("click", function () {
    if (pwShown == 0) {
        pwShown = 1;
        show();
    } else {
        pwShown = 0;
        hide();
    }
}, false);
}