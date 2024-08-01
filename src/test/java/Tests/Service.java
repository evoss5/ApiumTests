package Tests;

import io.appium.java_client.android.AndroidDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class Service {
    Random random = new Random();

    public Service(AndroidDriver driver) {  // TODO: 01.08.2024 poprawić, nie potrzeba drivera
    }

    public ArrayList<String> countries() {
        ArrayList<String> countriesList = new ArrayList<>();
        countriesList.add("Poland");
        countriesList.add("Germany");
        countriesList.add("Slovakia");
        countriesList.add("Egypt");
        countriesList.add("Austria");
        countriesList.add("Georgia");
        return countriesList;
    }
    public ArrayList<String> cardNumbers() {
        ArrayList<String>cards = new ArrayList<>();

        cards.add("2720002236506367");
        cards.add("5212928911688864");
        cards.add("5189024250271378");
        cards.add("2720559411213481");
        cards.add("2720621132798990");
        cards.add("2571081640075375");
        cards.add("5204867363776381");
        cards.add("5282591476771643");
        return cards;
    }

    public String getRandomValue(ArrayList<String> list) {
        return list.get(random.nextInt(list.size()));
    }

    public String cardNumber() {
        String cardNumber = random.nextInt(1000, 9999) + String.valueOf(random.nextInt(1000, 9999)) + random.nextInt(1000, 9999) + String.valueOf(random.nextInt(1000, 9999));
        return cardNumber;
    }

    // TODO: 01.08.2024 posprzątać klasę
    public String expirationDate() {
        String date = String.valueOf(random.nextInt(10, 13) + String.valueOf(random.nextInt(25, 40)));
        return date;
    }
    public String randomSecurityCode() {
        return String.valueOf(random.nextInt(100, 999));

    }
    public String getCredential(String credentialName) throws IOException {
        FileReader reader = new FileReader("credentials");
        Properties properties = new Properties();
        properties.load(reader);
        return properties.getProperty(credentialName);
    }
    }
