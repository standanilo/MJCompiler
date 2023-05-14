// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class SingleGlobalVarDeclaration extends GlobalVarDeclaration {

    private GlobalVarDeclSemi GlobalVarDeclSemi;

    public SingleGlobalVarDeclaration (GlobalVarDeclSemi GlobalVarDeclSemi) {
        this.GlobalVarDeclSemi=GlobalVarDeclSemi;
        if(GlobalVarDeclSemi!=null) GlobalVarDeclSemi.setParent(this);
    }

    public GlobalVarDeclSemi getGlobalVarDeclSemi() {
        return GlobalVarDeclSemi;
    }

    public void setGlobalVarDeclSemi(GlobalVarDeclSemi GlobalVarDeclSemi) {
        this.GlobalVarDeclSemi=GlobalVarDeclSemi;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVarDeclSemi!=null) GlobalVarDeclSemi.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarDeclSemi!=null) GlobalVarDeclSemi.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarDeclSemi!=null) GlobalVarDeclSemi.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleGlobalVarDeclaration(\n");

        if(GlobalVarDeclSemi!=null)
            buffer.append(GlobalVarDeclSemi.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleGlobalVarDeclaration]");
        return buffer.toString();
    }
}
