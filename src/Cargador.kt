import kotlin.random.Random

class Cargador{

    val tambor = cargartambor(elegirnumbalas())

    private fun elegirnumbalas():Int{
        val numbalas = Random.nextInt(2,9)
        println("Hay $numbalas cartuchos en el cargador")
        return numbalas
    }


    private fun cargartambor(numebala: Int) : MutableList<Cartucho>{

        val listadecartucho = mutableListOf<Cartucho>()
        for (i in 1..numebala){
            listadecartucho.add(Cartucho(Random.nextBoolean()))
        }
        var contarcargadas = listadecartucho.count { it.cargado == true}

        if (contarcargadas == 0) {
            contarcargadas++
            listadecartucho[0] = Cartucho(true)
        }else if(contarcargadas == numebala){
            contarcargadas--
            listadecartucho[0] = Cartucho(false)
        }

        listadecartucho.shuffle()

        println("$contarcargadas estan cargados")
        return listadecartucho
    }

    fun shufflear(){
        tambor.shuffle()
    }
}