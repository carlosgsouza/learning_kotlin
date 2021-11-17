package carlosgsouza.learningkotlin.basics

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ReadOnlyObservable<T>(private val value: T, private val onRead: () -> Unit) : ReadOnlyProperty<Any?, T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        onRead()
        return value
    }
}