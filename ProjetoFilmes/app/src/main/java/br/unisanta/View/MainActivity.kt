package br.unisanta.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.Dao.FilmesDao
import br.unisanta.Model.Filmes
import br.unisanta.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    val dao = FilmesDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCadastra = findViewById<Button>(R.id.btnCadastra)
        val edtTitulo = findViewById<EditText>(R.id.edtTitulo)
        val edtDescricao= findViewById<EditText>(R.id.edtDescricao)
        val edtNota = findViewById<EditText>(R.id.edtNota)
        val edtUrl = findViewById<EditText>(R.id.edtUrl)

        val fabAvanca = findViewById<TextView>(R.id.floatingActionButton)

        btnCadastra.setOnClickListener {
            val filme = Filmes(edtTitulo.text.toString(), edtDescricao.text.toString(),edtNota.text.toString(),edtUrl.text.toString())
            dao.cadastraFilme(filme)
            Toast.makeText(this, "Filme Cadastro com sucesso", Toast.LENGTH_SHORT).show()
            edtTitulo.text.clear()
            edtDescricao.text.clear()
            edtNota.text.clear()
            edtUrl.text.clear()
        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}