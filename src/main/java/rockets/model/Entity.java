package rockets.model;

public abstract class Entity {
    private Long id;

    private String wikilink;

    public String getWikilink() {
        return wikilink;
    }

    public void setWikilink(String wikilink) {
        this.wikilink = wikilink;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected boolean isCountry(String country) {
        String[] Words = country.split(" ");
        for (String w : Words) {
            if (!Character.isUpperCase(w.charAt(0))) {
                return false;
            }
        }
        return true;
    }
}
