/**
 * Clase que representa una escopeta.
 */
class Escopeta {

    // Cargador de la escopeta
    val cargador = Cargador()

    /**
     * Método para realizar un disparo con la escopeta.
     * @return true si el disparo fue exitoso (cartucho cargado), false si no hay cartucho cargado.
     */
    fun disparo(): Boolean {
        // Verificar si hay un cartucho cargado en el tambor
        if (cargador.tambor.isNotEmpty() && cargador.tambor[0].cargado) {
            println("BOOM")
            // Eliminar el cartucho disparado del cargador
            cargador.tambor.removeAt(0)
            return true
        } else {
            println("clic")
            // Eliminar el cartucho del cargador, aunque no haya disparo
            if (cargador.tambor.isNotEmpty()) {
                cargador.tambor.removeAt(0)
            }
            return false
        }
    }
}
