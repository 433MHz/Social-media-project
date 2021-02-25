package pl.krystian.TwiFac.token;

import java.util.HashMap;

class ListOfTokenUser {
	
	static HashMap<String, Integer> list;
	
	static void Add(String token, int id) {
		list.put(token, id);
	}
	
	static boolean isTokeAvailable(String token) {
		if(list.containsKey(token)) return false;
		else return true;
	}
	
	static int getId(String token) {
		return list.get(token);
	}
	
	static HashMap<String, Integer> getList() {
		return list;
	}
}
