package com.matheus.aulacomponenteslistagenscolecoes.teste

//DRY -> Don't Repeat Yourself (Não repita código) (ok)
// Divisão de responsabilidades (ok)
// Classes devem UTILIZAR outras classes (ok)
// Alto acoplamento e baixo acoplamento (ok)
class Musico( val instrumento: Instrumento ) {
    fun tocar(){
        println("Musico tocando")
        instrumento.sendoTocado()
    }
}

//Herança e Interface (Contrato) -> Composição
interface Instrumento {
    abstract fun sendoTocado ()
}

class Violao: Instrumento {//DOIS TIPOS: violão e instrumento
    override fun sendoTocado (){
        println("utilizando cordas (20 linhas de código)")
        println("para tocar o violão")
    }
    fun ajustarCordas(){
        println("Ajustar cordas")
    }

}

class Bateria: Instrumento {
    override fun sendoTocado (){
        println("utilizando baquetas (20 linhas de código)")
        println("para tocar a bateria")
    }
    fun ajustarBaqueta(){
        println("Ajustar baqueta")
    }

}

class Guitarra: Instrumento {
    override fun sendoTocado() {
        println("utilizando cordas (20 linhas de código)")
        println("utilizando ajuste de som")
        println("para tocar a guitarra")
    }

    fun ajustarCordas() {
    }
}

fun main() {

    //val violao: Instrumento = Violao()
    //val bateria: Instrumento = Bateria()


    //Tela 1 violão
    val violao1 = Violao()
    val musico1 = Musico( violao1 )
    musico1.tocar()

    println("+++++++++")

    //Tela 2 violão
    val violao2 = Violao()
    val musico2 = Musico( violao2 )
    musico2.tocar()

    println("+++++++++")

    //Tela 3 bateria
    val bateria1 = Bateria()
    val musico3 = Musico( bateria1 )
    musico3.tocar()

    println("+++++++++")

    //Tela 4 guitarra
    val guitarra = Guitarra()
    val musico4 = Musico( guitarra )
    musico4.tocar()
}