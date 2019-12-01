package j;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: Options */
public final class s extends AbstractList<i> implements RandomAccess {

    /* renamed from: a reason: collision with root package name */
    final i[] f10273a;

    /* renamed from: b reason: collision with root package name */
    final int[] f10274b;

    private s(i[] iVarArr, int[] iArr) {
        this.f10273a = iVarArr;
        this.f10274b = iArr;
    }

    public static s a(i... iVarArr) {
        if (iVarArr.length == 0) {
            return new s(new i[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(iVarArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(Integer.valueOf(-1));
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.set(Collections.binarySearch(arrayList, iVarArr[i3]), Integer.valueOf(i3));
        }
        if (((i) arrayList.get(0)).size() != 0) {
            int i4 = 0;
            while (i4 < arrayList.size()) {
                i iVar = (i) arrayList.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < arrayList.size()) {
                    i iVar2 = (i) arrayList.get(i6);
                    if (!iVar2.b(iVar)) {
                        continue;
                        break;
                    } else if (iVar2.size() == iVar.size()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("duplicate option: ");
                        sb.append(iVar2);
                        throw new IllegalArgumentException(sb.toString());
                    } else if (((Integer) arrayList2.get(i6)).intValue() > ((Integer) arrayList2.get(i4)).intValue()) {
                        arrayList.remove(i6);
                        arrayList2.remove(i6);
                    } else {
                        i6++;
                    }
                }
                i4 = i5;
            }
            f fVar = new f();
            a(0, fVar, 0, arrayList, 0, arrayList.size(), arrayList2);
            int[] iArr = new int[a(fVar)];
            for (int i7 = 0; i7 < iArr.length; i7++) {
                iArr[i7] = fVar.readInt();
            }
            if (fVar.o()) {
                return new s((i[]) iVarArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    public final int size() {
        return this.f10273a.length;
    }

    public i get(int i2) {
        return this.f10273a[i2];
    }

    private static void a(long j2, f fVar, int i2, List<i> list, int i3, int i4, List<Integer> list2) {
        int i5;
        int i6;
        f fVar2;
        int i7;
        f fVar3 = fVar;
        int i8 = i2;
        List<i> list3 = list;
        int i9 = i3;
        int i10 = i4;
        List<Integer> list4 = list2;
        if (i9 < i10) {
            int i11 = i9;
            while (i11 < i10) {
                if (((i) list3.get(i11)).size() >= i8) {
                    i11++;
                } else {
                    throw new AssertionError();
                }
            }
            i iVar = (i) list.get(i3);
            i iVar2 = (i) list3.get(i10 - 1);
            int i12 = -1;
            if (i8 == iVar.size()) {
                i12 = ((Integer) list4.get(i9)).intValue();
                i9++;
                iVar = (i) list3.get(i9);
            }
            int i13 = i9;
            if (iVar.b(i8) != iVar2.b(i8)) {
                int i14 = 1;
                for (int i15 = i13 + 1; i15 < i10; i15++) {
                    if (((i) list3.get(i15 - 1)).b(i8) != ((i) list3.get(i15)).b(i8)) {
                        i14++;
                    }
                }
                long a2 = j2 + ((long) a(fVar)) + 2 + ((long) (i14 * 2));
                fVar3.writeInt(i14);
                fVar3.writeInt(i12);
                for (int i16 = i13; i16 < i10; i16++) {
                    byte b2 = ((i) list3.get(i16)).b(i8);
                    if (i16 == i13 || b2 != ((i) list3.get(i16 - 1)).b(i8)) {
                        fVar3.writeInt((int) b2 & 255);
                    }
                }
                f fVar4 = new f();
                int i17 = i13;
                while (i17 < i10) {
                    byte b3 = ((i) list3.get(i17)).b(i8);
                    int i18 = i17 + 1;
                    int i19 = i18;
                    while (true) {
                        if (i19 >= i10) {
                            i6 = i10;
                            break;
                        } else if (b3 != ((i) list3.get(i19)).b(i8)) {
                            i6 = i19;
                            break;
                        } else {
                            i19++;
                        }
                    }
                    if (i18 == i6 && i8 + 1 == ((i) list3.get(i17)).size()) {
                        fVar3.writeInt(((Integer) list4.get(i17)).intValue());
                        i7 = i6;
                        fVar2 = fVar4;
                    } else {
                        fVar3.writeInt((int) ((((long) a(fVar4)) + a2) * -1));
                        i7 = i6;
                        fVar2 = fVar4;
                        a(a2, fVar4, i8 + 1, list, i17, i6, list2);
                    }
                    fVar4 = fVar2;
                    i17 = i7;
                }
                f fVar5 = fVar4;
                fVar3.a(fVar5, fVar5.size());
                return;
            }
            int min = Math.min(iVar.size(), iVar2.size());
            int i20 = i8;
            int i21 = 0;
            while (i20 < min && iVar.b(i20) == iVar2.b(i20)) {
                i21++;
                i20++;
            }
            long a3 = 1 + j2 + ((long) a(fVar)) + 2 + ((long) i21);
            fVar3.writeInt(-i21);
            fVar3.writeInt(i12);
            int i22 = i8;
            while (true) {
                i5 = i8 + i21;
                if (i22 >= i5) {
                    break;
                }
                fVar3.writeInt((int) iVar.b(i22) & 255);
                i22++;
            }
            if (i13 + 1 != i10) {
                f fVar6 = new f();
                fVar3.writeInt((int) ((((long) a(fVar6)) + a3) * -1));
                a(a3, fVar6, i5, list, i13, i4, list2);
                fVar3.a(fVar6, fVar6.size());
            } else if (i5 == ((i) list3.get(i13)).size()) {
                fVar3.writeInt(((Integer) list4.get(i13)).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    private static int a(f fVar) {
        return (int) (fVar.size() / 4);
    }
}
