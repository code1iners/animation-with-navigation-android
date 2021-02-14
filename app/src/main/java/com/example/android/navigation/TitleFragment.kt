package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false
        )

//        binding.playButton.setOnClickListener { view: View ->
////            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
//            // note. able to change next code
//            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
//        }
        // note. able to change next code
        // note. play game button click listener
        binding.playButton.setOnClickListener { view: View ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }

        // note. Tells Android that the Fragment has a menu (overflow menu init).
        setHasOptionsMenu(true)

        return binding.root
    }

    // note. Where you inflate your menu (actually apply into UI).
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }
    // note. Called when a menu item is selected (menu select listener).
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
}