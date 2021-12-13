package com.example.newsapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.browser.customtabs.CustomTabsIntent
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout



class MainActivity : AppCompatActivity() {


    val api = "f83526809bc44fa88ab7de1748dfb289"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mtoolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(mtoolbar)

//        val mhome =findViewById<TabItem>(R.id.home)
//        val mscience =findViewById<TabItem>(R.id.science)
//        val msports =findViewById<TabItem>(R.id.sports)
//        val mtech =findViewById<TabItem>(R.id.technology)
//        val mentertainment =findViewById<TabItem>(R.id.entertainment)

        val viewPager = findViewById<ViewPager>(R.id.fragmentcontainer)
        val tabLayout = findViewById<TabLayout>(R.id.include)
        val adapter = PagerAdapter(supportFragmentManager)




        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(SportsFragment(), "Sports")
        adapter.addFragment(HealthFragment(), "Health")
        adapter.addFragment(ScienceFragment(), "Science")
        adapter.addFragment(EntertainmentFragment(), "Entertainment")
        adapter.addFragment(TechFragment(), "Technology")

//        makes fragments move sideways
        viewPager.adapter = adapter

//sync with fragment and tabs
        tabLayout.setupWithViewPager(viewPager)


    }


}





