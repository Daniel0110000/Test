package dev.dr10.test.domain.utilities

class CallHandler {
    companion object {
        suspend fun <T> callHandler(block: suspend () -> T): Resource<T> {
            return try {
                Resource.Success(
                    data = block()
                )
            } catch (e: Exception) {
                Resource.Error(
                    "Exception ${e.message}"
                )
            }
        }
    }
}