package soottocfg.ast.Absyn; // Java Package generated by the BNF Converter.

public class Return extends JumpStm {
  public Return() { }

  public <R,A> R accept(soottocfg.ast.Absyn.JumpStm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof soottocfg.ast.Absyn.Return) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}
