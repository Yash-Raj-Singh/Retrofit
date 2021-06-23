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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val respository = Respository()

        val viewmodelFactory = MainViewModelFactory(respository)

        viewModel = ViewModelProvider(this, viewmodelFactory).get(MainViewModel::class.java)

//        viewModel.getCountryDetail()

        val options : HashMap<String, String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"

        btnNumInput.setOnClickListener{
            val number: Int = Integer.parseInt(etNumber.text.toString())
            viewModel.getCustomPost2(number, options)

            viewModel.myResponse4.observe(this, Observer { response ->
                if(response.isSuccessful)
                {
                    tvText.text = response.body().toString()

                    response.body()?.forEach{
                        Log.d("RESP", it.userId.toString())
                        Log.d("RESP", it.id.toString())
                        Log.d("RESP", it.title)
                        Log.d("RESP", it.body)
                        Log.d("RESP", "--------------------")
                    }



                }
                else
                {
                    Log.d("RESP", response.errorBody().toString())
                    tvText.text = response.code().toString()
                }
            })

        }

    }
}