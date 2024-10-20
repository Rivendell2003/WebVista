//@Author Jonathan V. Apiolaza
//@Date 20/10/2024
//@Version 1.0

package com.example.webvista

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextUrl: EditText
    private lateinit var buttonOpen: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextUrl = findViewById(R.id.editTextUrl)
        buttonOpen = findViewById(R.id.buttonOpen)

        buttonOpen.setOnClickListener {
            val url = editTextUrl.text.toString().trim() // un pekeño trim para eliminar espacios en blanco

            if (url.isEmpty()) {
                // poonemos un mensaje de error si la URL está vacía
                Toast.makeText(this, "Por favor, ingresa una URL", Toast.LENGTH_SHORT).show()
            } else {
                // x temas de seguridad advertimos q el  URL comience con http:// o https://
                val fullUrl = if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    "https://$url" // otorgamos  HTTPS por defecto
                } else {
                    url
                }

                // comienzo del WebActivity con la URL colocada
                val intent = Intent(this, WebActivity::class.java)
                intent.putExtra("url", fullUrl)
                startActivity(intent)
            }
        }
    }
}
