package learnjava;

public class Main {

    public static void main(String[] args) {
	    String var4 = "This is private to main";
	    ScopeCheck scopeInstance = new ScopeCheck();
	    scopeInstance.useInner();
        System.out.println("ScopeInstance var1 = " + scopeInstance.getVar1());
        System.out.println(var4);
        scopeInstance.timesTwo();
        ScopeCheck.InnerClass innerClassInstance = scopeInstance.new InnerClass();
        innerClassInstance.timesTwo();
    }
}
