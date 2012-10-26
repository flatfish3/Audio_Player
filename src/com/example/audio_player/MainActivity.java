package com.example.audio_player;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener{

	MediaPlayer bgm = null;
	ToggleButton tbtn = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bgm = MediaPlayer.create(this, R.raw.cat);
        
        tbtn = (ToggleButton)findViewById(R.id.toggleButton1);
        tbtn.setOnClickListener(this);        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(tbtn.isChecked()){
			bgm.seekTo(0);
			bgm.start();
		}
		else{
			bgm.pause();
		}
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		bgm.stop();
		bgm.release();
	}
}
