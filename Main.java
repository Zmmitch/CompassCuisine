import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://api.yelp.com/v3/businesses/search?location=Atlanta&term=food&categories=cafe&sort_by=best_match&limit=20"))
//                .header("accept", "application/json")
//                .header("Authorization", "Bearer QzJetKQ88gshaEO4iRtMTFvbiuLZBEfOY543wNbk1H6TkeigxpI_C1uqyQGuuBMoAgz1J98wNK4ZVpf8d2NCoCvqJN-rw2NAvibG1w4WcKQSEAwjtYni36nOnqW7ZXYx")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());

        // DISTANCE(google)  PRICE(1-4)  RATING(1-5) TIME1)5)

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Cuisine Compass!");
        System.out.println("Please answer a couple of questions so we can guide you to " +
                "the perfect website for you: ");
        System.out.println("-----------------------------------------------------------------------------");

        System.out.println("What type of cuisine are you feeling? ");
        String userCuisine = scanner.nextLine();

        System.out.println("What is the prefered price you are willing to pay(1-4)?");
        String userPrice = scanner.nextLine();

        System.out.println("What time do you plan on going(0-24)?");
        String userTime = scanner.nextLine();

        System.out.println("What is the maximum distance you will travel(0-40000) meters?");
        String userDistance = scanner.nextLine();

        System.out.println("What rating do you prefer the restaurant to have? ");
        String userRating = scanner.nextLine();

        System.out.println("What is the perferred city of the restaraunt");
        String userLocation = scanner.nextLine();

        System.out.println("How you feelin today what type of restaraunt you feel ex: fast food, casual ex:");
        String userVibe = scanner.nextLine();

        String url = "https://api.yelp.com/v3/businesses/search?location=" + userLocation + "&term=food&radius=" + userDistance + "&categories=" + userCuisine + "&categories=" + userVibe + "&price=" + userPrice + "&sort_by=best_match&limit=20";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("accept", "application/json")
                .header("Authorization", "Bearer Token")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        String res = response.body();
        // on
        Gson gson = new Gson();
        RestaurantResponse restaurantResponse = gson.fromJson(res, RestaurantResponse.class);
        List<Restaurant> restaurants = restaurantResponse.getBusinesses();

        // Set user preferences
        UserPreference preference = new UserPreference(userCuisine, userPrice, Integer.parseInt(userTime), Integer.parseInt(userDistance), Double.parseDouble(userRating), 0.3, 0.2, 0.2, 0.1, 0.2);

        // Declaring Recommender system
        RecommenderSystem recommender = new RecommenderSystem();

        // Get recommended restaurants
        List<Restaurant> recommendations = recommender.recommendRestaurants(preference);


        for (Restaurant restaurant : restaurants) {
            //  System.out.println("ID: " + restaurant.getId());
            recommendations.add(restaurant);
            System.out.println("Name: " + restaurant.getName());
            System.out.println("Rating: " + restaurant.getRating());
            switch (restaurant.getPrice()) {
                case "$":
                    System.out.println("Price: Inexpensive, usually $10 and under");
                    break;
                case "$$":
                    System.out.println("Moderately expensive, usually between $10-$25");
                    break;
                case "$$$":
                    System.out.println("Expensive, usually between $25-$45");
                    break;
                case "$$$$":
                    System.out.println(" Very Expensive, usually over $50");
                    break;
            }


        }
        // System.out.println("Rating: " + apiRequest.getRating());

    // apiRequest apiRequest = gson.fromJson(response.body(), apiRequest.class);




        System.out.println("-----------------------------------------------------------------------------");
//        if (apiRequests != null) {
//            // Iterate over the list and print information for each person
//            for (apiRequest place : apiRequests) {
//                System.out.println("Name: " + place.getName());
//                System.out.println("Id: " + place.getId());
//            }
//            }
//         else {
//            System.out.println("Parsing failed. Check JSON array data and class structure.");
//        }




        System.out.println("Recommended restaurants based on user preferences:");
        selectionSort(recommendations);


        if (recommendations.size() == 0) {
            System.out.println("Sorry you are being too picky");
        }
        else {
            for (int i = 0; i < 3; i++) {
                if (recommendations.size() == i) {
                    break;
                }
                System.out.println((i + 1) + ". " + recommendations.get(i).getName() + ":");
             //   System.out.println("Type - " + recommendations.get(i).getVibe());
                System.out.println("Rating - " + recommendations.get(i).getRating());

                switch (recommendations.get(i).getPrice()) {
                    case "$":
                        System.out.println("Price: Inexpensive, usually $10 and under");
                        break;
                    case "$$":
                        System.out.println("Moderately expensive, usually between $10-$25");
                        break;
                    case "$$$":
                        System.out.println("Expensive, usually between $25-$45");
                        break;
                    case "$$$$":
                        System.out.println(" Very Expensive, usually over $50");
                        break;
                }
             System.out.println(" ");
            }

        }

    }
    public static void selectionSort(List<Restaurant> restaurants) {
        int n = restaurants.size();

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (restaurants.get(j).getUtility() > restaurants.get(maxIndex).getUtility()) {
                    maxIndex = j;
                }
            }
            // Swap the found maximum element with the first element
            Restaurant temp = restaurants.get(maxIndex);
            restaurants.set(maxIndex, restaurants.get(i));
            restaurants.set(i, temp);
        }
    }
}
