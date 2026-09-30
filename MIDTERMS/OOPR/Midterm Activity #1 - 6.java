public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("ST10234", "Alice Smith", "2002/5/14", 180);

        System.out.println("Student 1 Name: " + student1.getStudentName()); 
        System.out.println("Student 1 Points: " + student1.getTariffPoints());
        
        System.out.println("Student 2 Name: " + student2.getStudentName());
        System.out.println("Student 2 Points: " + student2.getTariffPoints());

        System.out.println("Total Students Created: " + Student.getNoOfStudents());
    }
}

public class Student {
    private static int noOfStudents = 0;
    private String studentNo;
    private String studentName;
    private String dateOfBirth;
    private int tariffPoints;

    public Student() {
        this.studentNo = "not known";
        this.studentName = "not known";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dateOfBirth = "01/01/1995";
        this.tariffPoints = 20;
        noOfStudents++;
    }

    public Student(String studentNo, String studentName, String dateOfBirth, int tariffPoints) {
        setStudentNo(studentNo);
        setStudentName(studentName);
        setDateOfBirth(dateOfBirth);
        setTariffPoints(tariffPoints);

        noOfStudents++;
    }

    public static int getNoOfStudents() {
        return noOfStudents;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        if (studentNo == null || studentNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Student number cant be empty.");
        }
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cant be empty.");
        }
        this.studentName = studentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.trim().isEmpty()) {
            throw new IllegalArgumentException("Date of birth cant no value.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getTariffPoints() {
        return tariffPoints;
    }

    public void setTariffPoints(int tariffPoints) {
        if (tariffPoints < 20 || tariffPoints > 280) {
            throw new IllegalArgumentException("Tariff points must be between 20 and 280.");
        }
        this.tariffPoints = tariffPoints;
    }
}
