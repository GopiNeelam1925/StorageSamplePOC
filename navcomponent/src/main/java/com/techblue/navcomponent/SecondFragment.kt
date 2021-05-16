package com.techblue.navcomponent

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.techblue.navcomponent.databinding.FragmentSecondBinding


class SecondFragment : Fragment(R.layout.fragment_second) {

    lateinit var fragmentSecondBinding: FragmentSecondBinding
    val args: SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSecondBinding = FragmentSecondBinding.bind(view)

        Log.e("BlankFragment222", "onViewCreated")
        Log.e("SecondFragment", "${args.age}")

        fragmentSecondBinding.header2Txt.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("BlankFragment222", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("BlankFragment222", "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("BlankFragment222", "onAttach")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("BlankFragment222", "onActivityCreated")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("BlankFragment222", "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("BlankFragment222", "onDetach")
    }

    override fun onStart() {
        super.onStart()
        Log.e("BlankFragment222", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("BlankFragment222", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("BlankFragment222", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("BlankFragment222", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("BlankFragment222", "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("BlankFragment222", "onSaveInstanceState")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e("BlankFragment222", "onViewStateRestored")
    }
}