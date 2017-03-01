package soottocfg.ast.Absyn; // Java Package generated by the BNF Converter.

public class TList1 extends TypeList {
  public final Type type_;
  public TList1(Type p1) { type_ = p1; }

  public <R,A> R accept(soottocfg.ast.Absyn.TypeList.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof soottocfg.ast.Absyn.TList1) {
      soottocfg.ast.Absyn.TList1 x = (soottocfg.ast.Absyn.TList1)o;
      return this.type_.equals(x.type_);
    }
    return false;
  }

  public int hashCode() {
    return this.type_.hashCode();
  }


}
