
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/synerzip/codebase/play-java-intro/conf/routes
// @DATE:Wed May 04 15:01:55 IST 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:7
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
        
          if (file1 == """ + implicitly[JavascriptLiteral[String]].to("index.html") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "person"})
          }
        
          if (file1 == """ + implicitly[JavascriptLiteral[String]].to("person.js") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "person/data"})
          }
        
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def updatePerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.updatePerson",
      """
        function(id0,name1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id0)) + "&" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name1))})
        }
      """
    )
  
    // @LINE:11
    def removePerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.removePerson",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "person/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id0))})
        }
      """
    )
  
    // @LINE:9
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "person"})
        }
      """
    )
  
    // @LINE:10
    def addPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.addPerson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "person"})
        }
      """
    )
  
  }


}
