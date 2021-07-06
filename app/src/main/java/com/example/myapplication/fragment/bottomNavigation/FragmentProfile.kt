package com.example.myapplication.fragment.bottomNavigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication.EditProfileActivity
import com.example.myapplication.LoginActivity
import com.example.myapplication.R
import com.example.myapplication.util.toast

/**
 * A simple [Fragment] subclass.
 */
class FragmentProfile : Fragment(R.layout.activity_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profile = view.findViewById<ImageButton>(R.id.editprofile)

        profile.setOnClickListener {
            val intentprofile = Intent(requireContext(), EditProfileActivity::class.java)
            startActivity(intentprofile)

            toast(requireContext(), "succes")
        }

        val logout = view.findViewById<ImageButton>(R.id.logout)
        logout.setOnClickListener {
            val intentlogot = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intentlogot)
//            intentlogot.fin
        }
    }

}
