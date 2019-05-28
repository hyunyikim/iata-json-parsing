package kr.co.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface IataService {
	
	JSONArray selectKRIataList() throws Exception;
	JSONObject selectOneIata(String icao) throws Exception;

}
