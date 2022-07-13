import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun test_comissionCount_def() {
        val paySum = 1000_00
        val expected = 0

        val result = comissionCount(paySum)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_card_def() {
        val paySum = 1000_00
        val payInMonth = 1000_00
        val expected = 0

        val result = comissionCount(paySum = paySum, payInMonth = payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_payInMonth_def_vk() {
        val cardType = "VK Pay"
        val expected = 0

        val result = comissionCount(100, cardType)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_payInMonth_def_visa() {
        val cardType = "Visa"
        val expected = 3500

        val result = comissionCount(100, cardType)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_payInMonth_def_mir() {
        val cardType = "Mir"
        val expected = 3500

        val result = comissionCount(100, cardType)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_payInMonth_def_msater() {
        val cardType = "Mastercard"
        val expected = 0

        val result = comissionCount(100, cardType)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_payInMonth_def_maestro() {
        val cardType = "Maestro"
        val expected = 0

        val result = comissionCount(100, cardType)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_vk() {
        val cardType = "VK Pay"
        val paySum = 1000_00
        val payInMonth = 10_000_00
        val expected = 0

        val result = comissionCount(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_master() {
        val cardType = "Mastercard"
        val paySum = 1000_00
        val payInMonth = 100_000_00
        val expected = paySum * 60/10000 + 20_00

        val result = comissionCount(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_master_min() {
        val cardType = "Mastercard"
        val paySum = 1000_00
        val payInMonth = 10_000_00
        val expected = 0

        val result = comissionCount(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_maestro() {
        val cardType = "Maestro"
        val paySum = 1000_00
        val payInMonth = 100_000_00
        val expected = paySum * 60/10000 + 20_00

        val result = comissionCount(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_maestro_min() {
        val cardType = "Maestro"
        val paySum = 1000_00
        val payInMonth = 10_000_00
        val expected = 0

        val result = comissionCount(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_visa() {
        val cardType = "Visa"
        val paySum = 10000_00
        val payInMonth = 10_000_00
        val expected = paySum * 75/10000

        val result = comissionCount(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_visa_min() {
        val cardType = "Visa"
        val paySum = 100_00
        val payInMonth = 10_000_00
        val expected = 35_00

        val result = comissionCount(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_mir() {
        val cardType = "Mir"
        val paySum = 10000_00
        val payInMonth = 10_000_00
        val expected = paySum * 75/10000

        val result = comissionCount(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_comissionCount_mir_min() {
        val cardType = "Mir"
        val paySum = 100_00
        val payInMonth = 10_000_00
        val expected = 35_00

        val result = comissionCount(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_pay_def_ok() {
        val paySum = 100_00
        val expected = true

        val result = pay(paySum)

        assertEquals(expected, result)
    }

    @Test
    fun test_pay_def_err() {
        val paySum = 1_000_000_00
        val expected = false

        val result = pay(paySum)

        assertEquals(expected, result)
    }

    @Test
    fun test_pay_overflow_limits_card() {
        val cardType = "Visa"
        val paySum = 140_000_00
        val payInMonth = 550_000_00
        val expected = false

        val result = pay(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_pay_overflow_limits_vk() {
        val cardType = "VK Pay"
        val paySum = 10_0000_00
        val payinMonth = 45_000_00
        val expected = false

        val result = pay(paySum, cardType, payinMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_pay_ok_card() {
        val cardType = "Visa"
        val paySum = 100_000_00
        val payInMonth = 150_000_00
        val expected = true

        val result = pay(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

    @Test
    fun test_pay_ok_vk() {
        val cardType = "Vk Pay"
        val paySum = 1_000_00
        val payInMonth = 15_000_00
        val expected = true

        val result = pay(paySum, cardType, payInMonth)

        assertEquals(expected, result)
    }

}