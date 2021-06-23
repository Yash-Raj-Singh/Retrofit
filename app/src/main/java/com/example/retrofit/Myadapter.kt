package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_item.view.*

class Myadapter: RecyclerView.Adapter<Myadapter.MyViewHolder>() {

    private var MyList = emptyList<Post>()

    inner class MyViewHolder(itemview : View): RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.textView.text = MyList[position].userId.toString()
        holder.itemView.textView2.text = MyList[position].id.toString()
        holder.itemView.textView3.text = MyList[position].title
        holder.itemView.textView4.text = MyList[position].body
    }

    override fun getItemCount(): Int {
        return MyList.size
    }

    fun setData(newList : List<Post>)
    {
        MyList = newList
        notifyDataSetChanged()
    }
}