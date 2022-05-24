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


        for(Reading reading :station.readings){
            reading.setFahrenheitTemp();
            reading.setBeaufort();
            reading.save();
        }

        Logger.info("station id = " + id);
        render("stationview.html", station);
    }

    public static void addReading(Long id, int code, double temperature, double windSpeed, int pressure)
    {
        Reading reading = new Reading(code,temperature,windSpeed,pressure);
        Station currentstation = Station.findById(id);
        currentstation.readings.add(reading);
        currentstation.save();
        redirect ("/stations/" + id);
    }
}



/*
Playlist playlist = Playlist.findById(id);
    Logger.info ("Playlist id = " + id);
    render("playlist.html", playlist);
 */