package com.kolev.cli



trait Command {
  def run: Cli
}

class CommandDef(val name: String,  val code: CommandFunc) {
  def call(params: Array[String]): CommandCall = new CommandCall(params, code)
}

class CommandCall(val params: Array[String], val code: CommandFunc) extends Command {
  override def run: Cli = code.apply(params)
}