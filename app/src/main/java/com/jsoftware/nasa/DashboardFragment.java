package com.jsoftware.nasa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class DashboardFragment extends Fragment {

    private Button button, btn2;
    TextView regText, trainText;

    VideoView videoView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard, container,false);

        regText = v.findViewById(R.id.regCardTxt3);
        regText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TicketsDates.class);
                startActivity(intent);
            }
        });

        trainText = v.findViewById(R.id.TrainingCardTxtiii);
        trainText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PaymentActivity.class);
                startActivity(intent);
            }
        });


        videoView2 = v.findViewById(R.id.videoView5);
        String videoPath2 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.nasa2;
        Uri uri = Uri.parse(videoPath2);
        videoView2.setVideoURI(uri);

        MediaController mediaController2 = new MediaController(getContext());
        videoView2.setMediaController(mediaController2);
        mediaController2.setAnchorView(videoView2);

        videoView2.start();

        btn2 = v.findViewById(R.id.visualizationbtn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getActivity(), PreviewActivity.class);
                startActivity(intent2);

            }
        });

        button = v.findViewById(R.id.getTicketButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PaymentActivity.class);
                startActivity(intent);
            }
        });

        return v;

    }

}
