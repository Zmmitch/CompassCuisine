import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class RecommenderSystem {
    List<Restaurant> restaurants;

    public RecommenderSystem() {
        restaurants = new ArrayList<>();
    }


    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> recommendRestaurants(UserPreference preferences) {
        List<Restaurant> recommendedRestaurants = new ArrayList<>();
        double utility = 0;
//        HashMap<Double,Restaurant> map=new HashMap<Double, Restaurant>();
        double max = 0;

        for (int i = 0; i < restaurants.size(); i++) {
            utility = restaurants.get(i).calculateUtility(preferences);

           // System.out.println(utility);
            if (utility >= .4) {
                recommendedRestaurants.add(restaurants.get(i));
            }
        }
        return  recommendedRestaurants;
    }
}
