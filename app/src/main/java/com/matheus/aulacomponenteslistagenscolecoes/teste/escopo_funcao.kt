package com.matheus.aulacomponenteslistagenscolecoes.teste


class Pessoa {

    val nome = "" //Escopo local

}

var nome = ""//Escopo global

fun executar() {

    //val nome = "ana"//Escopo local
    nome = "executou nome nome ana"

}

fun main() {
    //nome = "Jamilton"
    executar()
    println(nome)
}