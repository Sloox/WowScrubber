package wrightstuff.wowscrubber.ui.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.model.guild.News;
import wrightstuff.wowscrubber.model.user.User;
import wrightstuff.wowscrubber.ui.BaseFragment;
import wrightstuff.wowscrubber.ui.MainGuildActivity;
import wrightstuff.wowscrubber.ui.guild.GuildAdapter;

public class UserFragment extends BaseFragment implements UserContract.View {
    private static final String TAG = UserFragment.class.getCanonicalName();

    private UserContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private UserFeedAdapter mAdapter;

    private News newsItem;

    private TextView tvUserName, tvRace, tvClass, tvLevel, tvLOnline;
    private ImageView mProfilePicture;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new UserPresenter(getContext());
    }

    private void updateFragmentData(@NonNull final News newsItem) {
        this.newsItem = newsItem;
        mPresenter.refreshUserDetails(newsItem);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_user, container, false);
        mLoadingView = view.findViewById(R.id.loading_progress);
        mContentView = view.findViewById(R.id.content_frame);

        tvUserName = (TextView) view.findViewById(R.id.tv_username);
        tvClass = (TextView) view.findViewById(R.id.tv_class);
        tvLevel = (TextView) view.findViewById(R.id.tv_level);
        tvRace = (TextView) view.findViewById(R.id.tv_race);
        tvLOnline = (TextView) view.findViewById(R.id.tv_last_online);
        mProfilePicture = (ImageView) view.findViewById(R.id.iv_profile_pic);


        mLayoutManager = new LinearLayoutManager(getContext());

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_userFeed);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new UserFeedAdapter();
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.bind(this);

        getBundleData();
    }

    private void getBundleData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String myString = bundle.getString(MainGuildActivity.ITEM_NEWS_BROADCAST_EVENT);
            if (myString != null) {
                Gson gson = new Gson();
                News userNews = gson.fromJson(myString, News.class);
                updateFragmentData(userNews);
            } else {
                showMessage(R.string.text_unknown_error);
                Log.d(TAG, "getBundleData() - bundle string is null");
            }
        } else {
            showMessage(R.string.text_unknown_error);
            Log.d(TAG, "getBundleData() - bundle is null");
        }
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


    @Override
    public void updateUserNewsView(final User userDetails, final News news) {
        tvUserName.setText(userDetails.getName());
        tvClass.setText(userDetails.getClassTalentTypeString());
        tvRace.setText(userDetails.getGenderAsString() + " " + userDetails.getRaceAsString());
        tvLevel.setText(Html.fromHtml("level: " + userDetails.getLevel().toString() + "<br/>ilvl: " + userDetails.getItems().getStringAverageItemLevelEquipped()));
        tvLOnline.setText(Html.fromHtml(userDetails.getLastOnline(news.getTimestamp())));
        mAdapter.updateUserFeed(userDetails);
    }


    @Override
    public void setUserNewsPicture(String url) {
        mProfilePicture.setImageResource(R.drawable.progress_animation);
        Picasso.with(getContext()).load(url).error(R.drawable.error).fit().into(mProfilePicture);
    }

}
