package com.example.cybergarden.presenter.questions

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.cybergarden.data.QuestionItem
import com.example.cybergarden.databinding.QuestionItemBinding


class QuestionsAdapter(private val news: List<QuestionItem>) :
    RecyclerView.Adapter<QuestionsAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: QuestionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var onItemClick: ((QuestionItem) -> Unit)? = null

        fun onBind(news: List<QuestionItem>, position: Int) {
            binding.apply {
                title.text = news[position].title
                description.text = news[position].description
                if (news[position].hideItem) {
                    description.visibility = View.VISIBLE
                } else {
                    description.visibility = View.GONE
                }
            }

            itemView.setOnClickListener {
                onItemClick?.invoke(news[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = QuestionItemBinding.inflate(inflater, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(news, position)
    }

    override fun getItemCount() = news.size

    open class RecyclerItemClickListener(
        recyclerView: RecyclerView,
        private val mListener: OnItemClickListener?
    ) : RecyclerView.OnItemTouchListener {
        private var mGestureDetector: GestureDetector = GestureDetector(
            recyclerView.context,
            object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    return true
                }

                override fun onLongPress(e: MotionEvent) {}
            })

        interface OnItemClickListener {
            fun onItemClick(view: View, position: Int)
        }

        override fun onInterceptTouchEvent(view: RecyclerView, e: MotionEvent): Boolean {
            val childView = view.findChildViewUnder(e.x, e.y)
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView))
                return true
            }
            return false
        }

        override fun onTouchEvent(view: RecyclerView, motionEvent: MotionEvent) {}
        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
    }

}
