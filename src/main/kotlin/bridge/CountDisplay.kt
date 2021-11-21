package bridge

class CountDisplay(impl: DisprayImpl) : Display(impl) {
    fun multiDisplay(times: Int) {
        open()
        repeat(times) {
            print()
        }
        close()
    }
}
