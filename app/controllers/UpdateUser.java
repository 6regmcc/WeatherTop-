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

    public static void updateUser(long id, String email, String password, String firstname, String lastname){
        Member member  = Accounts.getLoggedInMember();
        if(!"".equals(email)){
            member.email = email;
            Logger.info("updated email address to "  + email );
        }
        if(!"".equals(password)){
            member.password = password;
            Logger.info("updated password to "  + "*******" );
        }
        if(!"".equals(firstname)){
            member.firstname = firstname;
            Logger.info("updated firstname to "  + firstname );
        }
        if(!"".equals(lastname)){
            member.lastname = lastname;
            Logger.info("updated lastname to "  + lastname );
        }

        member.save();
        Logger.info("user update method was called" + id + email );
        redirect("/user");
    }
}
