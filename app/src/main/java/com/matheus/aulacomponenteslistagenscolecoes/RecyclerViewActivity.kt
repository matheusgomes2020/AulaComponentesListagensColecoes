package com.matheus.aulacomponenteslistagenscolecoes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvLista: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lista = listOf(
            Mensagem("jamilton", "Olá, tudo bem?", "10:45"),
            Mensagem("ana", "Tú tens?", "08:57"),
            Mensagem("maria", "Legal!!!", "16:32"),
        )

        rvLista = findViewById(R.id.rv_lista)
        rvLista.adapter = MensagemAdapter( lista )
        rvLista.layoutManager = LinearLayoutManager(this)

    }
}