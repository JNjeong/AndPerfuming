package com.jjn.perfuming.userinfo;

public class infodata {
    private static String GMid = "000000";
    private static String GMpw = "asdf0000";

    private static String userid="";
    private static String userpw;
    private static String username;
    private static int userphone;
    private static String useremail;
    private static int usergender;
    private static String useraddr1;
    private static String useraddr2;
    private static String userarrd3;
    private static int userzipcode;

    public infodata(){;}

    public infodata(String userid, String userpw, String username, int userphone, String useremail, int usergender, String useraddr1, String useraddr2, String userarrd3, int userzipcode) {
        this.userid = userid;
        this.userpw = userpw;
        this.username = username;
        this.userphone = userphone;
        this.useremail = useremail;
        this.usergender = usergender;
        this.useraddr1 = useraddr1;
        this.useraddr2 = useraddr2;
        this.userarrd3 = userarrd3;
        this.userzipcode = userzipcode;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserphone() {
        return userphone;
    }

    public void setUserphone(int userphone) {
        this.userphone = userphone;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public int getUsergender() {
        return usergender;
    }

    public void setUsergender(int usergender) {
        this.usergender = usergender;
    }

    public String getUseraddr1() {
        return useraddr1;
    }

    public void setUseraddr1(String useraddr1) {
        this.useraddr1 = useraddr1;
    }

    public String getUseraddr2() {
        return useraddr2;
    }

    public void setUseraddr2(String useraddr2) {
        this.useraddr2 = useraddr2;
    }

    public String getUserarrd3() {
        return userarrd3;
    }

    public void setUserarrd3(String userarrd3) {
        this.userarrd3 = userarrd3;
    }

    public int getUserzipcode() {
        return userzipcode;
    }

    public void setUserzipcode(int userzipcode) {
        this.userzipcode = userzipcode;
    }
}
