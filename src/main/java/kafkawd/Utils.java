package kafkawd;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    // return the fake first and last name
    public static String getRandomName() {
        Faker faker = new Faker();
        return faker.name().fullName();
    }

    // return the random string. kasfdhjashkdfa
    public static String getRandomString() {
        return RandomStringUtils.random(20, true, false);
    }



}
