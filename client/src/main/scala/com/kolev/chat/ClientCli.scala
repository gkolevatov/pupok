package com.kolev.chat

import _root_.com.kolev.cli.Cli

class ClientCli(client: Chat.Client, val mainCli: Cli, val clientName: String) extends Cli {


  override def help: String = {
    s"""
      | You registered as $clientName.
      | Usage:
      |    send <message text> - to send a message
      |    poll - to receive all messages
      |    logout - to log out
      |""".stripMargin
  }

  registerCommand("send", params => {
    val message = new Message().setText(params.mkString(" "))
      .setTimstamp(System.currentTimeMillis)
      .setUserName(clientName)
    client.post(message)
    println("message sended")
    this
  })

  registerCommand("poll", params => {
    client.pull().forEach(message => {
      println(s"${message.getUserName}: ${message.getText}")
    })

    this
  })

  registerCommand("logout", params => {
    println("You logged out successfully")
    mainCli
  })

}
