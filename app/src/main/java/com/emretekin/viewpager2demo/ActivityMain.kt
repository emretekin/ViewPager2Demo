package com.emretekin.viewpager2demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ActivityMain : AppCompatActivity() {

    lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createViews()
        setViewPager()
    }

    fun createViews(){
        viewPager = findViewById(R.id.view_pager)
    }

    fun setViewPager(){
        viewPager.adapter = BeerPagerAdapter(Beers.BeersStrings)
        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        //viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    class BeerPagerAdapter(private val beersStrings: Array<String>) : RecyclerView.Adapter<BeerViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
            return BeerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_beer, parent, false))
        }

        override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
            holder.beerName.text = beersStrings[position]
        }

        override fun getItemCount() = beersStrings.size
    }

    class BeerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val beerName: TextView = view.findViewById(R.id.beer_name)
    }
}
