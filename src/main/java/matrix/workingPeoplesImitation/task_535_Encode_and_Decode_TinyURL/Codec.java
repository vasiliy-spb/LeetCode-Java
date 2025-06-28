package matrix.workingPeoplesImitation.task_535_Encode_and_Decode_TinyURL;

import java.util.HashMap;
import java.util.Map;

// my solution
public class Codec {
    Map<Integer, String> hash = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String[] parts = longUrl.split("(?<=\\w)\\/", 2);
        hash.put(parts[1].hashCode(), longUrl);
        return parts[0] + "/" + parts[1].hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] parts = shortUrl.split("(?<=\\w)\\/", 2);
        return hash.get(Integer.valueOf(parts[1]));
    }

    public static void main(String[] args) {
        String s = "https://leetcode.com/problems/design-tinyurl";
        String[] parts = s.split("(?<=\\w)\\/", 2); // ["https://leetcode.com", "problems/design-tinyurl"]
        for (String st : parts)
            System.out.println(st);
    }
}