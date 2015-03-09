**Note: this is not intended for use in production.**

# Retry mechanism with Scala Futures

This is a simple demonstration on how to implement a retry mechanism for potentially failing operations (e.g. database access).

The `withRetries` function takes the number of retries and the operation to be executed.
