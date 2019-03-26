package rockets.model;

public class Payload extends Entity {
    private String name;
    private String category;
    private String funcfion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFuncfion() {
        return funcfion;
    }

    public void setFuncfion(String funcfion) {
        this.funcfion = funcfion;
    }
}
