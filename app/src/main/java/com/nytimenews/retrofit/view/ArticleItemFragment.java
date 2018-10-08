package com.nytimenews.retrofit.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.nytimenews.retrofit.R;
import com.nytimenews.retrofit.model.Article;
import com.nytimenews.retrofit.presenter.MainContract;
import com.nytimenews.retrofit.presenter.MainPresenterImpl;

import java.util.ArrayList;


public class ArticleItemFragment extends Fragment implements MainContract.MainView{

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private static final String TAG_DETAIL_FRAGMENT = "TAG_DETAIL_FRAGMENT";

    private int id;
    private MainContract.presenter presenter;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ArticleItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article_item_list, container, false);

        initializeRecyclerView(view);
        initProgressBar();
        presenter = new MainPresenterImpl(this, new GetArticleIntractorImpl());
        presenter.requestDataFromServer();
        return view;
    }

    /**
     * Initializing RecyclerView
     */
    private void initializeRecyclerView(View v) {


        recyclerView = v.findViewById(R.id.recycler_view_employee_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    /**
     * Initializing progressbar programmatically
     * */
    private void initProgressBar() {
        progressBar = new ProgressBar(getContext(), null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);

        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setGravity(Gravity.CENTER);
        relativeLayout.addView(progressBar);

        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        progressBar.setVisibility(View.INVISIBLE);

        getActivity().addContentView(relativeLayout, params);
    }


    /**
     * RecyclerItem click event listener
     * */
    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(Article article) {

            Bundle articlebundle = new Bundle();
            articlebundle.putParcelable("article", article);

            // insert detail fragment into detail container
            ArticleDetailsFragment detailFragment = new ArticleDetailsFragment();
            detailFragment.setArguments(articlebundle);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.frameContainer, detailFragment, TAG_DETAIL_FRAGMENT)
                    .addToBackStack(TAG_DETAIL_FRAGMENT)
                    .commit();
        }
    };

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void setDataToRecyclerView(ArrayList<Article> articleArrayList) {

        ArticleItemRecyclerViewAdapter adapter = new ArticleItemRecyclerViewAdapter( articleArrayList, recyclerItemClickListener);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getContext(),
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
