package entidades;

/**
 * Created by adri on 18/12/16.
 */
public class Llave {
    private int id;

    public Llave (){
        this.id =0;
    }
    public Llave(int ID){
        this.id=ID;
    }
    public void setId(int ID){
      this.id = ID;
    }

    public int getId(){
        return this.id;
    }



}
