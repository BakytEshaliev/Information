/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Леван
 */
public class ParseNews {
    private ArrayList<News> news=new ArrayList<>();
    
    public void parse() throws IOException{
        Document doc=Jsoup.connect("https://lenta.ru/parts/news").get();
        Elements h3Elements=doc.select("h3");
        for(Element h3Element:h3Elements){
            Elements aElements=h3Element.select("a");
            for(Element aElement:aElements){
                String url=aElement.attr("abs:href");
                String title=aElement.text();
                News newNews=new News(title,url);
                news.add(newNews);
            }
        }
    }
    
    public String getTitle(int i){
        return news.get(i).getTitle();
    }
    
    public String getUrl(int i){
        return news.get(i).getUrl();
    }
}
