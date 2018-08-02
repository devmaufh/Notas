package maufdh.dev.notas.Models;

import java.util.Date;

public class ModelPizarra {
    int id;
    String name;
    String description;
    String color;
    Date date;

    public ModelPizarra(int id, String name, String description, String color, Date date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
