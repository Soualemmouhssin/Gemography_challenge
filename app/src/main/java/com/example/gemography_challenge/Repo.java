package com.example.gemography_challenge;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class Repo {
    private String title ;
    private String description = null ;
    private int stars = 0 ;
    final static String url  = "https://api.github.com/search/repositories?q=created:>" ;
    final static String label_items ="items";
    final static String label_name= "name";
    final static String label_desc = "description";
    final static String label_owner = "owner";
    final static String label_userName = "full_name";
    final static String label_avatar = "avatar_url";
    final static String label_stars = "stargazers_count";


    void getData(String url) {

    }
    private Repo (String title, String desc,int stars ,  String userName, String avatar_url) {
        this.title = title ;
        this.description = desc ;
        this.stars ;
    }

    Repo[] getReposFromStr (int page ) {
        String jsonString ="";
        try {
              jsonString = Utils.Get_url(url);
        }
        catch (Exception e) { e.printStackTrace();
            Log.d("","exception " + e.toString());
            return null;
        }

        try {
            JSONObject ReposObj = new JSONObject(jsonString);

            JSONArray ReposArray = ReposObj.getJSONArray(label_items);
            if(ReposArray.length() <= 0 ) ;
            Repo repos[] = new Repo[ReposArray.length()];
            for (int i = 0 ; i < ReposArray.length(); i++) {
                JSONObject ReposObject = ReposArray.getJSONObject(i);
                JSONObject OwnerObject = ReposObject.getJSONObject(label_owner) ;
                repos[i] = new Repo(ReposObj.getString(label_name), ReposObj.getString(label_desc),ReposObj.getInt(label_stars),
                            OwnerObject.getString(label_userName),OwnerObject.getString(label_avatar)) ;
            }

        }

        catch (Exception e) { e.printStackTrace();
            Log.d("","exception " + e.toString());}
        return null;
    }





}


}
