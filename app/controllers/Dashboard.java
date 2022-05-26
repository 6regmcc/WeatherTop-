package controllers;
import models.Member;
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

    Member member = Accounts.getLoggedInMember();
    Logger.info("logged in member is " + member);
    List<Station> stations = member.stations;
    Logger.info("stations is " + stations);

    for(Station station : stations){
      for(Reading reading :station.readings){
        reading.setFahrenheitTemp();
        reading.setBeaufort();
        reading.setWindChill();
        reading.setCardinalPoint();
        reading.setWeatherCodeIcon();
        reading.save();
      }
    }

    render ("dashboard.html",  stations);
  }

  public static void addStation (String name,double latitude,double longitude )
  {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station (name,latitude,longitude);
    member.stations.add(station);
    Logger.info ("Adding a new playlist called " + name);
    station.save();
    redirect ("/dashboard");
  }



}


/*

{
    Logger.info("Rendering Dasboard");
    Member member = Accounts.getLoggedInMember();
    List<Playlist> playlists = member.playlists;
    render ("dashboard.html", playlists);
  }
 */