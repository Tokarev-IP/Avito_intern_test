package test.app.avito_intern_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_v)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = RecyclerViewAdapter()

        dataClass.addNumberList()
       // dataClass.delete()
    }
}