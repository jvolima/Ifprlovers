<%-- 
    Document   : index
    Created on : 07/08/2022, 20:30:49
    Author     : jvolima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>IFPRLOVERS | Início</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link href="https://fonts.googleapis.com/css2?family=Imperial+Script&family=Inter:wght@700&family=Itim&display=swap" rel="stylesheet" />
        <link rel="stylesheet" href="./styles/global.css" />
        <link rel="stylesheet" href="./styles/home.css" />
    </head>
    <body>
        <div id="container">
            <div id="leftContainer">
                <div>
                    <h1>Find your soul mate.</h1>
                </div>
            </div>
            <div id="rightContainer">
                <div id="rightContent">
                    <img id="logo" src="./images/logo.svg" alt="Logo" />
                    <a href="ProfileController">Perfil</a>
                    <a id="lastButton" href="FindLoverController">Achar Lover</a>
                    <form method="post" action="HomeController">
                        <button type="submit">
                            Sair
                        </button>
                    </form>
                </div>   
                <img class="couple" src="./images/cople.png" alt="Couple" />
            </div>
        </div>
    </body>
</html>
