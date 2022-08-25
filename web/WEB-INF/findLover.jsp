<%-- 
    Document   : findLover
    Created on : 23/08/2022, 11:01:13
    Author     : jvolima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IFPRLOVERS | Achar Lover</title>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400&family=Itim&display=swap" rel="stylesheet" />
        <link rel="stylesheet" href="./styles/global.css" />
        <link rel="stylesheet" href="./styles/find.css" />
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
                
                <form method="post" action="SelectLoverController">  
                    <div id="loverAndPercentage">
                        <div class="loverCard">
                            <div class="loverCardImage">

                            </div>
                            <div class="loverCardNameAndAge">
                                <div class="loverCardNameContainer">
                                    <span>${user.name}</span>
                                </div>
                                <div class="loverCardAgeContainer"> 
                                    <span>${user.age}</span>
                                </div>
                            </div>
                        </div>

                        <div id="heartContainer">
                            <span>${percentage != null ? percentage : "?"}</span>
                        </div>

                        <div class="loverCard">
                            <div class="loverCardImage">

                            </div>
                            <div class="loverCardNameAndAge">
                                <div class="loverCardNameContainer">
                                    <span>${lover.name}</span>
                                </div>
                                <div class="loverCardAgeContainer"> 
                                    <span>${lover.age}</span>
                                </div>
                            </div>
                                
                            <input type="hidden" name="emailUser" value="${user.email}" />
                            <input type="hidden" name="emailLoverSelected" value="${lover.email}" />
                        </div>
                    </div>
                         
                    <div id="buttonTest">
                        <button type="submit">Testar!</button>
                    </div>
                </form>
                            
                <div id="containerLovers">
                    <div id="contentLovers">
                        <c:forEach var="loverToSelect" varStatus="status" items="${lovers}">
                            <a class="loverCardSmall" href="SelectLoverController?loverEmail=${loverToSelect.email}">
                                <div class="loverCardImageSmall" style="background-image: url(https://github.com/jvolima.png); background-position: center; background-size: cover"></div>
                                <div class="loverCardNameAndAgeSmall">
                                    <div class="loverCardNameContainerSmall">
                                        <span>${loverToSelect.name}</span>
                                    </div>
                                    <div class="loverCardAgeContainerSmall">
                                        <span>${loverToSelect.age}</span>
                                    </div>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
