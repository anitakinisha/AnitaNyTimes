package com.nytimenews.retrofit.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import com.nytimenews.retrofit.R;
import com.nytimenews.retrofit.model.Article;

public class articleDetails extends AppCompatActivity {

    private int id;
    private TextView txtTitle, txtbyline, txtpublishDate,txtSource,txtSection,txtType,txtView,txtAbstract;
    Article article = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        Intent mIntent = getIntent();
        article = mIntent.getParcelableExtra("article");
//        initializeToolbarAndRecyclerView();
        initWidget();
    }
    /**
     * Initializing Toolbar and RecyclerView
     */
    private void initWidget() {

        txtTitle =  (TextView)findViewById(R.id.txt_title);
        txtbyline =  (TextView)findViewById(R.id.txt_biline);
        txtSource = (TextView)findViewById(R.id.txt_Source);
        txtpublishDate =  (TextView)findViewById(R.id.txt_publishDate);
        txtSection =  (TextView)findViewById(R.id.txt_section);
        txtType =  (TextView)findViewById(R.id.txt_type);
        txtView = (TextView)findViewById(R.id.txt_view);
        txtAbstract =  (TextView)findViewById(R.id.txt_Abstract);

        txtTitle.setText(article.getTitle());
        txtbyline.setText(article.getByLine());
        txtSource.setText(article.getSource());
        txtpublishDate.setText(article.getPublishDate());
        txtSection.setText(article.getSection());
        txtType.setText(article.getType());
        txtView.setText(article.getViews());
        txtAbstract.setText(article.getAbstractd());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_refresh) {
//            presenter.onRefreshButtonClick();
//        }

        return super.onOptionsItemSelected(item);
    }

}
