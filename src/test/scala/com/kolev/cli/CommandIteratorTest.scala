package com.kolev.cli

import java.io.InputStream

import org.scalatest.flatspec.AnyFlatSpec
import java.io.ByteArrayInputStream

class CommandIteratorTest extends AnyFlatSpec {

  private def stream(s: String): InputStream = {
    new ByteArrayInputStream(s.getBytes)
  }

  "Iterator " should " be empty if input stream is empty" in {
    val iterator = new CommandIterator((stream("")))

    assert(iterator.isEmpty)
  }

}
