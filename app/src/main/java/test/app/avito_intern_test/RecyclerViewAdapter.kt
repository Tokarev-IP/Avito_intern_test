package test.app.avito_intern_test


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter() : RecyclerView.Adapter<MyViewHolder>() {



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mtitle.text = dataClass.numberList[position].toString()
    }

    override fun getItemCount(): Int {
        return dataClass.numberList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val mInfalter = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_view, parent, false)
        return MyViewHolder(mInfalter)

    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val mtitle: TextView = itemView.findViewById(R.id.text_number)
}