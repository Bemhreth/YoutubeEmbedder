package com.EmpowerYouth;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
//import com.google.android.youtube.player.YouTubeBaseActivity;
//import com.google.android.youtube.player.YouTubePlayer.*;
//import com.google.android.youtube.player.YouTubePlayer;
//import com.google.android.youtube.player.YouTubeInitializationResult;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Map;
//import org.jetbrains.annotations.NotNull;
//import com.google.android.youtube.player.YouTubePlayerView;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;


public class MainActivity extends AppCompatActivity implements ListBlankFragment.OnFragmentInteractionListener {

    private YouTubePlayerView playerView;
    private static final String TAG = "IFramePreview";
    Control control1 = new Control(this);

    /** Fullscreen functionality **/

    private boolean fullscreenEnabled = true;

    ImageView I1;
    ImageView I2;
    ImageView I3;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView descriptionTV;
    YouTubePlayerView youTubePlayerView;
    Control control;
    Button commentsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        I2 = findViewById(R.id.imageView6);
        I1 = findViewById(R.id.imageView5);
        I3 = findViewById(R.id.imageView7);
        t1 = findViewById(R.id.textView5);
        t2 = findViewById(R.id.textView6);
        t3 = findViewById(R.id.textView7);
        t4 = findViewById(R.id.textView);
        descriptionTV = findViewById(R.id.description_tv);
        control = new Control(this);
        commentsButton = findViewById(R.id.comments_button);
        commentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CommentsActivity.class);
                startActivity(intent);

            }
        });

        //control.setContext2(this);


        control.maincontrol(new VolleyCallback() {
            @Override
            public void onSuccess() {
                t1.setText(control.model.getViewed());
                Log.d("this_is_unuque_because:" ,"-->"+control.model.getLikes());
                t2.setText(control.model.getLikes());
                Log.d("this_is_unuque_because:" ,"-->"+control.model.getDislikes());
                t3.setText(control.model.getDislikes());
                Log.d("this_is_unuque_because:" ,"-->"+control.model.getTitle());
                t4.setText(control.model.getTitle());
                Log.d("this_is_unuque_because:" ,"-->"+control.model.getDescription());
            }

            @Override
            public void onError(TYPE type, Map<String, String> errorList) {

            }
        });
        //control.maincontrol();
        getLifecycle().addObserver(youTubePlayerView);
        //view();
        youTubePlayerView.addYouTubePlayerListener(new YouTubePlayerListener() {
            public void onApiChange(YouTubePlayer youTubePlayer) {

            }

            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
//                youTubePlayer.loadVideo(YoutubeConfig.getLink(), 0);

            }
            @Override
            public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState playerState) {


            }

            @Override
            public void onPlaybackQualityChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackQuality playbackQuality) {

            }

            @Override
            public void onPlaybackRateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackRate playbackRate) {

            }

            @Override
            public void onError(YouTubePlayer youTubePlayer, PlayerConstants.PlayerError playerError) {

            }

            @Override
            public void onCurrentSecond(YouTubePlayer youTubePlayer, float v) {

            }

            @Override
            public void onVideoDuration(YouTubePlayer youTubePlayer, float v) {

            }

            @Override
            public void onVideoLoadedFraction(YouTubePlayer youTubePlayer, float v) {

            }

            @Override
            public void onVideoId(YouTubePlayer youTubePlayer, String s) {

            }

//
        });
        playVideo(YoutubeConfig.getLink());

        displayFragment(YoutubeConfig.getLink());



    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (!fullscreenEnabled) {
                if (playerView != null) {
                    playerView.toggleFullScreen();
                }
            }
        } else {
            if (fullscreenEnabled) {
                if (playerView != null) {
                    playerView.toggleFullScreen();
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "it is getting destroyed", Toast.LENGTH_LONG).show();
        // moreVideosRecycler = null;
        // moreVideoAdapter = null;
    }

    public void displayFragment(String videoLink){
        ListBlankFragment listBlankFragment = ListBlankFragment.newInstance(videoLink);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.youtubeListContainer, listBlankFragment)
                .addToBackStack(null)
                .commit();

    }

    public void onItemClickListener(String videoLink){
        YoutubeConfig.setLink(videoLink);
        playVideo(videoLink);
    }

    public void playVideo(final String videoLink){
        youTubePlayerView.getYouTubePlayerWhenReady(new YouTubePlayerCallback() {
            @Override
            public void onYouTubePlayer(YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(videoLink, 0);
                displayFragment(videoLink);

            }
        });

        control.maincontrol(new VolleyCallback() {
            @Override
            public void onSuccess() {
                t1.setText(control.model.getViewed());
//                Log.d("MAIN_ACTIVITY:" ,"-->"+control.model.getLikes());
                t2.setText(control.model.getLikes());
//                Log.d("MAIN_ACTIVITY:" ,"-->"+control.model.getDislikes());
                t3.setText(control.model.getDislikes());
//                Log.d("MAIN_ACTIVITY:" ,"-->"+control.model.getTitle());
                t4.setText(control.model.getTitle());
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(descriptionTV.getVisibility() == View.VISIBLE){
                            descriptionTV.setVisibility(View.GONE);
                        }
                        else descriptionTV.setVisibility(View.VISIBLE);
                    }
                });
                descriptionTV.setText(control.model.getDescription());
//                Log.d("MAIN_ACTIVITY:" ,"-->"+control.model.getDescription());
            }

            @Override
            public void onError(TYPE type, Map<String, String> errorList) {
                Log.d("MAIN_ACTIVITY", "ERROR ON VOLLEY REQUEST: " + type.name());
            }
        });
    }
}


