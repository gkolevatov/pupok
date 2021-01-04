package com.kolev.chat

import org.apache.thrift.TException
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.protocol.TProtocol
import org.apache.thrift.transport.TSocket
import org.apache.thrift.transport.TTransport
import org.apache.thrift.transport.TTransportException
import java.util.Collections
import java.util.Scanner

import com.kolev.cli.CliApp

object Client {
  def main(args: Array[String]) = {
    val cli = new MainClienCli
    val app = new CliApp(cli)
    app.run(System.in)
  }

}
