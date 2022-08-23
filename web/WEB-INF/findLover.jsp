<%-- 
    Document   : findLover
    Created on : 23/08/2022, 11:01:13
    Author     : jvolima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFPRLOVERS | Achar Lover</title>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400&family=Itim&display=swap" rel="stylesheet" />
        <link rel="stylesheet" href="./styles/global.css" />
        <link rel="stylesheet" href="./styles/findLover.css" />
    </head>
    <body>
        <div id="container">
            <a id="backButton" href="HomeController">
                <img src="./images/doubleArrowLeft.svg" alt="Duas setas apontadas para a esquerda" />
            </a>
            <header>
                <img src="./images/logoWithLine.svg" alt="Logo ifprlovers" />
            </header>
            
            <div id="containerSelectLover">
                <h1>Selecione seu Lover</h1>
                
                <div id="loverAndPercentage">
                    <div class="loverCard">
                        <div class="loverCardImage">
                            
                        </div>
                        <div class="loverCardNameAndAge">
                            <div class="loverCardNameContainer">
                                <span>João Victor Ramalho Alves</span>
                            </div>
                            <div class="loverCardAgeContainer"> 
                                <span>18</span>
                            </div>
                        </div>
                    </div>
                    
                    <div id="heartContainer">
                        <span>?</span>
                    </div>
                    
                    <div class="loverCard">
                        <div class="loverCardImage">
                            
                        </div>
                        <div class="loverCardNameAndAge">
                            <div class="loverCardNameContainer">
                                <span>João Vitor Lima</span>
                            </div>
                            <div class="loverCardAgeContainer"> 
                                <span>17</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
