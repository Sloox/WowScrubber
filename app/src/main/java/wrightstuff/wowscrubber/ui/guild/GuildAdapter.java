package wrightstuff.wowscrubber.ui.guild;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.api.item.ItemRepository;
import wrightstuff.wowscrubber.api.item.ItemRepositoryMVP;
import wrightstuff.wowscrubber.model.guild.GuildNews;
import wrightstuff.wowscrubber.model.guild.News;
import wrightstuff.wowscrubber.model.item.Item;

public class GuildAdapter extends RecyclerView.Adapter<GuildAdapter.ViewHolder> {
    private GuildNews mGuildNews = new GuildNews();
    private List<News> mNews = new ArrayList<>();

    private static final String TAG = GuildAdapter.class.getCanonicalName();

    private WeakReference<Context> mWRContext;
    private ItemRepository itemRepository;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onNewsItemClicked(News userNews);
    }

    public GuildAdapter(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mWRContext = new WeakReference<>(parent.getContext());
        itemRepository = new ItemRepositoryMVP(mWRContext.get());
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guild, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String titleText = "";
        String nameText = "";
        News userNews = null;
        if (mGuildNews != null && mGuildNews.getNews() != null) {
            userNews = mNews.get(position);
            titleText = userNews.getTimeStampAsDate();
            nameText = userNews.getCharacter();
        }
        holder.mInformationTime.setText(titleText);
        holder.mInformationName.setText(nameText);

        updateProfilePicture(holder, userNews);

        if (userNews != null && userNews.isAchievement()) {
            updateUserAchievementNews(holder, userNews);
        } else {
            updateUserItemNews(holder, userNews);
        }

        final News finalUserNews = userNews;
        holder.mClickableView.setOnClickListener(v -> mOnItemClickListener.onNewsItemClicked(finalUserNews));

    }

    private void updateUserAchievementNews(final ViewHolder mViewHolder, final News userNews) {
        mViewHolder.mInformationName.setText(userNews.getCharacter() + userNews.getHowItemWasRetrieved());
        mViewHolder.mInformationItem.setText("[" + userNews.getAchievement().getTitle() + "]");
        mViewHolder.mInformationExtra.setText("via " + userNews.getAchievement().getDescription());
    }

    private void updateUserItemNews(final ViewHolder mViewHolder, final News userNews) {
        if (!userNews.hasItem()) {
            itemRepository.retrieveItem(userNews).delaySubscription(1, TimeUnit.SECONDS).subscribe(item -> styleItemInformation(mViewHolder, item, userNews), error -> Log.d(TAG, "Failed to get item information - " + error.getMessage()));
        } else {
            styleItemInformation(mViewHolder, userNews);
        }

    }

    private void styleItemInformation(final ViewHolder mViewHolder, final Item item, final News userNews) {
        userNews.setNewsItem(item);
        styleItemInformation(mViewHolder, userNews);
    }

    private void styleItemInformation(final ViewHolder mViewHolder, final News userNews) {
        Item item = userNews.getNewsItem();
        String information = userNews.getCharacterColorCoded();
        mViewHolder.mInformationName.setText(information);
        mViewHolder.mInformationItem.setText(Html.fromHtml(userNews.getHowItemWasRetrieved()+item.getItemNameInWowColor()));
        mViewHolder.mInformationExtra.setText(item.getItemLevel() + item.getItemFromContext());
        updateProfilePicture(mViewHolder, userNews);
    }

    private void updateProfilePicture(final ViewHolder mViewHolder, final News userNews) {
        mViewHolder.mItemPicture.setHasTransientState(true);
        mViewHolder.mItemPicture.setImageResource(R.drawable.progress_animation);
        if (userNews.hasItem()) {
            Picasso.with(mWRContext.get()).load(mWRContext.get().getString(R.string.eu_profile_picture_base) + userNews.getNewsItem().getIcon() + ".jpg").error(R.drawable.error).fit().into(mViewHolder.mItemPicture);
        }

    }

    @Override
    public int getItemCount() {
        int size = 0;
        if (mGuildNews != null && !mNews.isEmpty()) {
            size = mNews.size();
        }
        return size;
    }

    public void updateGuildNewsData(GuildNews guildNews) {
        if (guildNews != null && guildNews.getNews() != null) {
            mGuildNews = guildNews;
            mNews = guildNews.getNews();
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mInformationName;
        public TextView mInformationItem;
        public TextView mInformationExtra;
        public TextView mInformationTime;
        public ImageView mItemPicture;

        public View mClickableView;


        public ViewHolder(View root) {
            super(root);
            mInformationName = (TextView) root.findViewById(R.id.tv_name);
            mInformationItem = (TextView) root.findViewById(R.id.tv_item);
            mInformationExtra = (TextView) root.findViewById(R.id.tv_ilvl);
            mInformationTime = (TextView) root.findViewById(R.id.tv_date);
            mItemPicture = (ImageView) root.findViewById(R.id.iv_item_pic);

            mClickableView = root.findViewById(R.id.card_view);
        }
    }


}
