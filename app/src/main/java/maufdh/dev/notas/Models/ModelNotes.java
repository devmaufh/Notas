package maufdh.dev.notas.Models;

import java.util.Date;

public class ModelNotes {
    int id;
    String title;
    String text;
    int id_pizarra;
    int color;
    int secrete;
    Date date;

    public ModelNotes(int id, String title, String text, int id_pizarra, int color, int secrete, Date date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.id_pizarra = id_pizarra;
        this.color = color;
        this.secrete = secrete;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId_pizarra() {
        return id_pizarra;
    }

    public void setId_pizarra(int id_pizarra) {
        this.id_pizarra = id_pizarra;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSecrete() {
        return secrete;
    }

    public void setSecrete(int secrete) {
        this.secrete = secrete;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
