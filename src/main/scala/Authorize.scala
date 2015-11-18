import scala.concurrent._
import scala.concurrent.duration._

import com.keysurvey.api._

object Authorize {
  def main (args: Array[String] ) {
    println("Hello")
    val service = (new AuthenticationManagementServicePortBindings with scalaxb.Soap11ClientsAsync with  scalaxb.DispatchHttpClientsAsync {}).service

    val fresponse = service.getAuthenticationToken(Option("test"), Option("test"))

    fresponse.recover {
      case e: RuntimeException => println(s"RuntimeException")
    }

    val response = Await.result(fresponse, 20.seconds)

    println("Response " + response)

  }
}

