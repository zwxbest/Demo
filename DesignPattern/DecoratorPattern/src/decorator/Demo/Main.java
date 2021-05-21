package decorator.Demo;

public class Main {

    public static void main(String[] args) {
        Finery xc = new Finery();

        System.out.println("\n第一种装扮：");

        Sneakers pqx = new Sneakers();
        BigTrouser kk = new BigTrouser();
        TShirts dtx = new TShirts();

        pqx.Decorate(xc);
        kk.Decorate(pqx);
        dtx.Decorate(kk);
        dtx.Show();

        System.out.println("\n第二种装扮：");

        LeatherShoes px = new LeatherShoes();
        Tie ld = new Tie();
        Suit xz = new Suit();

        px.Decorate(xc);
        ld.Decorate(px);
        xz.Decorate(ld);
        xz.Show();

        System.out.println("\n第三种装扮：");
        Sneakers pqx2 = new Sneakers();
        LeatherShoes px2 = new LeatherShoes();
        BigTrouser kk2 = new BigTrouser();
        Tie ld2 = new Tie();

        pqx2.Decorate(xc);
        px2.Decorate(pqx);
        kk2.Decorate(px2);
        ld2.Decorate(kk2);

        ld2.Show();

    }
}
