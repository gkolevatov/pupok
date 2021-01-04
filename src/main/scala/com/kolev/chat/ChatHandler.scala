package com.kolev.chat

import com.kolev.chat.Chat
import com.kolev.chat.ChatUnavailable
import com.kolev.chat.Message
import org.apache.thrift.TException
import java.util

class ChatHandler extends Chat.Iface {
  private[chat] val queue = new util.ArrayList[Message]

  @throws[TException]
  override def ping() = System.out.println("ping")

  @throws[ChatUnavailable]
  @throws[TException]
  override def post(message: Message) = {
    System.out.println("Message recieved:" + message.getText)
    queue.add(message)
    true
  }

  @throws[TException]
  override def pull = new util.ArrayList[Message](queue)
}