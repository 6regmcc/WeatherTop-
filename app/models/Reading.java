package models;
import javax.persistence.Entity;

import play.db.jpa.Model;
import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
public class Reading extends Model{
    public Date date;
    public int code;
    public double temperature;
    public double windSpeed;
    public int pressure;
    public double fahrenheitTemp;
    public int beaufort;

    public double windChill;
    public int windDirection;
    public String cardinalPoint;
    public String weatherCodeIcon;
    public String weatherCodeText;

    public Reading(int code, double temperature, double windSpeed, int pressure, int windDirection) {
        this.date = new Date(System.currentTimeMillis());
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;

    }

    public void setFahrenheitTemp(){
        this.fahrenheitTemp = (this.temperature *((9*1.0)/5)) + 32;
    }

    public void setBeaufort(){
        if(this.windSpeed <=1){
            this.beaufort = 0;
        } else if(this.windSpeed <=5){
            this.beaufort = 1;
        } else if(this.windSpeed <=11){
            this.beaufort = 2;
        } else if(this.windSpeed <=19){
            this.beaufort = 3;
        } else if(this.windSpeed <=28){
            this.beaufort = 4;
        } else if(this.windSpeed <=38){
            this.beaufort = 5;
        } else if(this.windSpeed <=49){
            this.beaufort = 6;
        } else if(this.windSpeed <=61){
            this.beaufort = 7;
        } else if(this.windSpeed <=74){
            this.beaufort = 8;
        } else if(this.windSpeed <=88){
            this.beaufort = 9;
        } else if(this.windSpeed <=102){
            this.beaufort = 10;
        } else if(this.windSpeed <=117){
            this.beaufort = 11;
        }
    }

    public void setWindChill(){
        Double windChill = 13.12 + (0.6215 * this.temperature) - (11.37 * Math.pow(this.windSpeed, 0.16)) + ((0.3965 * this.temperature) * (Math.pow(this.windSpeed, 0.16)));
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        this.windChill = Double.parseDouble(df.format(windChill.doubleValue()));
    }

    public void setCardinalPoint(){
        if (this.windDirection > 348.75 || this.windDirection < 11.25){
            this.cardinalPoint = "North";
        }else if (this.windDirection > 11.25 && this.windDirection < 33.75){
            this.cardinalPoint = "North-Northeast";
        }else if (this.windDirection > 33.75 && this.windDirection < 56.25){
            this.cardinalPoint = "Northeast";
        }else if (this.windDirection > 56.25 && this.windDirection < 78.75){
            this.cardinalPoint = "East-Northeast";
        }else if (this.windDirection > 78.75 && this.windDirection < 101.25){
            this.cardinalPoint = "East";
        }else if (this.windDirection > 101.25 && this.windDirection < 123.75){
            this.cardinalPoint = "East-Southeast";
        }else if (this.windDirection > 123.75 && this.windDirection < 146.25){
            this.cardinalPoint = "Southeast";
        }else if (this.windDirection > 146.25 && this.windDirection < 168.75){
            this.cardinalPoint = "South-Southeast";
        }else if (this.windDirection > 168.75 && this.windDirection < 191.25){
            this.cardinalPoint = "South";
        }else if (this.windDirection > 191.25 && this.windDirection < 213.75){
            this.cardinalPoint = "South-Southwest";
        }else if (this.windDirection > 213.75 && this.windDirection < 236.25){
            this.cardinalPoint = "Southwest";
        }else if (this.windDirection > 236.25 && this.windDirection < 258.75){
            this.cardinalPoint = "West-Southwest";
        }else if (this.windDirection > 258.75 && this.windDirection < 281.25){
            this.cardinalPoint = "West";
        }else if (this.windDirection > 281.25 && this.windDirection < 303.75){
            this.cardinalPoint = "West-Northwest";
        }else if (this.windDirection > 303.75 && this.windDirection < 326.25){
            this.cardinalPoint = "Northwest";
        }else if (this.windDirection > 326.25 && this.windDirection < 384.75 ){
            this.cardinalPoint = "North-Northwest";
        }else{
            this.cardinalPoint = "ERROR";
        }
    }


    public void setWeatherCodeIcon(){
        if(this.code == 100){
            this.weatherCodeIcon = "sun icon";
            this.weatherCodeText = "Clear";
        }else if(this.code == 200){
            this.weatherCodeIcon = "cloud sun icon";
            this.weatherCodeText = "Partial clouds";
        }else if(this.code == 300){
            this.weatherCodeIcon = "cloud icon";
            this.weatherCodeText = "Cloudy";
        }else if(this.code == 400){
            this.weatherCodeIcon = "cloud sun rain icon";
            this.weatherCodeText = "Light Showers";
        }else if(this.code == 500){
            this.weatherCodeIcon = "cloud showers heavy icon";
            this.weatherCodeText = "Heavy Showers";
        }else if(this.code == 600){
            this.weatherCodeIcon = "cloud rain icon";
            this.weatherCodeText = "Rain";
        }else if(this.code == 700){
            this.weatherCodeIcon = "snowflake icon";
            this.weatherCodeText = "Snow";
        }else if(this.code == 800){
            this.weatherCodeIcon = "bolt icon";
            this.weatherCodeText = "Thunder";
        }
    }
}
