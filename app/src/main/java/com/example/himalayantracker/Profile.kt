package com.example.himalayantracker

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class Profile : Fragment() {

    private lateinit var customerservice : LinearLayout
    private lateinit var name :  TextView
    private lateinit var city : TextView
    private lateinit var phoneNo : TextView
    private lateinit var email1 : TextView
    private lateinit var logout : LinearLayout
    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_profile, container, false)

        //Intializations variables

        auth = FirebaseAuth.getInstance()
        logout = view.findViewById(R.id.pr_logout)
        name = view.findViewById(R.id.pr_txName)
        city  = view.findViewById(R.id.pr_txcity)
        phoneNo = view.findViewById(R.id.pr_txNumber)
        email1 = view.findViewById(R.id.pr_txEmail)

        //customer service
        customerservice = view.findViewById(R.id.Pr_Cs)
        customerservice.setOnClickListener {
            val intent =  Intent(requireContext(), CustomerService::class.java)
            startActivity(intent)
        }


        //logout
        logout.setOnClickListener {
            val message : String? = "Are You Sure You Want To log out"
            showCustomDialogBox(message)
        }
        //Funtions
        details()



        return view

    }

    // Logout Button
    private fun showCustomDialogBox(message: String?) {
            val dialog = Dialog(requireContext())
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.logout)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val tvMessage : TextView = dialog.findViewById(R.id.tvMessage)
            val btnYes : Button = dialog.findViewById(R.id.btnYes)
            val btnNo : Button = dialog.findViewById(R.id.btnNo)
            tvMessage.text =  message
            btnYes.setOnClickListener {
                auth.signOut()
                val intent = Intent(requireContext(),Login::class.java)
                startActivity(intent)
                Toast.makeText(requireContext(),"LogOut SuccessFully",Toast.LENGTH_SHORT).show()
            }
            btnNo.setOnClickListener{
                dialog.dismiss()
            }
            dialog.show()
    }


    // Desktop Details
    private fun details() {
        val sharedPreferences = this.activity?.getSharedPreferences("MyPre",Context.MODE_PRIVATE)
        val fname = sharedPreferences?.getString("01","").toString()
        val cname = sharedPreferences?.getString("02","").toString()
        val phno = sharedPreferences?.getString("03","").toString()
        val email = sharedPreferences?.getString("04","").toString()
        name.text = "$fname"
        city.text = "$cname"
        phoneNo.text = "$phno"
        email1.text = "$email"
    }



}