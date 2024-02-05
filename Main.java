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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Cuisine Compass!");
        System.out.println("Please answer a couple of questions so we can guide you to " +
                "the perfect website for you: ");
        System.out.println("-----------------------------------------------------------------------------");

        System.out.println("What type of cuisine are you feeling? ");
        String userCuisine = scanner.nextLine();

        System.out.println("What is the prefered price you are willing to pay(1-4)?");
        String userPrice =  scanner.nextLine();

        System.out.println("What time do you plan on going(0-24)?");
        String userTime =  scanner.nextLine();

        System.out.println("What is the maximum distance you will travel(0-30) miles?");
        String userDistance =  scanner.nextLine();

        System.out.println("What rating do you prefer the restaurant to have? ");
        String userRating =  scanner.nextLine();

//        System.out.println("What is the perferred city of the restaraunt");
//        String userLocation = scanner.nextLine();

//        System.out.println("How you feelin today what type of restaraunt you feel ex: fast food, casual ex:");
//        String userVibe = scanner.nextLine();

//        String url = "https://api.yelp.com/v3/businesses/search?location=" + userLocation + "&term=food&radius=" + userDistance+"&categories=" + userCuisine +"&categories=" + userVibe + "&price=" + userPrice + "&sort_by=best_match&limit=1";
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .header("accept", "application/json")
//                .header("Authorization", "Bearer QzJetKQ88gshaEO4iRtMTFvbiuLZBEfOY543wNbk1H6TkeigxpI_C1uqyQGuuBMoAgz1J98wNK4ZVpf8d2NCoCvqJN-rw2NAvibG1w4WcKQSEAwjtYni36nOnqW7ZXYx")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//
//        // Parse the JSON response using Gson
//        Gson gson = new Gson();
//       apiRequest apiRequest = gson.fromJson(response.body(), apiRequest.class);
//        System.out.println(response.body());
//        // Define the Type for a List of Person objects
//        Type rListType = new TypeToken<List<apiRequest>>() {}.getType();
//
//        // Parse JSON array data into a List of Person objects
//        List<apiRequest> people = gson.fromJson(response.body(), rListType);
//
//        if (people != null) {
//            // Iterate over the list and print information for each person
//            for (apiRequest person : people) {
//                System.out.println("Name: " + person.getName());
//                System.out.println("Id: " + person.getId());
//            }
//            }
//         else {
//            System.out.println("Parsing failed. Check JSON array data and class structure.");
//        }


        // Create an instance of the RecommenderSystem
        RecommenderSystem recommender = new RecommenderSystem();


                // AMERICAN
        recommender.addRestaurant(new Restaurant("Fare & Feed", "American", "Formal", 3, 16, 22, 10, 4));
        recommender.addRestaurant(new Restaurant("Golden Palace", "American", "Buffet", 3, 11, 19, 5, 4));
        recommender.addRestaurant(new Restaurant("Cajun Grill", "American", "Take out", 2, 12, 21, 11, 4));
        recommender.addRestaurant(new Restaurant("Prime Time Eats", "American", "Casual", 1, 9, 19, 15, 2));
        recommender.addRestaurant(new Restaurant("Smile N' Delight", "American", "Casual", 2, 10, 19, 13, 1));
        recommender.addRestaurant(new Restaurant("Fatty's", "American", "Formal", 4, 14, 2, 20, 3));
        recommender.addRestaurant(new Restaurant("Shake it up", "American", "Take Out", 1, 10, 19, 23, 3));

        // MEXICAN
        recommender.addRestaurant(new Restaurant("Pedros Tacos", "Mexican", "Take out", 1, 12, 19, 13, 4));
        recommender.addRestaurant(new Restaurant("Akwabe", "Mexican", "Buffett", 3, 10, 11, 20, 22));
        recommender.addRestaurant(new Restaurant("Casa Del Pepe", "Mexican", "Take Out", 4, 9, 23, 18, 2));
        recommender.addRestaurant(new Restaurant("Diegos Tacos", "Mexican", "Take Out", 2, 10, 19, 17, 4));
        recommender.addRestaurant(new Restaurant("Elicpse de Luna", "Mexican", "Take Out", 3, 10, 19, 24, 1));

        // CHINESE
        recommender.addRestaurant(new Restaurant("Wonton Express", "Chinese", "Casual", 2, 10, 19, 30, 4));
        recommender.addRestaurant(new Restaurant("China Kitchen", "Chinese", "Formal", 4, 14, 22, 5, 5));
        recommender.addRestaurant(new Restaurant("China Cafe", "Chinese", "Cafe", 1, 10, 19, 12, 3));
        recommender.addRestaurant(new Restaurant("Chopsticks", "Chinese", "Formal", 4, 9, 19, 21, 4));
        recommender.addRestaurant(new Restaurant("House of Lu", "Chinese", "Casual", 3, 10, 23, 18, 1));

        // ITALIAN
        recommender.addRestaurant(new Restaurant("Marcos", "Italian", "Formal", 4, 9, 22, 22, 5));
        recommender.addRestaurant(new Restaurant("Love Street", "Italian", "Casual", 2, 10, 19, 3, 3));
        recommender.addRestaurant(new Restaurant("Brasserie de Paris", "Italian", "Formal", 2, 12, 19, 23, 4));
        recommender.addRestaurant(new Restaurant("Italian Seafood", "Italian", "Formal", 3, 12, 19, 30, 4));
        recommender.addRestaurant(new Restaurant("Padella Italian Restaraunt", "Italian", "Formal", 4, 10, 19, 18, 3));

        // Japanese
        recommender.addRestaurant(new Restaurant("Naruto’s den", "Japanese", "Formal", 4, 10, 19, 28, 3));
        recommender.addRestaurant(new Restaurant("Sushi Roll", "Japanese", "Casual", 1, 12, 20, 5, 4));
        recommender.addRestaurant(new Restaurant("Fugo Express", "Japanese", "Formal", 3, 13, 2, 9, 3));
        recommender.addRestaurant(new Restaurant("Minato Japense Bar", "Japanese", "Take Out", 2, 12, 21, 14, 5));
        recommender.addRestaurant(new Restaurant("Sushi Home", "Japanese", "Take Out", 1, 13, 20, 23, 2));

        // Korean
        recommender.addRestaurant(new Restaurant("Figs BBQ", "Korean", "Take Out", 4, 12, 22, 25, 5));
        recommender.addRestaurant(new Restaurant("Korean Kingdom", "Korean", "Casual", 3, 10, 19, 14, 3));

        // FRENCH
        recommender.addRestaurant(new Restaurant("Cya's Bakery", "French", "Cafe", 1, 8, 19, 23, 1));
        recommender.addRestaurant(new Restaurant("French Palace", "French", "Bakery", 1, 7, 20, 23, 4));




