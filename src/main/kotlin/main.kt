fun main() {
    calculateCommission("Maestro", 100000, 80000)
}

fun calculateCommission(cardType: String = "VK Pay", previousTransfers: Int = 0, transferAmount: Int) {
    if (transferAmount > 150000 && cardType != "VK Pay" || transferAmount > 15000 && cardType == "VK Pay") {
        println("Превышение лимита")
    } else {
        when (cardType) {
            "Mastercard", "Maestro" -> {
                if (previousTransfers > 75000) {
                    val withCommission = (transferAmount + 20 + (0.6 * transferAmount) / 100).toInt()
                    println(withCommission)
                } else {
                    println(transferAmount)
                }
            }

            "Visa", "Мир" -> {
                if (transferAmount * 0.75 < 35) {
                    val withCommission = (transferAmount + 35).toInt()
                    println(withCommission)
                } else {
                    val withCommission = (transferAmount + (0.75 * transferAmount) / 100).toInt()
                    println(withCommission)
                }
            }

            else -> println(transferAmount)
        }
    }
}
