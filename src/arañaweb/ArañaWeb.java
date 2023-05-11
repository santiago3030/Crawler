/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arañaweb;

import java.io.IOException;

/**
 *
 * @author PC
 */
public class ArañaWeb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String url = "https://www.reddit.com";
        ParserEngine parser = new ParserEngine(url);
        parser.crawl(parser.getBaseUrl());
    }
    
}
