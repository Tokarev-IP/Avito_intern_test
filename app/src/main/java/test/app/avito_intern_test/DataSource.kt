package test.app.avito_intern_test

import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random


class DataSource {

    companion object {

        val numberList: MutableList<Int> = mutableListOf()

        fun addNumberList() {
            for (i in 1..15) {
                numberList.add(i)
            }
        }
    }
}