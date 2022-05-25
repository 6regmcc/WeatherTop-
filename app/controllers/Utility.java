package controllers;
import models.Reading;
import models.Station;
import play.mvc.Controller;

import static play.mvc.Controller.redirect;

public class Utility extends Controller {

    public static void addReading(Long id, int code, double temperature, double windSpeed, int pressure,int windDirection)
    {
        Reading reading = new Reading(code,temperature,windSpeed,pressure,windDirection);
        Station currentstation = Station.findById(id);
        currentstation.readings.add(reading);
        currentstation.save();
        redirect ("stationview.html", currentstation);
    }

}
