package com.example.kotlincard_footer

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import java.util.ArrayList


class HeaderAdapter(internal var data: ArrayList<Data>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var clickListener: ClickListener? = null
    private val marginTop: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM) {
            //inflate your layout and pass it to view holder
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_new, parent, false)
            return VHItem(itemView)
        } else if (viewType == TYPE_HEADER) {
            //inflate your layout and pass it to view holder
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.header_item, parent, false)
            return VHHeader(itemView)
        }
        throw RuntimeException("there is no type that matches the type $viewType + make sure your using types correctly")
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is VHItem) {
            val dataItem = getItem(position)
            //cast holder to VHItem and set data
            holder.title.text = dataItem.title
            holder.icon.setImageResource(dataItem.imageId)
            holder.icon_next.setImageResource(dataItem.imageId2)


            if(position.equals(1)){
                holder.itemView.setPadding(0, 50, 0, 100);
            }
            else if(position.equals(6)){

                holder.icon_next.setVisibility(View.INVISIBLE);
                holder.title.setTextColor(Color.parseColor("#F10F2A"))


            }

        } else if (holder is VHHeader) {
            val row =data[position]
            holder.titleheader.text=row.title_header
        }
    }

    override fun getItemCount(): Int {
        return data.size + 1
    }
    override fun getItemViewType(position: Int): Int {
        return if (isPositionHeader(position)) TYPE_HEADER else TYPE_ITEM

    }
    private fun isPositionHeader(position: Int): Boolean {
        return position == 0
    }

    private fun getItem(position: Int): Data {
        return data[position - 1]
    }
    fun setClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }
    internal inner class VHItem(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var title: TextView
        var icon: ImageView
        var icon_next: ImageView


        private val main: LinearLayout

        init {
            title = itemView!!.findViewById<View>(R.id.tv_profile_row) as TextView
            icon = itemView.findViewById<View>(R.id.img_profile_row) as ImageView
            icon_next = itemView.findViewById<View>(R.id.img_next_row) as ImageView

            main = itemView.findViewById<View>(R.id.main) as LinearLayout
            main.setOnClickListener { v ->
                Toast.makeText(
                    itemView.context,
                    "Position:" + Integer.toString(position),
                    Toast.LENGTH_SHORT
                ).show()
//                if (clickListener != null) {
//                    clickListener!!.itemClicked(v, adapterPosition)
//                }
            }
        }
    }
    internal inner class VHHeader(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var titleheader: TextView
        private val main_header: LinearLayout

        init {
            titleheader = itemView!!.findViewById<View>(R.id.txtHeader) as TextView
            main_header=itemView!!.findViewById<View>(R.id.main_header) as LinearLayout
            main_header.setOnClickListener {
                Toast.makeText(itemView.context,
                    "Postion Header"+ Integer.toString(position),Toast.LENGTH_LONG).show()
            }
        }
    }
    companion object {
        private val TYPE_HEADER = 0
        private val TYPE_ITEM = 1
    }
}


