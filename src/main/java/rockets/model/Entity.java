package rockets.model;

import static org.apache.commons.lang3.Validate.notNull;

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

    public boolean setId(Long id) {
        notNull(id, "id cannot be null");
        this.id = id;
        return true;
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
