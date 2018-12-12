package com.media.doopy.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.media.doopy.CoreData.Recipe.Hits;
import com.media.doopy.CoreData.Recipe.Recipe;
import com.media.doopy.R;

import java.util.Objects;

public class RecipeInfo extends AppCompatActivity {

    private AppCompatTextView labelC;

    private AppCompatTextView ingredientesC;

    private AppCompatTextView caloriasC;

    private  AppCompatTextView pesoTatalC;

    private ImageView topImage;

    public RequestOptions options;

    public static final String KEY_LABEL = "LABEL";

    public static final String KEY_INGRE = "INGRE";

    public static final String KEY_CALO = "CALO";

    public static final String KEY_PESO_TOT = "PESO_TOT";

    public static final String KEY_IMAGE = "IMAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.image)
                .error(R.drawable.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);

        labelC = findViewById(R.id.labelC);

        ingredientesC = findViewById(R.id.ingredientesC);

        caloriasC = findViewById(R.id.caloriasC);

        pesoTatalC = findViewById(R.id.pesoTatalC);

        topImage = findViewById(R.id.topImage);

        if (getIntent().hasExtra(KEY_LABEL))
            labelC.setText(getIntent().getStringExtra(KEY_LABEL));

        if (getIntent().hasExtra(KEY_INGRE))
            ingredientesC.setText(getIntent().getStringExtra(KEY_INGRE));

        if (getIntent().hasExtra(KEY_CALO))
            caloriasC.setText(getIntent().getStringExtra(KEY_CALO));

        if (getIntent().hasExtra(KEY_PESO_TOT))
            pesoTatalC.setText(getIntent().getStringExtra(KEY_PESO_TOT));

        if (getIntent().hasExtra(KEY_IMAGE))
            Glide.with(this)
                    .load(getIntent().getStringExtra(KEY_IMAGE))
                    .thumbnail(0.1f)
                    .apply(options)
                    .into(topImage);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:

                onBackPressed();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
