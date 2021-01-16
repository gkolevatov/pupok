package com.kolev

package object cli {
  type CommandFunc = Function[Array[String], Cli]
}
