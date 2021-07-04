package com.example.myapplication

import FirstFragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu_utama.*

class MenuUtamaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_utama)

        val fragmentMenuUtama=FragmentMenuUtama()
        val fragmentHistory=FragmentHistory()
        val fragmentProfile=FragmentProfile()
        val navigasi = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        setCurrentFragment(fragmentMenuUtama)

        navigasi.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_homepage->setCurrentFragment(fragmentMenuUtama)
                R.id.menu_history->setCurrentFragment(fragmentHistory)
                R.id.menu_profile->setCurrentFragment(fragmentProfile)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}
//class MenuUtamaActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_menu_utama)
//
//        val tenda = findViewById<ImageButton>(R.id.tent)
//        val jaket = findViewById<ImageButton>(R.id.jaket)
//        val kompor = findViewById<ImageButton>(R.id.kompor)
//        val sepatu = findViewById<ImageButton>(R.id.sepatu)
//        val tas = findViewById<ImageButton>(R.id.tas)
//        val lainnya = findViewById<ImageButton>(R.id.lainnya)
//
//        tenda.setOnClickListener{
//            val intenttent = Intent(this, PilihBarangActivity::class.java)
//            startActivity(intenttent)
//        }
//
//        jaket.setOnClickListener{
//            val intentjaket = Intent(this, PilihBarangActivity::class.java)
//            startActivity(intentjaket)
//        }
//
//        kompor.setOnClickListener{
//            val intentkompor = Intent(this, PilihBarangActivity::class.java)
//            startActivity(intentkompor)
//        }
//
//        sepatu.setOnClickListener{
//            val intentsepatu = Intent(this, PilihBarangActivity::class.java)
//            startActivity(intentsepatu)
//        }
//
//        tas.setOnClickListener{
//            val intenttas = Intent(this, PilihBarangActivity::class.java)
//            startActivity(intenttas)
//        }
//
//        lainnya.setOnClickListener{
//            val intentlainnya = Intent(this, PilihBarangActivity::class.java)
//            startActivity(intentlainnya)
//        }
//
//
//
//
//    }
//
//}
