package io.github.rodolfo42.futures

class UnstableDatabase(var failedAttempts: Int) extends Logging {
  override val logPrefix = "DB"

  def fails = failedAttempts > 0

  /**
   * This method throws an Exception on the first $failedAttempts times it's called,
   * and then succeeds every time after that.
   */
  def query(sql: String) = {
    if(fails) {
      failedAttempts = failedAttempts - 1
      log("Failed!")
      throw new Exception()
    } else {
      log("Succeeded!")
      42
    }
  }
}
