package controllers.users

import play.api._
import play.api.mvc._
import scala.concurrent._

import javax.inject.Inject

class Application @Inject() extends Controller {

  def index = Action { implicit request =>
    Ok("/ index method workss from users")
  }
}
