package $package$.pages

import $package$.Routes
import org.widok._
import org.widok.bindings.HTML

case class Main() extends Page {
  def view() =
    HTML.Anchor("Link to second page")
      .url(Routes.test("param", "first page"))

  def ready(route: InstantiatedRoute) {
    log(s"Page 'main' loaded with route '\$route'")
  }

  override def destroy() {
    log("Page 'main' left")
  }
}