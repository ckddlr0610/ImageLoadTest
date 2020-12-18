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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.orhanobut.logger.Logger
import kr.com.imageloadingtest.databinding.FragmentCoilBinding
import kr.com.imageloadingtest.databinding.FragmentGlideBinding
import kr.com.imageloadingtest.databinding.FragmentMainBinding
import kr.com.imageloadingtest.model.ImageList
import java.util.concurrent.TimeUnit

class CoilFragment : Fragment() {
    private lateinit var binding: FragmentCoilBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_coil, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun toSecond(millis: Long) =
            String.format("%d sec", TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)))

        binding.ivCoil.load(R.drawable.building)
        Logger.d("loading finish! + " + toSecond(System.currentTimeMillis()))
    }
}
