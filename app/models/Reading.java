package models;
import javax.persistence.Entity;

import play.db.jpa.Model;
import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;


@Entity
public class Reading extends Model{
    public int code;
    public double temperature;
    public double windSpeed;
    public int pressure;
    public double fahrenheitTemp;
    public int beaufort;

    public double windChill;
    public int windDirection;


    public Reading(int code, double temperature, double windSpeed, int pressure, int windDirection) {
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







}
