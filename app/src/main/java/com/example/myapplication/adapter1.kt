package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter1 internal constructor(private var rowDataList: List<SecondActivity.RowData>)
    : RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout1, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val rowData = rowDataList[position]
        holder.hinmoku.text = rowData.hinmoku
        holder.kingaku.text = rowData.kingaku
    }

    //List型なのでそのままだとエラーが出る。
    override fun getItemCount(): Int {
        return rowDataList.size
    }
}
class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var hinmoku: TextView = itemView.findViewById(R.id.text_view1)
    var kingaku: TextView = itemView.findViewById(R.id.text_view2)
}