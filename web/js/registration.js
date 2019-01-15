

$(document).ready(function () {
    $flag = 1;
    $("#login").focusout(function () {
        $login = $("#login").val();
        if ($(this).val() == '') {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_login").text("* You have to enter your login!");
        } else if ($login.length < 3 || $login.length > 15) {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_login").text("* You have enter min - 3 symbol, max - 15");

        } else if ($login.length > 3 || $login.length < 15) {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_login").text("");
        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_login").text("");
        }
    });
    $("#password").focusout(function () {
        $password = $("#password").val();
        if ($(this).val() == '') {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_password").text("* You have to enter your password!");
        } else if ($password.length > 20) {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_password").text("* Maximum 20 symbols");

        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_password").text("");

        }
    });
    $("#name").focusout(function () {
        if ($(this).val() == '') {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_name").text("* You have to enter your first name!");
        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_name").text("");

        }
    });
    $("#last").focusout(function () {
        if ($(this).val() == '') {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_last").text("* You have to enter your last name!");
        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_last").text("");
        }
    });
    $("#address").focusout(function () {
        if ($(this).val() == '') {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_address").text("* You have to enter your address");
        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_address").text("");

        }
    });
    $("#birthday").focusout(function () {
        if ($(this).val() == '') {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_birthday").text("* You have to enter your Date of Birth!");
        } else {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled', false);
            $("#error_birthday").text("");
        }
    });

    $("#telephone").focusout(function () {
        $pho = $("#telephone").val();
        if ($(this).val() == '') {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_telephone").text("* You have to enter your Phone Number!");
        } else if ($pho.length != 12) {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_telephone").text("* Length of Phone Number should be twelve");
        } else if (!$.isNumeric($pho)) {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_telephone").text("* Phone Number should be numeric");
        } else {
            $(this).css({"border-color": "#2eb82e"});
            $('#submit').attr('disabled', false);
            $("#error_telephone").text("");
        }
    });

    $("#submit").click(function () {
        if ($("#login").val() == '') {
            $("#login").css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_login").text("* You have to enter your login");
        }
        if ($("#password").val() == '') {
            $("#password").css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_password").text("* You have to enter your password!");
        }
        if ($("#name").val() == '') {
            $("#name").css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_name").text("* You have to enter your first name!");
        }
        if ($("#address").val() == '') {
            $("#address").css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_address").text("* You have to enter your address!");
        }
        if ($("#last").val() == '') {
            $("#last").css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_last").text("* You have to enter your Last name!");
        }
        if ($("#birthday").val() == '') {
            $("#birthday").css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_birthday").text("* You have to enter your Date of Birth!");
        }

        if ($("#telephone").val() == '') {
            $("#telephone").css("border-color", "#FF0000");
            $('#submit').attr('disabled', true);
            $("#error_telephone").text("* You have to enter your Phone Number!");
        }
    });


});