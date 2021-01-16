package com.kolev.chat

import com.kolev.cli.CliApp

object Client {
  def main(args: Array[String]) = {
    val cli = new MainClienCli
    val app = new CliApp(cli)
    app.run(System.in)
  }

}
