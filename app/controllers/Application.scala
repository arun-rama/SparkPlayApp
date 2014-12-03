package controllers


import org.smartnut._
import play.api.mvc._


object Application extends Controller {

  def index = Action {
    Ok(<h1>Hello World!</h1>).as(HTML)
  }

  def sumRange = Action {
    Ok( "" + SparkQuery.sumRange(1, 1000000) )
  }

}