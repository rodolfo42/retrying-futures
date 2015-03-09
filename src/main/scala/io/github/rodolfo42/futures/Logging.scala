package io.github.rodolfo42.futures

trait Logging {
  val logPrefix: String

  def log(message: Any) = {
    printf("[%-5s] %s\n", logPrefix, message)
  }
}
