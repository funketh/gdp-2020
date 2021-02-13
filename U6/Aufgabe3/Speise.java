abstract class Speise extends Lebensmittel {
    public Speise(String name, int menge) { super(name, menge); }
    public boolean trinken() { return false; }
    public boolean essen(int menge) {
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
            + " g)";
    }
}
