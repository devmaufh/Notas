package maufdh.dev.notas.Models;

public class ModelFavorites {
    int id;
    int id_note;

    public ModelFavorites(int id, int id_note) {
        this.id = id;
        this.id_note = id_note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }
}
