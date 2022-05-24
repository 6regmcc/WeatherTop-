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
        reading.save();
      }
    }

    render ("dashboard.html",  stations);
  }



}
