package example1;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Andrey Ledovskikh
 */
public class Codec {

    //"https://leetcode.com/problems/design-tinyurl"
    private final String pattern = "(.)+://(.)+\\.(.){2,3}/";

    public String encode(String longUrl) {

        var encodeString = longUrl.replaceAll(pattern, "");
        if (encodeString.isEmpty() || encodeString.isBlank()) {
            return longUrl;
        }

        Matcher matcher = Pattern.compile(pattern).matcher(longUrl);
        matcher.find();
        var baseUrl = matcher.group(0);

        encodeString = Base64.getEncoder().encodeToString(encodeString.getBytes(StandardCharsets.UTF_8));

        return baseUrl+encodeString;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        var decodeString = shortUrl.replaceAll(pattern, "");
        if (decodeString.isEmpty() || decodeString.isBlank()) {
            return shortUrl;
        }

        Matcher matcher = Pattern.compile(pattern).matcher(shortUrl);
        matcher.find();
        var baseUrl = matcher.group(0);

        decodeString = new String(Base64.getDecoder().decode(decodeString));

        return baseUrl+decodeString;
    }
}
