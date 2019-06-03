package com.example.lenovo.navigationex;

public class Uploadimagescomplain {
    private String mName;
    private String mImageUrl;

    public Uploadimagescomplain() {
        //empty constructor needed
    }

    public Uploadimagescomplain(String name, String imageUrl) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}