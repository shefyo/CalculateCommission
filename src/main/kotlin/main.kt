fun main() {
    var transfer = calculateCommission("Maestro", 100000, 150100)
    println(transfer)
}

fun calculateCommission(cardType: String = "VK Pay", previousTransfers: Int = 0, transferAmount: Int): Int {
    if (transferAmount > 150000 && cardType != "VK Pay" || transferAmount > 15000 && cardType == "VK Pay" || previousTransfers + transferAmount > 600000 && cardType != "VK Pay" || previousTransfers + transferAmount > 40000 && cardType == "VK Pay") {
        return -1
    } else return when (cardType) {
        "Mastercard", "Maestro" -> {
            if (previousTransfers + transferAmount > 75000) {
                (transferAmount + 20 + (0.6 * transferAmount) / 100).toInt()
            } else {
                0
            }
        }

        "Visa", "Мир" -> {
            if (transferAmount * 0.75 < 35) {
                (transferAmount + 35).toInt()
            } else {
                (transferAmount + (0.75 * transferAmount) / 100).toInt()
            }
        }

        else -> 0
    }
}
