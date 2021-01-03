package test.app.avito_intern_test

class DeleteSource {

    companion object {

        var deleteNumberList: MutableList<Int> = mutableListOf()

        fun dataAdd(number: Int) {
            deleteNumberList.add(number)
        }

        fun dataDelete(position: Int) {
            deleteNumberList.removeAt(position)
        }
    }
}