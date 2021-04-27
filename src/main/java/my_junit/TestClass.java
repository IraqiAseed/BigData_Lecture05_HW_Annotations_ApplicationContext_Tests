package my_junit;


public class TestClass {

    private int parameterNeedToInitializedEveryTest = 0;
    TestClass()
    {
        System.out.println("Test class running");
    }
    @RunBeforeEachTest
    public void before() {
        System.out.println("before test logic");
    }


    public void kaki() {
        System.out.println("kaki");
    }

    public void testMySomething() {
        System.out.println(parameterNeedToInitializedEveryTest);
        parameterNeedToInitializedEveryTest = 1;
        System.out.println("I shoud work because my name starts with test");
        System.out.println(parameterNeedToInitializedEveryTest);
    }

    public void test1() {
        System.out.println(parameterNeedToInitializedEveryTest);
        System.out.println("11111111111111");
        parameterNeedToInitializedEveryTest = 66;
        System.out.println(parameterNeedToInitializedEveryTest);
    }
}
