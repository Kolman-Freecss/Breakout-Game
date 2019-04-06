package com.ragnarok.controller;

import com.ragnarok.util.ParserMap;

/**
 * Singleton pattern.
 */
public class MapController
{

	private int mapLevel;
	private static MapController mapController;
	private static ParserMap parserMap;

	public static MapController getMapController()
	{
		if (mapController == null)
		{
			mapController = new MapController();
			parserMap = new ParserMap();
		}

		return mapController;
	}

	private MapController()
	{
	}

	public int getMapLevel()
	{
		return mapLevel;
	}

	public void setMapLevel(int mapLevel)
	{
		this.mapLevel = mapLevel;
	}

	public static void setMapController(MapController mapController)
	{
		MapController.mapController = mapController;
	}

	public ParserMap getParserMap()
	{
		return parserMap;
	}
}
