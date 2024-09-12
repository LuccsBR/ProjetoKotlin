package br.unisanta.Dao

import br.unisanta.Model.Filmes

class FilmesDao {
    companion object{
        private val filmes = mutableListOf<Filmes>()
    }

    fun cadastraFilme(filme: Filmes){
        Companion.filmes.add(filme)
    }

    fun obterLista():List<Filmes>{
        return Companion.filmes
    }
}