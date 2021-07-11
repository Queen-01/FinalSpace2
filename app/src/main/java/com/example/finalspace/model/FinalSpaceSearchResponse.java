
package com.example.finalspace.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FinalSpaceSearchResponse {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("fullUrl")
    @Expose
    private String fullUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FinalSpaceSearchResponse() {
    }

    /**
     * 
     * @param path
     * @param fullUrl
     * @param name
     * @param type
     */
    public FinalSpaceSearchResponse(String type, String name, String path, String fullUrl) {
        super();
        this.type = type;
        this.name = name;
        this.path = path;
        this.fullUrl = fullUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

}
