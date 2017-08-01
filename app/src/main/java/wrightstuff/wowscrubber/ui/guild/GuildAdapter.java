package wrightstuff.wowscrubber.ui.guild;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.model.GuildNews;

/**
 * Created by michaelwright on 01/08/2017.
 */

public class GuildAdapter extends RecyclerView.Adapter<GuildAdapter.ViewHolder> {
    private GuildNews mGuildNews = new GuildNews();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guild, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String titleText = "";
        if (mGuildNews != null && mGuildNews.getNews() != null) {
            titleText = mGuildNews.getNews().get(position).getCharacter() + "       " + mGuildNews.getNews().get(position).getTimeStampAsDate();
        }
        holder.mTitleView.setText(titleText);
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if (mGuildNews != null && mGuildNews.getNews() != null) {
            size = mGuildNews.getNews().size();
        }
        return size;
    }

    public void updateData(GuildNews guildNews) {
        if (guildNews != null) {
            mGuildNews = guildNews;
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitleView;

        public ViewHolder(View root) {
            super(root);
            mTitleView = (TextView) root.findViewById(R.id.tv_title);
        }
    }
}
