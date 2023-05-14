// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarDeclarationError2 extends GlobalVarDeclSemi {

    public GlobalVarDeclarationError2 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarDeclarationError2(\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarDeclarationError2]");
        return buffer.toString();
    }
}
