public class Emp {

    public Emp() {
    }

    private String name;
    private String department;
    private long sallary;

    public Emp(String name, String department, long sallary) {
        this.name = name;
        this.department = department;
        this.sallary = sallary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSallary() {
        return sallary;
    }

    public void setSallary(long sallary) {
        this.sallary = sallary;
    }
}
