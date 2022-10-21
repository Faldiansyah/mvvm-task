package com.cowok.hijrah.chapter6topic4mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cowok.hijrah.chapter6topic4mvvm.R
import com.cowok.hijrah.chapter6topic4mvvm.databinding.ActivityMainBinding
import com.cowok.hijrah.chapter6topic4mvvm.viewmodel.ViewModelCar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewModelCar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataCar()
    }

    private fun showDataCar() {
        viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.getliveDataCar().observe(this, Observer {
            if (it != null) {
                binding.rvCar.layoutManager = LinearLayoutManager(
                    this, LinearLayoutManager.VERTICAL,false
                )
                binding.rvCar.adapter = CarAdapter(it)
                val adapter = CarAdapter(it)
                adapter.notifyDataSetChanged()
            }
        })
        viewModel.callApiCar()
    }
}