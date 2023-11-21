package com.example.newsxpress;

import com.example.newsxpress.Models.NewsHeadllines;

import java.util.List;

public interface  OnFetchDataListener {
    void onFetchData(List<NewsHeadllines> list,String message);
    void onError(String message);
}
