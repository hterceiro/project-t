// @GENERATOR:play-routes-compiler
// @SOURCE:/src/main/java/conf/routes
// @DATE:Thu Apr 08 07:06:45 UTC 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package v1.actions.javascript {

  // @LINE:5
  class ReverseGetAction(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "v1.actions.GetAction.index",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/organizations/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0)) + "/contributors"})
        }
      """
    )
  
  }


}
