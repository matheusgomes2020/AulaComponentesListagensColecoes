package com.matheus.aulacomponenteslistagenscolecoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvLista: RecyclerView
    private lateinit var btnClique: Button
    private lateinit var mansagemAdapter: MensagemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lista = mutableListOf(
            Mensagem("jamilton", "Olá, tudo bem?", "10:45"),
            Mensagem("ana", "Tú tens? nada dsndsnjd dgggggggggggggggggggggggggggggggggggggggggggggggggggggggg gffffffffffff  ffffffffffffffffffffffffffffffsodshdsdsdhsd sdhsdishdhisid ", "08:57"),
            Mensagem("maria", "Legal!!!", "16:32"),
            Mensagem("pedro", "Olá, tudo bem?", "10:45"),
            Mensagem("marcela", "Tú tens?", "08:57"),
            Mensagem("jamilton", "Olá, tudo bem?", "10:45"),
        )

        rvLista = findViewById(R.id.rv_lista)
        btnClique = findViewById(R.id.btn_clique)

        mansagemAdapter = MensagemAdapter { nome ->
            Toast.makeText(this, "Olá $nome", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ListViewActivity::class.java)
            intent.putExtra("nome", nome)

            startActivity(intent)

        }

        mansagemAdapter.atualizarDados(
            lista
        )

        rvLista.adapter = mansagemAdapter

        /*
        rvLista.layoutManager = StaggeredGridLayoutManager(
            2,
            RecyclerView.VERTICAL
        )
        */
        /*
        rvLista.layoutManager = GridLayoutManager(
            this,
            2
        )

         */

        //LinearLayoutManager (XML e Código)

        rvLista.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        btnClique.setOnClickListener {

            mansagemAdapter.executarOperacao()

            /*
            lista.add(
                Mensagem("Nova Jamilton", "teste", "10:45")
            )
            mansagemAdapter.atualizarDados( lista )
             */

            /*
        rvLista.addItemDecoration(
            DividerItemDecoration(
                this,
                RecyclerView.VERTICAL
            )
        )
         */


        }
    }
}