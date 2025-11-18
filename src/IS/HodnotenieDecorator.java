package IS;

public class HodnotenieDecorator implements PesnickaDecorator{
    protected Pesnicka pesnicka;
    final private boolean hodnotenie;

    public HodnotenieDecorator(Pesnicka pesnicka, boolean hodnotenie) {
        this.pesnicka = pesnicka;
        this.hodnotenie = hodnotenie;
    }




    @Override
    public void getHodnotenie() {
        if(hodnotenie){
            System.out.println(" ");
            System.out.println("zanechali ste like");
        }
        else {
            System.out.println(" ");
            System.out.println("zanechali ste  dislike");
        }
    }
}
