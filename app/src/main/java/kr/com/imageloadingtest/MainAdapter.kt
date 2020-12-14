package kr.com.imageloadingtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger
import kr.com.imageloadingtest.databinding.ItemTestListBinding
import kr.com.imageloadingtest.model.LoaderType

class MainAdapter(
    private val list: List<LoaderType>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainViewHolder(
            ItemTestListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainViewHolder).bind(list[position])
    }

    class MainViewHolder(
        private val binding: ItemTestListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LoaderType) {
            binding.item = item
            binding.root.setOnClickListener {
                when(item) {
                    LoaderType.GLIDE ->
                        binding.root.findNavController().navigate(R.id.action_MainFragment_to_GlideFragment)

                    LoaderType.PICASSO ->
                        binding.root.findNavController().navigate(R.id.action_MainFragment_to_GlideFragment)

                    LoaderType.COIL ->
                        binding.root.findNavController().navigate(R.id.action_MainFragment_to_GlideFragment)

                    LoaderType.FRESCO ->
                        binding.root.findNavController().navigate(R.id.action_MainFragment_to_GlideFragment)
                }
            }
        }
    }
}