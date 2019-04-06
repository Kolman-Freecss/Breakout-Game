package com.ragnarok.util;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.ragnarok.model.Tile;

/**
 * Class that have methods to load the map from json file.
 */
public class ParserMap
{

	public static Json parserJSON;

	/*
	 * Initialize of parser in static context after the ParserMap class loads.
	 */
	static
	{
		parserJSON = new Json();
	}

	/**
	 * @param level number of map to search with pattern Map_{level}.json
	 */
	public List<Tile> parseMap(int level)
	{
		List<Tile> mapLoaded = new ArrayList<Tile>();

		// parserJSON.fromJson(Tile.class, new FileHandle("Map_1.json"));
		@SuppressWarnings("unchecked")
		ArrayList<JsonValue> auxList = parserJSON.fromJson(ArrayList.class, Gdx.files.internal("Map_1.json"));
		
		for(JsonValue value : auxList)
			mapLoaded.add(parserJSON.readValue(Tile.class, value)); 

		return mapLoaded;
	}

}
