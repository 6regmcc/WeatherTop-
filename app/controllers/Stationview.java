package controllers;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Stationview extends Controller
{
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        if(station.readings.size() > 0) {
            station.setMinTemperature();
            station.setMaxTemperature();
            station.setMinWindSpeed();
            station.setMaxWindSpeed();
            station.setMinPressure();
            station.setMaxPressure();
            station.setTemperatureTrendingValue();
            station.setWindTrendingValue();
            station.setPressureTrendingValue();
        }

        for(Reading reading :station.readings){
            reading.setFahrenheitTemp();
            reading.setBeaufort();
            reading.setWindChill();
            reading.setCardinalPoint();
            reading.setWeatherCodeIcon();
            reading.save();
        }

        Logger.info("station id = " + id);
        render("stationview.html", station);
    }

    public static void addReading(String date,Long id, int code, double temperature, double windSpeed, int pressure,int windDirection)
    {
        Reading reading = new Reading(date, code,temperature,windSpeed,pressure,windDirection);
        Station currentstation = Station.findById(id);
        currentstation.readings.add(reading);
        currentstation.save();
        redirect ("/stations/" + id);
    }

    public static void deleteReading(Long id, long readingid)
    {

        Station currentstation = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info ("Removing" + reading +  " " + readingid);
        currentstation.readings.remove(reading);
        currentstation.save();
        reading.delete();
        redirect ("/stations/" + id);
    }


}



/*
Playlist playlist = Playlist.findById(id);
    Logger.info ("Playlist id = " + id);
    render("playlist.html", playlist);
 */