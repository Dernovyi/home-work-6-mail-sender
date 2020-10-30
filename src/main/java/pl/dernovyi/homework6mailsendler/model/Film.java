package pl.dernovyi.homework6mailsendler.model;




import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Film {
    @NotNull
    private String name;
    @NotNull
    @Min(4)
    private int year;
    @NotNull
    private String producer;

    public Film() {
    }

    public Film(String name, int year, String producer) {
        this.name = name;
        this.year = year;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Film{");
        sb.append("name='").append(name).append('\'');
        sb.append(", year=").append(year);
        sb.append(", producer='").append(producer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
