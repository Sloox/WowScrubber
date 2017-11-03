package wrightstuff.wowscrubber.ui.guild;

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
import wrightstuff.wowscrubber.model.guild.GuildNews;
import wrightstuff.wowscrubber.model.guild.News;
import wrightstuff.wowscrubber.ui.BaseActivity;
import wrightstuff.wowscrubber.ui.BaseFragment;
import wrightstuff.wowscrubber.ui.user.UserFragment;


public class GuildFragment extends BaseFragment implements GuildContract.View, GuildAdapter.OnItemClickListener {
    private static final String TAG = GuildFragment.class.getCanonicalName();

    private GuildContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private GuildAdapter mAdapter;

    private TextView mTextInfo;
    private FloatingActionButton mFab;


    @Override
    public void setDataToAdapter(GuildNews data) {
        mAdapter.updateGuildNewsData(data);
        if (data == null || data.getNews() == null || data.getNews().size() < 1) {
            mTextInfo.setVisibility(View.VISIBLE);
            mTextInfo.setText(R.string.text_unknown_error);
        } else {
            mTextInfo.setVisibility(View.GONE);
        }
    }

    @Override
    public void enableFab(boolean visibility) {
        if (!visibility) {
            mFab.setVisibility(View.GONE);
            mFab.setOnClickListener(null);
        } else {
            mFab.setVisibility(View.VISIBLE);
            mFab.setOnClickListener(v -> mPresenter.updateGuildNews());
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

        mAdapter = new GuildAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        mLoadingView = view.findViewById(R.id.loading_progress);
        mContentView = view.findViewById(R.id.content_frame);


        mFab = (FloatingActionButton) view.findViewById(R.id.fab);
        enableFab(true);

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
        mPresenter.updateGuildNews();
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.unBind();
        }
        super.onDestroyView();
    }

    @Override
    public void onStart(){
        super.onStart();
        enableFab(true);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public String getCurrentTag() {
        return TAG;
    }

    @Override
    public void onNewsItemClicked(News userNews) {
        //news has been clicked (from inside adapter) now to broadcast to new fragment and transition
        mPresenter.sendNewsItemMessage(getContext(), userNews);
        enableFab(false);
    }
}
