package jaesung.project.architecturepractice.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jaesung.project.architecturepractice.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.e("Create")
    }
}