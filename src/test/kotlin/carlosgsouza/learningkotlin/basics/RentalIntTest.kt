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

        assertEquals(5, rentalInt.get())

        assertEquals(1, rentalInt.accessCount)
        assertEquals(1, rentalInt.accessCount)

        rentalInt.get()

        assertEquals(2, rentalInt.accessCount)
    }

    @Test
    fun testInvoice() {
        val rentalInt:RentalInt = RentalInt(5)

        assertEquals("$0 USD", rentalInt.getInvoice())
        assertEquals("$0 BRL", rentalInt.getInvoice("BRL"))
        assertEquals("$0 EUR", rentalInt.getInvoice("EUR"))

        rentalInt.get()
        rentalInt.get()
        rentalInt.get()
        assertEquals(3, rentalInt.accessCount)

        assertEquals("$3 USD", rentalInt.getInvoice())
        assertEquals("$3 BRL", rentalInt.getInvoice("BRL"))
    }

    @Test
    fun testObserver() {
        val observer: RentalIntObserver = mock()

        val rentalInt = RentalInt(5, observer)
        rentalInt.get()

        verify(observer).notify(5, 1)
    }
}