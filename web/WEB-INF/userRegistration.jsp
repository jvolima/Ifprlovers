<%-- 
    Document   : userRegistration
    Created on : 27/06/2022, 19:57:05
    Author     : jvolima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>IFPRLOVERS | Cadastre-se</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400&family=Itim&display=swap" rel="stylesheet" />
        <link rel="stylesheet" href="./styles/global.css" />
        <link rel="stylesheet" href="./styles/profileAndRegister.css" />
    </head>
    <body>
        <div id="container">
            <img class="couple" src="./images/cople.png" alt="Couple" />
            <div id="header">
                <a class="backButton" href="LoginController">
                    <img src="./images/arrowLeft.svg" alt="Seta para a esquerda" />
                </a>
                <div class="buttonLabel">
                    <span>Cadastro</span>
                </div>
            </div>
            
            <div id="content">
                <div id="containerFormLabel">
                    <div id="formLabel">
                        <span>Se torne um lover</span>
                    </div>
                </div>
                <form method="post" action="UserRegisterController" id="containerForm" enctype="multipart/form-data">
                    <div id="containerInputs">
                        <div class="containerTwoInputs containerInput">
                            <div class="biggerInput">
                                <label>Nome</label>
                                <input class="input" type="text" name="name" />
                            </div>
                            <div class="smallerInput">
                                <label>Idade</label>
                                <input class="input" type="number" name="age" />
                            </div>      
                        </div>
                        <div class="containerInput">
                            <label>Email</label>
                            <input class="input" type="email" name="email" />
                        </div>
                        <div class="containerInput">
                            <label>Senha</label>
                            <input class="input" type="password" name="password" />
                        </div>
                        <div class="containerInput">
                            <label>Link do seu avatar</label>
                            <input class="input" type="file" name="image" />
                        </div>
                        <div class="containerTwoInputs containerInput">
                            <div class="biggerInput"> 
                                <label>Orientação Sexual</label>
                                <input class="input" type="text" name="sexual_orientation" />
                            </div>
                            <div class="smallerInput">
                                <label>Sexo</label>
                                <input class="input" type="text" name="gender" />
                            </div> 
                        </div>
                    </div>
                    <div id="containerButton">
                        <button class="submitButton" type="submit">Cadastrar</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
