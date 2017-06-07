package controllers

import play.api._
import play.api.mvc._
import scala.concurrent._

import javax.inject.Inject
import play.api.i18n.{ MessagesApi }

class Application @Inject() (val messagesApi: MessagesApi) extends Controller {

  def test = Action { implicit request =>
    Ok("The API is ready")
  }

  def index = Action { implicit request =>
    Ok("This is front page")
  }

}
