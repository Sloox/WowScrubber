package wrightstuff.wowscrubber.ui.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.api.item.ItemRepository;
import wrightstuff.wowscrubber.api.item.ItemRepositoryMVP;
import wrightstuff.wowscrubber.model.item.Item;
import wrightstuff.wowscrubber.model.user.Feed;
import wrightstuff.wowscrubber.model.user.User;


public class UserFeedAdapter extends RecyclerView.Adapter<UserFeedAdapter.ViewHolder> {

    private static final String TAG = UserFeedAdapter.class.getCanonicalName();
    private WeakReference<Context> mWRContext;

    private List<Feed> mUserFeed = new ArrayList<>();

    private ItemRepository itemRepository;


    @Override
    public UserFeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mWRContext = new WeakReference<>(parent.getContext());
        itemRepository = new ItemRepositoryMVP(mWRContext.get());
        return new UserFeedAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_userfeed, parent, false));
    }

    @Override
    public void onBindViewHolder(UserFeedAdapter.ViewHolder holder, int position) {
        String dateTimeText = mUserFeed.get(position).getTimeStampAsDate();
        holder.mInformationTime.setText(dateTimeText);
        holder.mInformationView.setText(mUserFeed.get(position).getType());
        handleUserFeed(holder.mInformationView, mUserFeed.get(position));
    }

    private void handleUserFeed(TextView mInformationView, Feed userFeedItem) {
        switch (userFeedItem.getType()) {
            case "LOOT":
                retrieveUserItem(mInformationView, userFeedItem);
                break;
            case "CRITERIA":
                updateCriteriaItem(mInformationView, userFeedItem);
                break;
            case "BOSSKILL":
                updateBosskillItem(mInformationView, userFeedItem);
                break;
            case "ACHIEVEMENT":
                updateAcheivementItem(mInformationView, userFeedItem);
                break;
            default:
                break;
        }
    }

    private void updateAcheivementItem(TextView mInformationView, Feed userFeedItem) {
        mInformationView.setText(Html.fromHtml(userFeedItem.getAchievement().getTitleColored() + " (" + userFeedItem.getAchievement().getPoints() + "pts)" + " via " + userFeedItem.getAchievement().getDescription()));
    }

    private void updateBosskillItem(TextView mInformationView, Feed userFeedItem) {
        mInformationView.setText(Html.fromHtml(userFeedItem.getAchievement().getTitleBold() + " (" + userFeedItem.getQuantity() + "x)"));
    }

    private void updateCriteriaItem(TextView mInformationView, Feed userFeedItem) {
        mInformationView.setText(Html.fromHtml(userFeedItem.getAchievement().getTitleColored() + " via " + userFeedItem.getAchievement().getDescription()));
    }

    private void retrieveUserItem(TextView mInformationView, Feed userFeedItem) {
        mInformationView.setText(R.string.text_obtained_item);
        if (userFeedItem.hasItem()) {
            styleItemInformation(userFeedItem, mInformationView, userFeedItem.getFeedItem());
        } else {
            itemRepository.retrieveItem(userFeedItem).delaySubscription(1, TimeUnit.SECONDS).subscribe(item -> styleItemInformation(userFeedItem, mInformationView, item), error -> Log.d(TAG, "Failed to get item information - " + error.getMessage()));
        }
    }

    private void styleItemInformation(Feed userFeedItem, TextView mInformationView, Item item) {
        userFeedItem.setFeedItem(item);
        String information = item.getItemNameInWowColor() + " (" + item.getItemLevel() + ")" + item.getItemFromContext();
        mInformationView.setText(Html.fromHtml(information));
    }

    public void updateUserFeed(final User user) {
        mUserFeed = user.getFeed();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mUserFeed.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mInformationView;
        public TextView mInformationTime;

        public ViewHolder(View root) {
            super(root);
            mInformationView = (TextView) root.findViewById(R.id.tv_info);
            mInformationTime = (TextView) root.findViewById(R.id.tv_date);
        }
    }
}
