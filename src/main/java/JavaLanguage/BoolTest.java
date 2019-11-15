package JavaLanguage;

public class BoolTest {

    public static void main(String[] args){
        //java的文档上&&的优先级是高于||一级
        System.out.println(false || true && true);
        System.out.println(false || true && false);
    }

}
