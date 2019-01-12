$(document).ready(function(){
    $flag=1;
    $("#login").focusout(function(){
        if($(this).val()==''){
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_login").text("* You have to enter your login!");
        }
        else
        {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled',false);
            $("#error_login").text("");

        }
    });
    $("#password").focusout(function(){
        if($(this).val()==''){
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_password").text("* You have to enter your password!");
        }
        else
        {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled',false);
            $("#error_password").text("");

        }
    });
    $("#name").focusout(function(){
        if($(this).val()==''){
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_name").text("* You have to enter your first name!");
        }
        else
        {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled',false);
            $("#error_name").text("");

        }
    });
    $("#last").focusout(function(){
        if($(this).val()==''){
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_last").text("* You have to enter your Last name!");
        }
        else
        {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled',false);
            $("#error_last").text("");
        }
    });
    $("#address").focusout(function(){
        if($(this).val()==''){
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_address").text("* You have to enter your login!");
        }
        else
        {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled',false);
            $("#error_address").text("");

        }
    });
    $("#birthday").focusout(function(){
        if($(this).val()==''){
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_birthday").text("* You have to enter your Date of Birth!");
        }
        else
        {
            $(this).css("border-color", "#2eb82e");
            $('#submit').attr('disabled',false);
            $("#error_birthday").text("");
        }
    });
    // $("#gender").focusout(function(){
    //     $(this).css("border-color", "#2eb82e");
    //
    // });
    // $("#age").focusout(function(){
    //     if($(this).val()==''){
    //         $(this).css("border-color", "#FF0000");
    //         $('#submit').attr('disabled',true);
    //         $("#error_age").text("* You have to enter your Age!");
    //     }
    //     else
    //     {
    //         $(this).css({"border-color":"#2eb82e"});
    //         $('#submit').attr('disabled',false);
    //         $("#error_age").text("");
    //
    //     }
    // });
    $("#telephone").focusout(function(){
        $pho =$("#telephone").val();
        if($(this).val()==''){
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_telephone").text("* You have to enter your Phone Number!");
        }
         else if ($pho.length!=12)
        {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_telephone").text("* Lenght of Phone Number Should Be twelve");
        }
        else if(!$.isNumeric($pho))
        {
            $(this).css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_telephone").text("* Phone Number Should Be Numeric");
        }
        else{
            $(this).css({"border-color":"#2eb82e"});
            $('#submit').attr('disabled',false);
            $("#error_telephone").text("");
        }

    });

    $( "#submit" ).click(function() {
        if($("#login" ).val()=='')
        {
            $("#login").css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_login").text("* You have to enter your login");
        }
        if($("#password" ).val()=='')
        {
            $("#password").css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_password").text("* You have to enter your password!");
        }
        if($("#name" ).val()=='')
        {
            $("#name").css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_name").text("* You have to enter your first name!");
        }
        if($("#address" ).val()=='')
        {
            $("#address").css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_address").text("* You have to enter your address!");
        }
        if($("#last" ).val()=='')
        {
            $("#last").css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_last").text("* You have to enter your Last name!");
        }
        if($("#birthday" ).val()=='')
        {
            $("#birthday").css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_birthday").text("* You have to enter your Date of Birth!");
        }

        if($("#telephone" ).val()=='')
        {
            $("#telephone").css("border-color", "#FF0000");
            $('#submit').attr('disabled',true);
            $("#error_telephone").text("* You have to enter your Phone Number!");
        }
    });



});