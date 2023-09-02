package Main;

import jakarta.persistence.*;


@Entity
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "code")
    private String code;

    protected Stats() {
    }

    public Stats(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.getName()
                + " " + this.getCode() + " " +
                this.getId();
    }
}
