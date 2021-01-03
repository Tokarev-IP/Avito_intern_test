package test.app.avito_intern_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val CONSTK = "const_k"
    private val CONSTLIST = "const_list"
    private val CONST = 1
    private var TIME = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState?.getInt(CONSTK)!=null) DataSource.count(savedInstanceState.getInt(CONSTK))
        else DataSource.firstCount()

        if (savedInstanceState?.getInt(CONSTLIST)==null) DataSource.addNumberList()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_v)
        recyclerView.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.col_count))
        val mAdapter = RecyclerViewAdapter(DataSource.numberList)
        recyclerView.adapter = mAdapter


        dataSource()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mAdapter.notifyItemInserted(it)
                mAdapter.notifyItemRangeChanged(it, mAdapter.itemCount-it)
            }, {
            }, {

            })
    }

    private fun dataSource(): Observable<Int> {
        return Observable.create {
            while (TIME==1) {
                Thread.sleep(5000)
                if (TIME == 1) {
                    if (DeleteSource.deleteNumberList.size == 0) {
                        val i = Random.nextInt(DataSource.numberList.size)
                        DataSource.dataAdd(i, ++DataSource.count)
                        it.onNext(i)
                    }

                    if (DeleteSource.deleteNumberList.size > 0) {
                        val i = Random.nextInt(DeleteSource.deleteNumberList.size)
                        val j = Random.nextInt(DataSource.numberList.size+1)
                        DataSource.dataAdd(j, DeleteSource.deleteNumberList[i])
                        DeleteSource.dataDelete(i)
                        it.onNext(j)
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putInt(CONSTK,DataSource.count)
        }
        outState.run {
            putInt(CONSTLIST,CONST)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        TIME=0
        super.onDestroy()
    }
}