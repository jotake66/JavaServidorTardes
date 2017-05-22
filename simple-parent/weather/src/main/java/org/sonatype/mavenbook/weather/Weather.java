package org.sonatype.mavenbook.weather;

public class Weather {
  private String city;
  private String region;
  private String country;
  private String condition;
  private String temp;
  private String chill;
  private String humidity;

  public Weather() {}

  public String getCity() { return city; }
  public void setCity(String city) {
    this.city = city.trim();
  }

  public String getRegion() { return region; }
  public void setRegion(String region) {
    this.region = region.trim();
  }

  public String getCountry() { return country; }
  public void setCountry(String country) {
    this.country = country.trim();
  }

  public String getCondition() { return condition; }
  public void setCondition(String condition) {
    this.condition = condition.trim();
  }

  public String getTemp() { return temp; }
  public void setTemp(String temp) {
    this.temp = temp.trim();
  }
    
  public String getTempFormateado() { 
    return String.format("%.0fC", Double.parseDouble(this.temp));
  }

  public void setTempKelvin(String temp) {
      setTemp(String.valueOf((Double.parseDouble(temp) - 32.0) / 1.8));
  }
    
  public String getChill() { return chill; }
  public void setChill(String chill) {
    this.chill = chill.trim();
  }

  public String getHumidity() { return humidity; }
  public void setHumidity(String humidity) {
    this.humidity = humidity;
  }
}