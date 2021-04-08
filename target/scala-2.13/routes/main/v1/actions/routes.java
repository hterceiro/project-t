// @GENERATOR:play-routes-compiler
// @SOURCE:/src/main/java/conf/routes
// @DATE:Thu Apr 08 07:06:45 UTC 2021

package v1.actions;

import router.RoutesPrefix;

public class routes {
  
  public static final v1.actions.ReverseGetAction GetAction = new v1.actions.ReverseGetAction(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final v1.actions.javascript.ReverseGetAction GetAction = new v1.actions.javascript.ReverseGetAction(RoutesPrefix.byNamePrefix());
  }

}
