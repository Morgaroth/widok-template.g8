import org.scalajs.core.tools.sem.CheckedBehavior

name := """$name$"""

scalaVersion := "2.11.6"

scalacOptions ++= Seq("-unchecked", "-deprecation"
  , "-encoding", "utf8"
  , "-Xelide-below", annotation.elidable.ALL.toString
)

libraryDependencies ++= Seq(
  "io.github.widok" %%%! "widok" % "$widok_version$"
)

enablePlugins(ScalaJSPlugin)

persistLauncher := true

artifactPath in(Compile, packageScalaJSLauncher) := baseDirectory.value / "web" / "js" / "launcher.js"

artifactPath in(Compile, fastOptJS) := baseDirectory.value / "web" / "js" / "application.js"

artifactPath in(Compile, fullOptJS) := baseDirectory.value / "web" / "js" / "application.min.js"

scalaJSSemantics ~= (_
  .withRuntimeClassName(_ => "")
  .withAsInstanceOfs(CheckedBehavior.Unchecked)
  )