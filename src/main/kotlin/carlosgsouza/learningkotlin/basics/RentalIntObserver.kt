package carlosgsouza.learningkotlin.basics

import java.lang.IllegalArgumentException

/**
 * A simple observer.
 */
class RentalIntObserver {
    fun notify(value:Int, accessCount:Int) {
        if(accessCount < 0) {
            fail(accessCount)
        }
        print("$value accessed for the ${accessCount}th time")
    }

    private fun fail(accessCount: Int) : Nothing {
        throw IllegalArgumentException("$accessCount should be >= 0")
    }
}
