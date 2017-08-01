package wrightstuff.wowscrubber.ui.guild;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.model.GuildNews;
import wrightstuff.wowscrubber.ui.BaseActivity;
import wrightstuff.wowscrubber.ui.BaseFragment;

/**
 * Created by michaelwright on 01/08/2017.
 */

public class GuildFragment extends BaseFragment implements GuildContract.View {
    private static final String TAG = GuildFragment.class.getCanonicalName();

    private GuildContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private GuildAdapter mAdapter;

    private TextView mTextInfo;


    @Override
    public void setDataToAdapter(GuildNews data) {
        mAdapter.updateData(data);
        if (data == null || data.getNews() == null || data.getNews().size() < 1) {
            mTextInfo.setVisibility(View.VISIBLE);
            mTextInfo.setText(R.string.text_you_have_no_tracks);
        } else {
            mTextInfo.setVisibility(View.GONE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_guild, container, false);


        mLayoutManager = new LinearLayoutManager(getContext());

        mTextInfo = (TextView) view.findViewById(R.id.tv_info);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_guild);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GuildAdapter();
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(view1 -> mPresenter.updateTracks());

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new GuildPresenter(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.bind(this);
        mPresenter.updateTracks();
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.unBind();
        }
        super.onDestroyView();
    }

    @Override
    public String getCurrentTag() {
        return TAG;
    }


}
