import kotlin.contracts.contract

interface Objeto{
    fun accion(partida: Partida,jugador: Jugador)
}

class Cigarro():Objeto{
    override fun accion(partida: Partida,jugador: Jugador) {
        jugador.vida++
    }

    override fun toString(): String {
        return "Cigarro -> El cigarro te cura 1 de vida"
    }
}

class Lupa():Objeto{
    override fun accion(partida: Partida, jugador: Jugador) {
        if (partida.escopeta.cargador.tambor[0] == Cartucho(true)){
            println("Este cartucho esta cargado")
        }else println("Este cartucho esta descargado")
    }

    override fun toString(): String {
        return "Lupa -> Te permite ver el siguiente cartucho de cargador"
    }
}

class Refresco():Objeto{
    override fun accion(partida: Partida, jugador: Jugador) {
        if (partida.escopeta.cargador.tambor[0] == Cartucho(true)){
            println("Este cartucho estaba cargado")
        }else println("Este cartucho estaba descargado")
        partida.escopeta.cargador.tambor.remove(partida.escopeta.cargador.tambor[0])
    }

    override fun toString(): String {
        return "Refresco -> Descarga un cartucho"
    }
}

class Sierra():Objeto{
    override fun accion(partida: Partida, jugador: Jugador) {
        partida.danio = 2
    }

    override fun toString(): String {
        return "Sierra -> Duplica el daño por 1 tiro"
    }
}

class Esposas():Objeto{
    override fun accion(partida: Partida, jugador: Jugador) {
        partida.saltarTurno = true
    }

    override fun toString(): String {
        return "Esposas -> Te saltaras el turno del otro jugador"
    }
}

class Cuchara():Objeto{
    override fun accion(partida: Partida, jugador: Jugador) {
        partida.escopeta.cargador.shufflear()
    }

    override fun toString(): String {
        return "Cuchara -> Hace que el cargador sea aleatorio"
    }
}