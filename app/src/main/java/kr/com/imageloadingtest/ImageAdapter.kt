package kr.com.imageloadingtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orhanobut.logger.Logger
import kr.com.imageloadingtest.databinding.ItemImageBinding

class ImageAdapter(
        private val list: List<String>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(
                ItemImageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    //FIXME: 캐싱은 어떻게 테스트 해볼 수 있을지?
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageViewHolder).bind(list[position])
        if (position == 0) Logger.d("first Load! + " + System.currentTimeMillis())
        if (position == itemCount-1) Logger.d("last Load! + " + System.currentTimeMillis())
    }

    class ImageViewHolder(
            private val binding: ItemImageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            Glide.with(binding.root).load(item).into(binding.ivItemImage)
        }
    }
}
