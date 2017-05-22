package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class YahooRetriever {

    private static Logger log = Logger.getLogger(YahooRetriever.class);

    public InputStream retrieve(String zipcode) throws Exception {
        //zipcode va a ser el lugar en formato texto
        log.info( "Retrieving Weather Data" );
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" + zipcode +"%22)&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}