<%-- 
    Document   : profile
    Created on : 27/06/2022, 21:56:39
    Author     : jvolima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFPRLOVERS | Perfil</title>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400&family=Itim&display=swap" rel="stylesheet" />
        <link rel="stylesheet" href="./styles/global.css" />
        <link rel="stylesheet" href="./styles/registerAndProfile.css" />
    </head>
    <body>
        <div id="container">
            <img class="couple" src="./images/cople.png" alt="Couple" />
            <div id="header">
                <a class="backButton" id="editBackButton" href="HomeController">
                    <img src="./images/arrowLeft.svg" alt="Seta para a esquerda" />
                </a>
                <div class="buttonLabel" id="editButtonLabel">
                    <span>Perfil</span>
                </div>
            </div>
            
            <div id="content">
                <div id="containerFormLabel">
                    <div id="formLabel">
                        <span>Atualizar Perfil</span>
                    </div>
                </div>
                <form method="post" action="ProfileController" id="containerFormEdit">
                    <div id="containerInputs">
                        <div class="containerTwoInputs containerInput">
                            <div class="biggerInput">
                                <label>Nome</label>
                                <input class="input" type="text" name="name" value="${user.name}" />
                            </div>
                            <div class="smallerInput">
                                <label>Idade</label>
                                <input class="input" type="number" name="age" value="${user.age}" />
                            </div>      
                        </div>
                        <div class="containerInput">
                            <label>Email</label>
                            <input class="input" readonly="true" type="email" name="email" value="${user.email}" />
                        </div>
                        <div class="containerTwoInputs containerInput">
                            <div class="biggerInput"> 
                                <label>Orientação Sexual</label>
                                <input class="input" type="text" name="sexual_orientation" value="${user.sexualOrientation}" />
                            </div>
                            <div class="smallerInput">
                                <label>Sexo</label>
                                <input class="input" type="text" name="gender" value="${user.gender}" />
                            </div> 
                        </div>
                    </div>
                    <div id="containerButton">
                        <button class="submitButton" id="updateButton" type="submit">Salvar Alterações</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>