package kr.com.imageloadingtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.orhanobut.logger.Logger
import kr.com.imageloadingtest.databinding.FragmentGlideBinding
import kr.com.imageloadingtest.databinding.FragmentMainBinding
import kr.com.imageloadingtest.model.ImageList

class GlideFragment : Fragment() {
    private lateinit var binding: FragmentGlideBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        Logger.d("startImageLoad" + System.currentTimeMillis())
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_glide, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFragmentGilde.adapter =
                ImageAdapter(ImageList().images)

        binding.rvFragmentGilde
                .viewTreeObserver
                .addOnGlobalLayoutListener (object : ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        Toast.makeText(requireContext(), "로드 완료", Toast.LENGTH_LONG).show()

                        binding.rvFragmentGilde
                                .viewTreeObserver
                                .removeOnGlobalLayoutListener(this)
                    }
                })
    }
}
