package $package$.pages

import $package$.Routes
import org.scalajs.dom
import org.widok._
import org.widok.bindings.HTML

case class NotFound() extends Page {
  def view() = HTML.Heading.Level1("Page not found")

  def ready(route: InstantiatedRoute) {
    dom.setTimeout(() => Routes.main().go(), 2000)
  }
}