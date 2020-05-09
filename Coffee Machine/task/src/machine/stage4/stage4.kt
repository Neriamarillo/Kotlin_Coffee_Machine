package machine.stage4

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
    printStatus()
    when (selectAction()) {
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
    }
    printStatus()
}

fun printStatus() {
    println()
    println("The coffee machine has:")
    println("$waterLeft of water")
    println("$milkLeft of milk")
    println("$beansLeft of coffee beans")
    println("$cupsLeft of disposable cups")
    println("$$moneyLeft of money")
    println()
}

fun selectAction(): String {
    print("Write action (buy, fill, take): ")
    return readLine()!!
}

fun selectCoffeeType(): Int {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
    return readLine()!!.toInt()
}

fun buy() {

    when (selectCoffeeType()) {
        1 -> {  // espresso
            waterLeft -= 250
            beansLeft -= 16
            cupsLeft -= 1
            moneyLeft += 4
        }
        2 -> {  // latte
            waterLeft -= 350
            milkLeft -= 75
            beansLeft -= 20
            cupsLeft -= 1
            moneyLeft += 7
        }
        3 -> {  // cappuccino
            waterLeft -= 200
            milkLeft -= 100
            beansLeft -= 12
            cupsLeft -= 1
            moneyLeft += 6
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