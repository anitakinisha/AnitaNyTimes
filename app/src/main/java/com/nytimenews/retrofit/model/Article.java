package com.nytimenews.retrofit.model;

import android.os.Parcelable;
import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class Article implements Parcelable{

    @SerializedName("id")
    private double id;
    @SerializedName("title")
    private String title;
    @SerializedName("byline")
    private String byline;
    @SerializedName("source")
    private String source;
    @SerializedName("published_date")
    private String publishdate;
    @SerializedName("section")
    private String section;
    @SerializedName("type")
    private String type;
    @SerializedName("abstract")
    private String abstractd;
    @SerializedName("views")
    private int views;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flag){
        dest.writeDouble(id);
        dest.writeString(title);
        dest.writeString(byline);
        dest.writeString(publishdate);
        dest.writeString(source);
        dest.writeString(section);
        dest.writeString(type);
        dest.writeString(abstractd);
        dest.writeInt(views);
    }
    public Article(Parcel in) {
        id = in.readInt();
        title = in.readString();
        byline=in.readString();
        publishdate=in.readString();
        source=in.readString();
        section=in.readString();
        type=in.readString();
        abstractd=in.readString();
        views=in.readInt();
    }

    // This is to de-serialize the object
    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>(){
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public Article( double id, String title, String byLine,String source, String publishdate,String section, String type,String abstractd, int views){

        this.id = id;
        this.title = title;
        this.byline = byLine;
        this.byline = source;
        this.publishdate = publishdate;
        this.section = section;
        this.type = type;
        this.abstractd = abstractd;
        this.views = views;
    }

    public double getId() {
        return id;
    }

    public void setTitle(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getByLine() {
        return byline;
    }

    public void setByLine(String brief) {
        this.byline = byline;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPublishDate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }


    public String getSection() {
        return title;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbstractd() {
        return abstractd;
    }

    public void setAbstractd(String abstractd) {
        this.abstractd = abstractd;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}

