package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import kotlinx.android.synthetic.main.fragment_menu_utama.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentMenuUtama : Fragment() {

    companion object {
        val PIL_BARANG = "barang"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_utama, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tent = view.findViewById<ImageButton>(R.id.tent)

        tent.setOnClickListener {
            val intent = Intent(context, PilihBarangActivity::class.java)
            intent.putExtra(PIL_BARANG, "tenda")
            startActivity(intent)
        }
        val jaket = view.findViewById<ImageButton>(R.id.jaket)

        jaket.setOnClickListener {
            val intentjaket = Intent(context, PilihBarangActivity::class.java)
            intentjaket.putExtra(PIL_BARANG, "jaket")
            startActivity(intentjaket)
        }
        val kompor = view.findViewById<ImageButton>(R.id.kompor)
        kompor.setOnClickListener {
            val intentkompor = Intent(context, PilihBarangActivity::class.java)
            intentkompor.putExtra(PIL_BARANG, "kompor")
            startActivity(intentkompor)
        }

        val sepatu = view.findViewById<ImageButton>(R.id.sepatu)
        sepatu.setOnClickListener {
            val intentsepatu = Intent(context, PilihBarangActivity::class.java)
            intentsepatu.putExtra(PIL_BARANG, "sepatu")
            startActivity(intentsepatu)
        }

        val tas = view.findViewById<ImageButton>(R.id.tas)
        tas.setOnClickListener {
            val intenttas = Intent(context, PilihBarangActivity::class.java)
            intenttas.putExtra(PIL_BARANG, "tas")
            startActivity(intenttas)
        }

        val lainnya = view.findViewById<ImageButton>(R.id.lainnya)
        lainnya.setOnClickListener {
            val intentlainya = Intent(context,PilihBarangActivity::class.java)
            intentlainya.putExtra(PIL_BARANG, "lainnya")
            startActivity(intentlainya)
        }

        super.onViewCreated(view, savedInstanceState)
    }

}
