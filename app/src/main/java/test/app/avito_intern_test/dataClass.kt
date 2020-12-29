package test.app.avito_intern_test

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random


class dataClass {

    companion object {

        val numberList: MutableList<Int> = mutableListOf()

        fun delete() {
           dataSource()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    numberList.add(it, numberList.size + 1)
                }, {

                }, {

                })
        }

        private fun dataSource(): Observable<Int> {
            return Observable.create { it ->
                while (true) {
                    Thread.sleep(1000)
                    val i = Random.nextInt(numberList.size)
                    it.onNext(i)
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