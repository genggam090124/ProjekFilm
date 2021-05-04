package com.genggam.projekfilm;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoResponse {
    @SerializedName("Response")
    private String response;
    @SerializedName("totalResults")
    private String totalResults;
    @SerializedName("Search")
    private List<SearchItem> search;

    public String getResponse(){
        return response;
    }

    public void setTotalResults(String totalResults){
        this.totalResults = totalResults;
    }

    public String getTotalResults(){
        return totalResults;
    }

    public void setSearch(List<SearchItem> search){
        this.search = search;
    }

    public List<SearchItem> getSearch(){
        return search;
    }
}
