package controllers;

import models.Member;
import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;

public class UpdateUser extends Controller {
    public static void index(){

        Member member = Accounts.getLoggedInMember();
        Logger.info("Rendering User");
        render("user.html", member);
    }

    public static void updateEmail(long id, String email){
        Member member  = Accounts.getLoggedInMember();
        member.email = email;
        member.save();
        Logger.info("this method was called" + id + email );
        redirect("/user");
    }
}
