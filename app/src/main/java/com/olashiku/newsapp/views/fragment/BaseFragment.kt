package com.olashiku.newsapp.views.fragment

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.olashiku.newsapp.views.activity.MainActivity

open class BaseFragment: Fragment() {

    fun showBottomNavigationView(showBottomSheet:Boolean){
        (activity as MainActivity).showBottomNavigationView(showBottomSheet)
    }

    fun showToast(message:String){
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }

}