package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.File

class SecondActivity : AppCompatActivity() {
    private var mainAdapter: adapter1? = null
    val fileName = "data.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)
        val button = findViewById<Button>(R.id.button)
        val readFile = File(applicationContext.filesDir, fileName)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
        var vs:MutableList<String> = mutableListOf()

        if(readFile.exists()) {
            val contents = readFile.bufferedReader().use(BufferedReader::readText)
            vs = splitText1(contents) as MutableList<String>
        }
        recyclerView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        mainAdapter = adapter1(createRowData(vs))
        recyclerView.adapter = mainAdapter

        button.setOnClickListener{
            finish()
        }
    }
    private fun createRowData(vs: List<String>): List<RowData> {
        val dataSet: MutableList<RowData> = ArrayList()
        var i = 1
        while (i < vs.size) {
            val data = RowData()
            val vs2 = splitText2(vs[i])
            data.hinmoku = vs2[0]
            data.kingaku = "￥"+vs2[1]
            val add = dataSet.add(data)
            i += 1
        }
        return dataSet
    }
    inner class RowData {
        var hinmoku: String? = null
        var kingaku: String? = null
    }
    fun splitText1(text:String): List<String> {
        val s = text.split(",")
        return s
    }
    fun splitText2(text:String): List<String> {
        val s = text.split(":")
        return s
    }
}
