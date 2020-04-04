// src: https://jdm.kr/blog/217

package builderpattern;

public class PersonInfo {
    private String name;
    private Integer age;
    private String favoriteColor;
    private String favoriteAnimal;
    private Integer favoriteNumber;

    public PersonInfo(String name, Integer age, String favoriteColor, String favoriteAnimal, Integer favoriteNumber) {
        this.name = name;
        this.age = age;
        this.favoriteColor = favoriteColor;
        this.favoriteAnimal = favoriteAnimal;
        this.favoriteNumber = favoriteNumber;
    }

    public String getName() {
        return name;
    }

    public Integer age() {
        return age;
    }

    public String favoriteColor() {
        return favoriteColor;
    }

    public String getFavoriteAnimal() {
        return favoriteAnimal;
    }

    public Integer getFavoriteNumber() {
        return favoriteNumber;
    }

    public String getPersonInfo() {
        String personInfo = String.format("name: %s, age: %d, favoriteColor: %s, favoriteAnimal: %s, favoriteNumber: %d",
                name, age, favoriteColor, favoriteAnimal, favoriteNumber);
        return personInfo;
    }
}
