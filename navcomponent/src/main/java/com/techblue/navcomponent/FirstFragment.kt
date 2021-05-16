package com.techblue.navcomponent

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.techblue.navcomponent.databinding.FragmentFirstBinding
import com.techblue.navcomponent.models.User

class FirstFragment : Fragment(R.layout.fragment_first) {

    lateinit var fragmentFirstBinding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentFirstBinding = FragmentFirstBinding.bind(view)

        Log.e("BlankFragment", "onViewCreated")
        fragmentFirstBinding.nextBtn.setOnClickListener {

            val userIs = User(name = "Gopi Neelam", age = 26)
            val action =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(age = 19, user = userIs)
//            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment)
            Navigation.findNavController(view).navigate(action)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("BlankFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("BlankFragment", "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("BlankFragment", "onAttach")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("BlankFragment", "onActivityCreated")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("BlankFragment", "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("BlankFragment", "onDetach")
    }

    override fun onStart() {
        super.onStart()
        Log.e("BlankFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("BlankFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("BlankFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("BlankFragment", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("BlankFragment", "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("BlankFragment", "onSaveInstanceState")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e("BlankFragment", "onViewStateRestored")
    }
}