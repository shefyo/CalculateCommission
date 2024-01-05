fun main() {
    var transfer = calculateCommission("Maestro", 100000, 5000)
    println(transfer)
}

fun calculateCommission(cardType: String = "VK Pay", previousTransfers: Int = 0, transferAmount: Int): Int {
    return when (cardType) {
        "Mastercard", "Maestro" -> {
            if (previousTransfers + transferAmount > 75000) {
                (transferAmount - 20 - (0.6 * transferAmount) / 100).toInt()
            } else {
                0
            }
        }

        "Visa", "Мир" -> {
            if (transferAmount * 0.75 < 35) {
                (transferAmount - 35).toInt()
            } else {
                (transferAmount - (0.75 * transferAmount) / 100).toInt()
            }
        }

        else -> 0
    }
}
