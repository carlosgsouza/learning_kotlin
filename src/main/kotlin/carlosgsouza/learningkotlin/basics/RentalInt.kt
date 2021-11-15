package carlosgsouza.learningkotlin.basics

fun Int.getValueAndLog() : Int {
    println("Accessing value of $this")
    return this
}

data class RentalInt(private val value: Int, private val observer: RentalIntObserver? = null) {
    var accessCount: Int = 0

    fun get(): Int {
        accessCount++
        observer?.notify(value, accessCount)
        return value.getValueAndLog()
    }

    fun getInvoice(unit: String = "USD"): String {
        return "$$accessCount $unit"
    }
}