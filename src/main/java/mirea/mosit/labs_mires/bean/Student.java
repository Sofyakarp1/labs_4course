package mirea.mosit.labs_mires.bean;

public class Student {

    private int id;
    private String name;
    private String surname;
    private String second_name;
    private int study_group_id;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public int getStudy_group_id() {
        return study_group_id;
    }

    public void setStudy_group_id(int study_group_id) {
        this.study_group_id = study_group_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", second_name='" + second_name + '\'' +
                ", study_group_id=" + study_group_id +
                '}';
    }
}
