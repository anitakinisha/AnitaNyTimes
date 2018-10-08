package com.nytimenews.retrofit.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

;
import com.nytimenews.retrofit.R;
import com.nytimenews.retrofit.model.Article;

public class ArticleDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match


    private int id;
    private TextView txtTitle, txtbyline, txtpublishDate,txtSource,txtSection,txtType,txtView,txtAbstract;
    Article article = null;
    ActionBarDrawerToggle mDrawerToggle;

    private OnFragmentInteractionListener mListener;

    public ArticleDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        article = getArguments().getParcelable("article");
        View view = inflater.inflate(R.layout.fragment_article_details, container, false);
        initWidget(view);
        return view;
    }

    private void initWidget(View view) {

        txtTitle = (TextView) view.findViewById(R.id.txt_title);
        txtbyline = (TextView) view.findViewById(R.id.txt_biline);
        txtSource = (TextView) view.findViewById(R.id.txt_Source);
        txtpublishDate = (TextView) view.findViewById(R.id.txt_publishDate);
        txtSection = (TextView) view.findViewById(R.id.txt_section);
        txtType = (TextView) view.findViewById(R.id.txt_type);
       // txtView = (TextView) view.findViewById(R.id.txt_view);
        txtAbstract = (TextView) view.findViewById(R.id.txt_Abstract);

        txtTitle.setText(article.getTitle());
        txtbyline.setText(article.getByLine());
        txtSource.setText(article.getSource());
        txtpublishDate.setText(article.getPublishDate());
        txtSection.setText(article.getSection());
        txtType.setText(article.getType());
       // txtView.setText((article.getViews()));
        txtAbstract.setText(article.getAbstractd());

    }
        // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
