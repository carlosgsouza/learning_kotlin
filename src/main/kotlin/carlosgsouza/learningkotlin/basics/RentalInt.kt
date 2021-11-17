package carlosgsouza.learningkotlin.basics

data class RentalInt(private val _value: Int, var accessCount: Int = 0, val observer: RentalIntObserver? = null) {

    val value: Int by ReadOnlyObservable(_value) {
        accessCount++
        observer?.notify(_value, accessCount)
    }

    fun getInvoice(unit: String = "USD"): String = "$$accessCount $unit"
}
