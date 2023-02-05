package model;

import java.util.UUID;

public class DDL {
    private String id,textEn,textBn;

    public DDL(String textEn, String textBn) {
        this.id = UUID.randomUUID().toString();
        this.textEn = textEn;
        this.textBn = textBn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextEn() {
        return textEn;
    }

    public void setTextEn(String textEn) {
        this.textEn = textEn;
    }

    public String getTextBn() {
        return textBn;
    }

    public void setTextBn(String textBn) {
        this.textBn = textBn;
    }

    @Override
    public String toString() {
        return "DDL{" +
                "id='" + id + '\'' +
                ", textEn='" + textEn + '\'' +
                ", textBn='" + textBn + '\'' +
                '}';
    }
}
