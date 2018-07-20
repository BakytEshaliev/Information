/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

/**
 *
 * @author Леван
 */
public class News {

    private String title;
    private String url;

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public News(String title, String url) {
        this.title = title;
        this.url = url;
    }

}
