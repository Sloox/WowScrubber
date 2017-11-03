package wrightstuff.wowscrubber.api;

import android.content.Context;
import android.support.annotation.NonNull;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import wrightstuff.wowscrubber.R;

/**
 * Created by michaelwright on 01/08/2017.
 */

public abstract class BaseService {
    protected Retrofit mRetrofit;


    public BaseService(@NonNull final Context context, ServiceType type) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(10000);
        dispatcher.setMaxRequestsPerHost(1000);
        OkHttpClient client = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .addInterceptor(logging)
                .build();

        String baseUrl;
        switch (type) {
            case EU_BASE:
                baseUrl = context.getString(R.string.eu_base);
                break;
            case EU_PICTURES:
                baseUrl = context.getString(R.string.eu_picture_base);
                break;
            default:
                baseUrl = context.getString(R.string.eu_base);
        }

        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    protected enum ServiceType {US_BASE, EU_BASE, EU_PICTURES}

}
