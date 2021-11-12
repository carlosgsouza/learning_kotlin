package carlosgsouza.learningkotlin.basics

data class RentalInt(private val value: Int, private val observer: RentalIntObserver? = null) {
    var accessCount: Int = 0

    fun get(): Int {
        accessCount++
        observer?.notify(value, accessCount)
        return value
    }

    fun getInvoice(unit: String = "USD"): String {
        return "$$accessCount $unit"
    }
}