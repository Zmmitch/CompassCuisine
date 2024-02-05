import com.google.gson.annotations.SerializedName;

public class apiRequest {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("rating")
    private double rating;

    @SerializedName("is_closed")
    private boolean is_closed;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public apiRequest() {
    }
}
