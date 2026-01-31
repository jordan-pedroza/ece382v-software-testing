package pset1;

public class C {
    int f;
    public C(int f) {
        this.f = f;
    }

    @Override
    public boolean equals(Object o) {
        // assume this method is implemented for you
        //example implementation
        if (this == o) 
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        C c = (C) o;
        return f == c.f;
    }

    @Override
    public int hashCode() {
        // assume this method is implemented for you
        //example implementation
        return f;
    }
}