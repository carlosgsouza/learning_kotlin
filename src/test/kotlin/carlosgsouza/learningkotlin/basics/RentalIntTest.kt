package carlosgsouza.learningkotlin.basics

import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class RentalIntTest {

    @Test
    fun testAccessCunt() {
        val rentalInt:RentalInt = RentalInt(5)

        assertEquals(0, rentalInt.accessCount)
        assertEquals(0, rentalInt.accessCount)

        assertEquals(5, rentalInt.value)

        assertEquals(1, rentalInt.accessCount)
        assertEquals(1, rentalInt.accessCount)

        rentalInt.value

        assertEquals(2, rentalInt.accessCount)
    }

    @Test
    fun testInvoice() {
        val rentalInt:RentalInt = RentalInt(5)

        assertEquals("$0 USD", rentalInt.getInvoice())
        assertEquals("$0 BRL", rentalInt.getInvoice("BRL"))
        assertEquals("$0 EUR", rentalInt.getInvoice("EUR"))

        rentalInt.value
        rentalInt.value
        rentalInt.value
        assertEquals(3, rentalInt.accessCount)

        assertEquals("$3 USD", rentalInt.getInvoice())
        assertEquals("$3 BRL", rentalInt.getInvoice("BRL"))
    }

    @Test
    fun testObserver() {
        val observer: RentalIntObserver = mock()

        val rentalInt = RentalInt(5, observer = observer)
        rentalInt.value

        verify(observer).notify(5, 1)
    }
}