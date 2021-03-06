package app.bo.com.ucb.viewmodelfragment

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(private val loginRepository: LoginRepository): ViewModel() {

    sealed class UiModel {
        object Loading : UiModel()
        class Login(val resp: Boolean): UiModel()
    }

    val model: LiveData<UiModel>
        get() = _model

    private val _model = MutableLiveData<UiModel>()

    fun doLogin(userName: String, password: String) {
        _model.value = UiModel.Loading
        val runnable = Runnable {
            _model.value = UiModel.Login( loginRepository.login(userName, password))
        }

        Handler().postDelayed(runnable, 3000)

    }
}