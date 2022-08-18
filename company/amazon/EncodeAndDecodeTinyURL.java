package arrays;
//TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
//and it returns a short URL such as http://tinyurl.com/4e9iAk.
//
//Design the encode and decode methods for the TinyURL service. There is no restriction on how your 
//encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL 
//and the tiny URL can be decoded to the original URL.

import java.util.HashMap;

public class EncodeAndDecodeTinyURL {


    public static void main(String[] args) {
        Code code = new Code();
        String check = code.encode("https://test.com/whythisone");
        String check1 = code.encode("https://test.com/whythistwo");
        String check2 = code.encode("https://test.com/whythisthree");
    }
}

class Code {
    HashMap<String, String> map = new HashMap<String, String>();
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int count = 1;

    public String getKey() {
        int c = count;
        StringBuilder sb = new StringBuilder();
        while (c > 0) {
            c--;
            sb.append(chars.charAt(c % 62));
            c /= 62;
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = getKey();
        map.put(key, longUrl);
        count++;
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}
