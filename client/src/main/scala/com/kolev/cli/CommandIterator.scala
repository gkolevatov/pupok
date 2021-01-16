package com.kolev.cli

import java.io.InputStream
import java.util.Scanner

class CommandIterator(stream: InputStream) extends Iterator[String] {

  private val scanner = new Scanner(stream)

  override def hasNext: Boolean =  scanner.hasNextLine
  override def next(): String = scanner.nextLine()
}
