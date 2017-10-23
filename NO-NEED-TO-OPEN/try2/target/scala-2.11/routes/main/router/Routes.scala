
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/synerzip/codebase/play-java-intro/conf/routes
// @DATE:Wed May 04 15:01:55 IST 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  Assets_1: controllers.Assets,
  // @LINE:9
  Application_0: controllers.Application,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    Assets_1: controllers.Assets,
    // @LINE:9
    Application_0: controllers.Application
  ) = this(errorHandler, Assets_1, Application_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_1, Application_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person""", """controllers.Assets.at(path:String = "/public", file:String = "index.html")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person/data""", """controllers.Assets.at(path:String = "/public", file:String = "person.js")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person""", """controllers.Application.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person""", """controllers.Application.addPerson()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person/""" + "$" + """id<[^/]+>""", """controllers.Application.removePerson(id:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person/""" + "$" + """id<[^/]+>&""" + "$" + """name<[^/]+>""", """controllers.Application.updatePerson(id:String, name:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_Assets_at0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person")))
  )
  private[this] lazy val controllers_Assets_at0_invoker = createInvoker(
    Assets_1.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """person"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Assets_at1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person/data")))
  )
  private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
    Assets_1.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """person/data"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person")))
  )
  private[this] lazy val controllers_Application_index2_invoker = createInvoker(
    Application_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """person"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_addPerson3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person")))
  )
  private[this] lazy val controllers_Application_addPerson3_invoker = createInvoker(
    Application_0.addPerson(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "addPerson",
      Nil,
      "POST",
      """""",
      this.prefix + """person"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_removePerson4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_removePerson4_invoker = createInvoker(
    Application_0.removePerson(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "removePerson",
      Seq(classOf[String]),
      "DELETE",
      """""",
      this.prefix + """person/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_updatePerson5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person/"), DynamicPart("id", """[^/]+""",true), StaticPart("&"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_updatePerson5_invoker = createInvoker(
    Application_0.updatePerson(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "updatePerson",
      Seq(classOf[String], classOf[String]),
      "PUT",
      """""",
      this.prefix + """person/""" + "$" + """id<[^/]+>&""" + "$" + """name<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_Assets_at0_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("index.html"))) { (path, file) =>
        controllers_Assets_at0_invoker.call(Assets_1.at(path, file))
      }
  
    // @LINE:8
    case controllers_Assets_at1_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("person.js"))) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_1.at(path, file))
      }
  
    // @LINE:9
    case controllers_Application_index2_route(params) =>
      call { 
        controllers_Application_index2_invoker.call(Application_0.index)
      }
  
    // @LINE:10
    case controllers_Application_addPerson3_route(params) =>
      call { 
        controllers_Application_addPerson3_invoker.call(Application_0.addPerson())
      }
  
    // @LINE:11
    case controllers_Application_removePerson4_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Application_removePerson4_invoker.call(Application_0.removePerson(id))
      }
  
    // @LINE:12
    case controllers_Application_updatePerson5_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("name", None)) { (id, name) =>
        controllers_Application_updatePerson5_invoker.call(Application_0.updatePerson(id, name))
      }
  }
}
