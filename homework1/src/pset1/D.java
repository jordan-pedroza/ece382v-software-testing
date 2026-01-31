package pset1;

public class D extends C {
    int g;
    public D(int f, int g) {
        super(f);
        this.g = g;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        D d = (D) o;
        return f == d.f && g == d.g;
    }
    @Override
    public int hashCode() {
        // assume this method is implemented for you
        String f_str = Integer.toBinaryString(f);
        String g_str = Integer.toBinaryString(g);
        String f_n_g_str = f_str + '9' + g_str;

        return Integer.parseInt(f_n_g_str);
    }
}