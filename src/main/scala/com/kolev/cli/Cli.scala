package com.kolev.cli

import scala.collection.mutable.ListBuffer

trait Cli {  self =>

  val commands: ListBuffer[CommandDef] = new ListBuffer[CommandDef]

  val callHelp: Command = new Command {
    override def run: Cli = {
      println(self.help)
      self
    }
  }

  def parse(command: String): Command = {
    val tokens = command.split(" ")
    val commandName = tokens(0).toLowerCase

    val params = tokens.tail

    commands.find(_.name == commandName).map(_.call(params)).getOrElse(callHelp)
  }

  def registerCommand(commandName: String, code: CommandFunc): Unit = {
    commands += new CommandDef(commandName,  code)
  }

  def help: String

  def showHelp: Unit = {
    callHelp.run
  }

  def showError(error: String) = {
    println(s"Invalid syntax: $error")
    println(self.help)
    self
  }

  def showIntro: Unit = {
    showHelp
  }



}
