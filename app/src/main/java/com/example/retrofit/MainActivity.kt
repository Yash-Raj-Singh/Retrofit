package com.example.retrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private val adapter by lazy {
        Myadapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        val respository = Respository()

        val viewmodelFactory = MainViewModelFactory(respository)

        viewModel = ViewModelProvider(this, viewmodelFactory).get(MainViewModel::class.java)

        viewModel.getCustomPost(2,"id", "desc")

        viewModel.myResponse3.observe(this, Observer { response->
            if(response.isSuccessful)
            {
                response.body()?.let { adapter.setData(it) }
            }
            else
            {
                Toast.makeText(this, "Bad Network Call", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setupRecyclerView(){
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}