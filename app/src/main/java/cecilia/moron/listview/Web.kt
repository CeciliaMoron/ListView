package cecilia.moron.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import de.keyboardsurfer.android.widget.crouton.Crouton
import de.keyboardsurfer.android.widget.crouton.Style

class Web : AppCompatActivity ()

internal var etPeso: EditText, internal var etAltura:EditText
internal var resultado: TextView
internal var btnCalcultar: Button
internal var imagen: ImageView

protected override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    etPeso = findViewById<View>(R.id.etPeso) as EditText
    etAltura = findViewById<View>(R.id.etAltura) as EditText
    resultado = findViewById<View>(R.id.tvResultado) as TextView
    btnCalcultar = findViewById<View>(R.id.btnCalcular) as Button
    imagen = findViewById<View>(R.id.imagen) as ImageView

    btnCalcultar.setOnClickListener {
        val peso: Double
        val altura: Double
        val IMC: Double
        peso = java.lang.Double.parseDouble(etPeso.text.toString())
        altura = java.lang.Double.parseDouble(etAltura.getText().toString())
        //peso(kg)/talla(m2)
        IMC = peso / Math.pow(altura, 2.0)

        //Bajo peso    <18.50
        //Normal 18.5 - 24.99
        //Sobrepeso   >= 25.00
        var situacion = 0

        if (IMC <= 18.5) {
            situacion = 1
        }
        if (IMC > 18.5 && IMC < 24.99) {
            situacion = 2
        }
        if (IMC > 25) {
            situacion = 3
        }
        when (situacion) {
            1 -> {
                Picasso.with(getApplicationContext())
                    .load("https://hombrestrabajandohoy.files.wordpress.com/2014/11/dibujo-de-persona-levantando-una-pesa.jpg")
                    .into(imagen)
                //Picasso.get().load("https://hombrestrabajandohoy.files.wordpress.com/2014/11/dibujo-de-persona-levantando-una-pesa.jpg").into(imagen);
                Crouton.makeText(this@MainActivity, "BAJO PESO", Style.INFO).show()
            }
            2 -> {
                Picasso.with(getApplicationContext())
                    .load("https://www.realmenrealstyle.com/wp-content/uploads/2012/01/images3.jpg")
                    .into(imagen)
                //Picasso.get().load("https://www.realmenrealstyle.com/wp-content/uploads/2012/01/images3.jpg").into(imagen);
                Crouton.makeText(this@MainActivity, "PESO NORMAL", Style.CONFIRM).show()
            }
            3 -> {
                Picasso.with(getApplicationContext())
                    .load("https://img.myloview.es/cuadros/sobrepeso-hombre-de-dibujos-animados-con-dos-helados-400-23406617.jpg")
                    .into(imagen)
                //Picasso.get().load("https://img.myloview.es/cuadros/sobrepeso-hombre-de-dibujos-animados-con-dos-helados-400-23406617.jpg").into(imagen);
                Crouton.makeText(this@MainActivity, "SOBRE PESO", Style.ALERT).show()
            }
        }
        resultado.text = "" + IMC
    }
}
}
