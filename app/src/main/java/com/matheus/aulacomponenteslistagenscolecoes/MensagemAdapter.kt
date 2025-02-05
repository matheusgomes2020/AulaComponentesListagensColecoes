package com.matheus.aulacomponenteslistagenscolecoes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MensagemAdapter(
    private val clique: ( String ) -> Unit
) : RecyclerView.Adapter<MensagemAdapter.MensagemViewHolder>() {

    private var listaMensagens = mutableListOf<Mensagem>()

    fun executarOperacao() {

        listaMensagens.removeAt(1)
        listaMensagens.removeAt(2)
        notifyItemRangeRemoved(1, 2)
        //notifyItemRemoved(1)

        /*
        listaMensagens[0] = Mensagem("Ui", "TUTS?", "10:45")
        listaMensagens[1] = Mensagem("SERÀ?", "TUTS?2","10:60")
        notifyItemRangeChanged(0, 2)
         */

        /*
        listaMensagens[0] = Mensagem("JJ", "Cadê o PÃOOOOOOOOOOOO?", "23:95")
        notifyItemChanged(0)
         */

        /*
        listaMensagens.add(
            Mensagem("Nova Pedro", "Olá, tudo bem?", "17:12")
        )
        listaMensagens.add(
            Mensagem("Nova Maria", "teste Maria", "11:45")
        )
        listaMensagens.add(
            Mensagem("Nova João", "teste João", "11:45")
        )
        notifyItemRangeChanged(2,3)
        notifyItemInserted(listaMensagens.size)
         */

    }

    fun atualizarDados( lista: MutableList<Mensagem> ) {
        listaMensagens = lista
        notifyDataSetChanged()
    }

    inner class MensagemViewHolder (
        val itemView: View
    ) : ViewHolder(itemView) {

        //val textNome: TextView = itemView.findViewById(R.id.textNome)
        val textNome: TextView = itemView.findViewById(R.id.text_card_nome)
        val textUltima: TextView = itemView.findViewById(R.id.text_card_ultima)
        val imagePerfil: ImageView = itemView.findViewById(R.id.imageViewPerfil)
        val cardViewLayout: View = itemView.findViewById(R.id.cardViewLayout)
        //val textHorario: TextView = itemView.findViewById(R.id.textHorario)
        //val textUltima: TextView = itemView.findViewById(R.id.textultima)

        fun bind( mensagem: Mensagem ){//Conectar com a interface

            textNome.text = mensagem.nome
            textUltima.text = mensagem.ultima

            //val context = itemView.context
            cardViewLayout.setOnClickListener {
                clique( mensagem.nome )
            }
        }

    }

    //Ao Criar o View Holder -> Criar a visualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViewHolder {

        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        /*
        val itemView = layoutInflater.inflate(
            R.layout.item_lista, parent, false
        )
         */

        val itemView = layoutInflater.inflate(
            R.layout.item_cardview, parent, false
        )

        return MensagemViewHolder( itemView )

    }


    // ao vincular o view holder -> preencher os dados
    override fun onBindViewHolder(holder: MensagemViewHolder, position: Int) {

        val mensagem = listaMensagens[position]
        holder.bind( mensagem )
//        holder.textNome.text = mensagem.nome
//        //holder.textHorario.text = mensagem.horario
//        holder.textUltima.text = mensagem.ultima

        /*
        val context = holder.itemView.context
        holder.imagePerfil.setOnClickListener {
            Toast.makeText(context, "Olá, ${mensagem.nome}", Toast.LENGTH_SHORT).show()
        }
         */


    }

    override fun getItemCount(): Int {
        return listaMensagens.size
    }

}