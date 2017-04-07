package pb.backend.infrastructure
import akka.http.scaladsl.marshalling.{Marshaller, _}
import akka.http.scaladsl.model.MediaType
import akka.http.scaladsl.model.MediaTypes._
import play.twirl.api.{Html, Txt, Xml}

package object twirl {
  implicit val twirlHtmlMarshaller: ToEntityMarshaller[Html] = twirlMarshaller[Html](`text/html`)
  implicit val twirlTxtMarshaller: ToEntityMarshaller[Txt]   = twirlMarshaller[Txt](`text/plain`)
  implicit val twirlXmlMarshaller: ToEntityMarshaller[Xml]   = twirlMarshaller[Xml](`text/xml`)

  def twirlMarshaller[A](contentType: MediaType): ToEntityMarshaller[A] =
    Marshaller.StringMarshaller.wrap(contentType)(_.toString)
}
