import kotlin.random.Random

/**
 * Clase que representa una escopeta.
 */
class Escopeta {

    // Cargador de la escopeta
    // Tambor de cartuchos cargados
    val tambor = cargarTambor(elegirNumBalas())

    /**
     * Método privado para elegir el número de balas en el cargador.
     * @return El número de balas seleccionado aleatoriamente.
     */
    private fun elegirNumBalas(): Int {
        val numBalas = Random.nextInt(2, 9)
        println("Hay $numBalas cartuchos en el cargador")
        return numBalas
    }

    /**
     * Método privado para cargar el tambor con los cartuchos.
     * @param numBalas El número de balas a cargar en el tambor.
     * @return Una lista mutable de cartuchos cargados.
     */
    private fun cargarTambor(numBalas: Int): MutableList<Cartucho> {
        val listaDeCartuchos = mutableListOf<Cartucho>()
        // Cargar los cartuchos en el tambor
        for (i in 1..numBalas) {
            listaDeCartuchos.add(Cartucho(Random.nextBoolean()))
        }
        var contarCargadas = listaDeCartuchos.count { it.cargado }

        // Verificar si no hay cartuchos cargados o todos están cargados
        if (contarCargadas == 0) {
            contarCargadas++
            listaDeCartuchos[0] = Cartucho(true)
        } else if (contarCargadas == numBalas) {
            contarCargadas--
            listaDeCartuchos[0] = Cartucho(false)
        }

        // Mezclar la lista de cartuchos
        listaDeCartuchos.shuffle()

        println("$contarCargadas están cargados")
        return listaDeCartuchos
    }

    /**
     * Método para mezclar los cartuchos en el tambor.
     */
    fun shufflear() {
        tambor.shuffle()
    }

    /**
     * Método para realizar un disparo con la escopeta.
     * @return true si el disparo fue exitoso (cartucho cargado), false si no hay cartucho cargado.
     */
    fun disparo(): Boolean {
        // Verificar si hay un cartucho cargado en el tambor
        return if (tambor.isNotEmpty() && tambor[0].cargado) {
            println("BOOM")
            // Eliminar el cartucho disparado del cargador
            tambor.removeAt(0)
            true
        } else {
            println("clic")
            // Eliminar el cartucho del cargador, aunque no haya disparo
            if (tambor.isNotEmpty()) {
                tambor.removeAt(0)
            }
            false
        }
    }
}
