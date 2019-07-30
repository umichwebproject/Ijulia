<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
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
            <li><a href="/">Problem</a></li>
            <li><a href="/">Discussion</a></li>
            <li><a href="/">Help</a></li>
            <li><a href="/">Course</a></li>
        </ul>
    </div>
</header>
<div id="wrapper" class="normal-wrapper">

    <form id="addquestion" action="addquestion" method="post"
          enctype="multipart/form-data" class="small-page-card">

        <h2>Question</h2>
        <label>title <input type="text" name="title" /></label>
        <label>title <textarea type="text" name="content" /></textarea></label>
        <input type="submit" value="submit">

        <p class="bottom">
        </p>
    </form>

</div>
</body>
</html>