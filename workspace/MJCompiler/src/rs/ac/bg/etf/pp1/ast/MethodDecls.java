// generated with ast extension for cup
// version 0.8
// 17/0/2023 17:36:42


package rs.ac.bg.etf.pp1.ast;

public class MethodDecls extends MethodDecl {

    private MethodReturnType MethodReturnType;
    private FormPars FormPars;
    private MethodVarDeclList MethodVarDeclList;
    private StatementList StatementList;

    public MethodDecls (MethodReturnType MethodReturnType, FormPars FormPars, MethodVarDeclList MethodVarDeclList, StatementList StatementList) {
        this.MethodReturnType=MethodReturnType;
        if(MethodReturnType!=null) MethodReturnType.setParent(this);
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.MethodVarDeclList=MethodVarDeclList;
        if(MethodVarDeclList!=null) MethodVarDeclList.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodReturnType getMethodReturnType() {
        return MethodReturnType;
    }

    public void setMethodReturnType(MethodReturnType MethodReturnType) {
        this.MethodReturnType=MethodReturnType;
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
    }

    public MethodVarDeclList getMethodVarDeclList() {
        return MethodVarDeclList;
    }

    public void setMethodVarDeclList(MethodVarDeclList MethodVarDeclList) {
        this.MethodVarDeclList=MethodVarDeclList;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodReturnType!=null) MethodReturnType.accept(visitor);
        if(FormPars!=null) FormPars.accept(visitor);
        if(MethodVarDeclList!=null) MethodVarDeclList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodReturnType!=null) MethodReturnType.traverseTopDown(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(MethodVarDeclList!=null) MethodVarDeclList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodReturnType!=null) MethodReturnType.traverseBottomUp(visitor);
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(MethodVarDeclList!=null) MethodVarDeclList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecls(\n");

        if(MethodReturnType!=null)
            buffer.append(MethodReturnType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodVarDeclList!=null)
            buffer.append(MethodVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecls]");
        return buffer.toString();
    }
}
