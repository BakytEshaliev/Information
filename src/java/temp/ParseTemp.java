/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Леван
 */
public class ParseTemp{
    public int parse() throws IOException{
        Document doc=Jsoup.connect("https://api.openweathermap.org/data/2.5/weather?id=1528675&APPID=0ea3e094b469b6a58e80b8efffc63561&mode=xml").get();
        Elements e=doc.select("temperature");
        double tempK=Double.parseDouble(e.attr("value"));
        int tempC=(int)tempK-273;
        return tempC;
    }
}
