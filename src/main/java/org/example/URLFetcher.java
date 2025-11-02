package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;

public class URLFetcher {
    public Set<String> fetchLinks(String url){
        Set<String>links=new HashSet<>();
        Document document=null;
        try{
            document= Jsoup.connect(url).timeout(50000).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Elements anchorTags=document.select("a[href]");
        for(Element link:anchorTags){
            String extractedUrl=link.absUrl("href");
            if(!extractedUrl.isEmpty()){
                links.add(extractedUrl);
            }
        }
        return links;
    }
}
