package shelter.model;

public abstract class Animal {
    private int id;
    private String name;
    private int age;
    private boolean vaccinated;
    private int shelterID;
    private String breed;

    public Animal(int id, String name, int age, boolean vaccinated, int shelterID, String breed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.vaccinated = vaccinated;
        this.shelterID = shelterID;
        this.breed = breed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public int getShelterID() {
        return shelterID;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age +
                " | Vaccinated: " + vaccinated + " | ShelterID: " + shelterID + " | Breed: " + breed;
    }
}
