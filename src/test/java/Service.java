import java.util.ArrayList;
import java.util.Random;

public class Service {
    Random random = new Random();

public ArrayList<String> countries() {
    ArrayList<String>countriesList = new ArrayList<>();
    countriesList.add("Poland");
    countriesList.add("Germany");
    countriesList.add("Slovakia");
    countriesList.add("Egypt");
    countriesList.add("Austria");
    countriesList.add("Georgia");
    return countriesList;
}
public String getRandomValue(ArrayList<String>list) {
    int i = random.nextInt(list.size());
    return list.get(i);
}

}