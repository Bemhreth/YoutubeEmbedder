package com.EmpowerYouth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class CommentsActivity extends AppCompatActivity {

    TextView commentTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        commentTV = findViewById(R.id.comments_tv);

        final Control control = new Control(this);
//        Log.d("")
        control.comments_list(new VolleyCallback() {
            @Override
            public void onSuccess() {
                String comments = "No Comments";
//                t1.setText(control.model.getViewed());
//                Log.d("MAIN_ACTIVITY:" ,"-->"+control.model.getLikes());
//                t2.setText(control.model.getLikes());
//                Log.d("MAIN_ACTIVITY:" ,"-->"+control.model.getDislikes());
//                t3.setText(control.model.getDislikes());
//                Log.d("MAIN_ACTIVITY:" ,"-->"+control.model.getTitle());
//                t4.setText(control.model.getTitle());
//                t4.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if(descriptionTV.getVisibility() == View.VISIBLE){
//                            descriptionTV.setVisibility(View.GONE);
//                        }
//                        else descriptionTV.setVisibility(View.VISIBLE);
//                    }
//                });
//                descriptionTV.setText(control.model.getDescription());
//                Log.d("COMMENTS_ACTIVITY:" ,"-->"+control.commentsList.size());
//                Toast.makeText(CommentsActivity.this, "--"+control.commentsList.get(1).getComment(), Toast.LENGTH_SHORT).show();
                if(control.commentsList.size() > 0) comments = "";
                for (int i = 0;i < control.commentsList.size();i++){
//                    Log.d("COMMENTS_ACTIVITY", "IN "+i);
                     comments += control.commentsList.get(i).getAuthor() + " - " + control.commentsList.get(i).getComment() + "\n\n";
                }

                commentTV.setText(comments);
            }

            @Override
            public void onError(TYPE type, Map<String, String> errorList) {
                Log.d("MAIN_ACTIVITY", "ERROR ON VOLLEY REQUEST: " + type.name());
            }
        });
    }
}
