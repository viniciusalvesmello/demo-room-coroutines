package io.github.viniciusalvesmello.demoroomcoroutines

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.github.viniciusalvesmello.shared.utils.observe
import io.github.viniciusalvesmello.shared.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initObservers()
        initListeners()
    }

    private fun initView() {
        userViewModel.getAll()
    }

    private fun initObservers() {
        with(userViewModel.viewState) {
            observe(loading) {
                pbLoading.visibility = if(it) View.VISIBLE else View.GONE
            }
            observe(users) {
                tvUser.text = it.toString()
            }
            observe(error) {
                tvUser.text = it.message
            }
        }
    }

    private fun initListeners() {
        btRegister.setOnClickListener {
            userViewModel.insert(
                email = etEmail.text.toString(),
                name = etName.text.toString()
            )
        }
    }
}
