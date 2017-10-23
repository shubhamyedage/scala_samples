
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/synerzip/codebase/play-java-intro/conf/routes
// @DATE:Wed May 04 15:01:55 IST 2016


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
