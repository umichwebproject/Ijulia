<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>I-Julia</title>
    <link rel="stylesheet" href="/style/style.css" />
    <link href="https://fonts.googleapis.com/css?family=Architects+Daughter|Open+Sans:400,700" rel="stylesheet">

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

    <form id="login" action="" method="post"
          enctype="multipart/form-data" class="small-page-card">

        <h2>Login</h2>
        <label>email <input type="text" name="email" /></label>
        <label>password <input type="password" name="password" /></label>
        <input type="submit" value="login">

        <p class="bottom">
            <a href="create?redirect=/">Need an account? Create one here.</a>
            <a href="forgot?redirect=/" style="display: block; margin-top: 10px;">Forgot your password?</a>
        </p>
    </form>

</div>
</body>
</html>