package models;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();
    public String name;
    public double latitude;
    public double longitude;
    public double minTemperature;
    public double maxTemperature;
    public double minWindSpeed;
    public double maxWindSpeed;
    public double minPressure;
    public double maxPressure;
    public String temperatureTrendingValue;
    public String windTrendingValue;
    public String pressureTrendingValue;

    public Station(String name, double latitude, double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;



    }

    public void setMinTemperature(){
        this.minTemperature = readings.get(0).temperature;
        for(Reading reading: readings){
            if(reading.temperature < this.minTemperature ){
                this.minTemperature = reading.temperature;
            }
        }
    }

    public void setMaxTemperature(){
        this.maxTemperature = readings.get(0).temperature;
        for(Reading reading: readings){
            if(reading.temperature > this.maxTemperature ){
                this.maxTemperature = reading.temperature;
            }
        }
    }

    public void setMinWindSpeed(){
        this.minWindSpeed = readings.get(0).windSpeed;
        for(Reading reading: readings){
            if(reading.windSpeed < this.minWindSpeed ){
                this.minWindSpeed = reading.windSpeed;
            }
        }
    }

    public void setMaxWindSpeed(){
        this.maxWindSpeed = readings.get(0).windSpeed;
        for(Reading reading: readings){
            if(reading.windSpeed > this.maxWindSpeed ){
                this.maxWindSpeed = reading.windSpeed;
            }
        }
    }

    public void setMinPressure(){
        this.minPressure = readings.get(0).pressure;
        for(Reading reading: readings){
            if(reading.pressure < this.minPressure ){
                this.minPressure = reading.pressure;
            }
        }
    }

    public void setMaxPressure(){
        this.maxPressure = readings.get(0).pressure;
        for(Reading reading: readings){
            if(reading.pressure > this.maxPressure ){
                this.maxPressure = reading.pressure;
            }
        }
    }

    public void setTemperatureTrendingValue(){

        this.temperatureTrendingValue = "right floated blue big window minimize outline icon";
        if(readings.size() >= 4){
            double mostRecentTemp = readings.get(readings.size()-1).temperature;
            double secondMostRecentTemp = readings.get(readings.size()-2).temperature;
            double thirdMostRecentTemp = readings.get(readings.size()-3).temperature;
            double forthMostRecentTemp = readings.get(readings.size()-4).temperature;
            if(mostRecentTemp > secondMostRecentTemp && secondMostRecentTemp > thirdMostRecentTemp && thirdMostRecentTemp > forthMostRecentTemp){
                this.temperatureTrendingValue = "right floated green arrow up icon";
            }else if(mostRecentTemp < secondMostRecentTemp && secondMostRecentTemp < thirdMostRecentTemp && thirdMostRecentTemp < forthMostRecentTemp){
                this.temperatureTrendingValue = "right floated red arrow down icon";
            }
        }
    }

    public void setWindTrendingValue(){
        this.windTrendingValue = "right floated blue big window minimize outline icon";
        if(readings.size() >= 4){
            double mostRecentWind = readings.get(readings.size()-1).windSpeed;
            double secondMostRecentWind = readings.get(readings.size()-2).windSpeed;
            double thirdMostRecentWind = readings.get(readings.size()-3).windSpeed;
            double forthMostRecentWind = readings.get(readings.size()-4).windSpeed;
            if(mostRecentWind > secondMostRecentWind && secondMostRecentWind > thirdMostRecentWind && thirdMostRecentWind > forthMostRecentWind){
                this.windTrendingValue = "right floated green arrow up icon";
            }else if(mostRecentWind < secondMostRecentWind && secondMostRecentWind < thirdMostRecentWind && thirdMostRecentWind < forthMostRecentWind){
                this.windTrendingValue = "right floated red arrow down icon";
            }
        }
    }

    public void setPressureTrendingValue(){
        this.pressureTrendingValue = "right floated blue big window minimize outline icon";
        if(readings.size() >= 4){
            double mostRecentPressure = readings.get(readings.size()-1).pressure;
            double secondMostRecentPressure = readings.get(readings.size()-2).pressure;
            double thirdMostRecentPressure = readings.get(readings.size()-3).pressure;
            double forthMostRecentPressure = readings.get(readings.size()-4).pressure;
            if(mostRecentPressure > secondMostRecentPressure && secondMostRecentPressure > thirdMostRecentPressure && thirdMostRecentPressure > forthMostRecentPressure){
                this.pressureTrendingValue = "right floated green arrow up icon";
            }else if(mostRecentPressure < secondMostRecentPressure && secondMostRecentPressure < thirdMostRecentPressure && thirdMostRecentPressure < forthMostRecentPressure){
                this.pressureTrendingValue = "right floated red arrow down icon";
            }
        }
    }

    public void parseLatitudeLongitude(){
        DecimalFormat df = new DecimalFormat("000.###");
        df.setRoundingMode(RoundingMode.CEILING);
        this.latitude = Double.parseDouble(df.format(this.latitude));
        this.longitude = Double.parseDouble(df.format(this.longitude));
    }
}
