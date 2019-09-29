package com.example.android.sunburntest;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CardViewHolder> {
    private final String userCountryCode;
    private List<Site> webSites;

    public RecyclerViewAdapter(List<Site> webSites, String userCountryCode) {
        this.webSites = webSites;
        this.userCountryCode = userCountryCode;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.cardName.setText(webSites.get(position).getName());
        if (webSites.get(position).getAllowedCountries() != null) {
            if (webSites.get(position).getAllowedCountries().contains(userCountryCode))
                holder.cardWebView.loadUrl(webSites.get(position).getWebAddress());
            else
                holder.cardWebView.loadDataWithBaseURL("file:///android_asset/", "<img src='ops.jpg' />", "text/html", "utf-8", null);

        } else {
            holder.cardWebView.loadUrl(webSites.get(position).getWebAddress());

        }
    }

    @Override
    public int getItemCount() {
        return webSites.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        TextView cardName;
        WebView cardWebView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_view);
            cardName = itemView.findViewById(R.id.card_name_tv);
            cardWebView = itemView.findViewById(R.id.card_web_view);
            cardWebView.getSettings().setJavaScriptEnabled(true);
            cardWebView.setInitialScale(1);
            cardWebView.getSettings().setLoadWithOverviewMode(true);
            cardWebView.getSettings().setUseWideViewPort(true);
            cardWebView.setWebViewClient(new MyWebViewClient());
        }
    }

}


