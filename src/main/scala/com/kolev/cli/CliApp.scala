package com.kolev.cli

import java.io.InputStream


class CliApp(defaultCli: Cli) {
    def run(in: InputStream): Unit = {
      var cli = defaultCli
      cli.showIntro
      for (s <- new CommandIterator(in)) {
        cli = cli.parse(s).run
      }
    }

}
