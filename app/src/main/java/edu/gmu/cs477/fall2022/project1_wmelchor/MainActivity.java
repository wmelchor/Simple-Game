package edu.gmu.cs477.fall2022.project1_wmelchor;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button ThreeByThreeGame;
    Button FourByFourGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intentThreeByThree = new Intent(this, ThreeByThree.class);
        ThreeByThreeGame = (Button) findViewById(R.id.ThreeByThreeButton);
        ThreeByThreeGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someActivityResultLauncher.launch(intentThreeByThree);
            }
        });
        Intent intentFourByFour = new Intent(this, FourByFour.class);
        FourByFourGame = (Button) findViewById(R.id.FourByFourButton);
        FourByFourGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someActivityResultLauncher.launch(intentFourByFour);
            }
        });
    }

    ActivityResultLauncher<Intent>
            someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result)
                {
                    if (result.getResultCode() ==
                            Activity.RESULT_OK) {
                        Intent data = result.getData();
                    }
                }
            });
}