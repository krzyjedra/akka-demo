import akka.stream.scaladsl._
import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import scala.concurrent._

object Akka extends App {
  implicit val system: ActorSystem = ActorSystem("Demo")
  val source: Source[Int, NotUsed] = Source(1 to 5)
  val done: Future[Done] = source.runForeach(i => println(i * 2))
  implicit val ec = system.dispatcher
  done.onComplete(_ => system.terminate())
}