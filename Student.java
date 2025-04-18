public class Student {
    private String prn;
    private String name;
    private String batch;

    public Student(String prn, String name, String batch) {
        this.prn = prn;
        this.name = name;
        this.batch = batch;
    }

    public String getPrn() {
        return prn;
    }

    public String getName() {
        return name;
    }

    public String getBatch() {
        return batch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
