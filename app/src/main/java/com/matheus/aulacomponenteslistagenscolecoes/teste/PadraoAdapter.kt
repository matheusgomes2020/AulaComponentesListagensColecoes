package com.matheus.aulacomponenteslistagenscolecoes.teste

class TomadaAntiga( val conector: Conector ) {
    fun passarenergia() {
        val qtPinos = conector.quantidadedePinos()
        if ( qtPinos == 2 ) {
            conector.ligarAparelho()
            println("Quantidade de pinos: $qtPinos")
            println("Passando energia")
        }
        else {
            println("Essa tomada só funciona com 2 pinos, você passou: $qtPinos")
        }
    }
}


interface Conector {
    fun quantidadedePinos() : Int
    fun ligarAparelho()
}

class conectorAdaptador(val conectorNovopadrao: ConectorNovopadrao) : Conector {
    override fun quantidadedePinos(): Int {
        return 2
    }

    override fun ligarAparelho() {
        conectorNovopadrao.ligarAparelho()
    }
}

class ConectorNovopadrao : Conector {
    override fun quantidadedePinos() : Int {
        return 3
    }
    override fun ligarAparelho() {
        println("aparelho está ligado")
        println("aparelho está ligado")
    }
}

fun main() {

    val conectorNovopadrao = ConectorNovopadrao()

    val conectorAdaptador = conectorAdaptador( conectorNovopadrao )

    val tomadaAntiga = TomadaAntiga( conectorAdaptador )
    tomadaAntiga.passarenergia()

}