// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class MultipleGlobalVarDeclarations extends GlobalVarDeclaration {

    private GlobalVarDeclComma GlobalVarDeclComma;
    private GlobalVarDeclaration GlobalVarDeclaration;

    public MultipleGlobalVarDeclarations (GlobalVarDeclComma GlobalVarDeclComma, GlobalVarDeclaration GlobalVarDeclaration) {
        this.GlobalVarDeclComma=GlobalVarDeclComma;
        if(GlobalVarDeclComma!=null) GlobalVarDeclComma.setParent(this);
        this.GlobalVarDeclaration=GlobalVarDeclaration;
        if(GlobalVarDeclaration!=null) GlobalVarDeclaration.setParent(this);
    }

    public GlobalVarDeclComma getGlobalVarDeclComma() {
        return GlobalVarDeclComma;
    }

    public void setGlobalVarDeclComma(GlobalVarDeclComma GlobalVarDeclComma) {
        this.GlobalVarDeclComma=GlobalVarDeclComma;
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
        if(GlobalVarDeclComma!=null) GlobalVarDeclComma.accept(visitor);
        if(GlobalVarDeclaration!=null) GlobalVarDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarDeclComma!=null) GlobalVarDeclComma.traverseTopDown(visitor);
        if(GlobalVarDeclaration!=null) GlobalVarDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarDeclComma!=null) GlobalVarDeclComma.traverseBottomUp(visitor);
        if(GlobalVarDeclaration!=null) GlobalVarDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleGlobalVarDeclarations(\n");

        if(GlobalVarDeclComma!=null)
            buffer.append(GlobalVarDeclComma.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarDeclaration!=null)
            buffer.append(GlobalVarDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleGlobalVarDeclarations]");
        return buffer.toString();
    }
}
