import org.scalajs.core.tools.sem.CheckedBehavior

name := """widok-project-template.g8"""

giter8Settings

resolvers += Resolver.url("typesafe", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns)

G8Keys.g8TestBufferLog := false

scriptedLaunchOpts ++= sys.process.javaVmArguments.filter(
  a => Seq("-Xmx", "-Xms", "-XX", "-Dsbt.log.noformat").exists(a.startsWith)
)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "io.github.widok" %%%! "widok" % "0.2.0"
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