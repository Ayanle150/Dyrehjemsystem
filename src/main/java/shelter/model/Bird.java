package shelter.model;

public class Bird extends Animal {
    private boolean canFly;
    private String cageSize;

    public Bird(int id, String name, int age, boolean vaccinated, int shelterID,
                String species, boolean canFly, String cageSize) {
        super(id, name, age, vaccinated, shelterID, species);
        this.canFly = canFly;
        this.cageSize = cageSize;
    }

    public boolean canFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public String getCageSize() {
        return cageSize;
    }

    public void setCageSize(String cageSize) {
        this.cageSize = cageSize;
    }

    public String getSpecies() {
        return getBreed();
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", vaccinated=" + isVaccinated() +
                ", shelterID=" + getShelterID() +
                ", species='" + getSpecies() + '\'' +
                ", canFly=" + canFly +
                ", cageSize='" + cageSize + '\'' +
                '}';
    }
}
