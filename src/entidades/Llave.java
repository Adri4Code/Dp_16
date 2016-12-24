package entidades;

/**
 * Created by adri on 18/12/16.
 */
public class Llave implements Comparable<Llave> {
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

    @Override
    public int compareTo(Llave o) {
        if (this.id == o.id) {
            return 0;
        }
        if (this.id > o.id)
            return 1;
        else
            return -1;


    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Llave)) return false;
        if (((Llave) obj).id == this.id) return true;
        return super.equals(obj);
    }


}
