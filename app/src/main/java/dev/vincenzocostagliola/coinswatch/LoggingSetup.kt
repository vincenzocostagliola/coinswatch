package dev.vincenzocostagliola.coinswatch

import android.content.Context
import timber.log.Timber
import java.util.Locale

object LoggingSetup {
    private const val TAG_LOGGING = "COINSWATCH"

    internal fun setupLogging() {
        val timberTag = TAG_LOGGING
        // TODO Add Remote logging like sentry
        Timber.plant(ExplicitDebugTree())
        Timber.tag(timberTag)
    }

    private open class ExplicitDebugTree : Timber.DebugTree() {
        override fun createStackElementTag(element: StackTraceElement): String {
            return String.format(
                Locale.US,
                "(%s:%s) [%s()]",
                element.fileName,
                element.lineNumber,
                element.methodName
            )
        }
    }
}