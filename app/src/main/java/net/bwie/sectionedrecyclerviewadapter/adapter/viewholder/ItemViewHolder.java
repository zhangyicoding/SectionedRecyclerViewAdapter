package net.bwie.sectionedrecyclerviewadapter.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.bwie.sectionedrecyclerviewadapter.R;
import net.bwie.sectionedrecyclerviewadapter.bean.ItemBean;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private TextView mContextTextView;
    private ImageView mImageView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        mContextTextView = itemView.findViewById(R.id.content_tv);
        mImageView = itemView.findViewById(R.id.image_view);
    }

    public void bind(ItemBean item) {
        mContextTextView.setText(item.getContent());

        Glide.with(mImageView.getContext())
                .load(item.getImgUrl())
                .into(mImageView);
    }

}
