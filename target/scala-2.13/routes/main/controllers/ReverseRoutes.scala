// @GENERATOR:play-routes-compiler
// @SOURCE:/src/main/java/conf/routes
// @DATE:Thu Apr 08 07:06:45 UTC 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:3
package controllers {

  // @LINE:3
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
