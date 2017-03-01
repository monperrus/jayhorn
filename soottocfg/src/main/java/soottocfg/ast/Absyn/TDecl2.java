package soottocfg.ast.Absyn; // Java Package generated by the BNF Converter.

public class TDecl2 extends Decl {
  public final String ident_;
  public final ListTupleEntry listtupleentry_;
  public final ListFieldDeclaration listfielddeclaration_;
  public TDecl2(String p1, ListTupleEntry p2, ListFieldDeclaration p3) { ident_ = p1; listtupleentry_ = p2; listfielddeclaration_ = p3; }

  public <R,A> R accept(soottocfg.ast.Absyn.Decl.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof soottocfg.ast.Absyn.TDecl2) {
      soottocfg.ast.Absyn.TDecl2 x = (soottocfg.ast.Absyn.TDecl2)o;
      return this.ident_.equals(x.ident_) && this.listtupleentry_.equals(x.listtupleentry_) && this.listfielddeclaration_.equals(x.listfielddeclaration_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.ident_.hashCode())+this.listtupleentry_.hashCode())+this.listfielddeclaration_.hashCode();
  }


}
