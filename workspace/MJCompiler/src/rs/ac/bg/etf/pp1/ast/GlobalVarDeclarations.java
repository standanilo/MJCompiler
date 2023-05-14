// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarDeclarations extends GlobalVarDeclList {

    private Type Type;
    private GlobalVarDeclaration GlobalVarDeclaration;

    public GlobalVarDeclarations (Type Type, GlobalVarDeclaration GlobalVarDeclaration) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.GlobalVarDeclaration=GlobalVarDeclaration;
        if(GlobalVarDeclaration!=null) GlobalVarDeclaration.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public GlobalVarDeclaration getGlobalVarDeclaration() {
        return GlobalVarDeclaration;
    }

    public void setGlobalVarDeclaration(GlobalVarDeclaration GlobalVarDeclaration) {
        this.GlobalVarDeclaration=GlobalVarDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(GlobalVarDeclaration!=null) GlobalVarDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(GlobalVarDeclaration!=null) GlobalVarDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(GlobalVarDeclaration!=null) GlobalVarDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarDeclarations(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarDeclaration!=null)
            buffer.append(GlobalVarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarDeclarations]");
        return buffer.toString();
    }
}
