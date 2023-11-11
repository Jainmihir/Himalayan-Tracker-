package com.example.himalayantracker

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.firebase.auth.FirebaseAuth


class Home : Fragment() {
    private lateinit var auth : FirebaseAuth
    private lateinit var hotels : LinearLayout
    private lateinit var tracks: LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        auth = FirebaseAuth.getInstance()
        hotels = view.findViewById(R.id.book_hotels)
        hotels.setOnClickListener {
            val intent = Intent(requireContext(),BookHotels::class.java)
            startActivity(intent)
        }
        tracks = view.findViewById(R.id.tracks_details)
        tracks.setOnClickListener {
            val intent = Intent(requireContext(),Tracks::class.java)
            startActivity(intent)
        }



        return view
    }

}