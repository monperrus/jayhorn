package soottocfg.ast.Absyn; // Java Package generated by the BNF Converter.

public class Etrip extends Exp {
  public final Exp exp_1, exp_2;
  public Etrip(Exp p1, Exp p2) { exp_1 = p1; exp_2 = p2; }

  public <R,A> R accept(soottocfg.ast.Absyn.Exp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof soottocfg.ast.Absyn.Etrip) {
      soottocfg.ast.Absyn.Etrip x = (soottocfg.ast.Absyn.Etrip)o;
      return this.exp_1.equals(x.exp_1) && this.exp_2.equals(x.exp_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.exp_1.hashCode())+this.exp_2.hashCode();
  }


}
