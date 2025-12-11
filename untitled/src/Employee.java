public class Employee {

    private String name;

    private String department;

    private Long sallary;

    public Employee() {
    }

    public Employee(String name, String department, Long sallary) {
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

    public Long getSallary() {
        return sallary;
    }

    public void setSallary(Long sallary) {
        this.sallary = sallary;
    }
}
