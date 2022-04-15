public class MyClassTest {

    static  MyClass mc =new MyClass();


    @Test(priority = 10)
    static public  void sumTest1(){
        if(5==mc.summ(2,3)){
            System.out.println("Тест пройден");
        }else {
            System.out.println("Тест не пройден");
        }


    }


    static public  void sumTest2(){
        if(10==mc.summ(7,3)){
            System.out.println("Тест пройден");
        }else {
            System.out.println("Тест не пройден");
        }


    }

    @Test(priority = 4)
    static public  void сoncatenationTest(){
        if(("Проба пера").equals(mc.сoncatenation("Проба ","пера"))){
            System.out.println("Тест пройден");
        }else {
            System.out.println("Тест не пройден");
        }


    }

    @Test(priority = 7)
    static public  void squrinTest(){
        if(112==mc.squring(13)){
            System.out.println("Тест пройден");
        }else {
            System.out.println("Тест не пройден");
        }


    }
    @Test
    static public  void substringTest(){
        if(10==mc.summ(7,3)){
            System.out.println("Тест пройден");
        }else {
            System.out.println("Тест не пройден");
        }


    }

    @BeforeSuite
    static public void pretest(){
        System.out.println("Информация перед тестированием");
    }

    @AfterSuite
    static  public void posttest(){
        System.out.println("Информация после тестипования");
    }






}
