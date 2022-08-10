package hiber.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "cars")
public class Car {

    // mbklnklklbngblkbbkgbklgbklgblkgbklgbklmgk
    // jhgkfbkfnkvfkvnfdkvnfkvnfjknkjfnjkfbjkfn
    // njkvhjknjkfvkjfvnkjmfvnmkfvnkmfvn
    // nkgvfdkvfjkvnfkvnfkvnmkfnvkmfnvmf
    // nvjknfjkvfjkvnfkjvnkfmvnmkfnvkmfnvjf
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
