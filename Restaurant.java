import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Locale;

public class Restaurant {
//    @SerializedName("name")
    private String name;

    private String cuisine;
    private String vibe; //

//    @SerializedName("price")
   private int price; // 1-4

   private int openingTime; // // 24 hour format
   private int closingTme; // 24 hour format
   private double distance; // max distance is about 30 miles

//    @SerializedName("rating")
   private int rating; // 1-5
    private double utility;


    public Restaurant(String name, String cuisine, String vibe, int price, int openingTime, int closingTme, double distance, int rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.vibe = vibe;
        this.price = price;
        this.openingTime = openingTime;
        this.closingTme = closingTme;
        this.distance = distance;
        this.rating = rating;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    public int getClosingTme() {
        return closingTme;
    }

    public void setClosingTme(int closingTme) {
        this.closingTme = closingTme;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getVibe() {
        return vibe;
    }

    public void setVibe(String vibe) {
        this.vibe = vibe;
    }


    public double getUtility() {
        return utility;
    }

    public void setUtility(double utility) {
        this.utility = utility;
    }
//1. Casa Del Pepe
//2. Elicpse de Luna
//3. Diegos Tacos
//4. Pedros Tacos
//5. Akwabe
    public double calculateUtility(UserPreference userPreferences) {
        if (cuisine.toLowerCase(Locale.ROOT).equals(userPreferences.getPreferredCuisine().toLowerCase(Locale.ROOT))) {
            double distanceUtility = distanceUtility(userPreferences.getMaxDistance(), distance);        //  1.0 / (1.0 + this.distance / userPreferences.getMaxDistance())
            double priceUtility = priceUtility(userPreferences.getMaximumPrice(), price);
            double ratingUtility = ratingUtility(userPreferences.getMinimumRating(), rating);
            double timeUtility = calculateTimeUtility( userPreferences.getPreferredTime(), getOpeningTime(), getClosingTme());
            double u = (distanceUtility * userPreferences.getWeightDistance()) +            // (cuisineUtility * userPreferences.getWeightCuisine()
                    (priceUtility * userPreferences.getWeightRating()) +
                    (ratingUtility * userPreferences.getWeightRating()) +
                    (timeUtility * userPreferences.getWeightTime());
            this.setUtility(u);
            System.out.println(u);
            return u;
        }
        else {
            return 0;
        }
      //  double cuisineUtility = this.cuisine.toLowerCase(Locale.ROOT).equals(userPreferences.getPreferredCuisine().toLowerCase(Locale.ROOT)) ? 1.0 : 0.0;

        }

    public double ratingUtility(double preferredRating, double restaurantRating) {
  //      return Math.exp(-0.5 * Math.pow((preferredRating - restaurantRating) / standardDeviation, 2));
        return 1.0 / (1.0 + restaurantRating / preferredRating);
    }

    public double priceUtility(double preferredPrice, double restaurantPrice) {
       // return Math.exp(-0.5 * Math.pow((preferredPrice - restaurantPrice) / standardDeviation, 2));
          return 1.0 / (1.0 + restaurantPrice / preferredPrice);
    }

    public double distanceUtility(double preferredDistance, double restaurantDistance) {

        if (restaurantDistance > preferredDistance) {
            return  0;
        }
        else {
            return 1.0 / (1.0 + restaurantDistance / preferredDistance);
        }
    }

    private double calculateTimeUtility(int preferredTime, int openingTime, int closingTime) {
        if (preferredTime < openingTime || preferredTime > closingTime ) {
            //    System.out.println("Restaraunt is currently closed ");
            return 0;
        }
        else {
            return 1;
            // Assume a simple linear decay function for both opening and closing times
//                    double openingTimeDecayFactor = 1.0 / (1.0 + Math.abs(openingTime - preferredTime));
//                    double closingTimeDecayFactor = 1.0 / (1.0 + 2.0 * Math.abs(closingTime - preferredTime));  //  more weight to closing time closer the closing time the least desiered
//
//                    double weightedOpeningTimeUtility = userPreference.getWeightTime() * openingTimeDecayFactor;
//                    double weightedClosingTimeUtility = userPreference.getWeightTime() * closingTimeDecayFactor;
//
//                    // Combine the weighted opening and closing time utilities
//                    return (weightedOpeningTimeUtility + weightedClosingTimeUtility) / 2.0;

        }

    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", vibe='" + vibe + '\'' +
                ", price=" + price +
                ", openingTime=" + openingTime +
                ", closingTme=" + closingTme +
                ", distance=" + distance +
                ", rating=" + rating +
                '}';
    }


}
