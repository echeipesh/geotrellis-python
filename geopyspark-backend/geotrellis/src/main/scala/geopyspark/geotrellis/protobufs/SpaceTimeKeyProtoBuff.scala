package geopyspark.geotrellis.protobufs

import geopyspark.geotrellis._
import geotrellis.spark._
import protos.keyMessages.{SpaceTimeKey => ProtoSpaceTimeKey}


trait SpaceTimeKeyProtoBuf {
  implicit def spaceTimeKeyProtoBufCodec = new ProtoBufCodec[SpaceTimeKey] {
    type M = ProtoSpaceTimeKey

    def encode(spaceTimeKey: SpaceTimeKey): ProtoSpaceTimeKey =
      ProtoSpaceTimeKey(col = spaceTimeKey.col, row = spaceTimeKey.row, instant = spaceTimeKey.instant)

    def decode(message: ProtoSpaceTimeKey): SpaceTimeKey =
      SpaceTimeKey(message.col, message.row, message.instant)
  }
}