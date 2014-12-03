name := "SparkPlayApp"

Common.settings

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)


libraryDependencies ++= Seq(
  Common.sparkDependency,
  "com.typesafe.akka" %% "akka-actor" % "2.2.3",
  "com.typesafe.akka" %% "akka-slf4j" % "2.2.3"
)

play.Project.playScalaSettings

//Modules
lazy val SparkPlayApp = project.in(file("."))
  .aggregate(SparkQueryLibrary)
  .dependsOn(SparkQueryLibrary)

lazy val SparkQueryLibrary = project

//plugins
net.virtualvoid.sbt.graph.Plugin.graphSettings