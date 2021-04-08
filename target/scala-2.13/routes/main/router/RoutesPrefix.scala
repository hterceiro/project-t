// @GENERATOR:play-routes-compiler
// @SOURCE:/src/main/java/conf/routes
// @DATE:Thu Apr 08 07:06:45 UTC 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
