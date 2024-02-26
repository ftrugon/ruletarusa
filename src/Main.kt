import kotlin.random.Random


fun main() {

    val todosobjetos = listOf(
        Cigarro(),
        Lupa(),
        Refresco(),
        Sierra(),
        Esposas(),
        Cuchara()
    )

    val aletorio1 = Random.nextInt(1,4)
    val listaitemsjug1  = crearlistaaleatoria(aletorio1,todosobjetos)
    val listaitemsjug2  = crearlistaaleatoria(aletorio1,todosobjetos)

    val aleatorio2 = Random.nextInt(3,6)
    val jugador1 = Jugador(1,"Fran", aleatorio2,listaitemsjug1)
    val jugador2 = Jugador(2,"Andres", aleatorio2,listaitemsjug2)
    val listajug = listOf(
        jugador1,
        jugador2
    )

    val partida = Partida(listajug)
    partida.iniciarpartida()
}


fun crearlistaaleatoria(numitems:Int,todosobjetos:List<Objeto>): MutableList<Objeto> {
    val listaadevolver = mutableListOf<Objeto>()
    for (i in 1..numitems){
        listaadevolver.add(todosobjetos.random())
    }
    return listaadevolver
}