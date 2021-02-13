class Wasser extends Getraenk {
    public Wasser(String name, int menge) { super(name, menge); }
    public boolean trinken() { return trinken(200); }
}
