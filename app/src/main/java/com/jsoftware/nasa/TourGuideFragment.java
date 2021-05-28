package com.jsoftware.nasa;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

public class TourGuideFragment extends Fragment {

    private WebView mWebView;
    Button btn;
    ImageButton imageButtonPluto, imageButtonNepune, imageButtonJupiter, imageButtonMars, imageButtonSaturn, imageButtonKuiperbelt,
            imageButtonUranus, imageButtonIss;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tour_guide, container,false);

        imageButtonPluto = v.findViewById(R.id.imageButtonPluto);
        imageButtonNepune = v.findViewById(R.id.imageButtonNeptune);
        imageButtonJupiter = v.findViewById(R.id.imageButtonJupiter);
        imageButtonMars = v.findViewById(R.id.imageButtonMars);
        imageButtonSaturn = v.findViewById(R.id.imageButtonSaturn);
        imageButtonKuiperbelt = v.findViewById(R.id.imageButtonKuiperbelt);
        imageButtonUranus = v.findViewById(R.id.imageButtonUranus);
        imageButtonIss = v.findViewById(R.id.imageButtonIss);

        mWebView = v.findViewById(R.id.mWebView3);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("https://solarsystem.nasa.gov/planets/dwarf-planets/pluto/overview");

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        imageButtonPluto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("https://solarsystem.nasa.gov/planets/dwarf-planets/pluto/overview");

            }
        });

        imageButtonNepune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("https://solarsystem.nasa.gov/planets/neptune/overview/");

            }
        });

        imageButtonJupiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("https://solarsystem.nasa.gov/planets/jupiter/overview/");

            }
        });

        imageButtonMars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("https://solarsystem.nasa.gov/planets/mars/overview/");

            }
        });

        imageButtonSaturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("https://solarsystem.nasa.gov/planets/saturn/overview/");

            }
        });

        imageButtonKuiperbelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("https://solarsystem.nasa.gov/solar-system/kuiper-belt/overview/");

            }
        });

        imageButtonUranus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("https://solarsystem.nasa.gov/planets/uranus/overview/");

            }
        });

        imageButtonIss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("https://solarsystem.nasa.gov/resources/2378/international-space-station-3d-model/");

            }
        });

        return v;
    }
}
