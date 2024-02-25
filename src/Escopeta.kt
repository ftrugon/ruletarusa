class Escopeta(){

    val cargador = Cargador()

    fun disparo(): Boolean{
        if (cargador.tambor[0] == Cartucho(true)){
            println("BOOM")
            cargador.tambor.remove(cargador.tambor[0])
            return true
        }else {
            println("clic")
            cargador.tambor.remove(cargador.tambor[0])
            return false
        }
    }


}