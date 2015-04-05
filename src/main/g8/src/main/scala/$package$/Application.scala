package $package$

import org.widok.Route
import org.widok.RoutingApplication


object Routes {
  val main = Route("/", pages.Main)
  val test = Route("/test/:param", pages.Test)
  val notFound = Route("/404", pages.NotFound)

  val routes = Set(main, test, notFound)
}

object Application extends RoutingApplication(
  Routes.routes,
  Routes.notFound
)