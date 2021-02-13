class Brot extends Speise {
    public Brot(int typ, int menge) {
        super("", menge);
        switch(typ) {
            case 0: name = "Weißbrot";
                    break;
            case 1: name = "Schwarzbrot";
                    break;
            case 2: name = "Mischbrot";
                    break;
            default: name = "Spezialbrot";
        }
    }
    public boolean essen() { return essen(50); }
}
