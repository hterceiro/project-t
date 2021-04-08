package VO;

public class Repos {
    private String name;
    private int contributions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }

    @Override
    public String toString() {
        return "Repos{" +
                "name='" + name + '\'' +
                ", contributions=" + contributions +
                '}';
    }
}
