<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>I-Julia</title>
    <link rel="stylesheet" href="/style/style.css" />
    <link href="https://fonts.googleapis.com/css?family=Architects+Daughter|Open+Sans:400,700" rel="stylesheet">
    <script>
        function validateForm() {
            var x = document.forms["account"]["password"].value;
            var y = document.forms["account"]["confirm-password"].value;
            var name = document.forms["account"]["username"].value;
            var email = document.forms["account"]["email"].value;
            if (x== "") {
                document.getElementById("note").innerHTML="<font color='red'>Please enter your email</font>";
                return false;
            }
            if (x != y) {
                document.getElementById("note").innerHTML="<font color='red'>Please confirm your password</font>";
                return false;
            }
            if (name=="") {
                document.getElementById("note").innerHTML="<font color='red'>Empty Username</font>";
                return false;
            }
            if (email== "") {
                document.getElementById("note").innerHTML="<font color='red'>Please enter your email</font>";
                return false;
            }

        }
    </script>
</head>
<body>
<header>
    <div class="wrapper">
        <ul class="ijulia-navbar">
            <li><a href="/"><h1>Ijulia</h1></a></li>
            <li><a href="/question">Problem</a></li>
            <li><a href="/">Discussion</a></li>
            <li><a href="/">Help</a></li>
            <li><a href="/">Course</a></li>
        </ul>
    </div>
</header>
<div id="wrapper" class="normal-wrapper">

    <form name= "account" id="create-account" action="" onsubmit="return validateForm()" method="post"
          enctype="multipart/form-data" class="small-page-card" >

        <h2>Create Account</h2>
        <label>username <input type="text" name="username" /></label>
        <label>email <input type="text" name="email" /></label>
        <label>password <input type="password" name="password" id="pwd" /></label>
        <label>confirm password <input type="password" name="confirm-password" id="cfm-pwd"/></label>
        <span id="note"></span>

        <input type="submit" value="Create Account">

        <p class="bottom"><a href="login?redirect=/">Already have an account? Login here.</a></p>
    </form>

</div>
</body>
</html>
