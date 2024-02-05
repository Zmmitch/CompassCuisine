public class UserPreference {
    // user prerfences
    private String preferredCuisine;
    private int  maximumPrice;
    private int preferredTime;
    private int maxDistance;
    private int minimumRating;


    // preference weights
    private double weightCuisine;
    private double weightDistance;
    private double weightPrice;
    private double weightTime;
    private double weightRating;


    public UserPreference(String preferredCuisine, int maximumPrice,
                          int preferredTime, int maxDistance, int minimumRating,
                          double weightCuisine, double weightDistance, double weightPrice,
                          double weightTime, double weightRating) {
        this.preferredCuisine = preferredCuisine;
        this.maximumPrice = maximumPrice;
        this.preferredTime = preferredTime;
        this.maxDistance = maxDistance ;
        this.minimumRating = minimumRating;
        this.weightCuisine = weightCuisine;
        this.weightDistance = weightDistance;
        this.weightPrice = weightPrice;
        this.weightTime = weightTime;
        this.weightRating = weightRating;
    }

    public String getPreferredCuisine() {
        return preferredCuisine;
    }

    public void setPreferredCuisine(String preferredCuisine) {
        this.preferredCuisine = preferredCuisine;
    }

    public int getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(int maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    public int getPreferredTime() {
        return preferredTime;
    }

    public void setPreferredTime(int preferredTime) {
        this.preferredTime = preferredTime;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setPreferredDistance(int preferredDistance) {
        this.maxDistance = preferredDistance;
    }

    public int getMinimumRating() {
        return minimumRating;
    }

    public void setMinimumRating(int minimumRating) {
        this.minimumRating = minimumRating;
    }


    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public double getWeightCuisine() {
        return weightCuisine;
    }

    public void setWeightCuisine(double weightCuisine) {
        this.weightCuisine = weightCuisine;
    }

    public double getWeightDistance() {
        return weightDistance;
    }

    public void setWeightDistance(double weightDistance) {
        this.weightDistance = weightDistance;
    }

    public double getWeightPrice() {
        return weightPrice;
    }

    public void setWeightPrice(double weightPrice) {
        this.weightPrice = weightPrice;
    }

    public double getWeightTime() {
        return weightTime;
    }

    public void setWeightTime(double weightTime) {
        this.weightTime = weightTime;
    }

    public double getWeightRating() {
        return weightRating;
    }

    public void setWeightRating(double weightRating) {
        this.weightRating = weightRating;
    }
}
