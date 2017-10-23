
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/synerzip/codebase/play-java-intro/conf/routes
// @DATE:Wed May 04 15:01:55 IST 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers {

  // @LINE:7
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def at(file:String): Call = {
    
      (file: @unchecked) match {
      
        // @LINE:7
        case (file) if file == "index.html" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public"), ("file", "index.html")))
          Call("GET", _prefix + { _defaultPrefix } + "person")
      
        // @LINE:8
        case (file) if file == "person.js" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public"), ("file", "person.js")))
          Call("GET", _prefix + { _defaultPrefix } + "person/data")
      
      }
    
    }
  
  }

  // @LINE:9
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def updatePerson(id:String, name:String): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "&" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
    }
  
    // @LINE:11
    def removePerson(id:String): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "person/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
    // @LINE:9
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "person")
    }
  
    // @LINE:10
    def addPerson(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "person")
    }
  
  }


}
