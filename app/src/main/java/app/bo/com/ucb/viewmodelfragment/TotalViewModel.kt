package app.bo.com.ucb.viewmodelfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TotalViewModel: ViewModel() {
    var total = 0
    val counter: LiveData<Int>
        get() = _counter

    private val _counter = MutableLiveData<Int>()

    fun addTotal() {
        total++
        _counter.value = total
    }
}