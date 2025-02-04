package com.matheus.aulacomponenteslistagenscolecoes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MensagemAdapter(
    private val lista: List<Mensagem>
) : RecyclerView.Adapter<MensagemAdapter.MensagemViewHolder>() {

    inner class MensagemViewHolder (
        val itemView: View
    ) : ViewHolder(itemView) {

        val textNome: TextView = itemView.findViewById(R.id.textNome)
        val textHorario: TextView = itemView.findViewById(R.id.textHorario)
        val textUltima: TextView = itemView.findViewById(R.id.textultima)

    }

    //Ao Criar o View Holder -> Criar a visualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViewHolder {

        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = layoutInflater.inflate(
            R.layout.item_lista,
            parent,
            false
        )

        return MensagemViewHolder( itemView )

    }


    // ao vincular o view holder -> preencher os dados
    override fun onBindViewHolder(holder: MensagemViewHolder, position: Int) {

        val mensagem = lista[position]
        holder.textNome.text = mensagem.nome
        holder.textHorario.text = mensagem.horario
        holder.textUltima.text = mensagem.ultima


    }

    override fun getItemCount(): Int {
        return lista.size
    }

}