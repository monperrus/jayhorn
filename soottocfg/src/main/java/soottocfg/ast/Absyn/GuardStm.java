package soottocfg.ast.Absyn; // Java Package generated by the BNF Converter.

public abstract class GuardStm implements java.io.Serializable {
  public abstract <R,A> R accept(GuardStm.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(soottocfg.ast.Absyn.Asrt p, A arg);
    public R visit(soottocfg.ast.Absyn.Asme p, A arg);

  }

}
