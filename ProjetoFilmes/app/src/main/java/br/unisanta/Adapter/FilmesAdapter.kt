package br.unisanta.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.Model.Filmes


class FilmesAdapter(private val filmes:List<Filmes>): RecyclerView.Adapter<FilmesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtTitulo = itemView.findViewById<TextView>(br.unisanta.R.id.txt_Titulo)
        val txtDescricao = itemView.findViewById<TextView>(br.unisanta.R.id.txt_Descricao)
        val txtNota = itemView.findViewById<TextView>(br.unisanta.R.id.txt_Nota)
        val videoView = itemView.findViewById<VideoView>(br.unisanta.R.id.videoView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(br.unisanta.R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.txtTitulo.text = filme.titulo
        holder.txtDescricao.text = filme.descricao
        holder.txtNota.text = filme.nota
        holder.videoView.setVideoPath(filme.URL);
        holder.videoView.start();

    }
}