package org.patas.student;

public class Student implements Comparable<Student> {
   private String name;
   private String enrollment;
   private Double grade;

   public Student (String name, String enrollment, Double grade) {
       this.name = name;
       this.enrollment = enrollment;
       this.grade = grade;
   }

    private Double getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student student) {
        return grade.compareTo(student.getGrade());
    }

    @Override
    public String toString() {
       return "Student: " + name + " | Grade: " + grade.toString();
    }
}
