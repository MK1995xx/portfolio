package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {
    val fileName = "data.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hinmokuText = findViewById<EditText>(R.id.editTextName)
        val kingakuText = findViewById<EditText>(R.id.editTextNumber)
        val button = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        var data1:String
        var data2:String
        val file1 = File(applicationContext.filesDir, fileName)
        File(applicationContext.filesDir, fileName).writer().use {
            it.write("テスト用：テスト用")
        }
        button.setOnClickListener{
            data1 = hinmokuText.text.toString()
            data2 = kingakuText.text.toString()
            "split by ,&."
            file1.appendText("," + data1 + ":" + data2)
            println("check1")

            Toast.makeText(applicationContext, data1 + "￥"+data2, Toast.LENGTH_SHORT).show()

        }
        button2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

}