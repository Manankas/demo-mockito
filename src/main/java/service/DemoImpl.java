package service;

public class DemoImpl {
    public String useDemoStaticMethod(){
        DemoUtil.demoStaticMethod(1);
        return "function executed successfully";
    }
}
