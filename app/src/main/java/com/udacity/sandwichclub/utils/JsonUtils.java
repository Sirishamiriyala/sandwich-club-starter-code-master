package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject sandwichJSONObject = new JSONObject(json);
            JSONObject jsonObject=sandwichJSONObject.getJSONObject("name");
            String mainName=jsonObject.getString("mainName");
            JSONArray array =jsonObject.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAs =new ArrayList<>();
                            for (int i = 0; i < array.length(); i++) {
                    alsoKnownAs.add(array.getString(i));
                }
            String PlaceOfOrigin=sandwichJSONObject.getString("placeOfOrigin");
            String description=sandwichJSONObject.getString("description");
            String image=sandwichJSONObject.getString("image");
            JSONArray ingredients_array=sandwichJSONObject.getJSONArray("ingredients");
            ArrayList<String> ingredients=new ArrayList<>();
                for (int i = 0; i < ingredients_array.length(); i++) {
                    ingredients.add(ingredients_array.getString(i));
                }
             return new Sandwich(mainName,alsoKnownAs,PlaceOfOrigin,description,image,ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
