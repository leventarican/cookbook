package com.github.leventarican.cleanarchitecture.enterprisebusinessrules;

/**
 * Entity - POJO
 *
 * @author levent
 */
public class Developer {

    private int experience;
    // preferred programming language
    private String programmingLang;
    private String id;
    private String password;

    public Developer(int experience, String programmingLang, String id, String password) {
        this.experience = experience;
        this.programmingLang = programmingLang;
        this.id = id;
        this.password = password;
    }

    public static DeveloperBuilder builder() {
        return new DeveloperBuilder();
    }

    /*
    var developer = Developer.builder()
        .setExperience(10)
        .setProgrammingLang("java")
        .setId("ID123")
        .setPassword("encrypted")
        .build();
    */
    public static class DeveloperBuilder {

        private int experience;
        private String programmingLang;
        private String id;
        private String password;

        public DeveloperBuilder() {
        }

        public DeveloperBuilder setExperience(int experience) {
            this.experience = experience;
            return this;
        }

        public DeveloperBuilder setProgrammingLang(String programmingLang) {
            this.programmingLang = programmingLang;
            return this;
        }

        public DeveloperBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public DeveloperBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Developer build() {
            return new Developer(experience, programmingLang, id, password);
        }

    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getProgrammingLang() {
        return programmingLang;
    }

    public void setProgrammingLang(String programmingLang) {
        this.programmingLang = programmingLang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("dev{exp=%d, lang: %s, id: %s, pw: %s}", experience, programmingLang, id, password);
    }

}
