package io.github.rodolfo42.futures

object Main extends App with Logging with Retrying {
  override val logPrefix = "Main"

  val database = new UnstableDatabase(failedAttempts = 4)
  val sql = "SELECT COUNT(*) FROM table"

  log("Trying database access...")

  withRetries(4) { attemptsLeft =>
    log(s"Attempts left: $attemptsLeft")
    val result = database.query(sql)
    log(s"Success: $result")
  }
}
