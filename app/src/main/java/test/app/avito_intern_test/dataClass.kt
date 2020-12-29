package test.app.avito_intern_test

import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random


class DataSource {

    companion object {

        val numberList: MutableList<Int> = mutableListOf()

        fun addNumber() {
           dataSource()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    numberList.add(it)
                }, {

                }, {

                })
        }

        private fun dataSource(): Observable<Int> {
            return Observable.create {
                while (true) {
                    Thread.sleep(5000)
                    val i = numberList.size+1
//                  it.onNext(i)
                }
            }
        }

        fun addNumberList() {
            for (i in 1..15) {
                numberList.add(i)
            }
        }
    }
}