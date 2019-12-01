package b.e.b.a;

import b.e.b.c;
import java.util.ArrayList;

/* compiled from: WidgetContainer */
public class u extends h {
    protected ArrayList<h> sa = new ArrayList<>();

    public void E() {
        this.sa.clear();
        super.E();
    }

    public void I() {
        super.I();
        ArrayList<h> arrayList = this.sa;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = (h) this.sa.get(i2);
                hVar.b(h(), i());
                if (!(hVar instanceof i)) {
                    hVar.I();
                }
            }
        }
    }

    public i K() {
        h m = m();
        i iVar = this instanceof i ? (i) this : null;
        while (m != null) {
            h m2 = m.m();
            if (m instanceof i) {
                iVar = (i) m;
            }
            m = m2;
        }
        return iVar;
    }

    public void L() {
        I();
        ArrayList<h> arrayList = this.sa;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = (h) this.sa.get(i2);
                if (hVar instanceof u) {
                    ((u) hVar).L();
                }
            }
        }
    }

    public void M() {
        this.sa.clear();
    }

    public void a(h hVar) {
        this.sa.add(hVar);
        if (hVar.m() != null) {
            ((u) hVar.m()).c(hVar);
        }
        hVar.b((h) this);
    }

    public void b(int i2, int i3) {
        super.b(i2, i3);
        int size = this.sa.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((h) this.sa.get(i4)).b(q(), r());
        }
    }

    public void c(h hVar) {
        this.sa.remove(hVar);
        hVar.b((h) null);
    }

    public void a(c cVar) {
        super.a(cVar);
        int size = this.sa.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((h) this.sa.get(i2)).a(cVar);
        }
    }
}
