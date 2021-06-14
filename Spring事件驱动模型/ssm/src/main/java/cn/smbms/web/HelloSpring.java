package cn.smbms.web;

public class HelloSpring {
    private String who = null;
    public HelloSpring(){

    }
    //构造注入
    public HelloSpring(String who){
        this.who = who;
    }

    public void print(){
        System.out.println("Hello" + this.getWho() + "!");
    }



    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

}
