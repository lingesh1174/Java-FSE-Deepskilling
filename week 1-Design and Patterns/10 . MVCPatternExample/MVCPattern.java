class Student{
    private String id, name, grade;
    public Student(String id, String name, String grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getId(){ 
        return id;
    }
    public void setId(String id){ 
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
}

class StudentView {
    public void displayStudentDetails(String id, String name, String grade){
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

class StudentController {
    private Student student;
    private StudentView view;
    public StudentController(Student student, StudentView view){
        this.student = student;
        this.view = view;
    }
    public void setStudentName(String name){
        student.setName(name);
    }
    public void setStudentGrade(String grade){
        student.setGrade(grade);
    }
    public String getStudentName(){
        return student.getName();
    }
    public String getStudentGrade(){
        return student.getGrade();
    }
    public void updateView(){
        view.displayStudentDetails(student.getId(), student.getName(), student.getGrade());
    }
}

public class MVCPattern{
    public static void main(String[] args){
        Student model = new Student("S123", "Ravi Kumar", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        System.out.println("Initial Student Details:");
        controller.updateView();
        controller.setStudentGrade("A+");
        System.out.println("\nUpdated Student Details:");
        controller.updateView();
    }
}