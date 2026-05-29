<h3>User Edition</h3>

${message}

<br><br>

<form>

    Username:
    <input name="username"
           value="${form.username}">

    <br><br>

    Password:
    <input name="password"
           value="${form.password}">

    <br><br>

    <input type="checkbox"
           ${form.remember?'checked':''}>

    Remember me?

</form>