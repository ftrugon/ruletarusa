///**
// * Jugar es la principal
// */
//fun jugar(tambor:MutableList<Int>){
//    print("Cara o cruz jugador 1?: ")
//    val empiezaprimero = caraocruz()
//
//    var contador = 1
//
//    do{
//
//        println()
//        val jugador = if (contador %2 == 0) empiezaprimero[1] else empiezaprimero[0]
//        println("Turno ${contador},${jugadores[jugador]}")
//        opciones(jugador)
//        val opcion = elegiropcion()
//
//        if (opcion == 1){
//            contador ++
//            val seacaboyo = disparo(tambor,contador-1)
//            if (seacaboyo){
//                println("Aun sigues dudando pero finalmente te decides, aprietas el gatillo")
//                println("Y lo ultimo que recuerdas es un gran BOOM al lado de tu oreja")
//                break
//
//            }else{
//                println("Fue algo arriesgado pero sigues en pie")
//            }
//
//        }else if (opcion == 2){
//            contador += 2
//            val seacaboel = disparo(tambor,contador-1)
//            if (seacaboel){
//
//                println("El pulso te tiembla mientras apuntas hacia tu oponente... ")
//                println("BOOOOMMM ")
//                println("parece que fue la opcion correcta")
//                break
//            }else{
//
//                println("Parece que sigue en pie tu oponente, quizas no fue la mejor idea...")
//                println("Ademas ahora te toca a ti")
//            }
//            val seacaboyo = disparo(tambor,contador-1)
//            if (seacaboyo){
//                println("Aun sigues dudando pero finalmente te decides, aprietas el gatillo")
//                println("Y lo ultimo que recuerdas es un gran BOOM al lado de tu oreja")
//                break
//            }else{
//                println("Fue algo arriesgado pero sigues en pie")
//            }
//        }
//
//
//    }while(contador < 6)
//}
