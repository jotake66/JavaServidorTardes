package org.sonatype.mavenbook.weather;

import java.io.InputStream;

import junit.framework.TestCase;

import org.sonatype.mavenbook.weather.Weather;
import org.sonatype.mavenbook.weather.YahooParser;

public class YahooParserTest extends TestCase {

    public YahooParserTest(String name) {
        super(name);
    }

    public void testParser() throws Exception {
        InputStream bioData = getClass().getClassLoader()
          .getResourceAsStream("bilbao-weather.xml");
        Weather weather = new YahooParser().parse( bioData );
        assertEquals( "Bilbao", weather.getCity() );
        assertEquals( "Basque Country", weather.getRegion() );
        assertEquals( "Spain", weather.getCountry() );
        assertEquals( "12.222222222222221", weather.getTemp() );
        assertEquals( "Cloudy", weather.getCondition() );
        assertEquals( "54", weather.getChill() );
        assertEquals( "81", weather.getHumidity() );
    }
}