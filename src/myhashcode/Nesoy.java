//src: https://nesoy.github.io/articles/2018-06/Java-equals-hashcode

package myhashcode;

public class Nesoy {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        if (this == obj) {
            System.out.println("Object Same");
            return true;
        }

        Nesoy that = (Nesoy) obj;
        if (this.name == null && this.name != null) {
            return false;
        }
        if (this.age == that.age && this.name.equals(that.name)) {
            System.out.println("Object value same");
            return true;
        }

        return false;
    }

    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((name == null) ? 0 : name.hashCode());
        hashCode = prime * hashCode + age;

        return hashCode;
    }
}