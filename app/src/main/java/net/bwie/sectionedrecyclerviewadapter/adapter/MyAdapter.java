package net.bwie.sectionedrecyclerviewadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.truizlop.sectionedrecyclerview.SectionedRecyclerViewAdapter;

import net.bwie.sectionedrecyclerviewadapter.R;
import net.bwie.sectionedrecyclerviewadapter.adapter.viewholder.FooterViewHolder;
import net.bwie.sectionedrecyclerviewadapter.adapter.viewholder.HeaderViewHolder;
import net.bwie.sectionedrecyclerviewadapter.adapter.viewholder.ItemViewHolder;
import net.bwie.sectionedrecyclerviewadapter.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends SectionedRecyclerViewAdapter
        <HeaderViewHolder, ItemViewHolder, FooterViewHolder> {

    private Context mContext;
    private List<List<ItemBean>> mSectionList;
    private List<String> mTitleList;

    public MyAdapter(Context context) {
        mContext = context;
        mSectionList = new ArrayList<>();
        mTitleList = new ArrayList<>();

    }

    // 添加数据
    public void addDatas(List<String> titleList, List<List<ItemBean>> sectionList) {
        mTitleList.addAll(titleList);
        mSectionList.addAll(sectionList);
        notifyDataSetChanged();
    }

    // 获取段落数量
    @Override
    protected int getSectionCount() {
        return mSectionList.size();
    }

    // 第某个段落中item的数量
    @Override
    protected int getItemCountForSection(int section) {
        return mSectionList.get(section).size();
    }


    // 第某个段落是否使用尾视图
    @Override
    protected boolean hasFooterInSection(int section) {
        return true;
    }

    // 创建头视图对应的ViewHolder
    @Override
    protected HeaderViewHolder onCreateSectionHeaderViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.item_header, parent, false);
        return new HeaderViewHolder(itemView);
    }

    // 创建尾视图对应的ViewHolder
    @Override
    protected FooterViewHolder onCreateSectionFooterViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.item_footer, parent, false);
        return new FooterViewHolder(itemView);
    }

    // 创建段落中item视图对应的ViewHolder
    @Override
    protected ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.item, parent, false);
        return new ItemViewHolder(itemView);
    }

    // 绑定头视图数据
    // section：代表第几个段落
    @Override
    protected void onBindSectionHeaderViewHolder(HeaderViewHolder holder, int section) {
        String title = mTitleList.get(section);

        holder.bind(title);
    }

    // 绑定尾视图数据
    @Override
    protected void onBindSectionFooterViewHolder(FooterViewHolder holder, int section) {
    }

    // 绑定段落中item视图数据
    // section：代表第几段
    // position：代表这段中的第几个item
    @Override
    protected void onBindItemViewHolder(ItemViewHolder holder, int section, int position) {
        ItemBean item = mSectionList.get(section).get(position);

        holder.bind(item);
    }
}
