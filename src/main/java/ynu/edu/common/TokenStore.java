package ynu.edu.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenStore {
    private static final Map<String, String> tokenMap = new ConcurrentHashMap<>();

    public static void put(String token, String userId) {
        tokenMap.put(token, userId);
    }

    public static String getUserId(String token) {
        return tokenMap.get(token);
    }

    public static boolean contains(String token) {
        return tokenMap.containsKey(token);
    }

    public static void remove(String token) {
        tokenMap.remove(token);
    }
}