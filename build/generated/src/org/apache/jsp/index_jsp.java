package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import exchangeRates.ParseExchangeRates;
import news.ParseNews;
import temp.ParseTemp;
import java.util.Timer;
import java.util.TimerTask;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Курс валют</h1>\n");
      out.write("        <h2>\n");
      out.write("            ");

                ParseExchangeRates per = new ParseExchangeRates();
                per.parse();
                out.println("<p>Курс доллара к рублю:" + per.getExchangeRateUSD() + "</p>");
                out.println("<p>Курс евро к рублю:" + per.getExchangeRateEuro() + "</p>");
            
      out.write("\n");
      out.write("        </h2>\n");
      out.write("        <h1>Последние новости:</h1>\n");
      out.write("        <h2>\n");
      out.write("            ");

                ParseNews pn = new ParseNews();
                pn.parse();
                for (int i = 0; i < 6; i++) {
                    out.println("<p><a href=\"" + pn.getUrl(i) + "\">" + pn.getTitle(i) + "</a></p>");
                }
            
      out.write("\n");
      out.write("        </h2>\n");
      out.write("        <h1>\n");
      out.write("            Погода в Бишкеке:\n");
      out.write("        </h1>\n");
      out.write("        <h2>\n");
      out.write("            ");

                ParseTemp pt = new ParseTemp();
                int temp = pt.parse();
                out.println("<p>" + temp + "°C</p>");
            
      out.write("\n");
      out.write("        </h2>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
