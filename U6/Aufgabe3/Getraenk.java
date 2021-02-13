abstract class Getraenk extends Lebensmittel {
    public Getraenk(String name, int menge) { super(name, menge); }
    public boolean essen() { return false; }
    public boolean trinken(int menge) {
        if (this.menge < menge) {
            this.menge = 0;
            return false;
        }
        this.menge -= menge;
        return true;
    }
    public String status() {
        return this.getClass().getSimpleName()
            + " ("
            + name
            + ", "
            + menge
            + " ml)";
    }
}
