<%-- 
    Document   : Information
    Created on : 28.06.2018, 22:46:41
    Author     : Леван
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="exchangeRates.ParseExchangeRates,news.ParseNews,temp.ParseTemp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Курс валют</h1>
        <h2>
            <%
                ParseExchangeRates per = new ParseExchangeRates();
                per.parse();
                out.println("<p>Курс доллара к рублю:" + per.getExchangeRateUSD() + "</p>");
                out.println("<p>Курс евро к рублю:" + per.getExchangeRateEuro() + "</p>");
            %>
        </h2>
        <h1>Последние новости:</h1>
        <h2>
            <%
                ParseNews pn = new ParseNews();
                pn.parse();
                for (int i = 0; i < 5; i++) {
                    out.println("<p><a href=\"" + pn.getUrl(i) + "\">" + pn.getTitle(i) + "</a></p>");
                }
            %>
        </h2>
        <h1>
            Погода в Бишкеке:
        </h1>
        <h2>
            <%
                ParseTemp pt = new ParseTemp();
                int temp = pt.parse();
                out.println("<p>" + temp + "°C</p>");
            %>
        </h2>
    </body>
</html>
