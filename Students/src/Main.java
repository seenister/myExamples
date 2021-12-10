import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Student Ira = new Student("Ira", 22, 10, 'f');
        Student Andrey = new Student("Andrey", 23, 7, 'm');
        Student Alexandr = new Student("Alexandr", 24, 6, 'm');
        Student Gleb = new Student("Gleb", 20, 9, 'm');
        Student Natasha = new Student("Natasha", 25, 8, 'f');

        ArrayList<Student> someStudents = new ArrayList<>();
        someStudents.add(Ira);
        someStudents.add(Andrey);
        someStudents.add(Alexandr);
        someStudents.add(Gleb);
        someStudents.add(Natasha);

        ShowFilteredStudents sh = new ShowFilteredStudents();
        sh.showFilteredStudentsAction(someStudents, new FilterOnAge());
        sh.showFilteredStudentsAction(someStudents, new FilterStudents() {
            @Override
            public boolean check(Student st) {
                return st.grade>9;
            }
        });
        sh.showFilteredStudentsAction(someStudents,(Student st) -> st.grade>9 ); 
    }


}

class Student {
    String name;
    int age;
    int grade;
    char sex;

    public Student(String name, int age, int grade, char sex) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", sex=" + sex +
                '}';
    }
}

interface FilterStudents {
    boolean check(Student st);
}

class FilterOnAge implements FilterStudents {

    @Override
    public boolean check(Student st) {
        return st.age<21;
    }
}

class ShowFilteredStudents {
    void showFilteredStudentsAction(ArrayList<Student> some, FilterStudents someClass) {
        for (Student s : some) {
            if (someClass.check(s)) {
                System.out.println(s);
            }
        }
    }

}

