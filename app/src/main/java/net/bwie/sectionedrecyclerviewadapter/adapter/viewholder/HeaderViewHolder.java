package net.bwie.sectionedrecyclerviewadapter.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import net.bwie.sectionedrecyclerviewadapter.R;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitleTextView;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        mTitleTextView = itemView.findViewById(R.id.header_tv);
    }

    public void bind(String title) {
        mTitleTextView.setText(title);
    }

}
