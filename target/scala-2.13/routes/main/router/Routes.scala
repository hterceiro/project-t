// @GENERATOR:play-routes-compiler
// @SOURCE:/src/main/java/conf/routes
// @DATE:Thu Apr 08 07:06:45 UTC 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:3
  HomeController_1: controllers.HomeController,
  // @LINE:5
  GetAction_0: v1.actions.GetAction,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:3
    HomeController_1: controllers.HomeController,
    // @LINE:5
    GetAction_0: v1.actions.GetAction
  ) = this(errorHandler, HomeController_1, GetAction_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, GetAction_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/organizations/""" + "$" + """name<[^/]+>/contributors""", """v1.actions.GetAction.index(name:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:3
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val v1_actions_GetAction_index1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/organizations/"), DynamicPart("name", """[^/]+""",true), StaticPart("/contributors")))
  )
  private[this] lazy val v1_actions_GetAction_index1_invoker = createInvoker(
    GetAction_0.index(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "v1.actions.GetAction",
      "index",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/v1/organizations/""" + "$" + """name<[^/]+>/contributors""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:3
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:5
    case v1_actions_GetAction_index1_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        v1_actions_GetAction_index1_invoker.call(GetAction_0.index(name))
      }
  }
}
