name := "SparkQueryLibrary"

Common.settings

libraryDependencies ++= Seq(
  Common.sparkDependency % "provided"
)