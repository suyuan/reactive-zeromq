package com.mintbeans.rzmq

import akka.util.ByteString
import org.zeromq.{ ZMQ, ZMsg }

object ZMQMessages {

  final case class ZMQMessage(payload: ByteString) {

    private[rzmq] def zMsg() = {
      val zmsg = new ZMsg
      zmsg.add(payload.toArray)
      zmsg
    }

    private[rzmq] def zMsgWithTopic(topic: String) = {
      val zmsg = new ZMsg
      zmsg.add(topic.getBytes(ZMQ.CHARSET))
      zmsg.add(payload.toArray)
      zmsg
    }
  }

}
