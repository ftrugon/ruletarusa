class Partida( val jugadores: List<Jugador>) {
    var estadopartida = false
    var escopeta = Escopeta()
    var danio = 1
    var cont = 1

    fun iniciarpartida(){
        estadopartida = true

        do {
            val jug = elegirjugador(cont)
            danio = 1
            println("----------------------------------------------------------------------------" )
            println("Ronda $cont, ${jug.nombre}")
            println("${jugadores[0].nombre}:${jugadores[0].vida}")
            println("${jugadores[1].nombre}:${jugadores[1].vida}")



            usarobjeto(jug)

            opciones(jug)
            val opcion = elegiropcion()

            if (opcion == 1) dispararme(jug,danio) else {
                dispararle(jug,danio)
                cont++
            }

            if (alguienmuere()) estadopartida = false
            if (escopeta.cargador.tambor.count { it.cargado == true} == 0) escopeta = Escopeta()
        }while (estadopartida)
    }

    fun usarobjeto(jug:Jugador){
        println("¿Quieres usar algún objeto? Este es tu inventario:")
        jug.objetos.forEachIndexed { index, objeto ->
            println("${index + 1}. $objeto")
        }
        println("${jug.objetos.size + 1}. No")

        print("Selecciona el número correspondiente al objeto que quieres usar (o introduce ${jug.objetos.size + 1} para salir): ")
        val respuesta = pedirrespuesta()
        if (respuesta.toIntOrNull() != null) {

            val opcion = respuesta.toInt()
            if (opcion in 1..jug.objetos.size) {
                val objetoElegido = jug.objetos[opcion - 1]
                println("Has elegido usar: $objetoElegido")
                    objetoElegido.accion(this,jug)
            } else if (opcion == jug.objetos.size + 1) {
                println("Has decidido no usar ningún objeto.")
            } else {
                println("Opción no válida.")
            }
        } else {
            println("Respuesta no válida.")
        }

    }

    fun pedirrespuesta(): String {
        return readln().trim().uppercase()
    }



    fun dispararme(jug:Jugador,danio:Int){
        if (escopeta.disparo()) jug.vida -= danio
    }

    fun dispararle(jug:Jugador,danio:Int){
        if (escopeta.disparo()){
            if (jug == jugadores[0]){
                jugadores[1].vida -= danio
            }else {
                jugadores[0].vida -= danio
            }
        }
    }

    fun elegirjugador(numrond:Int):Jugador{
        return if (numrond % 2 != 0) {
            jugadores[0]
        }else jugadores[1]
    }

    fun opciones(jugador:Jugador){
        println("Que quieres hacer?")
        println("1. Dispararte?")
        println("2. Disparar al oponente?")
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

    fun alguienmuere():Boolean{
        for (jugador in jugadores){
            if (jugador.vida == 0) return true
        }
        return false
    }
}