//        String preferredCuisine, int maximumPrice,
//        int preferredTime, int maxDistance, int minimumRating,
//        double weightCuisine, double weightDistance, double weightPrice,
//        double weightTime, double weightRating) {
//            this.preferredCuisine = preferredCuisine;

        // Set user preferences
        UserPreference preference = new UserPreference(userCuisine, Integer.parseInt(userPrice), Integer.parseInt(userTime), Integer.parseInt(userDistance), Integer.parseInt(userRating), 0.3, 0.2, 0.2, 0.1, 0.2);

        // Get recommended restaurants
        List<Restaurant> recommendations = recommender.recommendRestaurants(preference);



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
                System.out.println("Type - " + recommendations.get(i).getVibe());
                System.out.println("Rating - " + recommendations.get(i).getRating());

            if ( recommendations.get(i).getPrice() == 1) {
                System.out.println("Price: Inexpensive, usually $10 and under");
                }
            else if (recommendations.get(i).getPrice() == 2) {
                System.out.println("Moderately expensive, usually between $10-$25");
            }
            else if(recommendations.get(i).getPrice() == 3) {
                System.out.println("Expensive, usually between $25-$45");
            }
            else if (recommendations.get(i).getPrice() == 4) {
                System.out.println("Expensive, usually between $25-$45");
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
