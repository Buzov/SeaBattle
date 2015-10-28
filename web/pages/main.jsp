<%@page import="SeaBattle_V20.GamerInputAndOutput"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="SeaBattle_V20.Main"%>
<%@page import="SeaBattle_V20.Battlefield"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> SEA BATTLE V2.0 </title>
        <link href="css/Style_SeaBattle_V20.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <div id="wrapper">
            <div id="header"> SEA BATTLE </div>			
                <div id="Inf">
                    <div id="GamerInf"> GamerInf 
                        <form class="login_form" name="username" method="POST">
                            <% GamerInputAndOutput giao = new GamerInputAndOutput ();
                            String gamerInput = null;
                            %>
                             Имя: <input type="text" 
                                         
                                         name="<% giao.setGamerInput(gamerInput); %> " 
                                         
                                         value="" size="20" />
                            <input type="submit" value="Войти" />
                        </form>
                    
                    </div>				
                    <div id="ComputerInf">      </div>	
                    <div id="PictureInf"> PictureInf </div>	
		</div>
			
		<div id="Battlefield">
                    <!-- Автоматическая расстановка корабляей игрока -->
                    <div id="GamerBattlefield">	
                        <table>
                            <!-- Создание первой строки(шапки) таблицы -->
                            <tr>
                                <th>  </th>
                                <th> A </th>
                                <th> B </th>
                                <th> C </th>
                                <th> D </th>
                                <th> E </th>
                                <th> F </th>
                                <th> G </th>
                                <th> H </th>
                                <th> I </th>
                                <th> J </th>
                            </tr>         
                            <!-- Создание остальной части таблицы-->
                            <%  Map<String, Integer> battlefieldGamer = new HashMap <String, Integer>();                                
                                Main m = new Main ();
                                String valueOfCaseGamer = null;
                                
                            %>
                            <% battlefieldGamer = m.preparationGamer(); %>
                            <% for (int i = 1; i <= 10; i++){ %>
                                    <tr><td class = "left-column"> <%= i %> </td>
                                    <% for (int j = 65; j <= 74; j++){ %>
                                            <% valueOfCaseGamer = Character.toString((char) j) + i; %>
                                            <% if (battlefieldGamer.get(valueOfCaseGamer)>100){%>
                                                    <td class="yesShip">  </td>                                            
                                            <% } else {%>
                                                    <td> <input type="button" onclick="javascript:this.disabled=true;" >  </td>
                                            <%}%>
                                    <%}%>
                            <%}%>
                        </table>
                    </div>		
                    <div id="ComputerBattlefield">
                        <!-- Автоматическая расстановка корабляей компьютера -->
                        
                    </div>				
                    <div id="GamerMove"> GamerMove 
                    <h2> <% giao.getA(); %> </h2>
                    </div>				
                    <div id="ComputerMove"> ComputerMove </div>										
		</div>
			
                <div id="footer" >
                    <div id="GamerFooter"> MY FLEET! </div>				
                    <div id="ComputerFooter"> COMPUTER FLEET! </div>
                </div>
	</div>
    </body>
</html>
