package test.app.avito_intern_test

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.Completable
import kotlin.random.Random

class DataSource {

    companion object {

        var numberList: MutableList<Int> = mutableListOf()

        fun addNumberList() {
            for (i in 1..15) {
                numberList.add(i)
            }
        }

        fun setData(numbList: MutableList<Int>) {
            numberList = numbList
        }

        fun dataAdd(position: Int, number: Int) {
            numberList.add(position, number + 1)
        }


        fun dataDelete(position: Int) {
            numberList.remove(position + 1)

        }

    }
}