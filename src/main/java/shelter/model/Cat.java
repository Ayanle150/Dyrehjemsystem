package shelter.model;

public class Cat extends Animal {
    private boolean neutered;
    private String litterType;
    private int gramsPerDay;

    public Cat(int id, String name, int age, boolean vaccinated, int shelterID,
               String breed, boolean neutered, String litterType, int gramsPerDay) {
        super(id, name, age, vaccinated, shelterID, breed);
        this.neutered = neutered;
        this.litterType = litterType;
        this.gramsPerDay = gramsPerDay;
    }

    public boolean isNeutered() {
        return neutered;
    }

    public String getLitterType() {
        return litterType;
    }

    public int getGramsPerDay() {
        return gramsPerDay;
    }


    public int getLitterGramsPerDay() {
        return gramsPerDay;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", vaccinated=" + isVaccinated() +
                ", shelterID=" + getShelterID() +
                ", breed=" + getBreed() +
                ", neutered=" + neutered +
                ", litterType='" + litterType + '\'' +
                ", gramsPerDay=" + gramsPerDay +
                '}';
    }
}
