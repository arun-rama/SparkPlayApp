package org.smartnut

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.scheduler.{SplitInfo, StatsReportListener}
import org.apache.spark.{AccumulatorParam, Logging, SparkConf, SparkContext}



object SparkQuery extends Logging{

  var sparkContext: SparkContext = _

  def init() {



    if (sparkContext == null) {
      log.info("Initializing SparkContext")
      
      val sparkMaster = Option(System.getenv("SPARK_MASTER")).getOrElse("local[3]")
      log.info(s"setting $sparkMaster as spark master")

      log.info("SPARK_HOME " + System.getenv("SPARK_HOME"))
      val jobName: String = "TestSparkonPlay::" + java.net.InetAddress.getLocalHost.getHostName

      sparkContext = {
        val sparkConf = new SparkConf()
          .setMaster(sparkMaster)
          .setAppName(jobName)
          .setJars(List("file:"+System.getProperty("user.dir") + "/SparkQueryLibrary/target/scala-2.10/sparkquerylibrary_2.10-1.0-SNAPSHOT.jar"))

        Option(System.getenv("SPARK_HOME")).foreach(sparkConf.setSparkHome)
        new SparkContext(sparkConf)

       }

      sparkContext.addSparkListener(new StatsReportListener())

      log.info("Initialized SparkContext")

    }
  }


  def sumRange(start:Int, end:Int) :Long = {
    init()
    sparkContext.parallelize( 1 to 100 ).reduce( _+_ )
  }



}



