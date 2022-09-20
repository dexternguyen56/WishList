package com.codepath.wishlist

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    lateinit var adapter: WishListAdapter
    lateinit var item : WishList
    lateinit var name: String
    lateinit var price: String
    lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wlRv = findViewById<RecyclerView>(R.id.wishListRV)

        val summitButton = findViewById<Button>(R.id.button_submit)
        val nameET = findViewById<EditText>(R.id.editText_name)
        val urlET = findViewById<EditText>(R.id.editText_url)
        val priceET = findViewById<EditText>(R.id.editText_price)

        var wl : MutableList<WishList> = ArrayList()

        adapter = WishListAdapter(wl)
        wlRv.adapter = adapter
        wlRv.layoutManager = LinearLayoutManager(this)
        summitButton.setOnClickListener {
            name = nameET.getText().toString()
            price = priceET.getText().toString()
            url= urlET.getText().toString()
            item = WishList(name,price,url)

//            println(name+price+url)
//            println(item.itemName)

            wl.add(item)

            for(index in 0..wl.size-1){
                println(wl[index].itemName)
            }

            adapter.notifyDataSetChanged()

            nameET.onEditorAction(EditorInfo.IME_ACTION_DONE)
            nameET.getText().clear()
            priceET.onEditorAction(EditorInfo.IME_ACTION_DONE)
            priceET.getText().clear()
            urlET.onEditorAction(EditorInfo.IME_ACTION_DONE)
            urlET.getText().clear()
        }




    }
    //hide keyboard
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }




}

