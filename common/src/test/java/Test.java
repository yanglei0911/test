import com.neuedu.his.common.util.CaseHistoryGenerator;

public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            for (;;){
                System.out.println("t1"+CaseHistoryGenerator.genId());
            }
        });
        t1.start();
    }
}
