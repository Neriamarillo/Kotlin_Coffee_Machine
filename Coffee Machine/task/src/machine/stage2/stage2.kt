package machine.stage2

fun main() {
    print("Write how many cups of coffee you will need: ")
    val cupsOfCoffee = readLine()!!
    println("For $cupsOfCoffee cups of coffee you will need:")
    val water = (Integer.valueOf(cupsOfCoffee) * 200)
    println("$water ml of water")
    val milk = (Integer.valueOf(cupsOfCoffee) * 50)
    println("$milk ml of milk")
    val coffeeBeans = (Integer.valueOf(cupsOfCoffee) * 15)
    println("$coffeeBeans g of coffee beans")
    println()
}