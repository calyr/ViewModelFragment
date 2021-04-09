package app.bo.com.ucb.viewmodelfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class LoginActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var userName: EditText
    lateinit var password: EditText
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val loginViewModel = LoginViewModel(LoginRepository())

        loginViewModel.model.observe(this, Observer(::updateUi))

        button = findViewById(R.id.btnLogin)
        userName = findViewById(R.id.etUsername)
        password = findViewById(R.id.etPassword)
        progressBar = findViewById(R.id.progressBar)
        button.setOnClickListener {
            loginViewModel.doLogin( userName.text.toString(), password.text.toString() )
        }

    }

    private fun updateUi(uiModel: LoginViewModel.UiModel) {
        progressBar.visibility = if (uiModel is LoginViewModel.UiModel.Loading) View.VISIBLE else View.GONE
        when (uiModel) {
            is LoginViewModel.UiModel.Login -> {
                if( uiModel.resp ) {
                    Toast.makeText(this, "Exitoso", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}