package com.kolev.chat

import com.kolev.cli.Cli
import org.apache.thrift.TException
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TSocket

import scala.sys.exit

class MainClienCli extends Cli {



  override def help: String = {
      """
        | This is client shell.
        | Usage:
        |  login <user name>  - to login into chat
        |  quit - to quit the application
        |""".stripMargin
  }

  registerCommand("login", params => {
    if (params.length < 1) {
      showError("Client name should be specified")
    } else {
      try {
        val transport = new TSocket("localhost", 7911)
        transport.open()
        val protocol = new TBinaryProtocol(transport)
        val client = new Chat.Client(protocol)
        client.ping()

        val clientCli = new ClientCli(client, this, params.mkString(" "))

        clientCli.showHelp
        clientCli
      } catch {
        case e: TException =>
          e.printStackTrace()
          this
      }

    }
  })

  registerCommand("quit", params => {
    exit(0)
  })
}
