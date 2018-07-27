package com.example.reflection2;

/**
 * Description:
 * Created by wangjiawang on 2018/7/27.
 * complete
 */
@Test(tag = "Student class Test Annotation")
public class Student extends Person implements Examination {
    @Test(tag = "mGrade Text Annotation")
    int mGrade;

    public Student(String mName) {
        super(mName);
    }

    public Student(String mName, int mGrade) {
        super(mName);
        this.mGrade = mGrade;
    }

    private void learn(String course) {
        System.out.println(mName +" learn "+ course);
    }

    @Override
    public void takeAnExamination() {

    }

    @Override
    public String toString() {
        return " Student : "+mName;
    }
}
