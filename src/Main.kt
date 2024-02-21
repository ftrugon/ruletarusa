import kotlin.random.Random
val jugadores = mapOf("jug1" to "jugador 1","jug2" to "jugador 2")

fun historiaIntro() {
    val listahistoria = listOf(
    "Te despiertas en una habitación oscura, con solo una silla y una mesa frente a ti.",
    "No recuerdas cómo llegaste aquí, pero algo te dice que estás atrapado.",
    "En la mesa, ves una pistola cargada con una sola bala y una ruleta rusa.",
    "Una nota en la mesa dice: 'Para ganar tu libertad, debes jugar. No hay otra salida'.",
    "Te das cuenta de que estás en un juego mortal de ruleta rusa.",
    "Puedes escuchar un ruido siniestro proveniente de las paredes. El tiempo corre en tu contra.",
    "Las luces parpadean, y una voz mecánica resuena en la habitación: 'El juego está por comenzar'.",
    "Es momento de tomar una decisión: arriesgarte a jugar o esperar un destino incierto...",
    "Una pantalla gigante se enciende, mostrando un cronómetro que empieza a contar regresivamente.",
    "El sudor recorre tu frente mientras contemplas la decisión que tienes que tomar.",
    "¿Te arriesgarás a jugar o esperarás un destino incierto? El tiempo es limitado.",
    "Cada segundo que pasa aumenta la tensión y el peligro."
    )
    val aleatorio = Random.nextInt(0, 12)
    println(listahistoria[aleatorio])
}

fun pedirnumbalas():Int{
    var numebala = try {
        readln().toInt()
    }catch (e:Exception){
        println("Opcion no valida, solo habra 1 bala en el tambor")
        1
    }
    if (numebala < 1 || numebala >6){
        println("Opcion no valida, solo habra 1 bala en el tambor")
        numebala = 1
    }
    return numebala
}

fun cagartambor(numebala: Int) : MutableList<Int>{
    val tambor  = mutableListOf(0,0,0,0,0,0)
    val posilibre = mutableListOf(0,1,2,3,4,5)

    for (i in 1..numebala) {
        val aleatorio = posilibre.random()
        if (tambor[aleatorio] != 1){
            tambor[aleatorio] = 1
            posilibre.remove(aleatorio)
        }
    }
    println("Se ha cargado el tambor")
    println()
    return tambor
}
fun caraocruz():List<String>{
    var estado = false
    var eleccion: String
    do {
        eleccion = readln()
        if (eleccion.lowercase() == "cara"|| eleccion.lowercase() =="cruz"){
            estado = true
        }else{
            print("Opcion no valida: ")
        }
    }while (!estado)


    val aleatorio = Random.nextInt(1, 3)
    val suerte = if (aleatorio % 2 == 0) "cara" else "cruz"

    return if (suerte == eleccion) {
        println("Empiezas el primero")
        listOf("jug1","jug2")
    }else{
        println("Dirias que es mala suerte empezar segundo jugador 1?")
        listOf("jug2","jug1")
    }

}

fun opciones(jugador:String){
    println("Que quieres hacer ${jugadores[jugador]}?")
    println("1. Dispararte?")
    println("2. Disparar al oponente y luego a ti?")
}

fun elegiropcion(): Int {

    do {
        print("Que quieres hacer?: ")
        val opcion = try {
            readln().toInt()
        }catch (e:Exception){
            0
        }
        if (opcion < 1 || opcion > 2){
            println("Opcion no valida")
        }else{
            return opcion
        }
    }while (true)
}

fun disparo(tambor:MutableList<Int>, i:Int): Boolean{
    return if (tambor[i] == 1){
        true
    }else{
        false
    }
}

/**
 * Simplemente es una comprobacion de s o n
 * @return si o no
 */
fun comprobarrespuesta():String{
    var estado2 = false
    var respuesta = readln()
    do {
        if (respuesta.lowercase() == "s"||respuesta.lowercase() == "n"){
            estado2 = true
        }else{
            print("Respuesta no valida(s,n): ")
            respuesta = readln()
        }
    }while (!estado2)
    return respuesta
}
/**
 * ClS es simplemente para limpliar la pantalla, no es python, este simplemente hace un println 100 veces
 */
fun cls(){
    for (i in 1..40) println()
}

/**
 * Main es la funcion donde se ejecuta todas las partes del codigo y cuando se acaba se pregunta si se quiere jugar de
 * nuevo
 */
fun main() {
    var estado = false
    do {
        historiaIntro()
        print("Cuantas balas quereis en el tambor: ")
        val balas = pedirnumbalas()
        val tamborcargado = cagartambor(balas)
        jugar(tamborcargado)
        print("\nQuiereis jugar de nuevo: ")
        val respuesta = comprobarrespuesta()
        if (respuesta == "n"){
            estado = true
        }else{
            cls()
        }
    }while (!estado)

}
