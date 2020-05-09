package machine.stage3

import java.util.*
import kotlin.math.min

enum class Ingredients(val amount: Int) {
    WATER(200),
    MILK(50),
    BEANS(15);
}

fun main() {

    val waterNeeded = Ingredients.WATER.amount
    val milkNeeded = Ingredients.MILK.amount
    val beansNeeded = Ingredients.BEANS.amount

    val scanner = Scanner(System.`in`)
    print("Write how many ml of water the coffee machine has: ")
    val waterLeft = scanner.nextInt()
    print("Write how many ml of milk the coffee machine has: ")
    val milkLeft = scanner.nextInt()
    print("Write how many g of coffee beans the coffee machine has: ")
    val beansLeft = scanner.nextInt()
    print("Write how many coffee cups you will need: ")
    val cupsNeeded = scanner.nextInt()
    var availableWater = 0
    var availableMilk = 0
    var availableBeans = 0

    if (waterLeft > waterNeeded) {
        availableWater = waterLeft / waterNeeded
        if (milkLeft > milkNeeded) {
            availableMilk = milkLeft / milkNeeded
        }
        if (beansLeft > beansNeeded) {
            availableBeans = beansLeft / beansNeeded
        }
    }

    val availableCups = min(min(availableWater, availableMilk), availableBeans)

    when {
        cupsNeeded > availableCups -> {
            println("No, I can only make $availableCups cups of coffee")
        }
        cupsNeeded < availableCups -> {
            println("Yes, I can make that amount of coffee (and even ${availableCups - cupsNeeded} more than that)")
        }
        else -> {
            println("Yes, I can make that amount of coffee")
        }
    }
}