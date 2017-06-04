package activity.amigosecreto.db;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by HP on 21/06/2015.
 */
public class Desejo implements Parcelable, Comparable<Desejo> {

    private int id;
    private String produto;
    private String categoria;
    private String lojas;
    private double precoMinimo;
    private double precoMaximo;

    public Desejo() {
        // TODO Auto-generated constructor stub
    }

    public Desejo(int id, String produto){
        this.id = id;
        this.produto = produto;
    }

    public Desejo(Parcel parcel){
        String[] dados = new String[6];
        parcel.readStringArray(dados);
        this.id = Integer.parseInt(dados[0]);
        this.produto = dados[1];
        this.categoria = dados[2];
        this.lojas = dados[3];
        this.precoMinimo = Double.parseDouble(dados[4]);
        this.precoMaximo = Double.parseDouble(dados[5]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLojas() {
        return lojas;
    }

    public void setLojas(String lojas) {
        this.lojas = lojas;
    }

    public double getPrecoMinimo() {
        return precoMinimo;
    }

    public void setPrecoMinimo(double precoMinimo) {
        this.precoMinimo = precoMinimo;
    }

    public double getPrecoMaximo() {
        return precoMaximo;
    }

    public void setPrecoMaximo(double precoMaximo) {
        this.precoMaximo = precoMaximo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                ""+id,
                produto,
                categoria,
                lojas,
                ""+precoMinimo,
                ""+precoMaximo
        });
    }

    public static final Parcelable.Creator<Desejo> CREATOR = new Creator<Desejo>() {
        @Override
        public Desejo[] newArray(int size) {
            return new Desejo[size];
        }
        @Override
        public Desejo createFromParcel(Parcel source) {
            return new Desejo(source);
        }
    };

    @Override
    public int compareTo(Desejo d) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(d.getId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((categoria == null) ? 0 : categoria.hashCode());
        result = prime * result + id;
        result = prime * result + ((lojas == null) ? 0 : lojas.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precoMaximo);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(precoMinimo);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Desejo other = (Desejo) obj;
        if (categoria == null) {
            if (other.categoria != null)
                return false;
        } else if (!categoria.equals(other.categoria))
            return false;
        if (id != other.id)
            return false;
        if (lojas == null) {
            if (other.lojas != null)
                return false;
        } else if (!lojas.equals(other.lojas))
            return false;
        if (Double.doubleToLongBits(precoMaximo) != Double
                .doubleToLongBits(other.precoMaximo))
            return false;
        if (Double.doubleToLongBits(precoMinimo) != Double
                .doubleToLongBits(other.precoMinimo))
            return false;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[id="+id+";produto="+produto+";]";
    }

}
