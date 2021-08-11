package idv.hsu.handlebackpressinfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import idv.hsu.handlebackpressinfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fm by lazy {
        supportFragmentManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        val f = fm.fragments.find { it.isVisible }
        if (f is FragmentWithBackPress) {
            if (!f.onFragmentBackPressed()) { // fragment didn't handle on back press
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }
}