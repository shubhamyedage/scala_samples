package controllers;
import models.Person;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Application extends Controller {
    //Extract parameters from Query String
//    public Result echoData1(String name) {
//        String name1 = request().getQueryString("name");
//        return ok("hello" + name1);
//    }
    //Extract parameters from path
//    public Result echoData(String name) {
//        return ok("hello" + name);
//    }
//-----------------------------------------------------------------------------
    //Body parsing
    public Result index() {
        try {
            String list = Person.getListPerson();
            return ok(list).as("text/html");
        } catch (SQLException e) {
            return internalServerError(e.getMessage());
        } catch (ClassNotFoundException e) {
            return internalServerError(e.getMessage());
        }

    }
    @BodyParser.Of(BodyParser.FormUrlEncoded.class)
    public Result addPerson() {
//        String firstName = request().body().asFormUrlEncoded().get("firstName")[0];
//        String lastName = request().body().asFormUrlEncoded().get("lastNAme")[0];
//        return ok(firstName + " " + lastName);
//        JsonNode json = request().body().asJson();
//        return ok("Got name: " + json.get("firstName").asText(0000000000000));
        try {
            Person person = Person.getPersonName(request().body().asFormUrlEncoded());
            person.save();
            //return redirect("/person");
            return redirect(routes.Application.index());
        } catch (IllegalArgumentException ex) {
            return badRequest(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            return internalServerError("ClassNotFound" + ex.getMessage());
        } catch (SQLException e) {
            return internalServerError("Sql Exception" + e.getMessage());
        }
    }

    public Result removePerson(String id) {
        try {
            if (Person.remove(Integer.parseInt(id))) {
                return ok("Person not exist");
            } else {
                //return redirect("/person");
               return redirect(routes.Application.index());
            }
        } catch (SQLException e) {
            return internalServerError("Cant Remove" + e.getMessage());
        } catch (ClassNotFoundException e) {
            return internalServerError("Class not found" + e.getMessage());
        }
    }

    public Result updatePerson(String id, String name) {
        try {
            Person.update(Integer.parseInt(id), name);
            return redirect(routes.Application.index());
            //return redirect("/person");
        } catch (FileNotFoundException e) {
            return internalServerError(e.getMessage());
        } catch (ClassNotFoundException e) {
            return internalServerError(e.getMessage());
        } catch (SQLException e) {
            return internalServerError(e.getMessage());
        }

    }
//----------------------------------------------------------------------------------

    //content type:text/plain
//    public Result index() {
//        Result txtResult=ok("It works!");
//        return txtResult;
//    }
    //content type:application/json
//    public Result index()
//    {
//        JsonNode json = Json.toJson("Is works!");
//        Result jsonResult = ok(json);
//        return jsonResult;
//    }
    //content type:text/html
//    public Result index()
//    {
//        Result htmlResult=ok("<h1>It Works!</h1>").as("text/html");
//        return htmlResult;
//    }
//--------------------------------------------------------------------------------

    //Storing data in session
//    public Result login() {
//        session("connected", "user@synerzip.com");
//        return ok("stored at session!");
//    }
//
//    public Result index() {
//        String user = session("connected");
//        if (user != null) {
//            return ok("hello" + user);
//        } else {
//            return ok("oops! not connected");
//        }
//    }
//
//    public Result logout() {
//        String user = session().remove("connected");
//        return ok("bye" + user);
//    }
//
//    public Result endSession() {
//        String user = session().remove("connected");
//        return ok("End Session" + user);
//    }
//-------------------------------------------------------------------------------------

    //store data on flash
//    public Result save()
//    {
//        flash("message","Resources Found");
//        return ok("flash stored");
//    }
//    public Result index()
//    {
//        String warning=flash("message");
//        return ok("warning"+warning);
//    }
//    public Result remove()
//    {
//        flash().remove("Resources Found");
//        flash("Resources Not Found");
//        return ok("removed");
//    }
}
