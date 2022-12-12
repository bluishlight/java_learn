package com.atguigu4.exer;

public class ExamStudent {
    private  int FlowID;
    private  int Type;
    private  int Grade;
    private String IDCard;
    private String ExamCard;
    private String StudentName;
    private String Location;

    public ExamStudent() {
    }

    @Override
    public String toString() {
        return "ExamStudent{" +
                "FlowID=" + FlowID +
                ", Type=" + Type +
                ", Grade=" + Grade +
                ", IDCard='" + IDCard + '\'' +
                ", ExamCard='" + ExamCard + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ", Location='" + Location + '\'' +
                '}';
    }

    public ExamStudent(int flowID, int type, int grade, String IDCard, String examCard, String studentName, String location) {
        FlowID = flowID;
        Type = type;
        Grade = grade;
        this.IDCard = IDCard;
        ExamCard = examCard;
        StudentName = studentName;
        Location = location;
    }

    public int getFlowID() {
        return FlowID;
    }

    public void setFlowID(int flowID) {
        FlowID = flowID;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getExamCard() {
        return ExamCard;
    }

    public void setExamCard(String examCard) {
        ExamCard = examCard;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
