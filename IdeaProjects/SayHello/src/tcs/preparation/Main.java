package tcs.preparation;

public class Main {

    public static void main(String[] args) {
        PolitePerson jane = new PolitePerson("Jane");
        PolitePerson john = new PolitePerson("John");
        new Thread(new Runnable() {
            @Override
            public void run() {
                jane.sayHello(john);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                john.sayHello(jane);
            }
        }).start();
    }

    private static class PolitePerson{
        private String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person){
            System.out.format("%s:%s" + " has said hello to me%n", this.getName(),person.getName());
            person.sayHelloBack(person);
        }

        public synchronized void sayHelloBack(PolitePerson person){
            System.out.format("%s:%s" + " has said hello back to me%n",person.getName(),this.getName());
        }
    }
}
