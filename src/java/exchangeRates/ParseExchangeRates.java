/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exchangeRates;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Леван
 */
public class ParseExchangeRates{ 

    private String exchangeRateEuro;
    private String exchangeRateUSD;

    public String getExchangeRateEuro() {
        return exchangeRateEuro;
    }

    public String getExchangeRateUSD() {
        return exchangeRateUSD;
    }

    public void parse() throws IOException {
        Document doc = Jsoup.connect("https://www.cbr.ru/currency_base/daily/").get();
        Elements trElements = doc.select("tr");
        for (Element trElement : trElements) {
            if (trElement.text().contains("Доллар")) {
                exchangeRateUSD = trElement.child(4).text();
            } else if (trElement.text().contains("Евро")) {
                exchangeRateEuro = trElement.child(4).text();
            }
        }
    }
}
