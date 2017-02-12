package sample;

public class SampleController {
    protected String v1;
    protected String v2;
    protected String v3;
    protected String v4;
    protected String v5;
    protected String v6;

    public SampleController(String v1,String v2,String v3,String v4,String v5,String v6){
        this.v1=v1;
        this.v2=v2;
        this.v3=v3;
        this.v4=v4;
        this.v5=v5;
        this.v6=v6;
    }

    public void setValue1(String v){
        v1=v;
    }

    public String getValue1(){
        return v1;
    }
    public void setValue2(String v){
        v2=v;
    }

    public String getValue2(){
        return v2;
    }
    public void setValue3(String v){
        v3=v;
    }

    public String getValue3(){
        return v3;
    }
    public void setValue4(String v){
        v4=v;
    }

    public String getValue4(){
        return v4;
    }
    public void setValue5(String v){
        v5=v;
    }

    public String getValue5(){
        return v5;
    }
    public void setValue6(String v){
        v6=v;
    }

    public String getValue6(){
        return v6;
    }
}
