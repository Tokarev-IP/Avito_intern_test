package test.app.avito_intern_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataSource.addNumberList()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_v)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        //recyclerView.adapter = RecyclerViewAdapter()
        val mAdapter = RecyclerViewAdapter(DataSource.numberList)
        recyclerView.adapter = mAdapter


        dataSource()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                DataSource.numberList.add(it,DataSource.numberList.size+1)
                mAdapter.notifyDataSetChanged()
            }, {

            }, {

            })

    }


    private fun dataSource(): Observable<Int> {
        return Observable.create {
            while (true) {
                Thread.sleep(5000)
                val i = Random.nextInt(DataSource.numberList.size)
                it.onNext(i)
            }
        }
    }


}