
const val VKPAY = "VK Pay"
const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val MIR = "Mir"

/*
fun comissionCount(paySum:Int, cardType:String = VKPAY, payInMonth:Int = 0):Int {
    var comission = 0
    var masterNoComission = 75_000_00

    when (cardType) {
        MASTERCARD,MAESTRO -> {
            comission = if (paySum + payInMonth <= masterNoComission) 0 else paySum * 60/10000 + 20_00
        }
        VISA,MIR -> {
            comission = if (paySum * 75/10000 < 3500) 35_00 else paySum * 75/10000
        }
    }

    return comission
}
*/

fun comissionCount(paySum:Int, cardType:String = VKPAY, payInMonth:Int = 0):Int {
    val comission: Int
    val masterNoComission = 75_000_00

    if (cardType == MASTERCARD) {
        comission = if (paySum + payInMonth <= masterNoComission) 0 else paySum * 60/10000 + 20_00
    } else if (cardType == MAESTRO) {
        comission = if (paySum + payInMonth <= masterNoComission) 0 else paySum * 60 / 10000 + 20_00
    } else if (cardType == VISA) {
        comission = if (paySum * 75/10000 < 35_00) 35_00 else paySum * 75/10000
    } else if (cardType == MIR) {
        comission = if (paySum * 75/10000 < 35_00) 35_00 else paySum * 75/10000
    } else {
        comission = 0
    }

    return comission
}

fun pay(paySum:Int, cardType:String = VKPAY, payInMonth:Int = 0): Boolean {
    val cardMonthLinit = 600_000_00
    val cardDayLinit = 150_000_00
    val vkMonthLinit = 40_000_00
    val vkDayLinit = 15_000_00

    val dayLimit = if (cardType == VKPAY) vkDayLinit else cardDayLinit
    val monthLimit = if (cardType == VKPAY) vkMonthLinit else cardMonthLinit

    val result =
        if ((paySum > dayLimit) || (payInMonth + paySum > monthLimit)) {
            println("Платеж отменен, превышение лимитов!")
            false
        } else {
            val comission = comissionCount(paySum, cardType, payInMonth)
            println("Сумма комиссии составит: " + comission / 100 + " руб. " + comission % 100 + " коп.")
            true
    }
    return result
}


fun main() {
    val toPay = 20000_00
    var payInMonth = 579000_00

    if (pay(toPay, MIR , payInMonth)) payInMonth = payInMonth + toPay

}