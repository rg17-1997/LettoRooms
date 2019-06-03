package com.example.lenovo.navigationex;

public class NeedsDetail {
    private String needname;
    private String needemail;
    private String need;

    public NeedsDetail(String id, String nname, String nemail, String nneeds){

    }

    public NeedsDetail(String needname, String needemail, String need) {
        this.needname = needname;
        this.needemail = needemail;
        this.need = need;
    }

    public String getNeedname() {
        return needname;
    }

    public String getNeedemail() {
        return needemail;
    }

    public String getNeed() {
        return need;
    }
}
