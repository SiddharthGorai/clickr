package com.example.clickr

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class imagesView : AppCompatActivity() {

    private lateinit var list: ArrayList<imgData>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images_view)


        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val api: apiInterface = retrofit.create(apiInterface::class.java)
        val call: Call<DataModel> = api.getData()
        list = arrayListOf()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = LinearLayoutManager(this@imagesView)
        recyclerView.layoutManager = layoutManager

        call.enqueue(object : Callback<DataModel?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<DataModel?>, response: Response<DataModel?>) {
                if (response.isSuccessful) {
                    for (myData in response.body()!!) {
                        list.add(myData)
//                        Toast.makeText(this@imagesView, myData.toString(), Toast.LENGTH_LONG).show()

                    }
                    Log.d("Data",list.toString())
                    val adapter = myAdapter(list, this@imagesView)
                    recyclerView.adapter = adapter
                }

            }

            override fun onFailure(call: Call<DataModel?>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }
}