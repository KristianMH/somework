package controllers.users

import play.api.http.HttpErrorHandler
import javax.inject._

class Assets @Inject() (errorHandler: HttpErrorHandler)
  extends controllers.AssetsBuilder(errorHandler)
