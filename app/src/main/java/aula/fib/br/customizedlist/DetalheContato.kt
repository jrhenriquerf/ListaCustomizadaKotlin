package aula.fib.br.customizedlist

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.io.IOException
import java.io.InputStream
import android.content.res.AssetFileDescriptor



class DetalheContato : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_contato)

        val intent = intent
        if (intent != null) {
            val contato = intent.getSerializableExtra("contato") as Contato
            val nomecontato = findViewById<TextView>(R.id.nomecontato)
            val imageView = findViewById<ImageView>(R.id.fotocontato)
            imageView.setImageBitmap(getBitmapFromAsset(contato.id));

            /*if (contato.id.equals(6)){
                val mPlayer = MediaPlayer.create(this@DetalheContato, R.raw.c6)
                mPlayer.start()
            }*/

            //TODO: Play sounds
            /*var id = contato.id
            var afd: AssetFileDescriptor? = null
            try {
                val afd = assets.openFd("sounds/c$id.mp3")
                val player = MediaPlayer()
                player.setDataSource(afd.fileDescriptor)
                player.prepare()
                player.start()
            } catch (e: IOException) {
                val afd = assets.openFd("sounds/urna.mp3")
                val player = MediaPlayer()
                player.setDataSource(afd.fileDescriptor)
                player.prepare()
                player.start()
            }*/

            nomecontato.text = contato.nome
        }
    }

    private fun getBitmapFromAsset(id: Long): Bitmap {
        val assetManager = assets
        var istr: InputStream? = null
        try {
            istr = assetManager.open("images/c$id.png")
        } catch (e: IOException) {
            istr = assetManager.open("images/face_error.jpg")
        }
        return BitmapFactory.decodeStream(istr)
    }
}
