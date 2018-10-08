package com.nytimenews.retrofit.presenter;

import com.nytimenews.retrofit.model.Article;

import java.util.ArrayList;



public class MainPresenterImpl implements MainContract.presenter, MainContract.GetArticleIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetArticleIntractor getArticleIntractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetArticleIntractor getArticleIntractor) {
        this.mainView = mainView;
        this.getArticleIntractor = getArticleIntractor;
    }

    @Override
    public void onDestroy() {

        mainView = null;

    }

    @Override
    public void onRefreshButtonClick() {

        if(mainView != null){
            mainView.showProgress();
        }
        getArticleIntractor.getArticleArrayList(this);

    }

    @Override
    public void requestDataFromServer() {
        getArticleIntractor.getArticleArrayList(this);
    }


    @Override
    public void onFinished(ArrayList<Article> articleArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(articleArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
