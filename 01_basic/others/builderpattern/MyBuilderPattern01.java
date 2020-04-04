// src: https://jdm.kr/blog/217

package builderpattern;

public class MyBuilderPattern01 {
    public static void main(String[] args) {
        PersonInfoBuilder personInfoBuilder = new PersonInfoBuilder();
        PersonInfo result = personInfoBuilder
                .setName("MISTAKE")
                .setAge(30)
                .setFavoriteAnimal("cat")
                .setFavoriteColor("purple")
                .setFavoriteNumber(3)
                .build();

        System.out.println(result.getPersonInfo());
    }
}
