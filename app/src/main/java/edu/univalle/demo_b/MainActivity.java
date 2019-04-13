package edu.univalle.demo_b;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    VideoView vvVideo;
    TextView tvTitleCurrentVideo;
    MediaController mediaController;
    View itemMovie1, itemMovie2, itemMovie3, itemMovie4;
    View itemSeries1, itemSeries2, itemSeries3, itemSeries4;
    View itemComic1, itemComic2, itemComic3, itemComic4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vvVideo = findViewById(R.id.vvVideo);
        tvTitleCurrentVideo = findViewById(R.id.tvTitleCurrentVideo);
        mediaController = new MediaController(this);
        vvVideo.setMediaController(mediaController);

        // Movies
        itemMovie1 = findViewById(R.id.itemMovie1);
        itemMovie2 = findViewById(R.id.itemMovie2);
        itemMovie3 = findViewById(R.id.itemMovie3);
        itemMovie4 = findViewById(R.id.itemMovie4);

        // Series
        itemSeries1 = findViewById(R.id.itemSeries1);
        itemSeries2 = findViewById(R.id.itemSeries2);
        itemSeries3 = findViewById(R.id.itemSeries3);
        itemSeries4 = findViewById(R.id.itemSeries4);

        // Comics
        itemComic1 = findViewById(R.id.itemComic1);
        itemComic2 = findViewById(R.id.itemComic2);
        itemComic3 = findViewById(R.id.itemComic3);
        itemComic4 = findViewById(R.id.itemComic4);


        // Complentando infomacion de "Movies"

        ImageView ivMovie1 = itemMovie1.findViewById(R.id.ivImage);
        TextView tvTitle1 = itemMovie1.findViewById(R.id.tvTitle);
        TextView tvSubtitle1 = itemMovie1.findViewById(R.id.tvSubTitle);
        Glide.with(this).load("https://cdn140.picsart.com/259006439027202.png?c256x256").into(ivMovie1);
        tvTitle1.setText("Civil War");
        tvSubtitle1.setText("Civil War");
        itemMovie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVideo("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4", "Civil War");
            }
        });


        ImageView ivMovie2 = itemMovie2.findViewById(R.id.ivImage);
        TextView tvTitle2 = itemMovie2.findViewById(R.id.tvTitle);
        TextView tvSubtitle2 = itemMovie2.findViewById(R.id.tvSubTitle);
        Glide.with(this).load("https://cdnvos.lavoz.com.ar/sites/default/files/styles/box_128/public/nota_periodistica/avengers_7.jpg").into(ivMovie2);
        tvTitle2.setText("Avengers");
        tvSubtitle2.setText("Avengers");
        itemMovie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVideo("http://clips.vorwaerts-gmbh.de/VfE_html5.mp4", "Avengers");
            }
        });

        ImageView ivMovie3 = itemMovie3.findViewById(R.id.ivImage);
        TextView tvTitle3 = itemMovie3.findViewById(R.id.tvTitle);
        TextView tvSubtitle3 = itemMovie3.findViewById(R.id.tvSubTitle);
        Glide.with(this).load("https://a.wattpad.com/useravatar/vedhavishnu11.256.960680.jpg").into(ivMovie3);
        tvTitle3.setText("Justice Leage");
        tvSubtitle3.setText("Justice Leage");
        itemMovie3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVideo("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4", "Justice League");
            }
        });

        ImageView ivMovie4 = itemMovie4.findViewById(R.id.ivImage);
        TextView tvTitle4 = itemMovie4.findViewById(R.id.tvTitle);
        TextView tvSubtitle4 = itemMovie4.findViewById(R.id.tvSubTitle);
        Glide.with(this).load("https://m.media-amazon.com/images/I/61LlPldlDkL._AA256_.jpg").into(ivMovie4);
        tvTitle4.setText("Infinity War");
        tvSubtitle4.setText("Infinity War");
        itemMovie4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVideo("https://stream76.uqload.com/3rfkq2z5ejw2q4drdjw7hm5olvvqy37te6cu3rwn6esbv7zi4chiwtomi65a/v.mp4", "Infinity War");
            }
        });
        // TODO: Completar para la informacion (Imagen, titulo, subtitulo) de Series y Comics
    }

    private void setVideo(String url, String title) {
        if (vvVideo.isPlaying()) {
            vvVideo.stopPlayback();
        }
        vvVideo.setVideoPath(url);
        tvTitleCurrentVideo.setText(title);
        vvVideo.start();
        vvVideo.post(new Runnable() {
            @Override
            public void run() {
                mediaController.setAnchorView(vvVideo);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        vvVideo.post(new Runnable() {
            @Override
            public void run() {
                mediaController.setAnchorView(vvVideo);
            }
        });
    }
}
