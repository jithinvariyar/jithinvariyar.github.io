package learnjava;

public class MethodLocal {
        private final int j = 10;
        public void insideThis(){
            class Inner{
                void innerMethod(){
                    System.out.println("j = " + j);
                }
            }
            Inner in = new Inner();
            in.innerMethod();
        }
}
