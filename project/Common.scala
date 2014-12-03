import sbt._
import Keys._

object Common {
  val settings: Seq[Setting[_]] = Seq(
    organization := "org.smartnut",
    version := "1.0-SNAPSHOT",
    resolvers ++= Seq(
      "Cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
    )
  )

  val sparkDependency =  "org.apache.spark" %% "spark-core" % "1.1.0-cdh5.2.0"
  //val sparkDependency = "org.apache.spark" %% "spark-yarn" % "1.1.0-cdh5.2.0-SNAPSHOT"
}