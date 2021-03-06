package test.app.avito_intern_test

class DataSource {

    companion object {

        var numberList: MutableList<Int> = mutableListOf()
        var count:Int = 0

        fun count(mcount:Int){
            count = mcount
        }

        fun firstCount(){
            count=15
        }

        fun addNumberList() {
            for (i in 1..15) {
                numberList.add(i)
            }
        }

        fun dataAdd(position: Int, number: Int) {
            numberList.add(position, number)
        }

        fun dataDelete(position: Int) {
            numberList.removeAt(position)
        }

    }
}