package com.mcardenas.parstagram;

import com.parse.ParseObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Item_post {
    public String Username= "";
    public String Description;
    public String imageUrl;

    public static Item_post fromParseObject(ParseObject object){
        Item_post post= new Item_post();

        post.Description= object.get("description").toString();
        post.imageUrl= object.getParseFile("image").getUrl();

        return post;
    }

    public static List<Item_post> fromParseArray(List<ParseObject> objects){
        List<Item_post> posts= new ArrayList<>();

        for (ParseObject result : objects) {
            posts.add(fromParseObject(result));
        }

        return  posts;
    }


}
