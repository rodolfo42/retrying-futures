package io.github.rodolfo42.futures

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait Retrying {
  def withRetries[X](retries: Int)(f: Int => X): Future[X] =
    Future(f(retries)).recoverWith {
      case ex: Exception if retries > 0 =>
        withRetries(retries - 1)(f)
    }
}
