package com.rosa.ejemplo1

import com.rosa.ejemplo1.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.content.Context

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_STORAGE_PERMISSION = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


    }

    override fun onStart() {
        super.onStart()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            // No se han otorgado permisos, solicítalos
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CODE_STORAGE_PERMISSION)
        } else {
         }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_STORAGE_PERMISSION) {
            // Verifica si el usuario otorgó el permiso de escritura
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso otorgado, puedes proceder con la escritura en el archivo
            } else {
                // Permiso denegado, muestra un mensaje al usuario o toma otras acciones según sea necesario
            }
        }
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        // Aquí puedes realizar inicializaciones adicionales relacionadas con el contexto de la aplicación
        // Por ejemplo, configurar el idioma de la aplicación o la configuración específica del dispositivo
    }
}