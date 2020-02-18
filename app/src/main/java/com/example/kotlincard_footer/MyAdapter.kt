package com.example.kotlincard_footer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataList: List<Data>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var clickListener: ClickListener? = null

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var subtitle: TextView
        var icon: ImageView
        private val main: LinearLayout

        init {
            title = itemView.findViewById<View>(R.id.title) as TextView
            subtitle = itemView.findViewById<View>(R.id.subtitle) as TextView
            icon = itemView.findViewById<View>(R.id.icon) as ImageView
            main = itemView.findViewById<View>(R.id.main) as LinearLayout
            main.setOnClickListener { v ->
                Toast.makeText(
                    itemView.context,
                    "Position:" + Integer.toString(position),
                    Toast.LENGTH_SHORT
                ).show()
                if (clickListener != null) {
                    clickListener!!.itemClicked(v, adapterPosition)
                }
            }
        }
    }
    fun setClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val row = dataList[position]
        holder.title.text = row.title
        holder.subtitle.text = row.subtitle
        holder.icon.setImageResource(row.imageId)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}