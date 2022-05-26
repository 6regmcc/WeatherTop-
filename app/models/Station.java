package models;

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



}
