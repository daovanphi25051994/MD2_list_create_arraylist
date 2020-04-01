package arraylist;

import model.Student;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Student> listStudent = new MyList<>();
        Student student1 = new Student("phi", 26);
        Student student2 = new Student("dao", 22);
        Student student3 = new Student("van", 22);
        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);
        System.out.println(listStudent.get(0).getName());

        Student[] listCopy = new Student[listStudent.size()];
        listStudent.clone(listCopy);
        System.out.println(listCopy[0].getName());

        listCopy[0].setName("copyphi");

        System.out.println(listCopy[0].getName());
        System.out.println(listStudent.get(0).getName());

    }
}
