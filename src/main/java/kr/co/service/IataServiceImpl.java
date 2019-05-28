package kr.co.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service("iataService")
public class IataServiceImpl implements IataService {

	@Override
	public JSONArray selectKRIataList() throws Exception {

		JSONArray jsonArr = readJsonFromUrl("https://raw.githubusercontent.com/mwgg/Airports/master/airports.json");
		return jsonArr;
	}

	
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	

	public static JSONArray readJsonFromUrl(String url) throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		InputStream is = new URL(url).openStream();

		try {
			// 버퍼로 데이터 읽어오기
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);

			// Object로 parse
			Object obj = parser.parse(jsonText);

			// Object 객체를 HashMap으로 변환 후 JSONArray에 담기
			HashMap<String, Object> map = (HashMap<String, Object>) obj; 
			Set set = map.keySet();
			Iterator iterator = set.iterator();

			JSONArray jsonArr = new JSONArray();

			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				HashMap<String, Object> val = (HashMap<String, Object>) map.get(key);

				if (val.get("country").equals("KR")) {
					HashMap<String, Object> tempMap = new HashMap<String, Object>();
					tempMap.put(key, val);

					JSONObject tempObj = new JSONObject();
					tempObj.put(key, val);
					
					jsonArr.add(tempObj);
				}

			}
			// System.out.println("jsonArr : " + jsonArr);
			
			return jsonArr;
			
		} finally {
			is.close();
		}
	}

	
	@Override
	public JSONObject selectOneIata() throws Exception {
		return null;
	}

}
