package test.app.avito_intern_test

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val numberList: MutableList<Int>) : RecyclerView.Adapter<MyViewHolder>() {

    private val TAG = "myLogs"

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mtitle.text = numberList[position].toString()
        holder.mbutton.setOnClickListener {
            deleteButtonAction(position)
        }
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val mInfalter = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_view, parent, false)
        return MyViewHolder(mInfalter)


    }

    fun deleteButtonAction(position:Int){
        Log.d(TAG, "нажали DELETE $position и это номер из листа ${DataSource.numberList[position]}")
        DeleteSource.dataAdd(DataSource.numberList[position])
        Log.d(TAG, "добавил в удаленное число ${DataSource.numberList[position]}")
        DataSource.dataDelete(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount-position)

    }

}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val mtitle: TextView = itemView.findViewById(R.id.text_number)
    val mbutton: Button = itemView.findViewById(R.id.delete_button)
}