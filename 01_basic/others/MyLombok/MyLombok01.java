// src: https://niceman.tistory.com/99, https://www.daleseo.com/lombok-popular-annotations/

package MyLombok;

import MyLombok.LombokModel.LombokModelBuilder;

public class MyLombok01 {
    public static void main(String[] args) {
        LombokModel lombokModel = new LombokModelBuilder()
                .name("Park")
                .address("seould")
                .age("13")
                .build();

        System.out.println("Lombok library");
        System.out.println("LombokModel : " + lombokModel);
        System.out.println("LombokModel : " + lombokModel.toString());
        System.out.println("LombokModel : " + lombokModel.hashCode());
    }
}
