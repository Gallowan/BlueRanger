package com.example.gallo.scouthq1;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

public class FeedReader {
    private String rssUrl;

    public FeedReader(String url) {
        rssUrl = url;
    }

    public List<FeedSource> getItems() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        //Creates a new RssHandler which will do all the parsing.
        FeedHandler handler = new FeedHandler();
        //Pass SaxParser the RssHandler that was created.
        saxParser.parse(rssUrl, handler);
        return handler.getRssItemList();
    }
}