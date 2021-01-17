package com.kolev.chat

import org.apache.thrift.server.TThreadPoolServer
import org.apache.thrift.transport.TServerSocket
import org.apache.thrift.transport.TTransportException

object Server {
  def main(args: Array[String]) = {
    val server = new Server
    server.start()
  }
}

class Server {
  private def start() = try { // Set port
    val serverTransport = new TServerSocket(7911)
    // Set CrawlingHandler we defined before
    // to processor, which handles RPC calls
    // Remember, one service per server
    val handler = new ChatHandler
    val processor = new Chat.Processor[Chat.Iface](handler)
    val server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor))
    System.out.println("Starting server on port 7911 ...")
    server.serve()
  } catch {
    case e: TTransportException =>
      e.printStackTrace()
  }
}