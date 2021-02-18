package pl.krystian.TwiFac.Token;

import java.util.HashMap;

class ListOfTokenUser {
	
	static HashMap<String, Integer> list;
	
	static void Add(String token, int id) {
		list.put(token, id);
	}
	
	static boolean IsTokeAvailable(String token) {
		if(list.containsKey(token)) return false;
		else return true;
	}
	
	static int GetId(String token) {
		return list.get(token);
	}
}
