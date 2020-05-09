package machine.stage5

enum class Ingredients(val waterNeeded: Int, val milkNeeded: Int, val beansNeeded: Int,
                       val cupsNeeded: Int, val price: Int) {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);
}

object MachineContents {
    var money = 550
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
}

var moneyLeft = MachineContents.money
var waterLeft = MachineContents.water
var milkLeft = MachineContents.milk
var beansLeft = MachineContents.beans
var cupsLeft = MachineContents.cups

fun main() {
    do {
        val selection = selectAction()
        when (selection) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> printStatus()
        }
    } while (selection != "exit")
}

fun printStatus() {
    println()
    println("The coffee machine has:")
    println("$waterLeft of water")
    println("$milkLeft of milk")
    println("$beansLeft of coffee beans")
    println("$cupsLeft of disposable cups")
    println("$$moneyLeft of money")
}

fun selectAction(): String {
    println()
    print("Write action (buy, fill, take, remaining, exit): ")
    return readLine()!!
}

fun selectCoffeeType(): Int {
    println()
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    val selection = readLine()!!
    if (selection == "back") {
        return 0
    }
    return selection.toInt()
}

fun hasEnough(waterNeeded: Int, milkNeeded: Int, beansNeeded: Int): Boolean {
    var flag = true
    when {
        waterLeft < waterNeeded -> {
            println("Sorry, not enough water!")
            flag = false
        }
        milkLeft < milkNeeded -> {
            println("Sorry, not enough milk!")
            flag = false
        }
        beansLeft < beansNeeded -> {
            println("Sorry, not enough coffee beans!")
            flag = false
        }
        cupsLeft < 1 -> {
            println("Sorry, not enough disposable cups!")
            flag = false
        }
        else -> {
            println("I have enough resources, making you a coffee!")
        }
    }
    return flag
}

fun processCoffee(waterNeeded: Int, milkNeeded: Int, beansNeeded: Int, cupsNeeded: Int, price: Int) {
    waterLeft -= waterNeeded
    milkLeft -= milkNeeded
    beansLeft -= beansNeeded
    cupsLeft -= cupsNeeded
    moneyLeft += price
}

fun buy() {
    val espresso = Ingredients.ESPRESSO
    val latte = Ingredients.LATTE
    val cappuccino = Ingredients.CAPPUCCINO

    when (selectCoffeeType()) {
        0 -> {

        }
        1 -> {  // espresso
            if (hasEnough(espresso.waterNeeded, espresso.milkNeeded, espresso.beansNeeded)) {
                processCoffee(espresso.waterNeeded, espresso.milkNeeded, espresso.beansNeeded,
                        espresso.cupsNeeded, espresso.price)
            }
        }
        2 -> {  // latte
            if (hasEnough(latte.waterNeeded, latte.milkNeeded, latte.beansNeeded)) {
                processCoffee(latte.waterNeeded, latte.milkNeeded, latte.beansNeeded,
                        latte.cupsNeeded, latte.price)
            }
        }
        3 -> {  // cappuccino
            if (hasEnough(cappuccino.waterNeeded, cappuccino.milkNeeded, cappuccino.beansNeeded)) {
                processCoffee(cappuccino.waterNeeded, cappuccino.milkNeeded, cappuccino.beansNeeded,
                        cappuccino.cupsNeeded, cappuccino.price)
            }
        }
    }
}

fun fill() {
    println()
    println("Write how many ml of water do you want to add: ")
    waterLeft += readLine()!!.toInt()
    println("Write how many ml of milk do you want to add: ")
    milkLeft += readLine()!!.toInt()
    println("Write how many grams of coffee beans do you want to add: ")
    beansLeft += readLine()!!.toInt()
    println("Write how many disposable cups of coffee do you want to add: ")
    cupsLeft += readLine()!!.toInt()
}

fun take() {
    println()
    println("I gave you $moneyLeft")
    moneyLeft = 0
}