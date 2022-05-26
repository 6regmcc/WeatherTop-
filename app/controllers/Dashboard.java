package controllers;
import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;
import java.util.List;
import java.util.ArrayList;



public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");


    List<Station> stations = Station.findAll();

    for(Station station : stations){
      for(Reading reading :station.readings){
        reading.setFahrenheitTemp();
        reading.setBeaufort();
        reading.setWindChill();
        reading.setCardinalPoint();
        reading.save();
      }
    }

    render ("dashboard.html",  stations);
  }

  public static void addStation (String name,double latitude,double longitude )
  {
    Station station = new Station (name,latitude,longitude);
    Logger.info ("Adding a new playlist called " + name);
    station.save();
    redirect ("/dashboard");
  }



}
