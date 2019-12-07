package cecilia.moron.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //arreglo de datos
        val opciones = arrayOf("Botones", "Imágenes", "WebView", "Switch")
        //adaptador predefinido
        val adaptador = ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, opciones)
        //asignar el adaptador al listView
        miListWiew.adapter = adaptador
        miListWiew.setOnItemClickListener{ adapterView, view, i, l ->
           var intent = Intent()
            when(i){
                0-> {intent = Intent(this,Botones::class.java)
                }
                1-> {intent = Intent(this, Imagen::class.java)
                }
                2-> {intent = Intent(this, Web::class.java)
                }
                3-> {intent = Intent(this, Switch::class.java)
                }
            }
            startActivity(intent)

        }
    }
}
