function loginRegisterSwitch() {
    $('form').animate({ height: "toggle", opacity: "toggle" }, "slow");
}

$('.message a').click(function () {
    loginRegisterSwitch();
});

function showAlert() {
    $('div.alert').show();
}

$(document).ready(function () {
    $('button.register').click(function () {
        var firstName = $('.register-form .first-name').val();
        var lastName = $('.register-form .last-name').val();
        var email = $('.register-form .email').val();
        var password = $('.register-form .password').val();
        var confirmPassword = $('.register-form .confirm-password').val();

        if ($('[name = accessLevel]')[0].checked) {
            var accessLevel = 'user';
        } else if ($('[name = accessLevel]')[1].checked) {
            var accessLevel = 'admin';
        }

        if (firstName == '' || lastName == '' || email == '' || password == '' || confirmPassword == '') {
            alert("Please fill all fields!");
        } else if ((password.length) < 8) {
            alert("Password should atleast 8 character in length!");
        } else if (!(password).match(confirmPassword)) {
            alert("Your passwords don't match. Try again?");
        } else {
            var registerFormUser = {
                firstName: firstName,
                lastName: lastName,
                email: email,
                password: password,
                accessLevel: accessLevel
            };
            $.post("registration", registerFormUser, function (data) {
                if (data === 'Success') {
                    $('.register-form').trigger('reset');
                    $('.login-form').trigger('reset');
                    loginRegisterSwitch();
                    showAlert();
                }
            });
        }
    });
});

$(document).ready(function () {
    $('button.login').click(function () {
        var email = $('.login-form .email').val();
        var password = $('.login-form .password').val();

        if (email == '' || password == '') {
            alert('Please fill in the login form!');
        } else {
            var loginFormUser = {
                email: email,
                password: password
            };

            $.post('logging', loginFormUser, function (data) {
                if (typeof (data) === 'object') {
                    var customUrl = '';
                    var urlContent = window.location.href.split('/');

                    for (var i = 0; i < urlContent.length - 1; i++) {
                        customUrl += urlContent[i] + '/';
                    }
                    window.location = customUrl + data.destinationUrl;
                } else {
                    $('.login-form').trigger('reset');
                }
            });
        }
    });
});