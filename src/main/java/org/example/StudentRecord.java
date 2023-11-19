package org.example;

import java.time.LocalDate;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentRecord {
    private String name;
    @JsonProperty("DOB")
    private LocalDate DOB;
    private int Class;
    private Map<Subject , Integer> marks ;
    private float percentage ;
    private Grade Gradeval ;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public LocalDate getDOB(){
        return DOB;
    }

    public void setDOB(LocalDate DOB){
        this.DOB = DOB;
    }

    public int getClassValue(){
        return Class;
    }

    public void setClass(int Class){
        this.Class = Class;
    }

    public Map<Subject, Integer> getMarks(){
        return marks;
    }
    public void setMark(Map<Subject , Integer> marks){
        this.marks = marks;
    }

    public float getPercentage(){
        //considering total mark for each subject to be 100 .
        int total = 0;
        int sCount = 0;
        this.percentage = 0;
        for (Integer value : marks.values()) {
            sCount++;
            total += value;
        }
        if(sCount > 0)
            this.percentage = (float)(total / sCount*100 ) * 100 ;
        return this.percentage;
    }

    public Grade getGrade(){
        int percentage = (int)getPercentage();
        if(percentage >= 90) this.Gradeval =  Grade.A_PLUS;
        else if(percentage >= 80) this.Gradeval = Grade.A;
        else if(percentage >= 70) this.Gradeval = Grade.B;
        else if(percentage >= 60) this.Gradeval = Grade.B;
        else if(percentage >= 50) this.Gradeval = Grade.B;
        else this.Gradeval = Grade.F;
        return this.Gradeval;
    }

}
