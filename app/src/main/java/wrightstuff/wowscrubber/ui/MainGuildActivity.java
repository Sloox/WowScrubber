package wrightstuff.wowscrubber.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import wrightstuff.wowscrubber.R;
import wrightstuff.wowscrubber.ui.guild.GuildFragment;
import wrightstuff.wowscrubber.ui.user.UserFragment;


public class MainGuildActivity extends BaseActivity {
    public static final String TAG = MainGuildActivity.class.getCanonicalName();
    //fragment broadcast events
    public static final String ITEM_NEWS_BROADCAST_EVENT = "ITEM_NEWS_BROADCAST_EVENT";
    public static final String ITEM_NEWS_BROADCAST_MESSAGE = "ITEM_NEWS_BROADCAST_MESSAGE";

    private BroadcastReceiver guildNewsFragmentReciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra(ITEM_NEWS_BROADCAST_MESSAGE);
            Log.d(TAG, "Recieved news from local BroadcastReciever");
            UserFragment userFragment = new UserFragment();
            Bundle args = new Bundle();
            args.putString(ITEM_NEWS_BROADCAST_EVENT, message);
            userFragment.setArguments(args);
            replaceFragment(userFragment, true);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new GuildFragment(), false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(guildNewsFragmentReciever, new IntentFilter(ITEM_NEWS_BROADCAST_EVENT));
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(guildNewsFragmentReciever);
    }
}
