package com.matheus.aulacomponenteslistagenscolecoes.teste

data class Produto(
    var nome: String,
    var preco: Double
) {

    fun desativar() {
        println("Produto $nome com preço: $preco foi desativado")
    }

}

fun salvarproduto(produto: Produto) {

}
fun main() {

    var produto: Produto? = null

    produto = Produto("Notebook", 1200.00)

    produto.run { desativar() }

    /*
    if ( produto != null) {
        produto.preco = 1100.00
        salvarproduto( produto )
    }
     */

    /*
    produto?.let {  item ->
        item.preco = 1100.00
        item.nome = "iPad"
        salvarproduto( produto )
    }
     */

    /*
    val novoProduto = produto?.let {
        it.preco = 1100.00
        //salvarproduto( produto )
        it
    }
     */
    /*
    produto?.let {
        it.preco = 1100.00
        salvarproduto( it )
    }

    println( produto?.nome )
    println( produto?.preco )
     */

}