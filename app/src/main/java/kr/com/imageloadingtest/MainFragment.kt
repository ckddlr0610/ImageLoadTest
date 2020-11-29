package kr.com.imageloadingtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kr.com.imageloadingtest.databinding.FragmentMainBinding
import kr.com.imageloadingtest.model.LoaderType

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFragmentMain.adapter =
            MainAdapter(getTestList())
    }

    private fun getTestList(): List<LoaderType> {
        return listOf(
                LoaderType.GLIDE,
                LoaderType.PICASSO,
                LoaderType.COIL,
                LoaderType.FRESCO
        )
    }
}
