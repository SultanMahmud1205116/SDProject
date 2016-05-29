package com.example.sultanmahmud.databasedemoversionone.model;

/**
 * Created by sultanmahmud on 5/15/16.
 */
public class Asset implements java.io.Serializable {
    long assetID;
    String assetName;
    String assetCategory;
    String assetDescription;
    long assetvalue;
    public long getAssetID() {
        return assetID;
    }
    public void setAssetID(long assetID) {
        this.assetID = assetID;
    }
    public String getAssetName() {
        return assetName;
    }
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public long getAssetvalue() {
        return assetvalue;
    }
    public void setAssetvalue(long assetvalue) {
        this.assetvalue = assetvalue;
    }
    public String getAssetCategory() {
        return assetCategory;
    }
    public void setAssetCategory(String assetCategory) {
        this.assetCategory = assetCategory;
    }
    public String getAssetDescription() {
        return assetDescription;
    }
    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    public Asset(String assetName, String assetCategory, int assetvalue) {
        super();
        this.assetName = assetName;
        this.assetCategory = assetCategory;
        this.assetvalue = assetvalue;
    }

    @Override
    public String toString() {
        return "Asset [assetName=" + assetName + ", assetCategory=" + assetCategory + ", assetvalue=" + assetvalue
                + "]";
    }

}
