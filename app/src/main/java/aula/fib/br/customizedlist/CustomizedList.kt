package aula.fib.br.customizedlist

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class CustomizedList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customized_list)

        val listaContatos = ArrayList<Contato>()
        val c1 = Contato(1L, "Collor", "collor@br.com", "Alagoas")
        val c2 = Contato(2L, "Dilma", "dilma@br.com", "Porto Alegre")
        val c3 = Contato(3L, "Cabo Daciollo", "cabo@br.com", "Curitiba")
        val c4 = Contato(4L, "Ciro Gomes", "ciro@br.com", "Bauru")
        val c5 = Contato(5L, "Fernando Haddad", "fernando@br.com", "Agudos")
        val c6 = Contato(6L, "Eymael", "c6@br.com", "Florianopolis")

        listaContatos.add(c1)
        listaContatos.add(c2)
        listaContatos.add(c3)
        listaContatos.add(c4)
        listaContatos.add(c5)
        listaContatos.add(c6)

        val adapter = ContatoAdapter(applicationContext, listaContatos, assets)

        val lista = findViewById<ListView>(R.id.lista)
        lista.setAdapter(adapter)

        lista.setOnItemClickListener {parent, view, position, id ->
            val contato = listaContatos.get(position)
            val intent = Intent(this, DetalheContato::class.java)
            intent.putExtra("contato", contato)
            startActivity(intent)
        }
    }
}
