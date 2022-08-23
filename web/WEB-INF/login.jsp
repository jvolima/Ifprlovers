<%-- 
    Document   : login
    Created on : 07/08/2022, 20:29:27
    Author     : jvolima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>IFPRLOVERS | Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400&family=Itim&display=swap" rel="stylesheet" />
        <link rel="stylesheet" href="./styles/global.css" />
        <link rel="stylesheet" href="./styles/login.css" />
    </head>
    <body>
        <div id="container">
            <div id="leftContainer">
                <form method="post" action="LoginController">
                    <img src="./images/logoLogin.svg" alt="Logo ifprlovers" />
                    <div class="containerInput">
                        <input type="email" name="email" placeholder="Email" />
                    </div>
                    <div id="lastInput" class="containerInput">
                        <input type="password" name="password" placeholder="Senha" />
                    </div>
                    <button type="submit">Login</button>
                    <a href="WEB-INF/userRegistration.jsp">Realizar cadastro</a>
                </form>
            </div>
            <div id="rightContainer">
                
            </div>
        </div>
    </body>
</html>