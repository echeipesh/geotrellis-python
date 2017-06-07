package geopyspark.geotrellis

import scala.reflect._

import com.trueaccord.scalapb.GeneratedMessage

trait ProtoBufCodec[T, M <: GeneratedMessage] {
  def encode(thing: T): M
  def decode(message: M): T
}

object ProtoBufCodec {
  def apply[T, M <: GeneratedMessage](implicit ev: ProtoBufCodec[T, M]): ProtoBufCodec[T, M] = ev
}
