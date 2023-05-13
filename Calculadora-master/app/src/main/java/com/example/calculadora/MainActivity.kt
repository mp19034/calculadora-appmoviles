package com.example.calculadora
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.pow
import kotlin.math.sqrt
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    private lateinit var resultadoTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultadoTextView = findViewById(R.id.resultadoTextView)
        val ceroBoton: Button = findViewById(R.id.ceroBoton)
        ceroBoton.setOnClickListener { numeroPresionado("0") }
        val unoBoton: Button = findViewById(R.id.unoBoton)
        unoBoton.setOnClickListener { numeroPresionado("1") }
        val dosBoton: Button = findViewById(R.id.dosBoton)
        dosBoton.setOnClickListener { numeroPresionado("2") }
        val tresBoton: Button = findViewById(R.id.tresBoton)
        tresBoton.setOnClickListener { numeroPresionado("3") }
        val cuatroBoton: Button = findViewById(R.id.cuatroBoton)
        cuatroBoton.setOnClickListener { numeroPresionado("4") }
        val cincoBoton: Button = findViewById(R.id.cincoBoton)
        cincoBoton.setOnClickListener { numeroPresionado("5") }
        val seisBoton: Button = findViewById(R.id.seisBoton)
        seisBoton.setOnClickListener { numeroPresionado("6") }
        val sieteBoton: Button = findViewById(R.id.sieteBoton)
        sieteBoton.setOnClickListener { numeroPresionado("7") }
        val ochoBoton: Button = findViewById(R.id.ochoBoton)
        ochoBoton.setOnClickListener { numeroPresionado("8") }
        val nueveBoton: Button = findViewById(R.id.nueveBoton)
        nueveBoton.setOnClickListener { numeroPresionado("9") }
////////////////////////////////////////////////////////////////////////////
        val sumaBoton: Button = findViewById(R.id.sumaBoton)
        sumaBoton.setOnClickListener { operacionPresionada(SUMA) }
        val restaBoton: Button = findViewById(R.id.restaBoton)
        restaBoton.setOnClickListener { operacionPresionada(RESTA) }
        val multiBoton: Button = findViewById(R.id.multiBoton)
        multiBoton.setOnClickListener { operacionPresionada(MULTIPLICACION) }
        val divisionBoton: Button = findViewById(R.id.divisionBoton)
        divisionBoton.setOnClickListener { operacionPresionada(DIVISION) }
        val raizBoton: Button = findViewById(R.id.raizBoton)
        raizBoton.setOnClickListener { operacionPresionada(RAIZ) }
        val potenciaBoton: Button = findViewById(R.id.potenciaBoton)
        potenciaBoton.setOnClickListener { operacionPresionada(POTENCIA) }
        val puntoBoton: Button = findViewById(R.id.puntoBoton)
        puntoBoton.setOnClickListener { operacionPresionada(PUNTO) }
///////////////////////////////////////////////////////////////////////////////
        val borrarBoton: Button = findViewById(R.id.borrarBoton)
        borrarBoton.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultadoTextView.text = "0"
            operacion = NO_OPERACION
        }
        val igualBoton: Button = findViewById(R.id.igualBoton)

        igualBoton.setOnClickListener {
            if (operacion == DIVISION && num2 == 0.0) {
                Toast.makeText(this, "Error: no se puede dividir entre cero", Toast.LENGTH_SHORT).show()
            }else if(operacion == RAIZ && num1 <0 || num2 < 0){
                Toast.makeText(this, "Error: raiz negativa no existe", Toast.LENGTH_SHORT).show()
            }else{
                var resultado = when (operacion) {
                    SUMA -> num1 + num2
                    RESTA -> num1 - num2
                    MULTIPLICACION -> num1 * num2
                    DIVISION -> num1 / num2
                    RAIZ -> if (num1 > 0){
                        sqrt(num1)
                    }else if(num2 > 0){
                        sqrt(num2)
                    }else{

                    }
                    POTENCIA -> pow(num1, num2)
                    PUNTO -> (num2*0.1)+num1
                    else -> 0
                }
                resultadoTextView.text = resultado.toString()
                num1 = resultado as Double
          }
        }
    }
    private fun numeroPresionado(digito: String) {
        if (operacion == NO_OPERACION) {
            if (resultadoTextView.text == "0") {
                resultadoTextView.text = digito
            } else {
                resultadoTextView.text = "${resultadoTextView.text}$digito"
            }
            num1 = resultadoTextView.text.toString().toDouble()
        } else {
            if (resultadoTextView.text == "0") {
                resultadoTextView.text = digito
            } else {
                resultadoTextView.text = "${resultadoTextView.text}$digito"
            }
            num2 = resultadoTextView.text.toString().toDouble()
        }
    }
    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion
        resultadoTextView.text = "0"
    }
    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val RAIZ = 5
        const val POTENCIA =6
        const val PUNTO = 7
        const val NO_OPERACION = 0
    }
}