package shelter.model;

public class Dog extends Animal {
    private boolean adopted;
    private String foodType;
    private int gramsPerDay;

    public Dog(int id, String name, int age, boolean vaccinated, int shelterID,
               String breed, boolean adopted, String foodType, int gramsPerDay) {
        super(id, name, age, vaccinated, shelterID, breed);
        this.adopted = adopted;
        this.foodType = foodType;
        this.gramsPerDay = gramsPerDay;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getGramsPerDay() {
        return gramsPerDay;
    }

    public void setGramsPerDay(int gramsPerDay) {
        this.gramsPerDay = gramsPerDay;
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: Dog | Adopted: " + adopted +
                " | Food: " + foodType + " | Grams per day: " + gramsPerDay;
    }
}
