package com.atguigu.spring5;

public class Book {
    private String bname;
    private String bauthor;
    private String address;
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void  testDemo(){
        System.out.println(this.bname + " -- " + this.bauthor+ " " + this.address);
    }
//    public Book(String bname, String bauthor){
//        this.bname = bname;
//        this.bauthor = bauthor;
//    }

}
