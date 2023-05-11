/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arañaweb;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author PC
 */
public class ParserEngine {
    private String baseUrl;
    private ArrayList<String> urlList;
    
    
     public ParserEngine(String baseUrl){
        this.baseUrl = baseUrl;
        this.urlList = new ArrayList<String>();
    }

    public void crawl(String url) throws IOException {
        	
        Document doc = Jsoup.connect(url).ignoreContentType(true).get();
        Elements links = doc.select("a[href]");

        for (Element link : links) {
            String actualUrl = link.attr("abs:href");

            if (!urlList.contains(actualUrl) & actualUrl.startsWith(baseUrl)){
                print(" * a: <%s>  (%s)", actualUrl, trim(link.text(), 35));
                urlList.add(actualUrl);
                crawl(actualUrl);
            }
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }

    public String getBaseUrl(){
        return baseUrl;
    }

    public void setBaseUrl(String url){
        baseUrl = url;
    }

    public ArrayList<String> getUrlList(){
        return urlList;
    }
}


