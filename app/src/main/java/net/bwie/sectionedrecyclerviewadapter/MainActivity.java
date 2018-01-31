package net.bwie.sectionedrecyclerviewadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.truizlop.sectionedrecyclerview.SectionedSpanSizeLookup;

import net.bwie.sectionedrecyclerviewadapter.adapter.MyAdapter;
import net.bwie.sectionedrecyclerviewadapter.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * SectionedRecyclerViewAdapter
 * 三段式item的适配器
 * 头视图（标题）、item内容、尾视图
 */
public class MainActivity extends AppCompatActivity {

    public static final String IMG_URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517397949477&di=8a8e90fd5a4f2ab6cbd2b171b2222980&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D12867320%2C655225767%26fm%3D214%26gp%3D0.jpg";

    protected RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    // 全部item的数据
    private List<List<ItemBean>> mSectionList;
    // 全部段落标题的数据
    private List<String> mTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
        // item的数据
        initData();

        mAdapter.addDatas(mTitleList, mSectionList);
    }


    // 初始化数据
    // 每段中有若干item，所以一个段落就使用一个List集合管理内部的item
    // 还需要一个List集合管理这些段落，所以最终数据的格式就是List<List<>>
    private void initData() {
        // 所有段落的List集合
        mSectionList = new ArrayList<>();
        // 标题集合
        mTitleList = new ArrayList<>();

        // 10段
        for (int i = 0; i < 10; i++) {
            // 10个Item的List，也就是10个段落
            List<ItemBean> itemList = new ArrayList<>();
            // 每段（每个List集合）有3个item数据
            for (int j = 0; j < 3; j++) {
                ItemBean item = new ItemBean();
                item.setContent("第" + i + "段的第" + j + "个数据");
                item.setImgUrl(IMG_URL);
                itemList.add(item);
            }
            mSectionList.add(itemList);

            mTitleList.add("我是标题：" + i);
        }
    }


    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MyAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        // 设置这个玩意儿之后，就不会出现错乱情况
        SectionedSpanSizeLookup lookup = new SectionedSpanSizeLookup(mAdapter, layoutManager);
        layoutManager.setSpanSizeLookup(lookup);

        mRecyclerView.setLayoutManager(layoutManager);
    }
}
